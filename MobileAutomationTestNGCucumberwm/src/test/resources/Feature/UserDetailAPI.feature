@Userdetails
Feature: Mobile Automation API Testing
As a user I should be able to validate userdetail response with wiremock server 

Background: 
Given I start wiremock server

Scenario: To validate response with all user details
When I send get request
Then I should be able to get response of all users


Scenario: To validate response of a single user detail
When I send get request
Then I should get response with a single user

Scenario: To validate response to create a new user detail
When I send post request
Then I should be able to create a new user detail

Scenario: To validate response to update an user detail
When I send put request
Then I should be able to update an user detail

Scenario: To validate response to delete an user detail
When I send delete request
Then I should be able to delete an user detail
