package baseball.domain;

import java.util.List;

@FunctionalInterface
public interface UniqueNumberListGenerator {
    List<Integer> generate(final int startInclusive, final int endInclusive, final int count);
}
