package common.configs;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Data
public class DatabaseConfig {
	@SerializedName("academy_portal_service")
	private Database academyPortalService;

	public static DatabaseConfig create(AutotestConfig autotestConfig) {
		var inputStream = DatabaseConfig.class.getClassLoader()
			.getResourceAsStream("database_" + autotestConfig.getStand().name().toLowerCase() + ".json");

		if (inputStream == null) {
			throw new RuntimeException("Database config file not found!");
		}

		var reader = new BufferedReader(
			new InputStreamReader(inputStream)
		);

		return new Gson()
			.fromJson(reader, DatabaseConfig.class);
	}

	@Data
	public static class Database {
		private String host;
		private String name;
		private String username;
		private String password;
		@SerializedName("strict_mapper")
		private Boolean strictMapper;
	}
}
