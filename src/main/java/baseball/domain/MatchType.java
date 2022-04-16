package baseball.domain;

public enum MatchType {
    STRIKE,
    BALL,
    MISS
    ;

    public static MatchType judge(final boolean valueMatch, final boolean positionMatch) {
        if (!valueMatch) {
            return MISS;
        }
        return positionMatch ? STRIKE : BALL;
    }
}
