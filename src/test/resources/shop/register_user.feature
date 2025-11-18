Feature: Register user
  Function of user registration for e-commerce shop
  seleniumdemo.com

  Background: User is on the my account page
    Given User is on the main page of the shop
    When Go to the My Account page

  Scenario: Register with correct e-mail address and password
    And User puts correct data to the registration form
    Then User is redirected to the My Account page
    But User registration form is not displayed

  Scenario Outline: Register with incorrect e-mail and correct password
    And User submits email"incorrect@data.com" and password "<password>"
    Then Incorrect e-mail error message is displayed

    Examples:
      | password                                      |
      | pAssword!@#$1\"                               |
      | pAssword!@#$1\"pAssword!@#$1\"                |
      | pAssword!@#$1\"pAssword!@#$1\"pAssword!@#$1\" |