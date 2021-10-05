package com.example;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Reverse_7Test extends TestCase {


    private static final Reverse_7 reverse_7 = new Reverse_7();

    public void testReverse() {
        Assert.assertEquals(321, reverse_7.reverse(123));
        Assert.assertEquals(-321, reverse_7.reverse(-123));
        Assert.assertEquals(21, reverse_7.reverse(120));
    }

    public void testReverse1() {

        Assert.assertEquals(321, reverse_7.reverse1(123));
        Assert.assertEquals(-321, reverse_7.reverse1(-123));
        Assert.assertEquals(21, reverse_7.reverse1(120));
    }
}