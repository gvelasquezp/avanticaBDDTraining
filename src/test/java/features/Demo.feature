Feature: Validate Home page

  Scenario: After click Home tab in nav bar
    Given I open the Home page in the browser
    When I click on Home tab in nav bar
    Then I validate the Home page is displayed