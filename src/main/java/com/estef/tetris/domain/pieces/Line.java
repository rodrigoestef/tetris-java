package com.estef.tetris.domain.pieces;

import java.awt.Color;

import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.Point;

public class Line extends Piece {

  public Line() {
    super(new Point(-3, 0, Color.BLUE), new Point(-1, 0, Color.BLUE), new Point(1, 0, Color.BLUE),
        new Point(3, 0, Color.BLUE), Color.BLUE);
  }

}
