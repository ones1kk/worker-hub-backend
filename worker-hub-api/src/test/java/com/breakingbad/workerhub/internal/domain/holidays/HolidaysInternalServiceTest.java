package com.breakingbad.workerhub.internal.domain.holidays;

import com.breakingbad.workerhub.IntegrationTestConfig;
import com.breakingbad.workerhub.constant.Profiles;
import com.breakingbad.workerhub.domain.holidays.Holidays;
import com.breakingbad.workerhub.domain.holidays.repository.HolidaysRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@Import(IntegrationTestConfig.class)
@ActiveProfiles(Profiles.test)
class HolidaysInternalServiceTest {

    @InjectMocks
    private HolidaysInternalService holidaysInternalService;

    @Mock
    private HolidaysRepository holidaysRepository;

    @Nested
    @DisplayName("메소드 테스트")
    class MethodTest {

        @Test
        @DisplayName("findAllByYear() 테스트")
        void findAllByYear() throws Exception {
            // given
            Holidays holidays = new Holidays(Year.now(), "test", LocalDate.now());
            holidaysInternalService.save(holidays);
            Year year = Year.now();

            // when
            when(holidaysRepository.findAllByYear(year)).thenReturn(List.of(new Holidays(Year.now(), "test", LocalDate.now())));
            List<Holidays> holidaysList = holidaysInternalService.findAllByYear(year);

            // then
            assertThat(holidaysList).isNotNull()
                    .isNotEmpty();
            assertThat(holidaysList.size()).isNotNegative()
                    .isEqualTo(1);
        }

        @Test
        @DisplayName("findCountByYears() 테스트")
        void findCountByYears() throws Exception {
            // given
            Holidays holidays = new Holidays(Year.now(), "test", LocalDate.now());
            holidaysInternalService.save(holidays);

            // when
            List<Year> years = List.of(Year.now());
            when(holidaysRepository.findCountByYears(years)).thenReturn(1L);
            Long count = holidaysInternalService.findCountByYears(years);

            // then
            assertThat(count).isNotNull()
                    .isNotNegative()
                    .isEqualTo(1L);
        }

        @Test
        @DisplayName("saveAll() 테스트")
        void saveAll() throws Exception {
            // given
            List<Holidays> holidays = List.of(new Holidays(Year.now(), "test", LocalDate.now()));

            // when
            when(holidaysRepository.saveAll(holidays)).thenReturn(holidays);
            List<Holidays> holidaysList = holidaysInternalService.saveAll(holidays);

            // then
            assertThat(holidaysList).isNotNull()
                    .isNotEmpty();
            assertThat(holidaysList.size()).isNotNegative()
                    .isEqualTo(1);
        }

        @Test
        @DisplayName("save() 테스트")
        void save() throws Exception {
            // given
            Holidays holidays = new Holidays(Year.now(), "test", LocalDate.now());

            // when
            when(holidaysRepository.save(holidays)).thenReturn(holidays);
            Holidays saved = holidaysInternalService.save(holidays);

            // then
            assertThat(saved).isNotNull().isEqualTo(holidays);
        }

    }

}