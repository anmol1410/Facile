package com.java.anmol.facile.parsers.output_parsers.impl;

import com.java.anmol.facile.Action;
import com.java.anmol.facile.ParseData;
import com.java.anmol.facile.Parser;
import com.java.anmol.facile.parsers.EndParser;
import com.java.anmol.facile.parsers.output_parsers.ThenOutputParser;
import com.java.anmol.facile.parsers.output_parsers.WhenOutputParser;
import com.java.anmol.facile.predicates.Predicate;
import com.java.anmol.facile.predicates.impl.AndPredicate;
import com.java.anmol.facile.predicates.impl.OrPredicate;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public final class ThenOutputParserImpl extends Parser implements ThenOutputParser {

    private ParseData parseData;
    private WhenOutputParser whenOutputParser;
    private EndParser endParser;

    public ThenOutputParserImpl(ParseData parseData,
                                EndParser endParser) {
        super(parseData);
        this.parseData = parseData;
        this.endParser = endParser;
    }

    public void setWhenOutputParser(WhenOutputParser whenOutputParser) {
        this.whenOutputParser = whenOutputParser;
    }

    @Override
    public <I> WhenOutputParser orWhen(I input, OrPredicate<? super I> orPredicate) {
        if (!parseData.isReturned()) {
            parseData.setPrevResult(orPredicate.evaluate(input));
        }
        return whenOutputParser;
    }

    @Override
    public <I> WhenOutputParser orWhen(I input, AndPredicate<? super I> andPredicate) {
        if (!parseData.isReturned()) {
            parseData.setPrevResult(andPredicate.evaluate(input));
        }
        return whenOutputParser;
    }

    @SafeVarargs
    @Override
    public final <I> WhenOutputParser orWhen(I input, Predicate<? super I>... predicates) {
        if (!parseData.isReturned()) {
            parseData.setPrevResult(new AndPredicate<>(predicates).evaluate(input));
        }
        return whenOutputParser;
    }

    @SafeVarargs
    @Override
    public final <I> WhenOutputParser orWhenNot(I input, Predicate<? super I>... predicates) {
        if (!parseData.isReturned()) {
            parseData.setPrevResult(!(new AndPredicate<>(predicates).evaluate(input)));
        }
        return whenOutputParser;
    }

    @SafeVarargs
    @Override
    public final <I> EndParser otherwise(I actionInput, Action<I>... actions) {
        if (!parseData.isReturned()) {
            parseData.setReturned(true);
            for (Action<I> action : actions) {
                action.perform(actionInput);
            }
        }
        return endParser;
    }

    @Override
    public EndParser otherwise(Object output) {
        if (!parseData.isReturned()) {
            parseData.setReturned(true);
            parseData.setResult(output);
        }
        return endParser;
    }
}