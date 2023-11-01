package com.estef.tetris.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.estef.tetris.application.KeyController;
import com.estef.tetris.application.ViewModel;
import com.estef.tetris.domain.Game;

public class Window extends JFrame implements Consumer<Game> {
  public Window() {

    ViewModel.getInstance().getObservable().subscribe(this);

    this.setSize(500, 500);
    this.setTitle("Tetris");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new GridBagLayout());
    var c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 0.7;
    c.weighty = 0.7;
    c.gridx = 0;
    c.gridy = 0;
    this.add(new Grid(), c);
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 0.3;
    c.weighty = 0;
    c.gridx = 1;
    c.gridy = 0;
    this.add(new PieceView(), c);

    this.addKeyListener(new KeyController());

    this.setVisible(true);
  }

  @Override
  public void accept(Game t) {
  
    if(!t.isGameOver()){
      return;
    }

    var response = JOptionPane.showConfirmDialog(this, "Start new game ?", "Game Over", JOptionPane.YES_NO_OPTION);

    if(response == JOptionPane.YES_OPTION){
      ViewModel.getInstance().newGame();
      return;
    }

    System.exit(0);
  }
}
