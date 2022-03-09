Feature: CucumberJava

Scenario: Validate the user is logged correctly
Given I open the url BookShelf
When I Login to Book Shelf with email testt@email.fake and password password123
Then Account setting in Home page should be displayed with the email edwin.rockstar.20211013@email.fake

Scenario: Validate the user is logged out correctly
Given I open the url BookShelf
When I Login to Book Shelf with email test.1212121@email.fake and password password123
When I click in log out
Then the user is in the Login Page

Scenario: Validate the user is email valid format
Given I open the url BookShelf
When I enter an <email> with incorrect format
Then I got an email valid format validation messages
Examples: 
| email 		|
| test@ 		|
| test@.com |
| 111@.com.pe|
| 1111 		|
| ssdsdsdsdds|
| @@@@@@@@@|

Scenario: Validate the empty password message validation
Given I open the url BookShelf
When I enter an email testt@email.fake with empty password
Then I got a password empty validation messages

Scenario: Validate the email and password incorrect message validation
Given I open the url BookShelf
When I Login to Book Shelf with email testt@email.fake and password dfdfddf+.B57k
Then I got a email and password message validation messages
