package com.github.gv.ms.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int rows;
    private int cols;
    private int mines;

    private final List<Tile> tiles = new ArrayList<Tile>();

    public Board(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;

        generateTiles();
        assignNeighbours();
        sortMines();
    }

    private void generateTiles() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                tiles.add(new Tile(r, c));
            }
        }
    }

    private void assignNeighbours() {
        for (Tile tile1 : tiles) {
            for (Tile tile2 : tiles) {
                tile1.addNeighbour(tile2);
            }
        }
    }

    private void sortMines() {

    }

}
