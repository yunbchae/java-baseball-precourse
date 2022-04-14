package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @ParameterizedTest(name = "split 메소드는 구분자를 기준으로 분할한 문자열의 배열을 반환한다. ({index})")
    @MethodSource("provideSplitArguments")
    public void splitTest(String given, String delimiter, String[] expected) {
        String[] actual = given.split(delimiter);
        assertThat(actual).containsExactly(expected);
    }

    private static Stream<Arguments> provideSplitArguments() {
        return Stream.of(
                Arguments.of("1,2", ",", new String[] {"1", "2"}),
                Arguments.of("1", ",", new String[] {"1"})
        );
    }

    @DisplayName("substring 메소드는 특정 위치의 부분 문자열을 반환한다.")
    @Test
    public void substringTest() {
        String given = "(1,2)";
        String actual = given.substring(1, 4);
        String expected = "1,2";
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "charAt 메소드는 특정 위치의 문자를 반환한다. ({index})")
    @CsvSource(value = {"abc,0,a", "abc,1,b", "abc,2,c"})
    void charAtTest01(String given, int idx, char expected) {
        char actual = given.charAt(idx);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("charAt 메소드는 문자 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    public void charAtTest02() {
        String given = "abc";
        int OutOfBoundsIdx = 3;

        ThrowableAssert.ThrowingCallable whenCharAtOutOfIdx = () -> given.charAt(OutOfBoundsIdx);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(whenCharAtOutOfIdx)
                .withMessageMatching(String.format("String index out of range: %d", OutOfBoundsIdx));
    }
}
