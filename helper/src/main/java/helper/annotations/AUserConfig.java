package helper.annotations;

import common.configs.UserConfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AUserConfig {
	UserConfig.Role role() default UserConfig.Role.admin;
	boolean generateToken() default true;
}
