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
}
