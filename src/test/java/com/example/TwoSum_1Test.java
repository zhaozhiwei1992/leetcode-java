package com.example;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;

public class TwoSum_1Test extends TestCase {

    private static final TwoSum_1 twoSum_1 = new TwoSum_1();

    public void testTwoSum() {
        int[] nums = new int[]{2,5,5,11};
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, twoSum_1.twoSum(nums, 10)));
    }

    public void testTwoSum1() {

        int[] nums = new int[]{2,5,5,11};
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, twoSum_1.twoSum(nums, 10)));
    }
}