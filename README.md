# Facile
Easy to write multi-conditional predicates, eliminating the need of if-else/switch etc, and making the code look much readable and neater.

Like the if-else conditions, which may get complex and hard to read for complex conditions, Facile can be proven helpful.

A demo of its usage can be presented as:

    facile.when(input, predicate)
          .then(output1)
          .orWhen(input, predicate)
          .then(output2)
          .orWhen(inputString, predicate)
          .then(input)
          .otherwise(output3)
          .get();
          
See, its that neat and simple.

Here predicates are condition evaluators which evaluate to true or false.

Based on their evaluation, the facile can decide where to go furthur.
So simply if when() evaluates to false, it will go to evaluate orWhen() and if none of these evaluate true, then we can have otherwise().
Also the return statements i.e. then() and otherwise() can either return the output, or can perform actions.

To perform action, we need to provide the action implementation like:

    ...
    .otherwise(new PrintAction());
    
    class PrintAction implements Action<String> {

        @Override
        public void perform(String input) {
            System.out.print(input);
        }
    }

And similarly we can have predicates:
    
   Predicate<String> checkIfStringIsPalindrome = new Predicate<String>() {
        @Override
        public boolean evaluate(String input) {
            // Code here
            return isPalindrome;
        }
    };
    
    These Predicates will act on the input, which can be provided along in the conditions, e.g.
    
    .when("madam", checkIfStringIsPalindrome)

Also check the FacileTest.java class for more test examples.

