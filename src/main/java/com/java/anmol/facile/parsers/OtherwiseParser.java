package com.java.anmol.facile.parsers;

import com.java.anmol.facile.Action;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
@SuppressWarnings("unused")
public interface OtherwiseParser {

    /**
     * Performs some actions if no flow gets executed.
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br>
     * .when(***Can have variable number of Predicates***)
     * <br>*******bla bla bla*******
     * <br>
     * .otherwise("print statement", Action<String> printAction = output -> Logger.log(output)) //Called if no flow above evaluated true
     * </i>
     * <p>
     *
     * @param actionInput input for the Actions to act on.
     * @param actions     Actions to be performed if no flow gets executed.
     * @param <I>         Type of input on which the actionInput can act on.
     * @return EndParser on which you can get back the result using <b>.get()</b> if any.
     */

    @SuppressWarnings("unchecked")
    <I> EndParser otherwise(I actionInput, Action<I>... actions);

    /**
     * Returns back the output.
     * <br>Don't forget to call the <b>.get</b> after this, to get the output back.
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br>
     * .when(***Can have variable number of Predicates***)
     * <br>
     * .then(***some output to be returned***) //Called if when() evaluated to true
     * .otherwise(***some output to be returned***) //Called if when() evaluated to False
     * <br>.get(); // To get back the output
     * </i>
     *
     * @param output output to return back if this flow does not get executed.
     * @return EndParser on which you can get back the result using <b>.get()</b>.
     */
    EndParser otherwise(Object output);
}
