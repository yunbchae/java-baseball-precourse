package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTypeTest {

    @ParameterizedTest(name = "[{2}] valueMatch={0}, positionMatch={1}")
    @CsvSource(value = {
            "false, true, MISS",
            "false, false, MISS",
            "true, true, STRIKE",
            "true, false, BALL"
    })
    void judgeTest(final boolean valueMatch, final boolean positionMatch, final MatchType expected) {
        assertThat(MatchType.judge(valueMatch, positionMatch))
                .isEqualTo(expected);
    }

}