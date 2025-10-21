package academy.portal.service.http.api;

import academy.portal.service.http.api.models.PostUserTokenV1Request;
import base.http.api.BaseHttpApi;
import base.http.api.RestResponse;

public class AcademyPortalService extends BaseHttpApi {
	private final String host;

	private final String api = "/api";

	private final String v1 = "/v1";

	private final String apiUser = api + "/user";
	private final String apiUserAdmin = apiUser + "/admin";
	private final String apiUserToken = apiUser + "/token";

	public AcademyPortalService(String host) {
		this.host = host;
	}

	public RestResponse postUserTokenV1(PostUserTokenV1Request request) {
		var utl = host.concat(apiUserToken)
			.concat(v1);

		return sendPost(utl, request);
	}
}
