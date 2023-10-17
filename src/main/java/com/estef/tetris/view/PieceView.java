package com.estef.tetris.view;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import com.estef.tetris.domain.Piece;

public class PieceView extends JFrame {

  private Piece piece;

  public PieceView(Piece piece) {
    this.piece = piece;
    this.setSize(200, 200);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    new Timer().scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        PieceView.this.piece = PieceView.this.piece.rotate();
        PieceView.this.repaint();
      }
    }, 0, 1000);

  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    var w = this.getWidth();
    var h = this.getHeight();

    var R = this.getWidth() / 10;

    this.piece.getPoints().forEachRemaining(p -> {
      g.setColor(PieceView.this.piece.getColor());
      g.fillRect((int) (w / 2 + p.x * R) - R, (int) (h / 2 - p.y * R) - R, R * 2, R * 2);

    });
  }

}
