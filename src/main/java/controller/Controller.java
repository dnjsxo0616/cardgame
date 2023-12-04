package controller;

import domain.Board;
import domain.BoardPosition;
import domain.Players;
import view.contents.ContentsMessage;
import view.input.InputView;
import view.output.OutputView;

public class Controller {
    private Players players;
    private int playerIndex = 0;
    private int multipleCount = 1;

    public void play() {
        Board board = new Board();
//        OutputView.printBoard(board.getCardBoard());

        while (true) {
            try {
                OutputView.print(ContentsMessage.PLAYERS_MESSAGE);
                players = Players.createNewPlayers(InputView.readInput());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.println(e.getMessage());
            }
        }

        int roundCount = 0;
        while (!board.checkBoard()) {
            roundCount++;
            OutputView.printNewLine();
            OutputView.printBackOfBoard(board.getCardBoard());
            OutputView.println(ContentsMessage.INPUT_PLAY_MESSAGE, roundCount, board.cardBoardSize());
            OutputView.printPlayerScore(players);

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

                players.getPlayer(playerIndex).plusScore(multipleCount);
                multipleCount++;
            } else {
                playerIndex = (playerIndex + 1) % players.getPlayersSize();
                multipleCount = 1;
            }
        }

        OutputView.print(ContentsMessage.FINISH_MESSAGE);
        OutputView.printNewLine();
        OutputView.print(ContentsMessage.CLOSE_MESSAGE);
        OutputView.printNewLine();

        OutputView.printWinnerPlayer(players);

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
