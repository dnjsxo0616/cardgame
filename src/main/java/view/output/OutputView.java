package view.output;

import domain.Player;
import domain.Players;
import view.contents.ContentsMessage;

import java.util.List;

public class OutputView {
    public static void println(ContentsMessage contentsMessage, int countNumber, int leftoverCard) {
        System.out.println(contentsMessage.getFormattedMessage(countNumber, leftoverCard));
    }

    public static void print(ContentsMessage contentsMessage) {
        System.out.print(contentsMessage.getMessage());
    }

    public static void print(ContentsMessage contentsMessage, int count) {
        System.out.print(contentsMessage.getFormattedMessage(count));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printBackOfBoard(int[][] cardBoard) {
        for (int i = 0; i < cardBoard.length; i++) {
            for (int j = 0; j < cardBoard[i].length; j++) {
                if (cardBoard[i][j] == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printSelectNumberBoard(int[][] cardBoard, int[] input1, int[] input2) {
        for (int i = 0; i < cardBoard.length; i++) {
            for (int j = 0; j < cardBoard[i].length; j++) {
                if (i == input1[0] && j == input1[1] || i == input2[0] && j == input2[1]) {
                    System.out.print(cardBoard[i][j]);
                } else {
                    System.out.print("X");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 확인용
    public static void printBoard(int[][] cardBoard) {
        for (int i = 0; i < cardBoard.length; i++) {
            for (int j = 0; j < cardBoard[i].length; j++) {
                System.out.print(cardBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void printWinnerPlayer(Players players) {
        List<String> winnerPlayerName = players.winnerPlayer();
        if (winnerPlayerName.size() == 1) {
            System.out.printf((ContentsMessage.WINNER_MESSAGE.getMessage()) + "%n", winnerPlayerName.get(0));
        } else {
            StringBuilder winners = new StringBuilder(ContentsMessage.WINNERS_MESSAGE.getMessage());
            for (int i = 0; i < winnerPlayerName.size(); i++) {
                winners.append(winnerPlayerName.get(i));
                if (i < winnerPlayerName.size() - 1) {
                    winners.append(", ");
                }
            }
            System.out.println(winners);
        }
    }

    public static void printPlayerScore(Players players) {
        for (int i = 0; i < players.getPlayersSize(); i++) {
            Player player = players.getPlayer(i);
            System.out.printf((ContentsMessage.PLAYER_SCORE_MESSAGE.getMessage()) + "%n", player.getName().toString(), player.getScore());
        }
    }
}
