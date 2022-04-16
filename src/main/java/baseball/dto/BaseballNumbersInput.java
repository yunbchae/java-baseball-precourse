package baseball.dto;

import baseball.domain.BaseballNumbers;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbersInput {

    private static final String BASEBALL_NUMBERS_REGEX = "[1-9]{3}";

    private final BaseballNumbers baseballNumbers;

    public BaseballNumbersInput(final String input) {
        validateInput(input);
        this.baseballNumbers = new BaseballNumbers(parse(input));
    }

    private void validateInput(final String input) {
        if (input == null || !input.matches(BASEBALL_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(String.format("입력값이 유효하지 않습니다. input: %s", input));
        }
    }

    private List<Integer> parse(final String input) {
        final List<Integer> numberList = new ArrayList<>();
        for (final char c : input.toCharArray()) {
            numberList.add(Character.getNumericValue(c));
        }
        return numberList;
    }

    public BaseballNumbers getBaseballNumbers() {
        return baseballNumbers;
    }
}
