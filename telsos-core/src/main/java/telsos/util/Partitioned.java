// © 2024 Konrad Grzanek <kongra@gmail.com>
package telsos.util;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

import telsos.math.newtype.PosInt;

public final class Partitioned<T> extends AbstractList<List<T>> {

  public static <T> Partitioned<T> partition(List<T> list,
      PosInt partitionSize) {
    return new Partitioned<>(list, partitionSize);
  }

  private final List<T> list;

  private final int partitionSize;

  private Partitioned(List<T> list, PosInt partitionSize) {
    // We don't make a defensive copy of the argument list!
    this.list = Objects.requireNonNull(list);
    this.partitionSize = partitionSize.value();
  }

  @Override
  public List<T> get(int index) {
    final var start = index * partitionSize;
    final var end = Math.min(start + partitionSize, list.size());

    if (start > end)
      throw new IndexOutOfBoundsException("Index " + index
          + " is out of the list range <0," + (size() - 1) + ">");

    // We don't make a defensive copy of the subList!
    return list.subList(start, end);
  }

  @Override
  public int size() {
    return (int) Math.ceil((double) list.size() / partitionSize);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

}