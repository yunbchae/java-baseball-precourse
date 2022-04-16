package baseball.domain;

import java.util.Objects;

public class BaseballGame {

    private final BaseballNumbers baseballNumbers;
    private boolean playing;

    public BaseballGame(final BaseballNumbers baseballNumbers) {
        this.baseballNumbers = Objects.requireNonNull(baseballNumbers);
        this.playing = true;
    }

    public MatchResult match(final BaseballNumbers inputBaseballNumbers) {
        return baseballNumbers.match(inputBaseballNumbers);
    }

    public boolean isPlaying() {
        return playing;
    }

    public void quit() {
        playing = false;
    }
}
