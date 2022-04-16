package baseball.view;

import baseball.dto.BaseballNumbersInput;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public BaseballNumbersInput readBaseballNumbers() {
        final String input = Console.readLine();
        return new BaseballNumbersInput(input);
    }
}
