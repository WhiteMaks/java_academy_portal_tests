package helper.annotations;

import common.configs.UserConfig;

import java.lang.annotation.Annotation;

public class AUserConfigFactory {

	public static AUserConfig create() {
		return defaultUserConfig();
	}

	private static AUserConfig defaultUserConfig() {
		return new AUserConfig() {

			@Override
			public Class<? extends Annotation> annotationType() {
				return AUserConfig.class;
			}

			@Override
			public UserConfig.Role role() {
				return UserConfig.Role.admin;
			}

			@Override
			public boolean generateToken() {
				return true;
			}
		};
	}
}
