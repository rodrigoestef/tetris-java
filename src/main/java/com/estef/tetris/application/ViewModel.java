package com.estef.tetris.application;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.estef.tetris.domain.Game;
import com.estef.tetris.domain.Point;
import com.estef.tetris.domain.pieces.Ele;
import com.estef.tetris.utils.Observable;

public class ViewModel extends TimerTask {
  private final Observable<Game> observable = new Observable<Game>();

  private static ViewModel instance = new ViewModel();

  public void start() {
    var a = new ArrayList<Point>();
    a.add(new Point(1, 3));
    a.add(new Point(3, 3));
    a.add(new Point(5, 3));
    a.add(new Point(7, 3));
    a.add(new Point(9, 3));
    a.add(new Point(11, 3));
    a.add(new Point(13, 3));
    a.add(new Point(15, 3));
    a.add(new Point(1, 1));
    a.add(new Point(3, 1));
    a.add(new Point(5, 1));
    a.add(new Point(7, 1));
    a.add(new Point(9, 1));
    a.add(new Point(11, 1));
    a.add(new Point(13, 1));
    a.add(new Point(15, 1));
    observable.next(new Game(new Ele(), new Ele(), a));
    new Timer().scheduleAtFixedRate(this, 1000, 1000);
  }

  private ViewModel() {

  }

  public static ViewModel getInstance() {
    return instance;
  }

  public Observable<Game> getObservable() {
    return this.observable;
  }

  public void rotate() {
    var game = this.observable.getCurrent();

    this.observable.next(game.rotate());
  }

  public void right() {
    var game = this.observable.getCurrent();

    this.observable.next(game.right());
  }

  public void left() {
    var game = this.observable.getCurrent();

    this.observable.next(game.left());
  }

  @Override
  public void run() {

    var game = this.observable.getCurrent();

    this.observable.next(game.down());

  }

}
