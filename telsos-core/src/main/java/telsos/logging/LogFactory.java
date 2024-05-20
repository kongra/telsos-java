// © 2024 Konrad Grzanek <kongra@gmail.com>
package telsos.logging;

@FunctionalInterface
public interface LogFactory<T> {

  Log create(T arg);

}