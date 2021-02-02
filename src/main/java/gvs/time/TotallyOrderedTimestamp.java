package gvs.time;

import java.math.BigInteger;

public class TotallyOrderedTimestamp implements Comparable<TotallyOrderedTimestamp> {

  private long id;
  private long timestamp;

  public TotallyOrderedTimestamp(long id, long timestamp) {
    this.id = id;
    this.timestamp = timestamp;
  }

  @Override
  public int compareTo(TotallyOrderedTimestamp arg) {
    if (this.getTimestamp() != arg.getTimestamp())
      return Long.compare(this.getTimestamp(), arg.getTimestamp());
    return Long.compare(this.getId(), arg.getId());
  }

  public BigInteger asBigInteger() {
    // Funktioniert, weil: falls id1 > id2, timestamp1 >= timestamp2
    return new BigInteger(id + "" + timestamp);
  }

  public long getTimestamp() {
    return timestamp;
  }

  public long getId() {
    return id;
  }
}
