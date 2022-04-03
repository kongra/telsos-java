// © 2022 Konrad Grzanek <kongra@gmail.com>
package telsos;

import static telsos.Ch.chEmail;

public record Email(String value) {

  public static Email of(String value) {
    return new Email(value);
  }

  public Email {
    chEmail(value);
  }

}