package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueRandomNumberListGenerator implements UniqueNumberListGenerator {

    private static final String INVALID_RANGE_MESSAGE_FORMAT = "난수를 생성할 수 없습니다. startInclusive: %d, endInclusive: %d";
    private static final String INVALID_COUNT_MESSAGE_FORMAT = "난수를 생성할 수 없습니다. startInclusive: %d, endInclusive: %d, count: %d";

    @Override
    public List<Integer> generate(final int startInclusive, final int endInclusive, final int count) {
        validateRange(startInclusive, endInclusive);
        validateCount(startInclusive, endInclusive, count);

        final Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < count) {
            numberSet.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
        }
        return new ArrayList<>(numberSet);
    }

    private static void validateRange(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException(String.format(INVALID_RANGE_MESSAGE_FORMAT, startInclusive, endInclusive));
        }
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException(String.format(INVALID_RANGE_MESSAGE_FORMAT, startInclusive, endInclusive));
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(String.format(INVALID_RANGE_MESSAGE_FORMAT, startInclusive, endInclusive));
        }
    }

    private static void validateCount(final int startInclusive, final int endInclusive, final int count) {
        if (count < 0) {
            throw new IllegalArgumentException(String.format(INVALID_COUNT_MESSAGE_FORMAT, startInclusive, endInclusive, count));
        }
        if (endInclusive - startInclusive + 1 < count) {
            throw new IllegalArgumentException(String.format(INVALID_COUNT_MESSAGE_FORMAT, startInclusive, endInclusive, count));
        }
    }
}
