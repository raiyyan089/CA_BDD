Feature: Adding Christmas Gift to Cart 

Scenario: Add Christmas Gift to Cart
	Given Getting driver from SeachSD
	Then Click On Christmas Gift Menu
	Then Click On First Christmas Product to Open
	And select Add to Cart Christmas
	Then Go to Checkout
	And Close the Popup if it appears
	Then Return to Cart