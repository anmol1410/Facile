package com.java.anmol.facile;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public interface IParser {

    /**
     * Get the result back in the end, after the execution of the Facile is over.
     * <p><br>
     * For example:
     * <br><i>
     * Facile.init().
     * <br><br>
     * .when(***Conditions***)
     * <br><br>
     * .then(***some output to be returned***) //Returned this output in the <b>.get()</b>, if when() evaluated to true
     * <br><br>
     * .otherwise(***some output to be returned***) //Returned this output in the <b>.get()</b>, if when() evaluated to false
     * <br><br>.get(); // To get back the output
     * </i>
     *
     * @return the value which may be returned by then or othwwise, whichever flow gets executed bassed on the condition s.
     **/

    @SuppressWarnings("unused")
    Object get();
}
