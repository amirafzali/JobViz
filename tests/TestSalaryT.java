package tests;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import src.SalaryT;

public class TestSalaryT {
    private SalaryT s1, s2, s3, s4, s5, s6;

    private String fn1, fn2, fn3, fn4, fn5, fn6;
    private String ln1, ln2, ln3, ln4, ln5, ln6;
    private String p1, p2, p3, p4, p5, p6;
    private String e1, e2, e3, e4, e5, e6;
    private String se1, se2, se3, se4, se5, se6;
    private double sa1, sa2, sa3, sa4, sa5, sa6;
    private double b1, b2, b3, b4, b5, b6;
    private int y1, y2, y3, y4, y5, y6;

    @Before
    public void setUp(){


        s1 = new SalaryT(se1, fn1, ln1, sa1, b1, e1, p1, y1);
        s2 = new SalaryT(se2, fn2, ln2, sa2, b2, e2, p2, y2);
        s3 = new SalaryT(se3, fn3, ln3, sa3, b3, e3, p3, y3);
        s4 = new SalaryT(se4, fn4, ln4, sa4, b4, e4, p4, y4);
        s5 = new SalaryT(se5, fn5, ln5, sa5, b5, e5, p5, y5);
        s6 = new SalaryT(se6, fn6, ln6, sa6, b6, e6, p6, y6);
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testName(){

    }
}