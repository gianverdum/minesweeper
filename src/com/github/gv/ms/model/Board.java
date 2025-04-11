package com.github.gv.ms.model;

import com.github.gv.ms.exception.ExplosionException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    public void open(int row, int col) {
        try {
            tiles.parallelStream()
                    .filter(t -> t.getRow() == row && t.getCol() == col)
                    .findFirst()
                    .ifPresent(t -> t.open());
        } catch (ExplosionException e) {
            tiles.forEach(t -> t.setOpen(true));
            throw e;
        }
    }

    public void flag(int row, int col) {
        tiles.parallelStream()
                .filter(t -> t.getRow() == row && t.getCol() == col)
                .findFirst()
                .ifPresent(t -> t.changeFlag());
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
        long armedMines = 0;
        Predicate<Tile> hasMine = t -> t.hasMine();

        do {
            int random = (int) (Math.random() * tiles.size());
            tiles.get(random).setMine();
            armedMines = tiles.stream().filter(hasMine).count();
        } while (armedMines < mines);
    }

    public boolean goalAchieved() {
        return tiles.stream().allMatch(Tile::goalAchieved);
    }

    public void reset() {
        tiles.stream().forEach(Tile::reset);
        sortMines();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("  ");
        for (int c = 0; c < cols; c++) {
            sb.append(" ");
            sb.append(c);
            sb.append(" ");
        }
        sb.append("\n");

        int i = 0;
        for (int r = 0; r < rows; r++) {
            sb.append(r);
            sb.append(" ");
            for (int c = 0; c < cols; c++) {
                sb.append(" ");
                sb.append(tiles.get(i).toString());
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
