package com.example;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author zhaozhiwei
 * @version V1.0
 * @Title: JUnit3 Test Class.java.java
 * @Package com.example
 * @Description: TODO
 * @date 2021/10/11 下午8:43
 */
public class SearchInsert_35Test extends TestCase {

    public void testSearchInsert() {

        final SearchInsert_35 searchInsert_35 = new SearchInsert_35();

        //输入: nums = [1,3,5,6], target = 7
        //输出: 4

        Assert.assertEquals(4, searchInsert_35.searchInsert(new int[]{1, 3, 5, 6}, 7));

    }
}