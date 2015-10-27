package com.konradkrakowiak.samsungworkshop.model;

/**
 * POJO for json                  <br />
 *                                <br />
 *  {                             <br />
 *     "bronze": 6402,            <br />
 *     "silver": 5121,            <br />
 *     "gold": 336                <br />
 *  }                             <br />
 *
 */
public class BadgeCounts {

    int bronze;
    int silver;
    int gold;

    public int getBronze() {
        return bronze;
    }

    public int getSilver() {
        return silver;
    }

    public int getGold() {
        return gold;
    }
}
