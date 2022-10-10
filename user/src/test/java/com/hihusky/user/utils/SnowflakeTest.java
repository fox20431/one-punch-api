package com.hihusky.user.utils;

import org.junit.jupiter.api.Test;

public class SnowflakeTest {
    @Test
    void test() {
        Snowflake snowflake = new Snowflake();
        Long id = snowflake.nextId();
        // snowflake.
        // Long time = snowflake.timeGen();
        long[] parse = snowflake.parse(1028967880831668224L);
        System.out.println(id);
        System.out.println(parse[2]);
        // System.out.println(time);
    }
}
