package baseball.dto;

import baseball.domain.MatchResult;
import baseball.domain.MatchType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultOutputTest {

    @ParameterizedTest(name = "MatchResultOutput 생성 테스트 [{1}]")
    @MethodSource("provideCreateTestArguments")
    void createTest(final MatchResult matchResult, final String expectedMessage) {
        final MatchResultOutput matchResultOutput = new MatchResultOutput(matchResult);
        assertThat(matchResultOutput.getMessage())
                .isEqualTo(expectedMessage);
    }

    private static Stream<Arguments> provideCreateTestArguments() {
        return Stream.of(
                Arguments.of(createMatchResult(MatchType.BALL, MatchType.STRIKE, MatchType.STRIKE), "1볼 2스트라이크"),
                Arguments.of(createMatchResult(MatchType.BALL, MatchType.BALL), "2볼"),
                Arguments.of(createMatchResult(MatchType.STRIKE), "1스트라이크"),
                Arguments.of(createMatchResult(MatchType.STRIKE, MatchType.STRIKE, MatchType.STRIKE), "3스트라이크"),
                Arguments.of(createMatchResult(), "낫싱")
        );
    }

    private static MatchResult createMatchResult(final MatchType... matchTypes) {
        final MatchResult matchResult = new MatchResult();
        for (final MatchType matchType : matchTypes) {
            matchResult.add(matchType);
        }
        return matchResult;
    }
}