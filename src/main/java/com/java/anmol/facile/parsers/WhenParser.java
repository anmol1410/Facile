package com.java.anmol.facile.parsers;

import com.java.anmol.facile.parsers.output_parsers.WhenOutputParser;
import com.java.anmol.facile.predicates.Predicate;
import com.java.anmol.facile.predicates.impl.AndPredicate;
import com.java.anmol.facile.predicates.impl.OrPredicate;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public interface WhenParser {
    <I> WhenOutputParser when(I input, OrPredicate<? super I> orPredicate);

    <I> WhenOutputParser when(I input, AndPredicate<? super I> andPredicate);

    @SuppressWarnings("unchecked")
    <I> WhenOutputParser when(I input, Predicate<? super I>... Predicate);

    @SuppressWarnings("unchecked")
    <I> WhenOutputParser whenNot(I input, Predicate<? super I>... Predicate);
}
