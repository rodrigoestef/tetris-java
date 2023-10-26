package com.estef.tetris.application;

import com.estef.tetris.domain.Game;
import com.estef.tetris.utils.Observable;

public class ViewModel {
  private final Observable<Game> observable = new Observable<Game>();

  private static ViewModel instance = new ViewModel();

  public void start(){
    observable.next(new Game());
  }

  private ViewModel(){

  }

  public static ViewModel getInstance(){
    return instance;
  }

  public Observable<Game> getObservable() {
    return this.observable;
  }

}
