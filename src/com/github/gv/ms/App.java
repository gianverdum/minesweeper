package com.github.gv.ms;

import com.github.gv.ms.model.Board;
import com.github.gv.ms.view.BoardConsole;

public class App {

    public static void main(String[] args) {

        Board board = new Board(6,6,6);
        new BoardConsole(board);
    }
}
