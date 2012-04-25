package play;

public class ConditionalThunk<T> extends Thunk<T> {

  boolean computed;
  T value;

  @Override
  T get() {
    if (!computed) { value = compute(); computed = true; }
    return value;
  }

}
