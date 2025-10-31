package academy.portal.service.db;

import base.db.BaseDatabase;
import base.db.enums.JdbcDriver;
import common.configs.DatabaseConfig;

public class AcademyPortalServiceDatabase extends BaseDatabase {

	public AcademyPortalServiceDatabase(DatabaseConfig.Database database) {
		this(
			JdbcDriver.POSTGRESQL,
			database.getHost(),
			database.getName(),
			database.getUsername(),
			database.getPassword(),
			database.getStrictMapper()
		);
	}

	public AcademyPortalServiceDatabase(JdbcDriver driver, String host, String dbName, String username, String password, boolean strictMapper) {
		super(
			driver,
			host,
			dbName,
			username,
			password,
			strictMapper
		);
	}

}
