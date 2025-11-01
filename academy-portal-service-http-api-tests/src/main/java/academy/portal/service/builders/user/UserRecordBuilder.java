package academy.portal.service.builders.user;

import academy.portal.service.db.models.User;
import academy.portal.service.db.models.enums.Role;
import academy.portal.service.http.api.models.user.PostUserV1Request;
import org.junit.jupiter.api.Assertions;

public class UserRecordBuilder {

	public User prepareRecord(User actual, PostUserV1Request request, Role role) {
		var resultBuilder = actual.toBuilder();

		resultBuilder.role(role);
		resultBuilder.isActive(true);
		resultBuilder.username(request.getUsername());

		Assertions.assertNotNull(actual.getCreatedAt());
		Assertions.assertNotNull(actual.getUpdatedAt());

		return resultBuilder.build();
	}

}
