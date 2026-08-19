Feature: To validate single product order and checkout

Background: Given user launches the browser and navigate to HomePage

@smoke @regression
Scenario Outline: Add product to cart and verify successful message

Given user enters "<username>" and "<password>" to login the application
And user adds product to cart and clicks on cart icon
When user lands on cart page to checkout
And user enters the checkout details and clicks on continue
Then user verifies the successful message and logs out the application.

Examples:
| username      | password     |
| standard_user | secret_sauce |
| visual_user	| secret_sauce |

@smoke
Scenario: Verify login failure with invalid credentials

    Given user enters "invalid_user" and "invalid_password" to login the application
    Then user verifies the login error message