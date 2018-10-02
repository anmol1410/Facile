package com.java.anmol.facile.parsers.output_parsers;

import com.java.anmol.facile.IParser;
import com.java.anmol.facile.parsers.OrWhenParser;
import com.java.anmol.facile.parsers.OtherwiseParser;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public interface ThenOutputParser extends OrWhenParser, OtherwiseParser, IParser {

    void setWhenOutputParser(WhenOutputParser whenOutputParser);
}
