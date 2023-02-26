package com.breakingbad.workerhub.core.parser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class JsonParserTest {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class TestModel {
        private String name;
        private int age;
        private String number;

    }

    private TestModel testModel;

    @BeforeEach
    void beforeEach() {
        testModel = new TestModel("ones1kk", 29, "1");
    }

    @Nested
    @DisplayName("ObjectMapper를 활용하여 json을 parsing한다.")
    class MethodTest {

        @Test
        @DisplayName("객체를 json 형태로 converting한다.")
            // TODO json 문자열은 어떤 식으로 테스트 해야하는지...?
        void toJson() throws Exception {
            String json = JsonParser.toJson(testModel);
            assertThat(json).isNotNull()
                    .isNotEmpty();
        }

        @Test
        @DisplayName("객체를 json prettyPrinter로 converting한다.")
            // TODO json 문자열은 어떤 식으로 테스트 해야하는지...?
        void toJsonAsPrettyPrinter() throws Exception {
            String json = JsonParser.toPrettyJson(testModel);
            assertThat(json).isNotNull()
                    .isNotEmpty();
        }

        @Test
        @DisplayName("json 문자열을 Map 형태로 converting한다.")
        void toMap() throws Exception {
            // given
            String json = JsonParser.toJson(testModel);

            // when
            Map<String, Object> map = JsonParser.toMap(json);

            // then
            assertThat(map).isNotNull()
                    .isInstanceOf(Map.class)
                    .extracting(it -> it.get("name")).isEqualTo("ones1kk");

            assertThat(map.size()).isEqualTo(3);
        }

        @Test
        @DisplayName("json 문자열을 틀정 Object로 converting한다.")
        void toObject() throws Exception {
            // given
            String json = JsonParser.toJson(testModel);

            // when
            TestModel result = JsonParser.toObject(json, TestModel.class);

            // then
            assertThat(result).isNotNull()
                    .hasFieldOrPropertyWithValue("name", "ones1kk")
                    .hasFieldOrPropertyWithValue("age", 29)
                    .hasFieldOrPropertyWithValue("number", "1");
        }
    }

}