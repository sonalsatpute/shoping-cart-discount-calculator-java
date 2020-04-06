# Shopping Cart - Discount Calculator

A big retail brand, on the eve of Christmas wants to offer attractive discounts to its customers to boost their sales. 
The requirement is to offer different discount rates based on the customer billing.

#### Discount Slabs for Customers:
- $ 0 - $ 5,000 Nil
- $ 5,000 - $ 10,000 10.0 %
- $ 10,000 and above 20.0 %

Build a system that will take the Purchase amount as input, calculates and outputs the final Bill amount that will be charged back to the customer.

#### TEST CASES
Here are the test cases for some combinations of customer type and purchase amount

Customer Type | Purchase Amount | Bill Amount | 
 
- Regular | $  5,000   | $  5,000
- Regular | $ 10,000   | $  9,500
- Regular | $ 15,000   | $ 13,500

#### CONSIDERATIONS:
- We are looking for elegant design and solution for this problem
- The code should be extensible and maintainable
- i.e. it should be easy to
    - Add/remove new discount slabs
- Follow 10 minutes’ iterations, there should be something working to demo at the end of every iteration, commit your changes on github.
- Write Unit tests to execute and verify
the program

# Assumption
- All inputs are valid and Purchase amount is always of type long :P
- Slabs Configuration are valid
