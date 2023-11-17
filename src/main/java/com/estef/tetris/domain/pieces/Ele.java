package com.estef.tetris.domain.pieces;

import java.awt.Color;

import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.Point;

public class Ele extends Piece {
  public Ele() {
    super(new Point(-2, 0, Color.PINK), new Point(0, 0, Color.PINK), new Point(2, 0, Color.PINK),
        new Point(2, 2, Color.PINK));
  }
}
