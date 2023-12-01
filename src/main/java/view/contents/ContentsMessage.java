package view.Contents;

public enum ContentsMessage {
    INPUT_PLAY_MESSAGE("<시도 %d, 남은 카드: %d> 좌표를 두 번 입력하세요."),
    INPUT_FRIST("입력 %d? "),
    FINISH_MESSAGE("축하합니다~ 모든 카드를 맞췄습니다!!"),
    CLOSE_MESSAGE("게임을 종료합니다.");

    private final String message;

    ContentsMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(int count) {
        return String.format(message, count);
    }

    public String getFormattedMessage(int countNumber, int leftoverCard) {
        return String.format(message, countNumber, leftoverCard);
    }
}
