package baseball;

import baseball.domain.*;
import baseball.dto.BaseballNumbersInput;
import baseball.dto.MatchResultOutput;
import baseball.view.ConsoleInputView;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.PrintStreamOutputView;

import java.util.List;
import java.util.Objects;

import static baseball.domain.BaseballNumber.MAXIMUM_NUMBER;
import static baseball.domain.BaseballNumber.MINIMUM_NUMBER;
import static baseball.domain.BaseballNumbers.NUMBER_COUNT;

public class Application {

    private final InputView inputView;
    private final OutputView outputView;
    private final UniqueNumberListGenerator uniqueNumberListGenerator;

    public Application(final InputView inputView,
                       final OutputView outputView,
                       final UniqueNumberListGenerator uniqueNumberListGenerator
    ) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
        this.uniqueNumberListGenerator = Objects.requireNonNull(uniqueNumberListGenerator);
    }

    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final OutputView outputView = new PrintStreamOutputView();
        final UniqueNumberListGenerator uniqueNumberListGenerator = new UniqueRandomNumberListGenerator();

        final Application application = new Application(inputView, outputView, uniqueNumberListGenerator);
        application.startGame();
    }

    private void startGame() {
        final BaseballGame baseballGame = createNewGame();
        while (baseballGame.isPlaying()) {
            play(baseballGame);
        }
        outputView.printGameOverMessage(NUMBER_COUNT);
    }

    private BaseballGame createNewGame() {
        final List<Integer> generatedNumberList = uniqueNumberListGenerator.generate(MINIMUM_NUMBER, MAXIMUM_NUMBER, NUMBER_COUNT);
        final BaseballNumbers answer = new BaseballNumbers(generatedNumberList);
        return new BaseballGame(answer);
    }

    private void play(BaseballGame baseballGame) {
        outputView.printBaseballNumbersInputMessage();
        final BaseballNumbersInput baseballNumbersInput = inputView.readBaseballNumbers();
        final MatchResult matchResult = baseballGame.match(baseballNumbersInput.getBaseballNumbers());
        outputView.printMatchResult(new MatchResultOutput(matchResult));
        if (matchResult.isAnswer()) {
            baseballGame.quit();
        }
    }
}
