package com.estef.tetris.domain.pieces;

import java.awt.Color;

import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.Point;

public class Paralel extends Piece {
  public Paralel() {
    super(new Point(-2, 0, Color.RED), new Point(-0, 0, Color.RED), new Point(2, 0, Color.RED),
        new Point(-0, 2, Color.RED));
  }
}
