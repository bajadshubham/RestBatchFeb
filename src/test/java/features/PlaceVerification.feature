Feature: Validating Place API' s

Background:
Given User open application url
And User enter a username and password


@AddPlace
Scenario Outline: Verify if place is being successfully added using Add place API
Given Add Place Payload "<name>"	"<language>"	"<address>"
When user calls "addPlaceAPI" with "post" http request
Then the API should return a status code 200
And "status" is response body is "OK"
And "scope" is response body is "APP"
And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
 | name    | language | address            |
 | AAHouse | English  | World cross centre |
 | BBHouse | Marathi  | Sea cross centre   |
 
 @DeletePlace
 Scenario: verify if delete plce functionality is working
 Given Delete Place Payload
 When user calls "deletePlaceAPI" with "post" http request
 Then the API should return a status code 200
 And "status" is response body is "OK"