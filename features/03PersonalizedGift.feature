Feature: Sort Personalized Gifts

Scenario: Sort Personalized Gifts High to Low
	Given Getting driver from LoginSD
	Then Click On Personalized Gifts Menu
	Then Click On Sort By
	And select On High to Low
	Then check if first product has max price = 4500