package com.java.anmol.facile;

/**
 * @author AnmolSehgal
 * Github: https://github.com/anmol1410
 */
public class ParseData {
    private Object result = null;
    private boolean isReturned = false;
    private boolean prevResult = false;

    Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public boolean isPrevResult() {
        return prevResult;
    }

    public void setPrevResult(boolean prevResult) {
        this.prevResult = prevResult;
    }
}
