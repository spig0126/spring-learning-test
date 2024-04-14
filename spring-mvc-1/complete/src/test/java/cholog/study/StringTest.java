package cholog.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    String s1, s2, s3, s4;

    @BeforeEach
    public void setUp(){
        s1 = "1,2";
        s2 = "1";
        s3 = "(1,2)";
        s4 = "abc";
    }

    @Test
    void splitTwoElements(){
        String[] result = s1.split(",");

        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitOneElement(){
        String[] result = s2.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    void removeParenthesis(){
        String result = s3.substring(1, s3.length() - 1);

        assertThat(result).isEqualTo(s1);
    }

    @Test
    @DisplayName("Get character at specific position using charAt() and test StringIndexOutOfBoundsException")
    void charAt(){
        char result = s4.charAt(1);
        assertThat(result).isEqualTo('b');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            char exceptionResult = s4.charAt(10); // Try to access index 10 which is out of range
        }).withMessageMatching("String index out of range: \\d+");
    }

}
