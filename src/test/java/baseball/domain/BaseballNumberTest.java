package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("BaseballNumber equals 테스트")
    @Nested
    class BaseballNumberEqualsTest {

        @ParameterizedTest(name = "BaseballNumber 값을 비교할 수 있다. [{arguments}]")
        @CsvSource(value = {"1,1,true", "1,2,false"})
        void equalsTest(final int num1, final int num2, final boolean expected) {
            final BaseballNumber baseballNumber1 = new BaseballNumber(num1);
            final BaseballNumber baseballNumber2 = new BaseballNumber(num2);

            final boolean actual = baseballNumber1.equals(baseballNumber2);

            assertThat(actual).isEqualTo(expected);
        }
    }
}