
Feature: Testing Services on the swagger application


  Scenario: Check if the Services can be accessed by users
    When User sends a GET request to list endpoint of Services
    Then User must get back a valid status code 200 of Services

  Scenario: Check if the Services  can be created by users
    When User sends a POST request to list endpoint of Services
    Then User must get back a valid status code 201 of Services


  Scenario: Check if the Services can be updated by users
    When User sends a PUT request to list endpoint of Services
    Then User must get back a valid status code 200 of Services

  Scenario: Check if the Services can be deleted by users
    When User sends a DELETE request to list endpoint of Services
    Then User must get back a valid status code 200 of Services
    And User should verify that Services is deleted with 200






