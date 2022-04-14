package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메소드는 Set의 크기를 반환한다.")
    @Test
    public void sizeTest() {
        int actual = numbers.size();
        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "contains 메소드는 존재하는 값인 경우 참을 반환한다. ({index})")
    @ValueSource(ints = {1,2,3})
    public void containsTest01(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest(name = "contains 메소드는 값의 존재 여부를 반환한다. ({index})")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void containsTest02(int num, boolean expected) {
        boolean actual = numbers.contains(num);
        assertThat(actual).isEqualTo(expected);
    }

}
