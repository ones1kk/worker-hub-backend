package com.breakingbad.workerhub.core.api.url;

import com.breakingbad.workerhub.constant.HttpMethod;
import com.breakingbad.workerhub.constant.RequestProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class APICallerConfigurationTest {

    @Nested
    @DisplayName("HttpURLConnection의 설정 값을 저장하는 configuration")
    class ConfigurationTest {

        @Test
        @DisplayName("설정 값들을 저장한다.")
        void configure() throws Exception {
            // given
            HttpMethod method = HttpMethod.GET;
            RequestProperties json = RequestProperties.JSON;
            int connectionTimeout = 20;
            int readTimeout = 60;

            // when
            APICallerConfiguration configuration = APICallerConfiguration.builder()
                    .method(method)
                    .requestProperties(json)
                    .connectionTimeout(connectionTimeout)
                    .readTimeout(readTimeout)
                    .build();

            // then
            assertThat(configuration).isNotNull()
                    .hasFieldOrPropertyWithValue("method", HttpMethod.GET)
                    .hasFieldOrPropertyWithValue("requestProperties", RequestProperties.JSON)
                    .hasFieldOrPropertyWithValue("connectionTimeout", 20)
                    .hasFieldOrPropertyWithValue("readTimeout", 60);

        }

        @Test
        @DisplayName("클래스에서 제공하는 기본 값 설정 메소드.")
        void configure_default_01() throws Exception {
            // given
            APICallerConfiguration configuration = APICallerConfiguration.configure(HttpMethod.GET, RequestProperties.JSON);

            // then
            assertThat(configuration).isNotNull()
                    .hasFieldOrPropertyWithValue("method", HttpMethod.GET)
                    .hasFieldOrPropertyWithValue("requestProperties", RequestProperties.JSON);

        }

        @Test
        @DisplayName("클래스에서 제공하는 기본 값 설정 메소드.")
        void configure_default_02() throws Exception {
            // given
            APICallerConfiguration configuration = APICallerConfiguration.configure(HttpMethod.GET, RequestProperties.JSON, Map.of("key", "value"));

            // then
            assertThat(configuration).isNotNull()
                    .hasFieldOrPropertyWithValue("method", HttpMethod.GET)
                    .hasFieldOrPropertyWithValue("requestProperties", RequestProperties.JSON)
                    .hasFieldOrPropertyWithValue("params", Map.of("key", "value"));

        }

    }

}