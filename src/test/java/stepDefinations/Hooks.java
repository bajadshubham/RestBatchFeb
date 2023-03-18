package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeDeleteScenario() throws IOException {
		stepDefination m = new stepDefination();
		m.add_Place_Payload("Gopal", "marathi", "pune");
		m.user_calls_with_post_http_request("addPlaceAPI", "Post");
		m.verify_place_id_created_maps_to_using("Gopal", "getPlaceAPI");
	}

}
