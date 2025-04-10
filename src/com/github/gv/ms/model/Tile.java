package com.github.gv.ms.model;

import com.github.gv.ms.exception.ExplosionException;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private final int row;
    private final int col;

    private boolean isOpen;
    private boolean hasMine;
    private boolean hasFlag;

    private List<Tile> neighbours = new ArrayList<Tile>();

    Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }

    boolean addNeighbour(Tile neighbour) {
        boolean differentRow = row != neighbour.row;
        boolean differentCol = col != neighbour.col;
        boolean diagonal = differentRow && differentCol;

        int deltaRow = Math.abs(row - neighbour.row);
        int deltaCol = Math.abs(col - neighbour.col);
        int delta = deltaRow + deltaCol;

        if(delta == 1 && !diagonal) {
            neighbours.add(neighbour);
            return true;
        } else if(delta == 2 && diagonal) {
            neighbours.add(neighbour);
            return true;
        } else {
            return false;
        }

    }

    void changeFlag() {
        if(!isOpen) {
            hasFlag = !hasFlag;
        }
    }

    boolean open() {
        if(!isOpen && !hasFlag) {
            isOpen = true;

            if(hasMine) {
                throw new ExplosionException();
            }

            if(safeNeighbours()) {
                neighbours.forEach(Tile::open);
            }
            return true;
        } else {
            return false;
        }
    }

    boolean safeNeighbours() {
        return neighbours.stream().noneMatch(n -> n.hasMine);
    }
}
