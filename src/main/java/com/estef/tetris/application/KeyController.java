package com.estef.tetris.application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyController implements KeyListener {

  private static interface Fun {
    public void fun();
  }

  private HashMap<Integer, Fun> table = new HashMap<Integer, Fun>();

  public KeyController() {

    this.table.put(37, () -> ViewModel.getInstance().right());
    this.table.put(39, () -> ViewModel.getInstance().left());
    this.table.put(32, () -> ViewModel.getInstance().rotate());
    this.table.put(40, () -> ViewModel.getInstance().down());

  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    Fun f = this.table.get(e.getKeyCode());
  
    if(f == null){
      return;
    }

    f.fun();

  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

}
