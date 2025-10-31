package academy.portal.service.http.api.models;

import lombok.Data;

@Data
public class PostUserV1Request {
	private String username;
	private String password;
}
