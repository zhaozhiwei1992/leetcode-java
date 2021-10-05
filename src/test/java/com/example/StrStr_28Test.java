package com.example;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StrStr_28Test extends TestCase {

    public void testStrStr() {
        final StrStr_28 strStr_28 = new StrStr_28();
        Assert.assertEquals(4, strStr_28.strStr("mississippi", "issip"));
        Assert.assertEquals(2, strStr_28.strStr("hello", "ll"));
        Assert.assertEquals(-1, strStr_28.strStr("aaa", "aaaa"));
        Assert.assertEquals(6, strStr_28.strStr("bbbbababbbaabbba", "abb"));
    }

    public void testStrStr1() {
        final StrStr_28 strStr_28 = new StrStr_28();
        Assert.assertEquals(4, strStr_28.strStr1("mississippi", "issip"));
        Assert.assertEquals(2, strStr_28.strStr1("hello", "ll"));
        Assert.assertEquals(-1, strStr_28.strStr1("aaa", "aaaa"));
        Assert.assertEquals(6, strStr_28.strStr1("bbbbababbbaabbba", "abb"));
    }
}