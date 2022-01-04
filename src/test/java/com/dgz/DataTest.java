package com.dgz;

import com.dgz.common.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DataTest {

    Data data;

    @BeforeEach
    void setUp(){
        data = new Data();
    }

    @Test
    void test_1(){
        List<List<String>> value;

        value = data.getRow();
        assertTrue(value instanceof ArrayList);
    }



}
