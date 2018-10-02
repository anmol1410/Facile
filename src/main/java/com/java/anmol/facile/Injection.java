package com.java.anmol.facile;

import com.java.anmol.facile.parsers.EndParser;
import com.java.anmol.facile.parsers.WhenParser;
import com.java.anmol.facile.parsers.impl.EndParserImpl;
import com.java.anmol.facile.parsers.impl.WhenParserImpl;
import com.java.anmol.facile.parsers.output_parsers.ConditionOutputParser;
import com.java.anmol.facile.parsers.output_parsers.ThenOutputParser;
import com.java.anmol.facile.parsers.output_parsers.WhenOutputParser;
import com.java.anmol.facile.parsers.output_parsers.impl.ConditionOutputParserImpl;
import com.java.anmol.facile.parsers.output_parsers.impl.ThenOutputParserImpl;
import com.java.anmol.facile.parsers.output_parsers.impl.WhenOutputParserImpl;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
class Injection {

    private ParseData parseData = new ParseData();
    private ThenOutputParser thenOutputParser;
    private ConditionOutputParser conditionOutputParser;
    private EndParser endParser;

    WhenParser getWhenParser() {
        return new WhenParserImpl(parseData, getWhenOutputParser());
    }

    private WhenOutputParser getWhenOutputParser() {
        ThenOutputParser thenOutputParser = getThenOutputParser();
        WhenOutputParser whenOutputParser = new WhenOutputParserImpl(parseData,
                getConditionOutputParser(thenOutputParser),
                thenOutputParser);
        thenOutputParser.setWhenOutputParser(whenOutputParser);
        return whenOutputParser;
    }

    private ThenOutputParser getThenOutputParser() {
        if (thenOutputParser == null) {
            thenOutputParser = new ThenOutputParserImpl(parseData, getEndParser());
        }
        return thenOutputParser;
    }

    private EndParser getEndParser() {
        if (endParser == null) {
            endParser = new EndParserImpl(parseData);
        }
        return endParser;
    }

    private ConditionOutputParser getConditionOutputParser(ThenOutputParser thenOutputParser) {
        if (conditionOutputParser == null) {
            conditionOutputParser = new ConditionOutputParserImpl(parseData, thenOutputParser);
        }
        return conditionOutputParser;
    }
}