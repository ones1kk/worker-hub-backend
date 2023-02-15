package com.breakingbad.workerhub.core.api.kasi;

import com.breakingbad.workerhub.IntegrationTestConfig;
import com.breakingbad.workerhub.core.api.kasi.model.KasiResponse;
import com.breakingbad.workerhub.core.properties.ApiConfigProperties;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import retrofit2.Call;
import retrofit2.Response;

@SpringBootTest(classes = {IntegrationTestConfig.class})
@ActiveProfiles("test")
@Disabled
class KasiAPIsTest {

    @Autowired
    private KasiAPIs KasiApis;

    @Autowired
    private ApiConfigProperties apiConfigProperties;


    private static final String TYPE = "json";

    @Nested
    @DisplayName("천문연구원에서 제공하는 공휴일 API 동작 테스트, API 스펙 이슈 있습니다 -> 현재 답변 대기중")
    class APITest {

        @ParameterizedTest
        @CsvSource(value = {"2023|01", "2023|03", "2023|04", "2023|05"}, delimiter = '|')
        @DisplayName("공휴일을 년도/월별로 받아오는 API 테스트")
        void responseTest(String year, String month) throws Exception {
            // given
            String key = apiConfigProperties.getKasi().getKey();
//            String key = "";

            // when
            Call<KasiResponse> caller = KasiApis.getHolidaysByYearAndMonth(year, month, TYPE, key);
            Response<KasiResponse> execute = caller.execute();
            KasiResponse body = execute.body();

            System.out.println(body);

            // then
        }
    }

}