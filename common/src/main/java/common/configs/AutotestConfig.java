package common.configs;

import com.google.gson.Gson;
import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Data
public class AutotestConfig {
	private Stand stand;

	public static AutotestConfig create() {
		var inputStream = AutotestConfig.class.getClassLoader()
			.getResourceAsStream("autotest.json");

		if (inputStream == null) {
			throw new RuntimeException("Autotest config file not found!");
		}

		var reader = new BufferedReader(
			new InputStreamReader(inputStream)
		);

		return new Gson()
			.fromJson(reader, AutotestConfig.class);
	}

	public enum Stand {
		LOCAL,
		DEV,
		INT,
		PROD
	}

}
