package com.example;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RomanToInt_13Test extends TestCase {


    public void testRomanToInt() {

        final RomanToInt_13 romanToInt_13 = new RomanToInt_13();
        Assert.assertEquals(1994, romanToInt_13.romanToInt("MCMXCIV"));
        Assert.assertEquals(58, romanToInt_13.romanToInt("LVIII"));
        Assert.assertEquals(9, romanToInt_13.romanToInt("IX"));
    }
}