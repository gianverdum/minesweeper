package com.github.gv.ms.model;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private final int row;
    private final int col;

    private boolean isOpen;
    private boolean hasMine;
    private boolean hasFlag;

    private List<Tile> neighbors = new ArrayList<Tile>();

    Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }

    boolean addNeighbor(Tile neighbor) {
        boolean differentRow = row != neighbor.row;
        boolean differentCol = col != neighbor.col;
        boolean diagonal = differentRow && differentCol;

        int deltaRow = Math.abs(row - neighbor.row);
        int deltaCol = Math.abs(col - neighbor.col);
        int delta = deltaRow + deltaCol;

        if(delta == 1 && !diagonal) {
            neighbors.add(neighbor);
            return true;
        } else if(delta == 2 && diagonal) {
            neighbors.add(neighbor);
            return true;
        } else {
            return false;
        }

    }
}
