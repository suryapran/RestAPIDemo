package stepdefinition;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable
	{
		//excute only placeid is null
		StepDefinitions sd=new StepDefinitions();
		if(sd.placeid==null)
		{
		
			sd.add_place_payload_with_something_something_something("Shetty", "Spanish", "Asia");
			sd.user_calls_something_with_something_http_request("AddPlaceAPI", "POST");
			sd.verify_placeid_created_maps_to_something_using_something("Shetty", "getPlaceAPI");
			
		}
	}

}
