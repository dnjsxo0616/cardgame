package view.contents;

public enum ContentsMessage {
    INPUT_PLAY_MESSAGE("<시도 %d, 남은 카드: %d> 좌표를 두 번 입력하세요."),
    INPUT_MESSAGE("입력 %d? "),
    FINISH_MESSAGE("축하합니다~ 모든 카드를 맞췄습니다!!"),
    CLOSE_MESSAGE("게임을 종료합니다."),
    PLAYERS_MESSAGE("1P, 2P의 플레이어의 이름을 입력하세요. "),
    WINNER_MESSAGE("최종 우승자 : %s"),
    WINNERS_MESSAGE("공동 우승 : "),
    PLAYER_SCORE_MESSAGE("%s의 점수는 %d");

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
