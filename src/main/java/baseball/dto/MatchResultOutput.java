package baseball.dto;

import baseball.domain.MatchResult;

public class MatchResultOutput {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String BLANK = " ";

    private final String message;

    public MatchResultOutput(final MatchResult matchResult) {
        final String message = createBallAndStrikeMessage(matchResult);
        this.message = message.isEmpty() ? NOTHING : message;
    }

    private String createBallAndStrikeMessage(final MatchResult matchResult) {
        final StringBuilder stringBuilder = new StringBuilder();
        if (matchResult.getBallCount() > 0) {
            stringBuilder.append(matchResult.getBallCount()).append(BALL).append(BLANK);
        }
        if (matchResult.getStrikeCount() > 0) {
            stringBuilder.append(matchResult.getStrikeCount()).append(STRIKE);
        }
        return stringBuilder.toString().trim();
    }

    public String getMessage() {
        return message;
    }
}
