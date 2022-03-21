package telsos.db.tools;

import javax.sql.DataSource;

import telsos.db.tools.Transactions.TxExpr;
import telsos.db.tools.Transactions.TxStmt;

public interface Db {

  SQLDialect dialect();

  DataSource dataSource();

  default <T> T inSerializable(int allowedRestartsCount, TxExpr<T> expr) {
    return Transactions.inSerializable(dialect(), dataSource(),
        allowedRestartsCount, expr);
  }

  default void inSerializable(int allowedRestartsCount, TxStmt stmt) {
    Transactions.inSerializable(dialect(), dataSource(), allowedRestartsCount,
        stmt);
  }

  default <T> T inSerializable1(TxExpr<T> expr) {
    return inSerializable(1, expr);
  }

  default void inSerializable1(TxStmt stmt) {
    inSerializable(1, stmt);
  }

  default <T> T inSerializable2(TxExpr<T> expr) {
    return inSerializable(2, expr);
  }

  default void inSerializable2(TxStmt stmt) {
    inSerializable(2, stmt);
  }

  default <T> T inSerializable5(TxExpr<T> expr) {
    return inSerializable(5, expr);
  }

  default void inSerializable5(TxStmt stmt) {
    inSerializable(5, stmt);
  }

  default <T> T inSerializable8(TxExpr<T> expr) {
    return inSerializable(8, expr);
  }

  default void inSerializable8(TxStmt stmt) {
    inSerializable(8, stmt);
  }

  default <T> T inSerializable(TxExpr<T> expr) {
    return inSerializable(Integer.MAX_VALUE, expr);
  }

  default void inSerializable(TxStmt stmt) {
    inSerializable(Integer.MAX_VALUE, stmt);
  }

  default <T> T inReadCommitted(TxExpr<T> expr) {
    return Transactions.inReadCommitted(dialect(), dataSource(), expr);
  }

  default void inReadCommitted(TxStmt stmt) {
    Transactions.inReadCommitted(dialect(), dataSource(), stmt);
  }

}