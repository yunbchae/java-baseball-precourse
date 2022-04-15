package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UniqueRandomNumberListGeneratorTest {

    @ParameterizedTest(name = "난수 생성 성공 테스트 [{arguments}]")
    @CsvSource(value = {"1, 9, 3", "1, 9, 0", "1, 9, 9"})
    void generateSuccessTest(final int startInclusive, final int endInclusive, final int count) {
        final UniqueRandomNumberListGenerator uniqueRandomNumberListGenerator = new UniqueRandomNumberListGenerator();
        final List<Integer> numberList = uniqueRandomNumberListGenerator.generate(startInclusive, endInclusive, count);

        final List<Integer> expectedNumberList = IntStream.rangeClosed(startInclusive, endInclusive).boxed().collect(Collectors.toList());
        assertThat(numberList)
                .hasSize(count)
                .doesNotHaveDuplicates()
                .allMatch(expectedNumberList::contains);
    }

    @ParameterizedTest(name = "난수 생성 실패 테스트 [{arguments}]")
    @CsvSource(value = {
            "2, 1, 1",
            "1, 2147483647, 1",
            "-1, 2147483646, 1",
            "1, 9, -1",
            "1, 9, 10"
    })
    void generateFailTest(final int startInclusive, final int endInclusive, final int count) {
        final UniqueRandomNumberListGenerator uniqueRandomNumberListGenerator = new UniqueRandomNumberListGenerator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> uniqueRandomNumberListGenerator.generate(startInclusive, endInclusive, count));
    }

}