package baseball.view;

import baseball.dto.BaseballNumbersInput;
import baseball.dto.RestartOrQuitCommandInput;

public interface InputView {
    BaseballNumbersInput readBaseballNumbers();

    RestartOrQuitCommandInput readRestartOrQuitCommand();
}
