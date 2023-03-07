package com.breakingbad.workerhub.core.api;

import com.breakingbad.workerhub.constant.APIUrls;
import com.breakingbad.workerhub.constant.HttpMethod;
import com.breakingbad.workerhub.constant.RequestProperties;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class APICallerTest {

    @Nested
    @DisplayName("객체 생성 테스트")
    class CreateTest {

        @Test
        @DisplayName("객체 생성 테스트, 정적 메소드를 활용해 Instance를 생성한다.")
        void create() throws Exception {
            assertThatNoException().isThrownBy(() -> APICaller.of(APIUrls.TEST_API));
        }

    }

    @Nested
    @DisplayName("메소드 테스트")
    class MethodTest {

        @Test
        @DisplayName("configure() 메소드 테스트, configuration 설정이 완료 되면 실제 HttpClient를 호출하는 Caller 객체가 생성된다.")
        void configure() throws Exception {
            // given
            APICaller apiCaller = APICaller.of(APIUrls.TEST_API);
            APIConfiguration configuration = APIConfiguration.configure(HttpMethod.GET, RequestProperties.JSON);

            // when
            Caller caller = apiCaller.configure(configuration);

            // then
            assertThat(caller).isNotNull()
                    .hasFieldOrProperty("apiUrl")
                    .hasFieldOrProperty("configuration");
        }
    }

    @Getter
    static class Result {
        private Integer userId;
        private Integer id;
        private String title;
        private Boolean completed;
    }

    @Nested
    @DisplayName("예시 API 호출 테스트")
    class CallTest {

        @Test
        @DisplayName("Fake API를 활용한 호출 테스트.")
        void callTest() throws Exception {
            // given
            APIUrls apiUrl = APIUrls.TEST_API;
            APIConfiguration configuration = APIConfiguration.configure(HttpMethod.GET, RequestProperties.JSON);

            // when
            Result result = APICaller.of(apiUrl)
                    .configure(configuration)
                    .call()
                    .getResponse(Result.class);

            // then
            assertThat(result).isNotNull()
                    .hasFieldOrPropertyWithValue("userId", 1)
                    .hasFieldOrPropertyWithValue("id", 1)
                    .hasFieldOrPropertyWithValue("title", "delectus aut autem")
                    .hasFieldOrPropertyWithValue("completed", false);
        }
    }

}