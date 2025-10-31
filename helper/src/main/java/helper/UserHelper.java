package helper;

import academy.portal.service.http.api.models.PostUserTokenV1Request;
import academy.portal.service.http.api.steps.AcademyPortalServiceHttpApiSteps;
import common.configs.Config;
import helper.annotations.AUserConfig;

public class UserHelper {

	public static User login(AUserConfig config) {
		var result = new User();

 		var credentials = Config.USER.getCredentials()
			.get(config.role());

		 result.setUsername(credentials.getUsername());
		 result.setPassword(credentials.getPassword());

		 if (config.generateToken()) {
			 var apiSteps = new AcademyPortalServiceHttpApiSteps();

			 var tokenRequest = new PostUserTokenV1Request();
			 tokenRequest.setPassword(credentials.getPassword());
			 tokenRequest.setUsername(credentials.getUsername());

			 var tokenResponse = apiSteps.postUserTokenV1(tokenRequest);
			 result.setToken(tokenResponse.getToken());
		 }

		return result;
	}

}
