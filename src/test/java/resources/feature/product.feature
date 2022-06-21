
Feature: Testing Product on the swagger application

  Scenario: Check if the Product can be accessed by users
    When User sends a GET request to list endpoint
    Then User must get back a valid status code 200

  Scenario: Check if the Product can be created by users
    When User sends a POST request to list endpoint
    Then User must get back a valid status code 201


  Scenario: Check if the Product can be update by users
    When User sends a PUT request to list endpoint
    Then User must get back a valid status code 200

  Scenario: Check if the Product can be deleted by users
    When User sends a DELETE request to list endpoint
    Then User must get back a valid status code 200
    And User should verify that product is deleted with 200






#






