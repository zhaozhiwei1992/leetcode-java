package com.example;

import junit.framework.Assert;
import junit.framework.TestCase;

public class Palindrome_9Test extends TestCase {

    public void testIsPalindrome() {
        final Palindrome_9 palindrome_9 = new Palindrome_9();
        Assert.assertTrue(palindrome_9.isPalindrome(121));
        Assert.assertFalse(palindrome_9.isPalindrome(-121));
        Assert.assertFalse(palindrome_9.isPalindrome(10));
    }
}