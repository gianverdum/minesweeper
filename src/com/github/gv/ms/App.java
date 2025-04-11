package com.github.gv.ms;

import com.github.gv.ms.model.Board;

public class App {

    public static void main(String[] args) {

        Board board = new Board(6,6,2);

        board.flag(3,3);
        board.flag(2,3);
        board.open(4,4);

        System.out.println(board);
    }
}
