package common.configs;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Data
public class MicroserviceConfig {
	@SerializedName("academy_portal_service")
	private String academyPortalService;

	public static MicroserviceConfig create(AutotestConfig autotestConfig) {
		var inputStream = MicroserviceConfig.class.getClassLoader()
			.getResourceAsStream("microservice_" + autotestConfig.getStand().name().toLowerCase() + ".json");

		if (inputStream == null) {
			throw new RuntimeException("Microservice config file not found!");
		}

		var reader = new BufferedReader(
			new InputStreamReader(inputStream)
		);

		return new Gson()
			.fromJson(reader, MicroserviceConfig.class);
	}

}
