package com.breakingbad.workerhub.core.api.url;

import io.github.ones1kk.assertion.core.exception.AssertException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.*;

class URLBuilderTest {

    @Nested
    @DisplayName("생성 테스트")
    class CreateTest {

        @ParameterizedTest
        @ValueSource(strings = {"https://www.github.com", "http://www.naver.com", "www.google.com"})
        @DisplayName("올바른 URL 포맷은 객체를 생성할 수 있다.")
        void create_success(String value) throws Exception {
            assertThatNoException().isThrownBy(() -> new URLBuilder(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"테스트", "something", "123123", "123.123.123.12..5", "", " "})
        @DisplayName("올바르지 않은 URL 포맷은 객체를 생성할 수 없다.")
        void create_fail(String value) throws Exception {
            assertThatThrownBy(() -> new URLBuilder(value)).isInstanceOf(AssertException.class);
        }

    }

    @Nested
    @DisplayName("메소드 테스트")
    class ParamTest {

        @ParameterizedTest
        @CsvSource(value = {"q|깃허브", "q|구글", "q|인스타그램"}, delimiter = '|')
        void firstParam(String key, String value) throws Exception {
            // given
            String url = "https://www.google.com/search";

            // when
            URLBuilder urlBuilder = new URLBuilder(url);
            urlBuilder.firstParam(key, value);

            String result = urlBuilder.getResult();

            // then
            assertThat(result).isNotNull().isNotEmpty();
            assertThat(new URL(result)).hasHost("www.google.com")
                    .hasProtocol("https")
                    .hasPath("/search")
                    .hasParameter(key, value);
        }

        @Test
        @DisplayName("param 성공 테스트")
        void param_success() throws Exception {
            // given
            String requestUrl = "https://www.github.com";
            URLBuilder urlBuilder = new URLBuilder(requestUrl);
            urlBuilder.addPath("search");
            urlBuilder.firstParam("q", "깃허브");
            urlBuilder.param("sourceid", "chrome");
            urlBuilder.param("ie", "UTF-8");

            // when
            String result = urlBuilder.getResult();
            URL url = new URL(result);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();

            // then
            assertThat(result).isNotNull().isNotEmpty();

            assertThat(url).hasHost("www.github.com")
                    .hasParameter("sourceid", "chrome")
                    .hasParameter("ie", "UTF-8");

            assertThat(responseCode).isEqualTo(200);
        }

        @Test
        @DisplayName("param 실패 테스트")
        void param_fail() throws Exception {
            // given
            String url = "https://www.google.com";

            URLBuilder urlBuilder = new URLBuilder(url);
            urlBuilder.addPath("search");
            urlBuilder.param("sourceid", "chrome");
            urlBuilder.param("ie", "UTF-8");

            // when
            String result = urlBuilder.getResult();
            HttpURLConnection connection = (HttpURLConnection) new URL(result).openConnection();
            int responseCode = connection.getResponseCode();

            // then
            assertThat(responseCode).isEqualTo(404);

        }

        @ParameterizedTest
        @ValueSource(strings = {"worker-hub", "ones1kk", "MyPottery", "paulront"})
        @DisplayName("addPath 테스트")
        void addPath(String value) throws Exception {
            // given
            String requestUrl = "https://www.github.com";
            URLBuilder urlBuilder = new URLBuilder(requestUrl);
            urlBuilder.addPath(value);

            // when
            String result = urlBuilder.getResult();
            URL url = new URL(result);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();

            // then
            assertThat(result).isNotNull().isNotEmpty();
            assertThat(new URL(result)).hasHost("www.github.com")
                    .hasProtocol("https")
                    .hasPath("/" + value);

            assertThat(responseCode).isEqualTo(200);
        }

    }

}