package academy.portal.service.http.api.models;

import lombok.Data;

@Data
public class PostUserTokenV1Request {
	private String username;
	private String password;
}
