package baseball.domain;

public class MatchResult {

    private int strikeCount;
    private int ballCount;

    public void add(final MatchType matchType) {
        if (matchType == MatchType.STRIKE) {
            strikeCount++;
        }
        if (matchType == MatchType.BALL) {
            ballCount++;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
