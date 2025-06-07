
Feature: Validate product lists and order
	Background:
    Given The user is on the SauceDemo login page
    
  Scenario Outline: checks products lists
  	When The user logs in with username "<username>" and password "<password>"
  	Then User lands on the product listing page
  	And list of products is visible
  	Examples:
  		|username     |password    |
  		|standard_user|secret_sauce|
  
  Scenario Outline: checks product sorting
    When The user logs in with username "<username>" and password "<password>"
    And user check that sorting by Price (low to high)
    Then sorts the items correctly
    Examples:
  		|username     |password    |
  		|standard_user|secret_sauce|
  		

   
  

