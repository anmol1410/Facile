package com.java.anmol.facile.parsers;

import com.java.anmol.facile.parsers.output_parsers.WhenOutputParser;
import com.java.anmol.facile.predicates.Predicate;
import com.java.anmol.facile.predicates.impl.AndPredicate;
import com.java.anmol.facile.predicates.impl.OrPredicate;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
@SuppressWarnings("unused")
public interface OrWhenParser {

    /**
     * Parses the orwhen conditions using OrPredicate, and if iT evaluates to true, it goes to <b>.then()</b>.
     * <br>Or else it flows down to <b>orwhen()</b> to evaluate it or to the  <b>.otherwise()</b> as the case may be
     * (bypassing the <b>.then()</b>).
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br><br>
     * .when(***Conditions***)
     * <br><br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * <br><br>
     * .orwhen(***Conditions***) //Called if upper when() evaluated to False
     * <br><br>
     * .then(***some output to be returned***) //Called if upper orwhen() evaluated to true
     * <br><br>
     * .otherwise(***some output to be returned***) //Called if nothing above evaluated to true
     * <br><br>
     * .get(); // To get back the output
     * </i>
     *
     * @param input       Input on which the orPredicate will feed on.
     * @param orPredicate OrPredicate which if true will go to <b>.then()</b> or else flows to <b>orwhen()</b> or to <b>.otherwise()</b> as the case may be.
     * @param <I>         Type of input.
     * @return WhenOutputParser on which you can call further conditions like <b>.and()</b>, <b>.or()</b>, <b>.not()</b> or return by <b>.then()</b>.
     */
    <I> WhenOutputParser orWhen(I input, OrPredicate<? super I> orPredicate);

    /**
     * Parses the orwhen conditions using andPredicate, and if it evaluates to true, it goes to <b>.then()</b>.
     * <br>Or else it flows down to <b>orwhen()</b> to evaluate it or to the  <b>.otherwise()</b> as the case may be
     * (bypassing the <b>.then()</b>).
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br><br>
     * .when(***Conditions***)
     * <br><br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * <br><br>
     * .orwhen(***Conditions***) //Called if upper when() evaluated to False
     * <br><br>
     * .then(***some output to be returned***) //Called if upper orwhen() evaluated to true
     * <br><br>
     * .otherwise(***some output to be returned***) //Called if nothing above evaluated to true
     * <br><br>
     * .get(); // To get back the output
     * </i>
     *
     * @param input        Input on which the andPredicate will feed on.
     * @param andPredicate andPredicate which if true will go to <b>.then()</b> or else flows to <b>orwhen()</b> or to <b>.otherwise()</b> as the case may be.
     * @param <I>          Type of input.
     * @return WhenOutputParser on which you can call further conditions like <b>.and()</b>, <b>.or()</b>, <b>.not()</b> or return by <b>.then()</b>.
     */
    <I> WhenOutputParser orWhen(I input, AndPredicate<? super I> andPredicate);

    /**
     * Parses the orwhen conditions using andPredicate, and if it evaluates to true, it goes to <b>.then()</b>.
     * <br>Or else it flows down to <b>orwhen()</b> to evaluate it or to the  <b>.otherwise()</b> as the case may be
     * (bypassing the <b>.then()</b>).
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br><br>
     * .when(***Conditions***)
     * <br><br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * <br><br>
     * .orwhen(***all Predicates must evaluate true***) //Called if upper when() evaluated to False
     * <br><br>
     * .then(***some output to be returned***) //Called if upper orwhen() evaluated to true
     * <br><br>
     * .otherwise(***some output to be returned***) //Called if nothing above evaluated to true
     * <br><br>
     * .get(); // To get back the output
     * </i>
     *
     * @param input      Input on which the predicates will feed on.
     * @param predicates predicates which if true will go to <b>.then()</b> or else flows to <b>orwhen()</b> or to <b>.otherwise()</b> as the case may be.
     * @param <I>        Type of input.
     * @return WhenOutputParser on which you can call further conditions like <b>.and()</b>, <b>.or()</b>, <b>.not()</b> or return by <b>.then()</b>.
     */
    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    <I> WhenOutputParser orWhen(I input, Predicate<? super I>... predicates);

    /**
     * Parses the when conditions using any number of predicates which are custom implemented, and if <b>all of them</b> evaluates to <b>False</b>, it goes to <b>.then()</b>.
     * <br>Or else it flows down to <b>orwhen()</b> to evaluate it or to the  <b>.otherwise()</b> as the case maY be
     * (bypassing the <b>.then()</b>).
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br><br>
     * .when(***Conditions***)
     * <br><br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * <br><br>
     * .orwhen(***all Predicates must evaluate False***) //Called if upper when() evaluated to False
     * <br><br>
     * .then(***some output to be returned***) //Called if upper orwhen() evaluated to true
     * <br><br>
     * .otherwise(***some output to be returned***) //Called if nothing above evaluated to true
     * <br><br>
     * .get(); // To get back the output
     * </i>
     *
     * @param input      Input on which the predicates will feed on.
     * @param predicates Custom implemented Predicates which if False will go to <b>.then()</b> or else flows to <b>orwhen()</b> or to <b>.otherwise()</b> as the case may be.
     * @param <I>        Type of input.
     * @return WhenOutputParser on which you can call further conditions like <b>.and()</b>, <b>.or()</b>, <b>.not()</b> or return by <b>.then()</b>.
     */
    @SuppressWarnings("unchecked")
    <I> WhenOutputParser orWhenNot(I input, Predicate<? super I>... predicates);
}
