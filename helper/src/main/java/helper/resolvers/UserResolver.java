package helper.resolvers;

import helper.User;
import helper.UserHelper;
import helper.annotations.AUserConfig;
import helper.annotations.AUserConfigFactory;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class UserResolver implements ParameterResolver {

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return parameterContext.getParameter().getType().equals(User.class);
	}

	@Override
	public @Nullable Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		var config = parameterContext.getDeclaringExecutable()
			.getAnnotation(AUserConfig.class);

		if (config == null) {
			config = AUserConfigFactory.create();
		}

		return UserHelper.login(config);
	}

}
