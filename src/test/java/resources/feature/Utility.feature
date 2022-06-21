
Feature: Testing utility on the swagger application

  Scenario: Check if the version can be accessed by users
    When User sends a GET request to list endpoint of version
    Then User must get back a valid status code 200 of version

  Scenario: Check if the healthcheck can be accessed by users
    When User sends a GET request to list endpoint of healthcheck
    Then User must get back a valid status code 200 of healthcheck








