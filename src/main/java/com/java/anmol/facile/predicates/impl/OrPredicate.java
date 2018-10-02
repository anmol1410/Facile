package com.java.anmol.facile.predicates.impl;

import com.java.anmol.facile.predicates.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public class OrPredicate<T> implements Predicate<T> {

    private List<Predicate<? super T>> mPredicates;

    @SafeVarargs
    public OrPredicate(Predicate<? super T>... Predicates) {
        this.mPredicates = new ArrayList<>();
        this.mPredicates.addAll(Arrays.asList(Predicates));
    }

    @Override
    public boolean evaluate(T input) {
        boolean evaluation = false;
        for (Predicate<? super T> Predicate : mPredicates) {
            if (Predicate.evaluate(input)) {
                evaluation = true;
                break;
            }
        }
        return evaluation;
    }
}
