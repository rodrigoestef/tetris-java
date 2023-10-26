package com.estef.tetris.view;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

import javax.swing.JFrame;

import com.estef.tetris.application.ViewModel;
import com.estef.tetris.domain.Game;
import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.pieces.Cube;

public class Window extends JFrame implements KeyListener, Consumer<Game> {

  private Piece piece = new Cube();

  private ViewModel viewModel = ViewModel.getInstance();

  private final int R = 20;

  public Window() {
    this.setSize(this.R * 2 * 8, this.R * 2 * 12);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.viewModel.getObservable().subscribe(this);
    this.addKeyListener(this);

  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    var w = this.getWidth();
    var h = this.getHeight();

    var R = this.getWidth() / (2 * 8);

    this.piece.getPoints().forEachRemaining(p -> {
      g.setColor(Window.this.piece.getColor());
      g.fillRect((w / 2 + p.x * R) - R, (h - p.y * R) - R, R * 2, R * 2);
    });
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(e.getKeyCode());
    if (e.getKeyCode() == 37) {
      this.piece.setX(-2);
    } else if (e.getKeyCode() == 39) {
      this.piece.setX(2);
    } else
      this.piece = this.piece.rotate();
    this.repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void accept(Game t) {
    this.piece = t.getCurrentPiece();
    System.out.println(this.piece);
    this.repaint();
  }

}
