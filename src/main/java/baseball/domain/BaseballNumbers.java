package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    public static final int REQUIRED_NUMBER_COUNT = 3;
    private static final int START_POSITION = 0;
    private static final String CANNOT_CREATE_MESSAGE_FORMAT = "BaseballNumbers를 생성할 수 없습니다. input numberList: %s";

    private final List<BaseballNumber> baseballNumberList;

    public BaseballNumbers(final List<Integer> numberList) {
        validateNumberCount(numberList);
        validateUniqueNumber(numberList);
        baseballNumberList = new ArrayList<>();
        numberList.forEach(number -> baseballNumberList.add(new BaseballNumber(number)));
    }

    private void validateNumberCount(final List<Integer> numberList) {
        if (numberList == null || numberList.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(CANNOT_CREATE_MESSAGE_FORMAT, numberList));
        }
    }

    private void validateUniqueNumber(final List<Integer> numberList) {
        final Set<Integer> numberSet = new HashSet<>(numberList);
        if (numberSet.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(CANNOT_CREATE_MESSAGE_FORMAT, numberList));
        }
    }

    public MatchResult match(final BaseballNumbers other) {
        final MatchResult matchResult = new MatchResult();
        for (int thisPosition = START_POSITION; thisPosition < this.baseballNumberList.size(); ++thisPosition) {
            final BaseballNumber thisBaseballNumber = this.baseballNumberList.get(thisPosition);
            final int otherPosition = other.baseballNumberList.indexOf(thisBaseballNumber);
            final MatchType matchType = MatchType.judge(otherPosition >= START_POSITION, otherPosition == thisPosition);
            matchResult.add(matchType);
        }
        return matchResult;
    }

}
