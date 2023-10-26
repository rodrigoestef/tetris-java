package com.estef.tetris;

import com.estef.tetris.application.ViewModel;
import com.estef.tetris.view.PieceView;
import com.estef.tetris.view.Window;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    // new Window(new Paralel());
    // new Window(new Line());
    // new Window(new Scade());
    new Window();

    new PieceView();
    ViewModel.getInstance().start();
    // new PieceView(new Line());
    // new PieceView(new Scade());
    // new PieceView(new Ele());

  }
}
