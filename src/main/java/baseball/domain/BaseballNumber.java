package baseball.domain;

public class BaseballNumber {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;

    private final int number;

    public BaseballNumber(final int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(final int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("BaseballNumber는 1에서 9 사이의 값이어야 합니다. input number: %d", number));
        }
    }
}
