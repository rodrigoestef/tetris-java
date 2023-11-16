package com.estef.tetris.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JPanel;

import com.estef.tetris.application.ViewModel;
import com.estef.tetris.domain.Game;
import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.Point;
import com.estef.tetris.domain.pieces.Cube;

public class Grid extends JPanel implements Consumer<Game> {

  private Piece piece = new Cube();
  private List<Point> points = new ArrayList<Point>();

  private ViewModel viewModel = ViewModel.getInstance();

  public Grid() {
    this.viewModel.getObservable().subscribe(this);
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    g.drawRect(0, 0, Point.W, Point.H);

    this.points.forEach(p -> {
      g.setColor(p.color);
      g.fillRect((p.x * Point.R) - Point.R, (Point.H - p.y * Point.R) - Point.R, Point.D, Point.D);
      g.setColor(Color.BLACK);
      g.drawRect((p.x * Point.R) - Point.R, (Point.H - p.y * Point.R) - Point.R, Point.D, Point.D);
    });

    this.piece.getPoints().forEach(p -> {
      g.setColor(Grid.this.piece.getColor());
      g.fillRect((p.x * Point.R) - Point.R, (Point.H - p.y * Point.R) - Point.R, Point.D, Point.D);
      g.setColor(Color.BLACK);
      g.drawRect((p.x * Point.R) - Point.R, (Point.H - p.y * Point.R) - Point.R, Point.D, Point.D);
    });
  }

  @Override
  public void accept(Game t) {
    this.piece = t.getCurrentPiece();
    this.points = t.getPoints();
    this.repaint();
  }

}
