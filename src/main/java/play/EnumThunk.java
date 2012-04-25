package play;

public class EnumThunk<T> extends Thunk<T> {

  private enum State {
    COMPUTED {
      @Override
      <T> T get(final EnumThunk<T> that) {
        return that.result;
      }
    },

    UNCOMPUTED {
      @Override
      <T> T get(final EnumThunk<T> that) {
        that.result = that.compute();
        that.state = this;
        return that.result;
      }
    };

    abstract <T> T get(EnumThunk<T> that);
  }

  private T result;
  private State state = State.UNCOMPUTED;

  @Override
  T get() {
    return state.get(this);
  }

}

