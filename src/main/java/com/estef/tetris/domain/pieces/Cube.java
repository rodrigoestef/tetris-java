package com.estef.tetris.domain.pieces;

import java.awt.Color;

import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.Point;

public class Cube extends Piece {

  public Cube() {
    super(new Point(1, 1, Color.YELLOW), new Point(1, -1, Color.YELLOW), new Point(-1, -1, Color.YELLOW),
        new Point(-1, 1, Color.YELLOW), Color.YELLOW);
  }

}
