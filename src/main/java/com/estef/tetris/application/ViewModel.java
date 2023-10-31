package com.estef.tetris.application;

import java.util.Timer;
import java.util.TimerTask;

import com.estef.tetris.domain.Game;
import com.estef.tetris.utils.Observable;

public class ViewModel extends TimerTask {
  private final Observable<Game> observable = new Observable<Game>();

  private static ViewModel instance = new ViewModel();

  public void start() {
    observable.next(new Game());
    new Timer().scheduleAtFixedRate(this, 1000, 1000);
  }

  public void newGame(){
    observable.next(new Game());
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

    if(game.isGameOver()){
      return;
    }

    this.observable.next(game.down());

  }

}
