package common.configs;

import com.google.gson.Gson;
import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

@Data
public class UserConfig {
	private Map<Role, Credentials> credentials;

	public static UserConfig create(AutotestConfig autotestConfig) {
		var inputStream = UserConfig.class.getClassLoader()
			.getResourceAsStream("user_" + autotestConfig.getStand().name().toLowerCase() + ".json");

		if (inputStream == null) {
			throw new RuntimeException("User config file not found!");
		}

		var reader = new BufferedReader(
			new InputStreamReader(inputStream)
		);

		return new Gson()
			.fromJson(reader, UserConfig.class);
	}

	@Data
	public static class Credentials {
		private String username;
		private String password;
	}

	public enum Role {
		admin,
		couch
	}
}
