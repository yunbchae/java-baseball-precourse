package baseball.view.dto;

import baseball.domain.BaseballNumbers;
import baseball.dto.BaseballNumbersInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseballNumbersInputTest {

    @DisplayName("BaseballNumbersInput 생성 성공 테스트")
    @Test
    void createSuccessTest() {
        final String input = "712";

        final BaseballNumbersInput baseballNumbersInput = new BaseballNumbersInput(input);

        assertThat(baseballNumbersInput.getBaseballNumbers())
                .isEqualTo(new BaseballNumbers(Arrays.asList(7, 1, 2)));
    }

    @ParameterizedTest(name = "BaseballNumbersInput 생성 실패 테스트 [{arguments}]")
    @ValueSource(strings = {"1234", "012", "abc"})
    void createFailTest(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbersInput(input))
                .withMessageContaining(input);
    }
}