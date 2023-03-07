package com.breakingbad.workerhub.domain.holidays.repository;

import com.breakingbad.workerhub.IntegrationTestConfig;
import com.breakingbad.workerhub.constant.Profiles;
import com.breakingbad.workerhub.domain.holidays.Holidays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(IntegrationTestConfig.class)
@ActiveProfiles(Profiles.test)
class HolidaysRepositoryTest {

    @Autowired
    private HolidaysRepository holidaysRepository;

    @BeforeEach
    void beforeEach() {
        holidaysRepository.save(Holidays.makeHolidays(20230121, "설날"));
        holidaysRepository.save(Holidays.makeHolidays(20230122, "설날"));
        holidaysRepository.save(Holidays.makeHolidays(20230123, "설날"));
    }

    @Nested
    @DisplayName("메소드 테스트")
    class MethodTest {

        @Test
        @DisplayName("findAllByYear() 테스트")
        void findAllByYear() throws Exception {
            // given
            Year year = Year.of(2023);

            // when
            List<Holidays> holidays = holidaysRepository.findAllByYear(year);

            // then
            assertThat(holidays).isNotNull().isNotEmpty()
                    .extracting("name")
                    .isNotNull()
                    .isEqualTo(Arrays.asList("설날", "설날", "설날"));
            assertThat(holidays.size()).isEqualTo(3);
        }

        @Nested
        @DisplayName("findCountByYears() 테스트")
        class FindCountByYearsTest {

            @Test
            @DisplayName("findCountByYears() 결과 있을 때 테스트")
            void findCountByYears_hasResult() throws Exception {
                // given
                List<Year> years = List.of(Year.of(2023));

                // when
                Long count = holidaysRepository.findCountByYears(years);

                // then
                assertThat(count).isNotNull()
                        .isNotNegative()
                        .isEqualTo(3);
            }

            @Test
            @DisplayName("findCountByYears() 결과 없을 때 테스트")
            void findCountByYears_hasNoResult() throws Exception {
                // given
                List<Year> years = List.of(Year.of(2022));

                // when
                Long count = holidaysRepository.findCountByYears(years);

                // then
                assertThat(count).isNotNull()
                        .isNotNegative()
                        .isEqualTo(0);
            }
        }

        @Test
        @DisplayName("findAllByYearAndMonth() 테스트")
        void findAllByYearAndMonth() throws Exception {
            // given
            Year year = Year.of(2023);
            Month month = Month.of(1);

            // when
            List<Holidays> holidays = holidaysRepository.findAllByYearAndMonth(year, month);

            // then
            assertThat(holidays).isNotNull().isNotEmpty()
                    .extracting("name")
                    .isNotNull()
                    .isEqualTo(Arrays.asList("설날", "설날", "설날"));
            assertThat(holidays.size()).isEqualTo(3);
        }

    }

}