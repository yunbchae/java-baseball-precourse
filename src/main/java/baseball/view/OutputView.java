package baseball.view;

import baseball.dto.MatchResultOutput;

public interface OutputView {
    void printBaseballNumbersInputMessage();

    void printMatchResult(MatchResultOutput matchResultOutput);

    void printGameOverMessage(int answerNumberCount);

    void printRestartOrQuitMessage(String restartCommand, String quitCommand);
}
