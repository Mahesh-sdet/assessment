Feature: Checkout
  As a end user
  I want to buy a product of my choice

  @end-to-end
  Scenario: select a product
    Given I am on homepage
    When I search for a product "laptop"
    And I select any product from list
    And I add product to basket
    And I go to basket
    And I click on checkout button
    And I click on guest checkout
    And I will enter email "mahesh.sdit@gmail.com"
    And I continue as guest
    And I click on delivery
    And I enter delivery details as below:
      | title | firstName | lastName | phoneNumber | postCode |
      | Mr    | mahesh    | reddy    | 07506559590 | tw135ap  |
    And I select delivery option as "Next or named day delivery"
    And I select delivery date to be "2" day of current date and proceed to payment
    Then I should validate the delivery details:
      | DeliveryDate | DeliveryOptions |
