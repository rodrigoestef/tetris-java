package com.estef.tetris.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ObservableTest {

  public String fist = "";

  public String second = "";

  @Test
  public void subscribe() {
    var observable = new Observable<String>();

    observable.subscribe(t -> {
      fist = t;
    });

    observable.next("fist");

    assertEquals("test first", "fist", fist);
    assertEquals("test first", "", second);

    observable.subscribe(t -> {
      second = t;
    });

    observable.next("second");
    assertEquals("test first", "second", fist);
    assertEquals("test first", "second", second);

  }

  @Test
  public void remove() {

    var observable = new Observable<String>();

    var first = observable.subscribe(t -> {
      fist = t;
    });

    var second = observable.subscribe(t -> {
      this.second = t;
    });

    observable.next("preremove");
    assertEquals("remove1", "preremove", fist);
    assertEquals("remove2", "preremove", this.second);


    first.unsubscribe();
    second.unsubscribe();

    observable.next("remove");
    assertEquals("remove1", "preremove", fist);
    assertEquals("remove2", "preremove", this.second);

  }

}
