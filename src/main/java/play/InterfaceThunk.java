package play;

public class InterfaceThunk<T> extends Thunk<T> {

  private interface Holder<T> {
    T get();
  }

  private class ComputedHolder implements Holder<T> {
    @Override
    public T get() {
      return result;
    }
  }

  private class WaitingHolder implements Holder<T> {
    @Override
    public T get() {
      result = compute();
      holder = new ComputedHolder();
      return result;
    }
  }

  private T result;

  private Holder<T> holder = new WaitingHolder();

  @Override
  T get() {
    return holder.get();
  }

}
