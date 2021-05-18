package telsos.db;

import javax.sql.DataSource;

import org.jooq.SQLDialect;

import com.zaxxer.hikari.HikariConfig;

import telsos.db.tools.Dbi;
import telsos.db.tools.HikariPool;

public class Maas implements Dbi {

  public static Maas get() {
    return instance;
  }

  @Override
  public SQLDialect dialect() {
    return SQLDialect.POSTGRES;
  }

  @Override
  public DataSource dataSource() {
    return pool.dataSource();
  }

  private final HikariPool pool = new HikariPool() {
    @Override
    public HikariConfig hikariConfig() {
      var config = new HikariConfig();
      config.setJdbcUrl("jdbc:postgresql://localhost/MAAS");
      config.setUsername("jee");
      config.setPassword("jee");
      config.addDataSourceProperty("cachePrepStmts", "true");
      config.addDataSourceProperty("prepStmtCacheSize", "250");
      config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

      config.setMaximumPoolSize(100);
      config.setAutoCommit(true);
      config.setValidationTimeout(5000);

      return config;
    }
  };

  private static final Maas instance = new Maas();

  private Maas() {
  }
}
