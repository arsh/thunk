package play;

import java.util.Date;

public abstract class Thunk<T> {

  abstract T get();

  final T compute() {
    System.out.println("computed result at " + new Date());
    return null;
  }
}

