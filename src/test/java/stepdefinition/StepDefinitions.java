package stepdefinition;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResourceEnum;
import resources.RequestSpecifications;
import resources.TestDataBuild;

public class StepDefinitions extends  RequestSpecifications
{
	RequestSpecification req;
	ResponseSpecification respoSpec;
	Response respo;
	static String placeid;
	JsonPath js;
	TestDataBuild data= new TestDataBuild();;
	
	@Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_payload_with_something_something_something(String name, String language, String address) throws Throwable 
	{
		//these 3 data is need to send in TestData payload
		// data = new TestDataBuild();
	
	      req=given().spec(RequestSpec())
				.body(data.addPlacePayLoad(name,language,address));
    }

	
//		 @Given("^Add Place Payload$")
//		 public void add_place_payload() throws Throwable 
//		 {
//		        
//								
//				TestDataBuild data = new TestDataBuild();
//				
//							
//				//RestAssured.baseURI="https://rahulshettyacademy.com";
////				 
//				
//			      res=given().spec(RequestSpec())
//						.body(data.addPlacePayLoad());
//				
//		  }

	@When("^User calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String resourc, String method) throws Throwable 
	{
		APIResourceEnum resoucrAPI=APIResourceEnum.valueOf(resourc);
    	System.out.println("resouce name ------"+resoucrAPI.getResource());
    	
    	respoSpec=new ResponseSpecBuilder()
    				.expectStatusCode(200)
    				.expectContentType(ContentType.JSON).build();
    	
    	if(method.equalsIgnoreCase("POST"))
    		 respo=req.when().post(resoucrAPI.getResource());
    	else if(method.equalsIgnoreCase("GET"))
   		 respo=req.when().get(resoucrAPI.getResource());
    	
//    	 respo=res.when().log().all()
//				.post(resoucrAPI.getResource())
//				.then().spec(respoSpec).extract().response();
//		String resp=respo.asString();
//
//		System.out.println("resp ----------"+resp);
    }
	

	
	

	    @Then("^The API call is success with status code 200$")
	    public void the_api_call_is_success_with_status_code_200() throws Throwable
	    {
	    	Assert.assertEquals(respo.getStatusCode(), 200);
	    	
	    }

	    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	    public void something_in_response_body_is_something(String key, String value) throws Throwable
	    {
//	       String resp=respo.asString();
//	        js= new JsonPath(resp);
	       //placeid= js.get("place_id");
	       

	    	Assert.assertEquals(getJsonPath(respo,key), value); 
	    }
	    

	    @And("^Verify place_Id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	    public void verify_placeid_created_maps_to_something_using_something(String name,String reso) throws Throwable
	    {
	    	   placeid= getJsonPath(respo,"place_id");
	    	   
	    	   req=given().spec(RequestSpec())
	   				.queryParam("place_id", placeid);
	    	   user_calls_something_with_something_http_request(reso,"GET");
	    	   String responame= getJsonPath(respo,"name");
	    	   Assert.assertEquals(name,responame);
	       
	    }
	    
	    @Given("^Deleteplace payload$")
	    public void deleteplace_payload() throws Throwable 
	    {
	    	
	    	req=given().spec(RequestSpec())
					.body(data.deletePlacePayload(placeid));
	        
	    }

}

