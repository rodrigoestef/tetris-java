package com.estef.tetris.domain;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class PieceTest {
  @Test
  public void mustNotPair(){
    var piece = new Piece(new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0), Color.BLUE);
  
    var p = piece.getPoints().next();

    assertEquals("not pair", new Point(1,25), p);

  }

}