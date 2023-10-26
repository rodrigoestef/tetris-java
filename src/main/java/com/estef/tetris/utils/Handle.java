package com.estef.tetris.utils;

public abstract class Handle<T, E> {
  private Handle<T, E> handle;

  public Handle<T,E> setNext(Handle<T,E> next){
    this.handle = next;
    return this.handle;
  }

  public E run(T value) {
    return this.handle.run(value);
  }

}
