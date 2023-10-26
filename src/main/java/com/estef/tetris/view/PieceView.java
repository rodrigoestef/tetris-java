package com.estef.tetris.view;

import java.awt.Graphics;
import java.util.function.Consumer;

import javax.swing.JFrame;

import com.estef.tetris.application.ViewModel;
import com.estef.tetris.domain.Game;
import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.pieces.Cube;

public class PieceView extends JFrame implements Consumer<Game> {

  private Piece piece = new Cube();

  private ViewModel viewModel = ViewModel.getInstance();

  public PieceView() {
    this.setSize(200, 200);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.viewModel.getObservable().subscribe(this);

  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    var w = this.getWidth();
    var h = this.getHeight();

    var R = this.getWidth() / 10;

    this.piece.getCentralyPoints().forEach(p -> {
      g.setColor(PieceView.this.piece.getColor());
      g.fillRect((w / 2 + p.x * R) - R, (h / 2 - p.y * R) - R, R * 2, R * 2);

    });
  }

  @Override
  public void accept(Game t) {
  
    this.piece = t.getNextPiece();

    this.repaint();

  }

}
