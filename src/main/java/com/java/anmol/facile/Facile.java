package com.java.anmol.facile;

import com.java.anmol.facile.parsers.WhenParser;
import com.java.anmol.facile.parsers.output_parsers.WhenOutputParser;
import com.java.anmol.facile.predicates.Predicate;
import com.java.anmol.facile.predicates.impl.AndPredicate;
import com.java.anmol.facile.predicates.impl.OrPredicate;

/**
 * Entry point for the conditions builder.
 * <p><p>
 * Usage:
 * <br><br><i>
 * Facile.init(). // To initialize the library.
 * <br>
 * .when(***Condition***)
 * <br>
 * .then(***some output to be returned***) //Called if when() evaluated to true
 * <br>
 * .otherwise(***some output to be returned***) //Called if when() evaluated to false
 * <br>.get(); // To get back the output
 * </i>
 *
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Facile {

    private WhenParser parser;

    public Facile() {
        parser = new Injection().getWhenParser();
    }

    public static Facile init() {
        return new Facile();
    }

    /**
     * Parses the when conditions using OrPredicate, and if iT evaluates to true, it goes to <b>.then()</b>.
     * <br>Or else it flows down to <b>orwhen()</b> to evaluate it or to the  <b>.otherwise()</b> as the case maY be
     * (bypassing the <b>.then()</b>).
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br>
     * .when(***Can have variable number of OrPredicates***)
     * <br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * <br>
     * .otherwise(***some output to be returned***) //Called if when() evaluated to false
     * <br>.get(); // To get back the output
     * </i>
     *
     * @param input     Input on which the predicate will feed on.
     * @param predicate OrPredicate which if true will go to <b>.then()</b> or else flows to <b>orwhen()</b> or to <b>.otherwise()</b> as the case may be.
     * @param <I>       Type of input.
     * @return WhenOutputParser on which you can call further conditions like <b>.and()</b>, <b>.or()</b>, <b>.not()</b> or return by <b>.then()</b>.
     */
    public final <I> WhenOutputParser when(I input, OrPredicate<I> predicate) {
        return parser.when(input, predicate);
    }

    /**
     * Parses the when conditions using AndPredicate, and if iT evaluates to true, it goes to <b>.then()</b>.
     * <br>Or else it flows down to <b>orwhen()</b> to evaluate it or to the  <b>.otherwise()</b> as the case maY be
     * (bypassing the <b>.then()</b>).
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br>
     * .when(***Can have variable number of AndPredicates***)
     * <br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * <br>
     * .otherwise(***some output to be returned***) //Called if when() evaluated to false
     * <br>.get(); // To get back the output
     * </i>
     *
     * @param input     Input on which the predicate will feed on.
     * @param predicate AndPredicate which if true will go to <b>.then()</b> or else flows to <b>orwhen()</b> or to <b>.otherwise()</b> as the case may be.
     * @param <I>       Type of input.
     * @return WhenOutputParser on which you can call further conditions like <b>.and()</b>, <b>.or()</b>, <b>.not()</b> or return by <b>.then()</b>.
     */
    public final <I> WhenOutputParser when(I input, AndPredicate<I> predicate) {
        return parser.when(input, predicate);
    }

    /**
     * Parses the when conditions using any number of Predicate which are custom implemented, and if <b>all of them</b> evaluates to <b>False</b>, it goes to <b>.then()</b>.
     * <br>Or else it flows down to <b>orwhen()</b> to evaluate it or to the  <b>.otherwise()</b> as the case maY be
     * (bypassing the <b>.then()</b>).
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br>
     * .whenNot(***Any number of predicates which must all evaluate to true***)
     * <br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * <br>
     * .otherwise(***some output to be returned***) //Called if when() evaluated to false
     * <br>.get(); // To get back the output
     * </i>
     *
     * @param input      Input on which the predicates will feed on.
     * @param predicates Custom implemented Predicates which if False will go to <b>.then()</b> or else flows to <b>orwhen()</b> or to <b>.otherwise()</b> as the case may be.
     * @param <I>        Type of input.
     * @return WhenOutputParser on which you can call further conditions like <b>.and()</b>, <b>.or()</b>, <b>.not()</b> or return by <b>.then()</b>.
     */
    @SafeVarargs
    public final <I> WhenOutputParser whenNot(I input, Predicate<I>... predicates) {
        return parser.whenNot(input, predicates);
    }

    /**
     * Parses the when conditions using any number of predicate which are custom implemented, and if <b>all of them</b> evaluates to true, it goes to <b>.then()</b>.
     * <br>Or else it flows down to <b>orwhen()</b> to evaluate it or to the  <b>.otherwise()</b> as the case maY be
     * (bypassing the <b>.then()</b>).
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br>
     * .when(***Can have variable number of Predicates***)
     * <br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * <br>
     * .otherwise(***some output to be returned***) //Called if when() evaluated to false
     * <br>.get(); // To get back the output
     * </i>
     *
     * @param input      Input on which the predicates will feed on.
     * @param predicates Custom implemented Predicates which if true will go to <b>.then()</b> or else flows to <b>orwhen()</b> or to <b>.otherwise()</b> as the case may be.
     * @param <I>        Type of input.
     * @return WhenOutputParser on which you can call further conditions like <b>.and()</b>, <b>.or()</b>, <b>.not()</b> or return by <b>.then()</b>.
     */
    @SafeVarargs
    final <I> WhenOutputParser when(I input, Predicate<I>... predicates) {
        return parser.when(input, predicates);
    }
}