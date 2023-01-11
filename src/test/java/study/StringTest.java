package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName(value = "replaceTest")
     void replace() {
        //when
        String actual = "abc".replace("b", "d");
        //then
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName(value = "요구사항1-1 split test")
    void split1(){
        //when
        String[] actual = "1,2".split(",");
        //then
        //assertThat(actual[0]).isEqualTo("1");
        //assertThat(actual[1]).isEqualTo("2");
        assertThat(actual).containsExactly("1","2"); //assert 최소화
    }

    @Test
    @DisplayName(value = "요구사항1-2 split 한글자 test")
    void split2() {
        // given
        // when
        String[] actual = "1".split(",");
        // then
        assertThat(actual.length).isEqualTo(1);
        assertThat(actual[0]).isEqualTo("1");
    }

    @Test
    @DisplayName(value = "요구사항2 substring test")
    void substring() {
        // given
        String str = "(1,2)";
        // when
        String actual = "(1,2)".substring(1, str.length()-1);
        // then
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName(value = "요구사항3-1 charAt test")
    void charAt() {
        // given
        String str = "abc";
        int index = 1;
        // when
        char actual = str.charAt(index);
        // then
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName(value = "요구사항3-2 index범위 예외 test")
    void charAtException() {
        // given
        String str = "abc";
        int index = str.length() + 1;
        // when
        // then
        assertThatThrownBy(() -> {
            char actual = str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index: 2, size: 2");
    }

}
