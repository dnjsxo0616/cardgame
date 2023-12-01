package controller;

import domain.Board;
import domain.BoardPosition;
import view.contents.ContentsMessage;
import view.input.InputView;
import view.output.OutputView;

public class Controller {
    public void play() {
        Board board = new Board();

        int roundCount = 0;
        while (!(board.checkBoard() || board.checkPairs())) {
            roundCount++;
            OutputView.printNewLine();
            OutputView.printBackOfBoard(board.getCardBoard());
            OutputView.println(ContentsMessage.INPUT_PLAY_MESSAGE, roundCount, board.cardBoardSize());

            int[] input1;
            int[] input2;

            while (true) {
                try {
                    input1 = getInput(1);
                    input2 = getInput(2);
                    if (board.checkEmptySpace(input1, input2)) {
                        throw new IllegalArgumentException("빈 공간의 좌표를 입력하셨습니다.");
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.println(e.getMessage());
                }
                OutputView.printNewLine();
            }

            OutputView.printSelectNumberBoard(board.getCardBoard(), input1, input2);

            if (board.checkEqualNumber(input1, input2)) {
                board.removeNumber(input1, input2);
                OutputView.printBackOfBoard(board.getCardBoard());
                OutputView.printNewLine();
            }
        }

        OutputView.print(ContentsMessage.FINISH_MESSAGE);
        OutputView.printNewLine();
        OutputView.print(ContentsMessage.CLOSE_MESSAGE);

    }

    private static int[] getInput(int inputCount) {
        while (true) {
            try {
                OutputView.print(ContentsMessage.INPUT_MESSAGE, inputCount);
                return BoardPosition.boardPosition(InputView.readInput());
            } catch (IllegalArgumentException e) {
                OutputView.println(e.getMessage());
            }
        }
    }
}
