package common.configs;

public interface Config {
	AutotestConfig AUTOTEST = AutotestConfig.create();
	MicroserviceConfig MICROSERVICE = MicroserviceConfig.create(AUTOTEST);
	UserConfig USER = UserConfig.create(AUTOTEST);
	DatabaseConfig DATABASE = DatabaseConfig.create(AUTOTEST);
}
