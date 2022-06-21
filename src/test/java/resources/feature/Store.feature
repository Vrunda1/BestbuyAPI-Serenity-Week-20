
Feature: Testing Store request on the swagger application

  Scenario: Check if the store can be accessed by users
    When User sends a GET request to list endpoint of store
    Then User must get back a valid status code 200 of store

  Scenario: Check if the new store can be created by users
    When User sends a POST request to list endpoint of store
    Then User must get back a valid status code 201 of store


  Scenario: Check if the store can be updated by users
    When User sends a PUT request to list endpoint of store
    Then User must get back a valid status code 200 of store

  Scenario: Check if the store can be deleted by users
    When User sends a DELETE request to list endpoint of store
    Then User must get back a valid status code 200 of store
   And User should verify that store is deleted with 200

  @test2
  Scenario: Check if the store can be accessed by users
    When User sends a GET request to list endpoint of store
    Then User must get back a valid status code 200 of store
    And  Verify  if the total is equal to 1572
    And  Verify  if the limit is equal to 10
    And  Check the single Name in the Array list (Inver Grove Heights)
    And Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    And Verify the storied=7 inside storeservices of the third store of second services
#    And Check hash map values createdAt inside storeservices map where store name = Roseville
    And Verify the state = MN of forth store
    And Verify the store name "Rochester" of ninthth store
   And  Verify the storeId = 11 for the 6th store
    And  Verify the serviceId = 4 for the seventhth store of forth service










