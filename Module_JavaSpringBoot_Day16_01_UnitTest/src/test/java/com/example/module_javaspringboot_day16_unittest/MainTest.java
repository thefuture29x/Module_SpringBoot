package com.example.module_javaspringboot_day16_unittest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class MainTest {
    MainApplication mainApplication = new MainApplication();

//    @Test
//    public void testSumTwoNumber(){
//        mainApplication.sumTwoNumber(Integer.MAX_VALUE,5);
//
//    }
    @Test
    public void testGiaiPTB2_01(){
        mainApplication.giaiPTB2(0,0,3);
    }
    @Test
    public void testGiaiPTB2_02(){
        mainApplication.giaiPTB2(0,2,3);
    }
    @Test
    public void testGiaiPTB2_03(){
        mainApplication.giaiPTB2(1,0,3);
    }
    @Test
    public void testGiaiPTB2_04(){
        mainApplication.giaiPTB2(1,9,3);
    }
    @Test
    public void testGiaiPTB2_05(){
        mainApplication.giaiPTB2(1,2,1);
    }

    @Test
    public void testGiaiPTB2_02_01(){
        Assertions.assertEquals("Phương trình vô nghiệm",mainApplication.giaiPTB2_02(0,0,3));
    }
    @Test
    public void testGiaiPTB2_02_02(){
        Assertions.assertEquals("Phương trình vô nghiệm",mainApplication.giaiPTB2_02(0,2,3));
    }
    @Test
    public void testGiaiPTB2_02_03(){
        Assertions.assertEquals("Phương trình vô nghiệm",mainApplication.giaiPTB2_02(1,0,3));
    }
    @Test
    public void testGiaiPTB2_02_04(){
        Assertions.assertEquals("Phương trình vô nghiệm",mainApplication.giaiPTB2_02(1,9,3));
    }
    @Test
    public void testGiaiPTB2_02_05(){
        Assertions.assertEquals("Phương trình vô nghiệm",mainApplication.giaiPTB2_02(1,2,1));
    }

}
