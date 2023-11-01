package com.estef.tetris;

import com.estef.tetris.application.ViewModel;
import com.estef.tetris.view.Window;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {

    new Window();
    ViewModel.getInstance().start();
  }
}
