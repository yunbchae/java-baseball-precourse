package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BaseballNumberTest {

    @DisplayName("BaseballNumber 생성 테스트")
    @Nested
    class BaseballNumberCreateTest {

        @ParameterizedTest(name = "BaseballNumber는 {0}을 값으로 가질 수 있다.")
        @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
        void numberCreateSuccessTest(final int num) {
            assertThatNoException()
                    .isThrownBy(() -> new BaseballNumber(num));
        }

        @ParameterizedTest(name = "BaseballNumber는 {0}을 값으로 가질 수 없다.")
        @ValueSource(ints = {0, 10})
        void numberCreateFailTest(final int num) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BaseballNumber(num))
                    .withMessageContaining(String.valueOf(num));
        }
    }
}