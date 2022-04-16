package baseball.dto;

public class RestartOrQuitCommandInput {

    public static final String RESTART_COMMAND = "1";
    public static final String QUIT_COMMAND = "2";

    private final boolean restart;

    public RestartOrQuitCommandInput(final String input) {
        validateInput(input);
        this.restart = RESTART_COMMAND.equals(input);
    }

    private void validateInput(final String input) {
        if (!RESTART_COMMAND.equals(input) && !QUIT_COMMAND.equals(input)) {
            throw new IllegalArgumentException(String.format("입력값이 유효하지 않습니다. input: %s", input));
        }
    }

    public boolean isRestart() {
        return restart;
    }
}
