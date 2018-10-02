package com.java.anmol.facile.parsers.output_parsers.impl;

import com.java.anmol.facile.Action;
import com.java.anmol.facile.ParseData;
import com.java.anmol.facile.Parser;
import com.java.anmol.facile.parsers.output_parsers.ConditionOutputParser;
import com.java.anmol.facile.parsers.output_parsers.ThenOutputParser;
import com.java.anmol.facile.parsers.output_parsers.WhenOutputParser;
import com.java.anmol.facile.predicates.Predicate;
import com.java.anmol.facile.predicates.impl.AndPredicate;
import com.java.anmol.facile.predicates.impl.OrPredicate;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public final class WhenOutputParserImpl extends Parser implements WhenOutputParser {

    private ParseData parseData;
    private ConditionOutputParser conditionOutputParser;
    private ThenOutputParser thenOutputParser;

    public WhenOutputParserImpl(ParseData parseData,
                                ConditionOutputParser conditionOutputParser,
                                ThenOutputParser thenOutputParser) {
        super(parseData);
        this.parseData = parseData;
        this.conditionOutputParser = conditionOutputParser;
        this.thenOutputParser = thenOutputParser;
    }

    @SafeVarargs
    @Override
    public final <I> ConditionOutputParser or(I input, Predicate<? super I>... Predicate) {
        if (!parseData.isPrevResult() && !parseData.isReturned()) {
            parseData.setPrevResult(new OrPredicate<>(Predicate).evaluate(input));
        }
        return conditionOutputParser;
    }

    @SafeVarargs
    @Override
    public final <I> ConditionOutputParser and(I input, Predicate<? super I>... Predicate) {
        if (parseData.isPrevResult() && !parseData.isReturned()) {
            parseData.setPrevResult(new AndPredicate<>(Predicate).evaluate(input));
        }
        return conditionOutputParser;
    }

    @Override
    public <I> ConditionOutputParser not(I input, Predicate<? super I> Predicate) {
        if (parseData.isPrevResult() && !parseData.isReturned()) {
            parseData.setPrevResult(!(new AndPredicate<>(Predicate).evaluate(input)));
        }
        return conditionOutputParser;
    }

    @SafeVarargs
    @Override
    public final <I> ThenOutputParser then(I actionInput, Action<I>... actions) {
        if (parseData.isPrevResult() && !parseData.isReturned()) {
            parseData.setReturned(true);
            for (Action<I> action : actions) {
                action.perform(actionInput);
            }
        }
        return thenOutputParser;
    }

    @Override
    public ThenOutputParser then(Object output) {
        if (parseData.isPrevResult() && !parseData.isReturned()) {
            parseData.setResult(output);
            parseData.setReturned(true);
        }
        return thenOutputParser;
    }
}