
@tag
Feature: Validating Place API's
  

  @AddPlace @Regression
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with "POST" http request
    Then The API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_Id created maps to "<name>" using "getPlaceAPI"
    
  Examples:
  	|name		|language 		|address			|
  	|AAHouse	|English		|World cross center	|	
#  	|BBHouse	|French			|World cross center2	|

 @DeletePlace @Regression
 Scenario: Verify if delete place functionality is working
 	Given Deleteplace payload
 	When User calls "deletePlaceAPI" with "POST" http request
 	Then The API call is success with status code 200 
 	And "status" in response body is "OK"