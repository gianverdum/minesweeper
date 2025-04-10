package com.github.gv.ms.model;

import com.github.gv.ms.exception.ExplosionException;
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
        boolean result = tile.addNeighbour(neighbour);
        assertTrue(result);
    }

    @Test
    void testNeighbourOnDelta2() {
        Tile neighbour = new Tile(2, 2);
        boolean result = tile.addNeighbour(neighbour);
        assertTrue(result);
    }

    @Test
    void testNeighbourOnDelta0() {
        Tile neighbour = new Tile(3, 3);
        boolean result = tile.addNeighbour(neighbour);
        assertFalse(result);
    }

    @Test
    void testNeighbourOnDeltaGreaterThan2() {
        Tile neighbour = new Tile(3, 5);
        boolean result = tile.addNeighbour(neighbour);
        assertFalse(result);
    }

    @Test
    void testTileDefaultValue() {
        assertFalse(tile.isOpen());
    }

    @Test
    void testOpenTileNotOpenedAndHasNotMine() {
        tile.open();
        assertTrue(tile.isOpen());
    }

    @Test
    void testOpenTileAlreadyOpenedAndHasMine() {
        tile.open();
        tile.setMine();
        assertTrue(tile.isOpen());
    }

    @Test
    void testExceptionOpenTileNotOpenedAndHasMine() {
        tile.setMine();
        assertThrows(ExplosionException.class, () -> {
            tile.open();
        });
    }

    @Test
    void testOpenTileWithNeighbours() {
        Tile tile11 = new Tile(1, 1);
        Tile tile22 = new Tile(2, 2);

        tile22.addNeighbour(tile11);
        tile.addNeighbour(tile22);

        tile.open();

        assertTrue(tile11.isOpen() && tile22.isOpen());
    }

    @Test
    void testOpenTileWithNeighboursHasMine() {
        Tile tile11 = new Tile(1, 1);
        Tile tile12 = new Tile(1, 2);
        Tile tile22 = new Tile(2, 2);

        tile12.setMine();
        tile22.addNeighbour(tile11);
        tile22.addNeighbour(tile12);
        tile.addNeighbour(tile22);

        tile.open();

        assertTrue(!tile11.isOpen() && tile22.isOpen());
    }

    @Test
    void testOpenTileShouldRemainOpenAfterMultipleOpenCalls() {
        tile.open();
        tile.open();
        assertTrue(tile.isOpen());
    }

    @Test
    void testFlagDefaultValue() {
        assertFalse(tile.hasFlag());
    }

    @Test
    void testSetFlag() {
        tile.changeFlag();
        assertTrue(tile.hasFlag());
    }

    @Test
    void testSetFlag2Calls() {
        tile.open();
        tile.open();
        assertFalse(tile.hasFlag());
    }
  
}