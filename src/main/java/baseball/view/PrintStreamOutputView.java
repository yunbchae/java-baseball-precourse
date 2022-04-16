package baseball.view;

import baseball.dto.MatchResultOutput;

public class PrintStreamOutputView implements OutputView {

    @Override
    public void printBaseballNumbersInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printMatchResult(final MatchResultOutput matchResultOutput) {
        System.out.println(matchResultOutput.getMessage());
    }
}
