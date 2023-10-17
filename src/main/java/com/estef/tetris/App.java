package com.estef.tetris;

import com.estef.tetris.domain.pieces.Cube;
import com.estef.tetris.domain.pieces.Ele;
import com.estef.tetris.domain.pieces.Line;
import com.estef.tetris.domain.pieces.Paralel;
import com.estef.tetris.domain.pieces.Scade;
import com.estef.tetris.view.PieceView;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    new PieceView(new Paralel());
    new PieceView(new Cube());
    new PieceView(new Line());
    new PieceView(new Scade());
    new PieceView(new Ele());
  }
}
