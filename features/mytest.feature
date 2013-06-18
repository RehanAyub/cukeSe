Feature: My website is top search hit
  @Selenium
  Scenario: Search and check
    Given I am on Google UK front page
    When I search for thirstybear
    Then my website is the top hit

  @Selenium
  Scenario: Arbitrary second test
    Given I am on Google UK front page
    When I search for thirstybear
    Then my website is the top hit

