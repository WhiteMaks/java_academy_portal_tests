package academy.portal.service.http.api.models.user;

import lombok.Data;

@Data
public class GetUserV1Response {
	private Long id;
	private String username;
	private String role;
}
