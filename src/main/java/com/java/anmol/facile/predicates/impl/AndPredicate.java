package com.java.anmol.facile.predicates.impl;

import com.java.anmol.facile.predicates.Predicate;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public class AndPredicate<T> implements Predicate<T> {
    private Predicate<? super T>[] predicates;

    @SafeVarargs
    public AndPredicate(Predicate<? super T>... Predicates) {
        this.predicates = Predicates;
    }

    @Override
    public boolean evaluate(T input) {
        boolean evaluation = true;
        for (Predicate<? super T> Predicate : predicates) {
            if (!Predicate.evaluate(input)) {
                evaluation = false;
                break;
            }
        }
        return evaluation;
    }
}