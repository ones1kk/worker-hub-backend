package com.breakingbad.workerhub.core.api.kasi;

import com.breakingbad.workerhub.IntegrationTestConfig;
import com.breakingbad.workerhub.core.api.kasi.model.KasiResponse;
import com.breakingbad.workerhub.core.properties.ApiConfigProperties;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import retrofit2.Call;
import retrofit2.Response;

import static com.breakingbad.workerhub.constant.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = IntegrationTestConfig.class)
@ActiveProfiles("test")
@Disabled
class KasiAPIsTest {

    @Autowired
    private KasiAPIs KasiApis;

    @Autowired
    private ApiConfigProperties apiConfigProperties;

    @Nested
    @DisplayName("천문연구원에서 제공하는 공휴일 API 동작 테스트")
    class APITest {

        @ParameterizedTest
        // API 스펙 이슈 있습니다 -> 현재 답변 대기중
        @CsvSource(value = {"2023|01", "2023|05", "2023|09", "2023|10"}, delimiter = '|')
        @DisplayName("공휴일 API 성공 테스트")
        void response_success(String year, String month) throws Exception {
            // given
            String key = apiConfigProperties.getKasi().getKey();

            // when
            Call<KasiResponse> caller = KasiApis.getHolidaysByYearAndMonth(year, month, JSON.getVar(), key);
            Response<KasiResponse> execute = caller.execute();
            KasiResponse body = execute.body();

            // then
            assertThat(body).isNotNull()
                    .isInstanceOf(KasiResponse.class);

            assertThat(body.getResponse().getBody().getTotalCount())
                    .isGreaterThanOrEqualTo(1);

        }

        @Test
        @DisplayName("공휴일 API 실패 테스트")
        void response_fail() throws Exception {
            // given

            // when

            // then
        }
    }

}