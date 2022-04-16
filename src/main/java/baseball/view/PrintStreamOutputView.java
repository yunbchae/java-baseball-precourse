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

    @Override
    public void printGameOverMessage(final int answerNumberCount) {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", answerNumberCount);
    }

    @Override
    public void printRestartOrQuitMessage(final String restartCommand, final String quitCommand) {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n", restartCommand, quitCommand);
    }
}
