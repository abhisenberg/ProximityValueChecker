package com.example.abheisenberg.proximitycheck;

/**
 * Created by abheisenberg on 23/8/17.
 */

public class content {
    float pval;
    long time;
    String state;

    public content(float pval, long time, String state) {
        this.time = time;
        this.pval = pval;
        this.state = state;
    }

    public long getTime(){
        return time;
    }

    public float getPval() {
        return pval;
    }

    public String getState() {
        return state;
    }
}
