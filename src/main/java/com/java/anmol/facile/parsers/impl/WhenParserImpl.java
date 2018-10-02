package com.java.anmol.facile.parsers.impl;

import com.java.anmol.facile.ParseData;
import com.java.anmol.facile.Parser;
import com.java.anmol.facile.parsers.WhenParser;
import com.java.anmol.facile.parsers.output_parsers.WhenOutputParser;
import com.java.anmol.facile.predicates.Predicate;
import com.java.anmol.facile.predicates.impl.AndPredicate;
import com.java.anmol.facile.predicates.impl.OrPredicate;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public final class WhenParserImpl extends Parser implements WhenParser {
    private ParseData parseData;
    private WhenOutputParser whenOutputParser;

    public WhenParserImpl(ParseData parseData,
                          WhenOutputParser whenOutputParser) {
        super(parseData);
        this.parseData = parseData;
        this.whenOutputParser = whenOutputParser;
    }

    @Override
    public <I> WhenOutputParser when(I input, OrPredicate<? super I> orPredicate) {
        if (!parseData.isReturned()) {
            parseData.setPrevResult(orPredicate.evaluate(input));
        }
        return whenOutputParser;
    }

    @Override
    public <I> WhenOutputParser when(I input, AndPredicate<? super I> andPredicate) {
        if (!parseData.isReturned()) {
            parseData.setPrevResult(andPredicate.evaluate(input));
        }
        return whenOutputParser;
    }

    @SafeVarargs
    @Override
    public final <I> WhenOutputParser when(I input, Predicate<? super I>... Predicates) {
        if (!parseData.isReturned()) {
            parseData.setPrevResult(new AndPredicate<>(Predicates).evaluate(input));
        }
        return whenOutputParser;
    }

    @SafeVarargs
    @Override
    public final <I> WhenOutputParser whenNot(I input, Predicate<? super I>... Predicates) {
        if (!parseData.isReturned()) {
            parseData.setPrevResult(!(new AndPredicate<>(Predicates).evaluate(input)));
        }
        return whenOutputParser;
    }
}