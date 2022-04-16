package baseball.view;

import baseball.dto.BaseballNumbersInput;
import baseball.dto.RestartOrQuitCommandInput;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public BaseballNumbersInput readBaseballNumbers() {
        final String input = Console.readLine();
        return new BaseballNumbersInput(input);
    }

    @Override
    public RestartOrQuitCommandInput readRestartOrQuitCommand() {
        final String input = Console.readLine();
        return new RestartOrQuitCommandInput(input);
    }
}
