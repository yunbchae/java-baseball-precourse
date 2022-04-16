package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.domain.MatchResult;
import baseball.domain.UniqueNumberListGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.dto.BaseballNumbersInput;
import baseball.dto.MatchResultOutput;

import java.util.List;
import java.util.Objects;

import static baseball.domain.BaseballNumber.MAXIMUM_NUMBER;
import static baseball.domain.BaseballNumber.MINIMUM_NUMBER;
import static baseball.domain.BaseballNumbers.REQUIRED_NUMBER_COUNT;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final UniqueNumberListGenerator uniqueNumberListGenerator;

    public BaseballGameController(final InputView inputView,
                                  final OutputView outputView,
                                  final UniqueNumberListGenerator uniqueNumberListGenerator
    ) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
        this.uniqueNumberListGenerator = Objects.requireNonNull(uniqueNumberListGenerator);
    }

    public void startGame() {
        final BaseballGame baseballGame = createNewGame();
        outputView.printBaseballNumbersInputMessage();
        final BaseballNumbersInput baseballNumbersInput = inputView.readBaseballNumbers();
        final MatchResult matchResult = baseballGame.match(baseballNumbersInput.getBaseballNumbers());
        outputView.printMatchResult(new MatchResultOutput(matchResult));
    }

    private BaseballGame createNewGame() {
        final List<Integer> generatedNumberList = uniqueNumberListGenerator.generate(MINIMUM_NUMBER, MAXIMUM_NUMBER, REQUIRED_NUMBER_COUNT);
        final BaseballNumbers answer = new BaseballNumbers(generatedNumberList);
        return new BaseballGame(answer);
    }
}
