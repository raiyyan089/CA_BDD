Feature: Add Gift Card

Scenario: Add Gift Card to the Cart
	Given Getting driver from AboutUsSD
	Then Click On Gift Card icon
	And select Add to Cart Gift
	Then verify if cart is displayed