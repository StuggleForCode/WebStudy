package cn.itcast.jdbc.example;

import java.util.ArrayList;

public class Calculate {

    static int sum(int a, int b){
        return a + b;
    }

    static double sum(double a, double b){
        return  a + b;
    }

    static byte sum(byte a, byte b){
        return (byte) (a + b);
    }

    static float sum(float a, float b){
        return  a + b;
    }

    static  long sum(long a, long b){
        return a + b;
    }

    static  short sum(short a, short b){
        return (short) (a + b);
    }

    static  int sum(ArrayList<Integer> a, int b){
        Integer cnt = 0;
        for(int i = 0; i < b; i++){
            cnt += a.get(i);
        }
        return cnt;
    }



}
