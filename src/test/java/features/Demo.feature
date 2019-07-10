Feature: Verify the user is able to login when sending valid credentials
	@TestScenario
  Scenario: Valid credentials
    Given I open the Home page in the browser
    And click on Login button
    When I enter the username "testUser" and the password "test-Pass"
    And click on login submit button
    Then I verify the user is able to login
  
  @TestScenarioOutline  
  Scenario Outline: Valid credentials
    Given I open the Home page in the browser
    And click on Login button
    When I enter the <username> and the <password>
    And click on login submit button
    Then I verify the user is able to login
	
	Examples:
	| username  | password  |
	| testUser2 | test-Pass2|
	
	
	
	