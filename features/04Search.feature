Feature: Search Diary and Verify if displayed

Scenario: Search Diary and Verify
	Given Getting driver from PersonalizedGiftSD
	Then Activate the Search box
	Then Get values from excel file
	And Send keys into the Search box
	Then verify if searched product is displayed