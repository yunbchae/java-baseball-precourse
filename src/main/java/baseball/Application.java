package baseball;

import baseball.domain.UniqueNumberListGenerator;
import baseball.domain.UniqueRandomNumberListGenerator;
import baseball.view.ConsoleInputView;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.PrintStreamOutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final OutputView outputView = new PrintStreamOutputView();
        final UniqueNumberListGenerator uniqueNumberListGenerator = new UniqueRandomNumberListGenerator();

        final BaseballGameController baseballGameController = new BaseballGameController(inputView, outputView, uniqueNumberListGenerator);
        baseballGameController.startGame();
    }
}
