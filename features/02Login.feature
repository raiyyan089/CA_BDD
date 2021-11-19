Feature: Login Big Small

Scenario Outline: User Sign In with multiple credentials
	Given Getting driver from HomePageSD
	Then Click On Sign In in Menu Bar
	Then Enter "<username>" and Enter "<password>"
	And Click On Sign In Button	
	
Examples:
	| username				| password		|
	|           			|           	|
	| simon@123 			| abcd      	|
	| JackNJill@gmail.com	| JackNJill 	|