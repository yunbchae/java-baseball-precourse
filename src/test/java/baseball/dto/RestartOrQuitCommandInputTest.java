package baseball.dto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RestartOrQuitCommandInputTest {

    @ParameterizedTest(name = "RestartOrQuitCommandInput 생성 성공 테스트 [{arguments}]")
    @CsvSource(value = {"1,true", "2,false"})
    void createSuccessTest(final String input, final boolean expected) {
        RestartOrQuitCommandInput restartOrQuitCommandInput = new RestartOrQuitCommandInput(input);
        assertThat(restartOrQuitCommandInput.isRestart())
                .isEqualTo(expected);
    }

    @ParameterizedTest(name = "RestartOrQuitCommandInput 생성 실패 테스트 [{arguments}]")
    @ValueSource(strings = {"3", "12", "a"})
    void createFailTest(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RestartOrQuitCommandInput(input))
                .withMessageContaining(input);
    }
}