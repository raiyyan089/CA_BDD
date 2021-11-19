Feature: Shop By Category Gift and Wishlist

Scenario: Add Shop By Category products to Wishlist
	Given Getting driver from ChristmasGiftSD
	Then Click On Shop By Category Drop Down
	Then select and Open 18th Birthday Gift
	Then Click On First Shop Product to Open
	And select Add to Wishlist
	Then verify if product is added