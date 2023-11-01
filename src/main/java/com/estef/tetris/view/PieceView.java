package com.estef.tetris.view;

import java.awt.Graphics;
import java.util.function.Consumer;

import javax.swing.JPanel;

import com.estef.tetris.application.ViewModel;
import com.estef.tetris.domain.Game;
import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.pieces.Cube;

public class PieceView extends JPanel implements Consumer<Game> {

  private Piece piece = new Cube();

  private ViewModel viewModel = ViewModel.getInstance();

  public PieceView() {
    this.setSize(200, 200);
    this.viewModel.getObservable().subscribe(this);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    g.drawRect(0, 0, 200, 200);

    var w = 200;
    var h = 200;

    var R = 200 / 10;

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
