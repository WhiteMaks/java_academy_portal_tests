package academy.portal.service.http.api.models.microservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class GetMicroserviceV1Response {
	private Boolean readyToUse;
}
