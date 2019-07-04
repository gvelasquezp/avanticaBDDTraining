Feature: Verify the user is able to login when sending valid credentials

  Scenario: Valid credentials
    Given I open the Home page in the browser
    And click on Login button
    When I enter the username "testUser" and the password "test-Pass"
    And click on login submit button
    Then I verify the user is able to login