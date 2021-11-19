Feature: Wishlist

Scenario: Verify products displayed in Wishlist
	Given Getting driver from AllofItSD
	Then Click On Wishlist icon
	And Close Popup if appears
	Then Verify if products are displayed