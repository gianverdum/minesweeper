package com.github.gv.ms.view;

import com.github.gv.ms.exception.ExitException;
import com.github.gv.ms.exception.ExplosionException;
import com.github.gv.ms.model.Board;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class BoardConsole {

    private Board board;
    private Scanner entry = new Scanner(System.in);

    public BoardConsole(Board board) {
        this.board = board;

        runGame();
    }

    private void runGame() {
        try {
            boolean continueGame = true;
            while (continueGame) {
                gameLoop();
                System.out.print("Let's Play? (Y/n): ");
                String input = entry.nextLine();

                if ("n".equalsIgnoreCase(input)) {
                    continueGame = false;
                } else {
                    board.reset();
                }
            }
        } catch (ExitException e) {
            System.out.println("Game ended");
        } finally {
            entry.close();
        }
    }

    private void gameLoop() {
        try {

            while (!board.goalAchieved()) {
                System.out.println(board);
                String input = getInput("Type (x,y): ");

                Iterator<Integer> xy = Arrays.stream(input.split(","))
                        .map(e -> Integer.parseInt(e.trim()))
                        .iterator();

                input = getInput("1 - Open or 2 - Flag: ");

                if ("1".equals(input)) {
                    board.open(xy.next(), xy.next());
                } else if ("2".equals(input)) {
                    board.flag(xy.next(), xy.next());
                }

            }
            System.out.println(board);
            System.out.println("You win!");
        } catch (ExplosionException e) {
            System.out.println(board);
            System.out.println("Game over!");
        }
    }

    private String getInput(String input) {
        System.out.print(input);
        String inputData = entry.nextLine();

        if("exit".equalsIgnoreCase(inputData)) {
            throw new ExitException();
        }
        return inputData;
    }
}
