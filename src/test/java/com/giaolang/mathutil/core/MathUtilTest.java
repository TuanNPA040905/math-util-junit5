/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.giaolang.mathutil.core;

import com.tuannpa.math.core.MathUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Admin
 */
public class MathUtilTest {
    
    //Chơi DDT, Tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào trong câu lệnh kiểm thử
    
    //Chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][] {
                {1,1},
                {2,2},
                {5,120},
                {6,720}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data, ngầm định thứ tự
    //của các phần tử của mảng, map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, MathUtil.getFactorial(input));
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(120, MathUtil.getFactorial(5));
//    }
    
    //Bắt ngoại lệ khi đưa data cà chớn!!!
    //@Test(expected - tên ngoại lệ.class) JUnit thôi, JUnit hok xài vậy!!!!
    
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //Biểu thức lambda
        //Hàm nhận tham số thứ 2 là 1 cái obj/có code implement cái
        //functional interface tên là Executable - có 1 hàm duy nhất ko code
        //tên là execute()
        //Chơi chậm
//        Executable excObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                MathUtil.getFactorial(-5);
//            }
//        };

//        Executable exObject = () -> {MathUtil.getFactorial(-5);};
        assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(-5));
    }
}
