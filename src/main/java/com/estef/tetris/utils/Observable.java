package com.estef.tetris.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Observable<T> implements Consumer<Observable<T>.Observer> {
  public class Observer implements Consumer<T> {

    private final Consumer<T> consumer;

    private final Observable<T> parent;

    public Observer(Consumer<T> consumer, Observable<T> parent) {
      this.consumer = consumer;
      this.parent = parent;
    }

    public void unsubscribe() {
      this.parent.remove(this);
    }

    @Override
    public void accept(T t) {
      this.consumer.accept(t);
    }

  }

  private List<Observer> subscribes = new ArrayList<Observer>();

  private T value;

  public void next(T t) {
    this.value = t;
    this.subscribes.forEach(this);
  }

  public void remove(Observable<T>.Observer observer) {

    int index = this.subscribes.indexOf(observer);

    this.subscribes.remove(index);

  }

  public Observer subscribe(Consumer<T> consumer) {
    var observer = new Observer(consumer, this);

    this.subscribes.add(observer);

    return observer;

  }

  @Override
  public void accept(Observer t) {
    t.accept(this.value);
  }

}
