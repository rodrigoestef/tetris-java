package com.estef.tetris.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JFrame;

import com.estef.tetris.application.ViewModel;
import com.estef.tetris.domain.Game;
import com.estef.tetris.domain.Piece;
import com.estef.tetris.domain.Point;
import com.estef.tetris.domain.pieces.Cube;

public class Window extends JFrame implements KeyListener, Consumer<Game> {

  private Piece piece = new Cube();
  private List<Point> points = new ArrayList<Point>();

  private ViewModel viewModel = ViewModel.getInstance();

  public Window() {
    this.setSize(Point.W, Point.H);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.viewModel.getObservable().subscribe(this);
    this.addKeyListener(this);

  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    this.points.forEach(p ->{
      g.setColor(Color.BLACK);
      g.fillRect((p.x * Point.R) - Point.R, (Point.H - p.y * Point.R) - Point.R, Point.D, Point.D);
    });

    this.piece.getPoints().forEach(p -> {
      g.setColor(Window.this.piece.getColor());
      g.fillRect((p.x * Point.R) - Point.R, (Point.H - p.y * Point.R) - Point.R, Point.D, Point.D);
    });
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == 37) {
      ViewModel.getInstance().right();
    } else if (e.getKeyCode() == 39) {
      ViewModel.getInstance().left();
    } else
      ViewModel.getInstance().rotate();
    this.repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void accept(Game t) {
    this.piece = t.getCurrentPiece();
    this.points = t.getPoints();
    this.repaint();
  }

}
