package telsos.paip;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class DepthFirstSearch<T> {

  @FunctionalInterface
  public interface CarrierSupplier<T> extends Supplier<Deque<Iterator<T>>> {}

  public static <T> DepthFirstSearch<T> of(Adjs<T> adjs, Predicate<T> goal) {
    return new DepthFirstSearch<>(adjs, goal);
  }

  public Optional<T> search(T start) {
    return search(start, LinkedList::new);
  }

  public Optional<T> search(T start, CarrierSupplier<T> cs) {
    final var carrier = cs.get();
    carrier.addFirst(List.of(start).iterator());
    return searchImpl(carrier);
  }

  private Optional<T> searchImpl(Deque<Iterator<T>> carrier) {
    while (!carrier.isEmpty()) {
      final var firstIteratorInCarrier = carrier.getFirst();
      if (!firstIteratorInCarrier.hasNext()) {
        // No elements in the firstIteratorInCarrier, let's remove it.
        carrier.removeFirst();
        continue;
      }

      final var element = firstIteratorInCarrier.next();
      if (goal.test(element))
        // We have a success.
        return Optional.of(element);

      final var iterableOverChildren = adjs.apply(element);
      if (iterableOverChildren != null) {
        final var iteratorOverChildren = iterableOverChildren.iterator();
        if (iteratorOverChildren.hasNext()) {
          carrier.addFirst(iteratorOverChildren);
        }
      }
    }

    // No more iterables in the carrier - we didn't succeed.
    return Optional.empty();
  }

  private final Adjs<T> adjs;

  private final Predicate<T> goal;

  private DepthFirstSearch(Adjs<T> adjs, Predicate<T> goal) {
    this.adjs = Objects.requireNonNull(adjs);
    this.goal = Objects.requireNonNull(goal);
  }
}
