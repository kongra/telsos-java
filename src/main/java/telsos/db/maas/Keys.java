/*
 * This file is generated by jOOQ.
 */
package telsos.db.maas;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import telsos.db.maas.tables.Profiles;
import telsos.db.maas.tables.records.ProfilesRecord;

/**
 * A class modelling foreign key relationships and constraints of tables in jee.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

  // -------------------------------------------------------------------------
  // UNIQUE and PRIMARY KEY definitions
  // -------------------------------------------------------------------------

  public static final UniqueKey<ProfilesRecord> PROFILES_PKEY = Internal
      .createUniqueKey(Profiles.PROFILES, DSL.name("profiles_pkey"),
          new TableField[] { Profiles.PROFILES.ID }, true);
}