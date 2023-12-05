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
        initStart();

        int roundCount = 0;
        while (!board.checkBoard()) {
            roundCount++;
            printHeadOutput(board, roundCount);

            int[] input1;
            int[] input2;

            while (true) {
                try {
                    input1 = getInput(1);
                    input2 = getInput(2);
                    checkEmptySpace(board, input1, input2);
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.println(e.getMessage());
                }
                OutputView.printNewLine();
            }

            printSelectBoard(board, input1, input2);

            if (board.checkEqualNumber(input1, input2)) {
                removeAndScorePlus(board, input1, input2);
            } else {
                changePlayer();
            }
        }
        printFinishOutput();
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

    private void printHeadOutput(Board board, int roundCount) {
        OutputView.println(ContentsMessage.CURRENT_BOARD.getMessage());
        OutputView.printBackOfBoard(board.getCardBoard());
        OutputView.printNewLine();

        OutputView.println(ContentsMessage.INPUT_PLAY_MESSAGE, roundCount, board.cardBoardSize());

        OutputView.printWhoPlayer(ContentsMessage.WHO_PLAYER_MESSAGE, players.getPlayer(playerIndex).getName().toString());
        OutputView.printPlayerScore(players);
    }

    private void printFinishOutput() {
        OutputView.print(ContentsMessage.FINISH_MESSAGE);
        OutputView.printNewLine();
        OutputView.print(ContentsMessage.CLOSE_MESSAGE);
        OutputView.printNewLine();

        OutputView.printWinnerPlayer(players);
    }

    private void removeAndScorePlus(Board board, int[] input1, int[] input2) {
        board.removeNumber(input1, input2);
        OutputView.printBackOfBoard(board.getCardBoard());
        OutputView.printNewLine();

        players.getPlayer(playerIndex).plusScore(multipleCount);
        multipleCount++;
    }

    private void changePlayer() {
        playerIndex = (playerIndex + 1) % players.getPlayersSize();
        multipleCount = 1;
    }

    private void initStart() {
        while (true) {
            try {
                OutputView.print(ContentsMessage.PLAYERS_MESSAGE);
                players = Players.createNewPlayers(InputView.readInput());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.println(e.getMessage());
            }
        }
    }

    private void checkEmptySpace(Board board, int[] input1, int[] input2) {
        if (board.checkEmptySpace(input1, input2)) {
            throw new IllegalArgumentException("빈 공간의 좌표를 입력하셨습니다.");
        }
    }

    private void printSelectBoard(Board board, int[] input1, int[] input2) {
        OutputView.printNewLine();
        OutputView.println(ContentsMessage.SELECT_BOARD.getMessage());
        OutputView.printSelectNumberBoard(board.getCardBoard(), input1, input2);
    }
}
