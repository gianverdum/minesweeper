package com.github.gv.ms.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    private Tile tile;

    @BeforeEach
    void initializeTile() {
        tile = new Tile(3, 3);
    }

    @Test
    void testNeighbourOnDelta1() {
        Tile neighbour = new Tile(3, 2);
        boolean result = tile.addNeighbor(neighbour);
        assertTrue(result);
    }

    @Test
    void testNeighbourOnDelta2() {
        Tile neighbour = new Tile(2, 2);
        boolean result = tile.addNeighbor(neighbour);
        assertTrue(result);
    }

    @Test
    void testExceptionNeighbourOnDelta0() {
        Tile neighbour = new Tile(3, 3);
        boolean result = tile.addNeighbor(neighbour);
        assertFalse(result);
    }

    @Test
    void testExceptionNeighbourOnDeltaGreaterThan2() {
        Tile neighbour = new Tile(3, 5);
        boolean result = tile.addNeighbor(neighbour);
        assertFalse(result);
    }
  
}