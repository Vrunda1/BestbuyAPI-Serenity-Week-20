
Feature: Testing Category on the swagger application

  Scenario: Check if the category can be accessed by users
    When User sends a GET request to list endpoint of category
    Then User must get back a valid status code 200 of category

  Scenario: Check if the category  can be created by users
    When User sends a POST request to list endpoint of category
    Then User must get back a valid status code 201 of category


  Scenario: Check if the category can be updated by users
    When User sends a PUT request to list endpoint of category
    Then User must get back a valid status code 200 of category

  Scenario: Check if the category can be deleted by users
    When User sends a DELETE request to list endpoint of category
    Then User must get back a valid status code 200 of category
    And User should verify that category is deleted with 200







