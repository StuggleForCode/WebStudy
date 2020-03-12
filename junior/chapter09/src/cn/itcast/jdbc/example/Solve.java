package cn.itcast.jdbc.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Solve {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入两个整数：");
        int a, b;
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(new Calculate().sum(a, b));
        System.out.println("请输入两个double类型的数字");
        double c, d;
        c = in.nextDouble();
        d = in.nextDouble();
        System.out.println(new Calculate().sum(c, d));
        System.out.println("请输入两个long类型的数字");
        long e, f;
        e = in.nextLong();
        f = in.nextLong();
        System.out.println(new Calculate().sum(e,f));
        System.out.println("请输入两个short类型的数");
        short g, h;
        g = in.nextShort();
        h = in.nextShort();
        System.out.println(new Calculate().sum(g, h));
        System.out.println("请输入两个float类型的数字");
        float k, l;
        k = in.nextFloat();
        l = in.nextFloat();
        System.out.println(new Calculate().sum(k, l));
        System.out.println("请输入两个bety类型的数字");
        byte m, n;
        m = in.nextByte();
        n = in.nextByte();
        System.out.println(new Calculate().sum(m, n));
        System.out.println("请输入任意数字，计算相加结果，每个数字之间一个空格，换行结束");
        String str=new Scanner(System.in).nextLine();
        String[] srr = str.split(" ");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < srr.length; i++){
            list.add(Integer.valueOf(srr[i]));
        }
        System.out.println("和为：" + new Calculate().sum(list, srr.length));
    }
}
