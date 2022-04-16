package baseball.domain;

import java.util.Objects;

public class BaseballGame {

    private final BaseballNumbers baseballNumbers;

    public BaseballGame(final BaseballNumbers baseballNumbers) {
        this.baseballNumbers = Objects.requireNonNull(baseballNumbers);
    }

    public MatchResult match(final BaseballNumbers inputBaseballNumbers) {
        return baseballNumbers.match(inputBaseballNumbers);
    }
}
