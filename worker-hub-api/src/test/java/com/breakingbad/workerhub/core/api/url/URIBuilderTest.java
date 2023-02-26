package com.breakingbad.workerhub.core.api.url;

import io.github.ones1kk.assertion.core.exception.AssertException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.*;

class URIBuilderTest {

    @Nested
    @DisplayName("생성 테스트")
    class CreateTest {

        @ParameterizedTest
        @ValueSource(strings = {"https://www.github.com", "http://www.naver.com", "www.google.com"})
        @DisplayName("올바른 URL 포맷은 객체를 생성할 수 있다.")
        void create_success(String value) throws Exception {
            assertThatNoException().isThrownBy(() -> new URIBuilder(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"테스트", "something", "123123", "123.123.123.12..5", "", " "})
        @DisplayName("올바르지 않은 URL 포맷은 객체를 생성할 수 없다.")
        void create_fail(String value) throws Exception {
            assertThatThrownBy(() -> new URIBuilder(value)).isInstanceOf(AssertException.class);
        }

    }

    @Nested
    @DisplayName("메소드 테스트")
    class MethodTest {

        @ParameterizedTest
        @CsvSource(value = {"q|깃허브", "q|구글", "q|인스타그램"}, delimiter = '|')
        @DisplayName("param() String 변수 테스트")
        void param_string(String key, String value) throws Exception {
            // given
            String requestUrl = "https://www.google.com/search";

            // when
            URIBuilder uriBuilder = new URIBuilder(requestUrl);
            uriBuilder.param(key, value);

            String uri = uriBuilder.getURI();

            // then
            assertThat(uri).isNotNull().isNotEmpty();
            assertThat(new URL(uri)).hasHost("www.google.com")
                    .hasProtocol("https")
                    .hasPath("/search")
                    .hasParameter(key, value);
        }

        @ParameterizedTest
        @CsvSource(value = {"q|깃허브", "q|구글", "q|인스타그램"}, delimiter = '|')
        @DisplayName("param() MultiValueMap 변수 테스트")
        void param_multiValueMap(String key, String value) throws Exception {
            // given
            String requestUrl = "https://www.google.com/search";

            // when
            URIBuilder uriBuilder = new URIBuilder(requestUrl);

            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.add(key, value);

            uriBuilder.param(multiValueMap);

            String uri = uriBuilder.getURI();

            // then
            assertThat(uri).isNotNull().isNotEmpty();
            assertThat(new URL(uri)).hasHost("www.google.com")
                    .hasProtocol("https")
                    .hasPath("/search")
                    .hasParameter(key, value);
        }

        @ParameterizedTest
        @ValueSource(strings = {"worker-hub", "ones1kk", "MyPottery", "paulront"})
        @DisplayName("통신 성공 테스트")
        void connect_success(String value) throws Exception {
            // given
            String requestUrl = "https://www.github.com";
            URIBuilder uriBuilder = new URIBuilder(requestUrl);
            uriBuilder.addPath(value);

            // when
            String result = uriBuilder.getEncodedURI();
            URL url = new URL(result);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();

            // then
            assertThat(result).isNotNull()
                    .isNotEmpty();

            assertThat(url).hasHost("www.github.com")
                    .hasPath("/" + value);

            assertThat(responseCode).isEqualTo(200);
        }

    }

}