package com.estef.tetris.domain.pieces;

import java.awt.Color;

import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.Point;

public class Scade extends Piece {
  public Scade() {
    super(new Point(-2, 1), new Point(-0, 1), new Point(0, -1), new Point(2, -1),Color.GREEN);
  }
}
