#Author: your.email@your.domain.com
Feature: Login Functionality on SauceDemo

  Background:
    Given The user is on the SauceDemo login page
    
  Scenario Outline: Login with valid/invalid credentials
    When The user logs in with username "<username>" and password "<password>"
    Then "<expected>"
    Examples: 
      | username  							| password 			| expected  																																	 |	
      | standard_user 					| secret_sauce  | The user should be redirected to the inventory page   											 |
			| problem_user    				| secret_sauce  | The user should be redirected to the inventory page                          |
			| performance_glitch_user | secret_sauce  | The user should be redirected to the inventory page                          |
			| standard_user           | abcd          | Error message should be displayed                                            |
			| invalid_username        | invalid_pass  | Error message should be displayed                                            | 
			
			
	Scenario Outline: Login with empty credentials
		When The user logs in with empty credentials
		Then The error message "<Error_Message>" should be displayed
		Examples:
		|Error_Message										 |
		|Epic sadface: Username is required|
