package com.bibiboom.arithmetic;

import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * @author Annie
 * @date 2021年05月29日 17:56
 */
public class String1 {

    @Test
    public void t1() {
        String s1 = new String("aaa");
        String s2 = new String("bbb");

        String s3 = s1.intern();

        System.out.println(s3 == s1.intern());
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
    }

    @Test
    public void t2() {

        String s1 = null;
        System.out.println(s1 = StringUtils.join("serverId", "-", "roleId"));

    }

    @Test
    public void t3() {

        String str = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";

    }

    @Test
    public void t4() {

        System.out.println(BigDecimal.ZERO);
        StringBuilder builder = new StringBuilder();
        builder.append(1);
        builder.append("你");
        builder.append(false);
        builder.delete(1, 2);
        System.out.println("builder = " + builder);
        StringBuffer buffer = new StringBuffer();

        System.out.println(String.join("-", "1", "2", "3"));
        System.out.println(String.join("", "1", "2", "3"));
    }

    public static void t17(Long timeStamp) {

//        Long timeStamp = 18752466L;

        Long days = (timeStamp / (1000 * 60 * 60 * 24));
        Long hours = ((timeStamp % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        Long minutes = ((timeStamp % (1000 * 60 * 60)) / (1000 * 60));
        Long seconds = ((timeStamp % (1000 * 60)) / 1000);
        System.out.println(days + "天" + hours + "时" + minutes + "分" + seconds + "秒");
    }

//    public static void main(String[] args) {
//        String1.t17(123231L);
//    }

    @Test
    public void t5() {

        String s1 = "未入驻";

        if (s1.equals("未入驻")) {
            System.out.println("空");
        }
    }

    public static String t16(Integer num) {

        switch (num) {
            case 0:
                return "未处理";
            case 1:
                return "已处理";
            case 2:
                return "已过期";
            default:
                return "未知";
        }
    }

    public static void main(String[] args) {
        String s = String1.t16(2);
        System.out.println(s);
    }

    @Test
    public void t9() {

//        long time = new Date().getTime();
        long time = 1624433150000L - 1624429772000L;
        System.out.println(time);

    }

}
