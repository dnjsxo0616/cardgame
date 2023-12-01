package view.output;

import view.contents.ContentsMessage;

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
                    System.out.print(" ");
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
    }
}
