**Project Details**

Construction:
(1)	The project consists of:
	4 pages
	BaseSteps (common repeated steps) like opening-up & closing the browser
	Sign-up New random user each time it runs the test case
	Sign-up existing user
	Log in with non-existing user 
	End-To-End scenario starting with logging in & then adding 2 different products to cart, and purchasing them

Functionality:
(2)	Each page has its relative locators & actions utilizing the POM
(3)	Explicit waits are mostly used in pages’ methods where needed
(4)	Sign-up using Fake data is used to generate a new sign-up user each time
(5)	A general implicit (timeout) command is used at the beginning of the homepage opening to wait for the buttons to load
(6)	Products’ names & prices are compared with the actual ones in the cart
