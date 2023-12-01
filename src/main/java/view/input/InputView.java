package view.input;

import java.util.Scanner;

public class InputView {
    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}