package academy.portal.service.builders.microservice;

import academy.portal.service.db.models.enums.Role;
import academy.portal.service.db.steps.AcademyPortalServiceDbSteps;
import academy.portal.service.http.api.models.microservice.GetMicroserviceV1Response;

public class GetMicroserviceV1ResponseBuilder {
	private final AcademyPortalServiceDbSteps dbSteps;

	public GetMicroserviceV1ResponseBuilder(AcademyPortalServiceDbSteps dbSteps) {
		this.dbSteps = dbSteps;
	}

	public GetMicroserviceV1Response prepareResponse(GetMicroserviceV1Response actual) {
		var resultBuilder = actual.toBuilder();

		var adminUserRecords = dbSteps.findUserByRole(Role.admin);

		resultBuilder.readyToUse(!adminUserRecords.isEmpty());

		return resultBuilder.build();
	}

}
