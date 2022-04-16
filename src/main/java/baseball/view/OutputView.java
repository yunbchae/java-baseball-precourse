package baseball.view;

import baseball.dto.MatchResultOutput;

public interface OutputView {
    void printBaseballNumbersInputMessage();

    void printMatchResult(MatchResultOutput matchResultOutput);
}
