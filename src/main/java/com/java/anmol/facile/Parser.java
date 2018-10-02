package com.java.anmol.facile;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public class Parser implements IParser {

    private ParseData parseData;

    public Parser(ParseData parseData) {
        this.parseData = parseData;
    }

    @SuppressWarnings({"UnusedReturnValue", "unused"})
    @Override
    public Object get() {
        return parseData == null ? null : parseData.getResult();
    }
}