package com.estef.tetris.view;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import com.estef.tetris.domain.Piece;

public class Window extends JFrame implements KeyListener {

  private Piece piece;

  private final int R = 20;

  public Window(Piece piece) {
    this.piece = piece;
    this.setSize(this.R * 2 * 8, this.R * 2 * 12);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    new Timer().scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        Window.this.piece.down();
        Window.this.repaint();
      }
    }, 1000, 1000);

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

}
