package com.java.anmol.facile.parsers;

import com.java.anmol.facile.Action;
import com.java.anmol.facile.parsers.output_parsers.ThenOutputParser;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
@SuppressWarnings("unused")
public interface ThenParser {

    /**
     * Performs some actions if this <b>then()</b> flow gets executed.
     * <p><p>
     * For example:
     * <br><i>
     * Facile.init().
     * <br>
     * .when(***Can have variable number of Predicates***)
     * <br>
     * .then("print statement", Action<String> printAction = output -> Logger.log(output)) //Called if when() evaluated to true
     * </i>
     * <p>
     *
     * @param actionInput input for the Actions to act on.
     * @param actions     Actions to be performed if this then flow gets executed.
     * @param <I>         Type of input on which the actionInput can act on.
     * @return ThenOutputParser on which you can call further conditions like <b>.orwhen()</b> or return by <b>.get()</b>.
     */
    @SuppressWarnings({"UnusedReturnValue", "unchecked"})
    <I> ThenOutputParser then(I actionInput, Action<I>... actions);

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
     * <br>.get(); // To get back the output
     * </i>
     *
     * @param output output to return back if this flow gets executed.
     * @return ThenOutputParser on which you can call further conditions like <b>.orwhen()</b> or return by <b>.get()</b>.
     */
    ThenOutputParser then(Object output);
}