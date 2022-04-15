package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class BaseballNumbersTest {

    @DisplayName("BaseballNumbers 생성 테스트")
    @Nested
    class BaseballNumbersCreateTest {

        @ParameterizedTest(name = "서로 다른 세 수로 BaseballNumbers를 생성할 수 있다.")
        @MethodSource("baseball.domain.BaseballNumbersTest#provideCreateSuccessTestArguments")
        void createSuccessTest(final List<Integer> numberList) {
            assertThatNoException()
                    .isThrownBy(() -> new BaseballNumbers(numberList));
        }

        @ParameterizedTest(name = "서로 다른 세 수가 아닌 경우, BaseballNumbers를 생성할 수 없다.")
        @MethodSource("baseball.domain.BaseballNumbersTest#provideCreateFailTestArguments")
        @NullAndEmptySource
        void createFailTest(final List<Integer> numberList) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BaseballNumbers(numberList))
                    .withMessageContaining(String.valueOf(numberList));
        }
    }

    private static Stream<Arguments> provideCreateSuccessTestArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3)),
                Arguments.of(Arrays.asList(4,8,6)),
                Arguments.of(Arrays.asList(9,7,5))
        );
    }

    private static Stream<Arguments> provideCreateFailTestArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,2)),
                Arguments.of(Arrays.asList(4,8)),
                Arguments.of(Arrays.asList(9,7,5,6))
        );
    }

}