package com.java.anmol.facile;

import com.java.anmol.facile.parsers.EndParser;
import com.java.anmol.facile.parsers.output_parsers.ConditionOutputParser;
import com.java.anmol.facile.parsers.output_parsers.ThenOutputParser;
import com.java.anmol.facile.parsers.output_parsers.WhenOutputParser;
import com.java.anmol.facile.predicates.Predicate;
import com.java.anmol.facile.predicates.impl.AndPredicate;
import com.java.anmol.facile.predicates.impl.OrPredicate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
@SuppressWarnings("unchecked")
public class FacileTest {

    private Facile facile;
    private String inputString = "input";
    private String outputString = "output";
    private Integer outputInteger = 10;
    private Predicate<String> stringTruePredicate = new Predicate<String>() {
        @Override
        public boolean evaluate(String input) {
            return true;
        }
    };
    private Predicate<String> stringFalsePredicate = new Predicate<String>() {
        @Override
        public boolean evaluate(String input) {
            return false;
        }
    };
    private AndPredicate<String> stringTrueAndPredicate = new AndPredicate<>(stringTruePredicate, stringTruePredicate);
    private AndPredicate<String> stringFalseAndPredicate = new AndPredicate<>(stringTruePredicate, stringFalsePredicate);
    private OrPredicate<String> stringTrueOrPredicate = new OrPredicate<>(stringTruePredicate, stringFalsePredicate);
    private OrPredicate<String> stringFalseOrPredicate = new OrPredicate<>(stringFalsePredicate, stringFalsePredicate);
    private Action<String> randomAction = new Action<String>() {
        @Override
        public void perform(String input) {
            // Do nothing
        }
    };
    private String outputThen = "then";
    private String outputOtherwise = "otherwise";
    private String outputWhen = "when";
    private String outputOrwhenFirst = "orwhenFirst";
    private String outputOrwhenSecond = "orwhenSecond";

    @Before
    public void setUp() {
        this.facile = Facile.init();
    }

    @Test
    public void whenTrue_ReturnThen_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringTruePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputThen);
    }

    @Test
    public void whenWithMultipleAndFalse_ReturnOtherwise_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalseAndPredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOtherwise);
    }

    @Test
    public void whenWithMultipleAndTrue_ReturnThen_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringTrueAndPredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputThen);
    }

    @Test
    public void whenWithMultipleOrTrue_ReturnThen_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringTrueOrPredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputThen);
    }

    @Test
    public void whenWithMultipleOrFalse_ReturnOtherwise_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalseOrPredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOtherwise);
    }

    @Test
    public void whenNotWithTruePredicate_ReturnOtherwise_Test() {
        Assert.assertEquals(
                facile.whenNot(inputString, stringTruePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOtherwise);
    }

    @Test
    public void whenNotWithFalsePredicate_ReturnThen_Test() {
        Assert.assertEquals(
                facile.whenNot(inputString, stringFalsePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputThen);
    }

    @Test
    public void whenFalse_ReturnOtherwise_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOtherwise);
    }

    @Test
    public void whenFalse_OrTrue_ReturnThen_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .or(inputString, stringTruePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputThen);
    }

    @Test
    public void whenTrue_OrFalse_ReturnThen_sTest() {
        Assert.assertEquals(
                facile.when(inputString, stringTruePredicate)
                        .or(inputString, stringFalsePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputThen);
    }

    @Test
    public void whenFalse_AndTrue_ReturnOtherwise_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .and(inputString, stringTruePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOtherwise);
    }

    @Test
    public void whenFalse_NotTrue_ReturnOtherwise_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .not(inputString, stringTruePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOtherwise);
    }

    @Test
    public void whenTrue_AndFalse_NotFalse_ReturnOtherwise_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringTruePredicate)
                        .and(inputString, stringFalsePredicate)
                        .not(inputString, stringFalsePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOtherwise);
    }

    @Test
    public void whenFalse_AndTrue_OrTrue_ReturnThen_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .and(inputString, stringTruePredicate)
                        .or(inputString, stringTruePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputThen);
    }

    @Test
    public void whenFalse_OrTrue_AndTrue_ReturnThen_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .or(inputString, stringTruePredicate)
                        .and(inputString, stringTruePredicate)
                        .then(outputThen)
                        .otherwise(outputOtherwise)
                        .get()
                , outputThen);
    }

    @Test
    public void whenFalse_OrwhenTrue_ReturnOrwhen_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .then(outputWhen)
                        .orWhen(inputString, stringTruePredicate)
                        .then(outputOrwhenFirst)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOrwhenFirst);
    }

    @Test
    public void whenFalse_FirstOrwhenTrue_ReturnOrwhenFirst_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .then(outputWhen)
                        .orWhen(inputString, stringTruePredicate)
                        .then(outputOrwhenFirst)
                        .orWhen(inputString, stringTruePredicate)
                        .then(outputOrwhenSecond)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOrwhenFirst);
    }

    @Test
    public void whenFalse_FirstOrwhenFalse_SecondOrwhenTrue_ReturnSecondOrwhen_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .then(outputWhen)
                        .orWhen(inputString, stringFalsePredicate)
                        .then(outputOrwhenFirst)
                        .orWhen(inputString, stringTruePredicate)
                        .then(outputOrwhenSecond)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOrwhenSecond);
    }

    @Test
    public void whenOrwhenAllFalse_ReturnOtherwise_Test() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .then(outputWhen)
                        .orWhen(inputString, stringFalsePredicate)
                        .then(outputOrwhenFirst)
                        .orWhen(inputString, stringFalsePredicate)
                        .then(outputOrwhenSecond)
                        .otherwise(outputOtherwise)
                        .get()
                , outputOtherwise);
    }

    @Test
    public void verifyMultipleReturnTypesSupportedTest() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .then(outputWhen)
                        .orWhen(inputString, stringTruePredicate)
                        .then(outputInteger)
                        .orWhen(inputString, stringFalsePredicate)
                        .then(outputString)
                        .otherwise(outputOtherwise)
                        .get()
                , outputInteger);
    }

    @Test
    public void verifySecondOrwhenReturnedWithMultipleReturns() {
        Assert.assertEquals(
                facile.when(inputString, stringFalsePredicate)
                        .then(outputWhen)
                        .orWhen(inputString, stringFalsePredicate)
                        .then(outputInteger)
                        .orWhen(inputString, stringTruePredicate)
                        .then(outputString)
                        .otherwise(outputOtherwise)
                        .get()
                , outputString);
    }

    @Test
    public void verifyTotalNumberOfObjectsFormed() {
        WhenOutputParser whenOutputParser = facile.when(inputString, stringFalsePredicate);
        ConditionOutputParser orConditionOutputParser = whenOutputParser.or(inputString, stringFalsePredicate);
        ConditionOutputParser andConditionOutputParser = orConditionOutputParser.and(inputString, stringFalsePredicate);
        ConditionOutputParser notConditionOutputParser = andConditionOutputParser.not(inputString, stringFalsePredicate);
        ThenOutputParser thenOutputParser = notConditionOutputParser.then(inputString, randomAction);
        WhenOutputParser orWhenOutputParser = thenOutputParser.orWhen(inputString, stringFalsePredicate);
        ConditionOutputParser conditionOutputParser = orWhenOutputParser.or(inputString, stringFalsePredicate);
        ThenOutputParser thenOutputParserOfOrwhen = conditionOutputParser.then(inputString, randomAction);
        Integer inputInteger = 5;
        EndParser endParser = thenOutputParser.otherwise(inputInteger); //4

        Assert.assertEquals(whenOutputParser, orWhenOutputParser); // 1
        Assert.assertEquals(thenOutputParser, thenOutputParserOfOrwhen); // 2
        Assert.assertEquals(orConditionOutputParser, andConditionOutputParser); //3
        Assert.assertEquals(orConditionOutputParser, conditionOutputParser); //3

        Set<IParser> set = new HashSet<>();
        set.add(whenOutputParser);
        set.add(orConditionOutputParser);
        set.add(andConditionOutputParser);
        set.add(notConditionOutputParser);
        set.add(thenOutputParser);
        set.add(orWhenOutputParser);
        set.add(conditionOutputParser);
        set.add(thenOutputParserOfOrwhen);
        set.add(endParser);

        Assert.assertEquals(set.size(), 4);
    }
}
