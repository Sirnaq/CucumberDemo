Feature: Register user
  Function of user registration for e-commerce shop
  seleniumdemo.com

  Scenario: Register with correct e-mail address and password
    Given User is on the main page of the shop
    When Go to the My Account page
    And User puts correct data to the registration form
    Then User is redirected to the My Account page
    But User registration form is not displayed

  Scenario: Register with incorrect e-mail and correct password
    Given User is on the main page of the shop
    When Go to the My Account page
    And User puts incorrect data to the registration form
    Then Incorrect e-mail error message is displayed