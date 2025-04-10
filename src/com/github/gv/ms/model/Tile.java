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
        return neighbors.add(neighbor);
    }
}
