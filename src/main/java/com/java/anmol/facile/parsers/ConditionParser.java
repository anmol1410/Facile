package com.java.anmol.facile.parsers;

import com.java.anmol.facile.parsers.output_parsers.ConditionOutputParser;
import com.java.anmol.facile.predicates.Predicate;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public interface ConditionParser {
    @SuppressWarnings("unchecked")
    <I> ConditionOutputParser or(I input, Predicate<? super I>... Predicate);

    @SuppressWarnings("unchecked")
    <I> ConditionOutputParser and(I input, Predicate<? super I>... Predicate);

    <I> ConditionOutputParser not(I input, Predicate<? super I> Predicate);
}
