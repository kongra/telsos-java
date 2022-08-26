package telsos.string;

import java.util.Optional;
import java.util.function.Predicate;

import telsos.Ch;
import telsos.newtype.Newtype;

public final class NonBlank extends Newtype<String> {

  public static NonBlank of(String s) {
    return Ch.checked(s, ch, NonBlank::new);
  }

  public static Optional<NonBlank> optionallyOf(String s) {
    return Ch.checkedOptionally(s, pred, NonBlank::new);
  }

  public static boolean isBlank(String s) {
    return s == null || s.isBlank();
  }

  public static final Predicate<String> pred = Predicate.not(NonBlank::isBlank);

  public static final Ch<String> ch = Ch.of(pred);

  private NonBlank(String value) {
    super(value);
  }

}