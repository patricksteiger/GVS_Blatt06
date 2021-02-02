package gvs.time;

import java.util.concurrent.atomic.AtomicLong;

public class TotallyOrderedClock {
  private static AtomicLong id = new AtomicLong();
  private long PID;
  private AtomicLong currentTimestamp = new AtomicLong();

  public TotallyOrderedClock(long PID) {
    this.PID = PID;
  }

  public TotallyOrderedTimestamp createTimestamp() throws IllegalArgumentException {
    return createTimestamp(System.currentTimeMillis());
  }

  public TotallyOrderedTimestamp createTimestamp(long time) throws IllegalArgumentException {
    long update =
        this.currentTimestamp.updateAndGet(
            stamp -> {
              if (time < stamp) throw new IllegalArgumentException();
              return time;
            });
    TotallyOrderedTimestamp stamp = new TotallyOrderedTimestamp(id.incrementAndGet(), update);
    return stamp;
  }
}
