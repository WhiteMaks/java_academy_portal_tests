package academy.portal.service.http.api;

import academy.portal.service.http.api.models.user.PostUserTokenV1Request;
import academy.portal.service.http.api.models.user.PostUserV1Request;
import base.http.api.BaseHttpApi;
import base.http.api.RestResponse;

import java.util.HashMap;
import java.util.Map;

public class AcademyPortalService extends BaseHttpApi {
	private final String host;

	private final String api = "/api";

	private final String v1 = "/v1";

	private final String apiUser = api + "/user";
	private final String apiUserAdmin = apiUser + "/admin";
	private final String apiUserToken = apiUser + "/token";

	private final String apiMicroservice = api + "/microservice";

	public AcademyPortalService(String host) {
		this.host = host;
	}

	public RestResponse getMicroserviceV1() {
		var url = host.concat(apiMicroservice)
			.concat(v1);

		return sendGet(url);
	}

	public RestResponse postUserAdminV1(PostUserV1Request request) {
		var url = host.concat(apiUserAdmin)
			.concat(v1);

		return sendPost(url, request);
	}

	public RestResponse postUserV1(PostUserV1Request request, String token) {
		var url = host.concat(apiUser)
			.concat(v1);

		return sendPost(url, request, generateHeaders(token));
	}

	public RestResponse postUserTokenV1(PostUserTokenV1Request request) {
		var utl = host.concat(apiUserToken)
			.concat(v1);

		return sendPost(utl, request);
	}

	private Map<String, String> generateHeaders(String token) {
		var result = new HashMap<String, String>();

		result.put("Authorization", "Bearer " + token);

		return result;
	}
}
