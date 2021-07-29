package util;

import org.junit.Test;
import org.springframework.scheduling.annotation.Async;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

    @Test
    public void t1() {

        for (int i = 1; i <31 ; i++) {

            String s1 = "COUNT(IF(cr.createDate =DATE_FORMAT(DATE_ADD( #{statisticsTime}, INTERVAL ";
            String s2 = " DAY), '%Y%m%d'), cr.content,null)),";
            String s3 = s1 + i + s2;
            System.out.println(s3);
        }

        String s5 = "COUNT(IF(gs_chat_record_1017.createDate =DATE_FORMAT(DATE_ADD(20210101, INTERVAL 1 DAY), '%Y%m%d'), gs_chat_record_1017.content,null)),";
        String s6 = "COUNT(IF(gs_chat_record_1017.createDate =DATE_FORMAT(DATE_ADD(20210101, INTERVAL 1 DAY), '%Y%m%d'), gs_chat_record_1017.content,null)),";
        boolean equals = s5.equals(s6);
        System.out.println(equals);
    }

    @Test
    public void t2() {

        for (int i = 1; i < 30; i++) {
            String s1 = "Day";
            String s3 = "聊天次数";
            String s2 = s1 + i + s3;
            System.out.println(s2);
        }

    }

    @Test
    public void t3() {


        for (int i = 1; i < 41; i++) {

            String s1 = "@ExcelFiled(colIndex = ";
            String s2 = ", colName = \"\")";
            System.out.println(s1 + i + s2);
//            System.out.println(i);
        }
    }


    @Test
    public void t4() {

        for (int i = 1; i < 31; i++) {

            String s1 = "detailsVo.setDay";
            String s2 = "((int) XMathUtil.divide(detailsVo.getDay";
            String s3 = "(),list.size()));";
//            String s4 = "()));";
            System.out.println(s1+i+s2+i+s3);
        }
    }

    @Test
    public void t5() {

        Color color = Color.RED;
        switch (color){
            case BLUE:
                System.out.println(Color.BLUE);
                break;
            case BLACK:
                System.out.println(Color.BLACK);
                break;
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println(Color.GREEN);
                break;
        }

        System.out.println("Color.RED = " + Color.RED);
    }


    @Test
    public void t6() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scan.close();
    }

    @Test
    public void t7() {

        // 九九乘法表
        System.out.println("九九乘法表:");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(" "+j+"x"+i+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }

    @Test
    public void t8() {

        // 三角形
        for(int i=1;i<=5;i++){
            for(int j=5; i<=j; j--)
                System.out.print(" ");
            for(int j=1; j<=i; j++)
                System.out.print("*");
            for(int j=1; j<i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    @Test
    public void t9() {

        // 杨辉三角  (格式规范)
        int rows = 10;

        for (int i = 0; i < rows; i++) {
            int num = 1;
            // 打印空格字符串
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d",num);
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }


    @Test
    public void t10() {

        // ArrayList & LinkedList 查询情况下的时间
        long start = System.nanoTime();
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        // 使用 getFirst() 获取头部元素
        System.out.println(sites.getFirst());
        long end = System.nanoTime();
        System.out.println("链表运行时间: "+ (end - start) + "纳秒");

        long start1 = System.nanoTime();
        ArrayList<String> sites1 = new ArrayList<String>();
        sites1.add("Google");
        sites1.add("Runoob");
        sites1.add("Taobao");
        sites1.add("Weibo");
        // 使用 getFirst() 获取头部元素
        System.out.println(sites1.get(0));
        long end1 = System.nanoTime();
        System.out.println("数组运行时间: "+ (end1 - start1) + "纳秒");
    }

    @Test
    public void t11() {

        // ArrayList & LinkedList 插入情况下的时间
        long start = System.nanoTime();
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        long end = System.nanoTime();
        System.out.println("链表运行时间: "+ (end - start) + "纳秒");

        long start1 = System.nanoTime();
        ArrayList<String> sites1 = new ArrayList<String>();
        sites1.add("Google");
        sites1.add("Runoob");
        sites1.add("Taobao");
        sites1.add("Weibo");
        long end1 = System.nanoTime();
        System.out.println("数组运行时间: "+ (end1 - start1) + "纳秒");
    }

    @Test
    public void t12() {

        // Map遍历方式 ---> 增强for循环
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("张三",12);
        map.put("张三1",12);
        map.put("张三2",12);
        map.put("张三3",12);
        map.put("张三4",12);
        map.put("张三5",12);
        map.put("张三6",12);
        map.put("张三7",12);
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("姓名: " + key + "," + "年龄: "+value);
        }
    }

    @Test
    public void t13() {

        // Map遍历方式 ---> 性能更好于entrySet
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("张三",12);
        map.put("张三1",12);
        map.put("张三2",12);
        map.put("张三3",12);
        map.put("张三4",12);
        map.put("张三5",12);
        map.put("张三6",12);
        map.put("张三7",12);

        for (String name : map.keySet()){
            System.out.println("姓名: "+name);
        }

        for (Object age : map.values()){
            System.out.println("姓名: "+age);
        }
    }

    @Test
    public void t14() {

        // Map遍历方式  ---> 迭代器 Iterator
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("张三",12);
        map.put("张三1",12);
        map.put("张三2",12);
        map.put("张三3",12);
        map.put("张三4",12);
        map.put("张三5",12);
        map.put("张三6",12);
        map.put("张三7",12);

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            System.out.println("姓名: "+next.getKey()+","+"年龄: "+next.getValue());
        }
    }

    @Test
    public void t15() {

        for (int i = 0; i < 10000; i++) {
            System.out.println("第一个方法执行了");
        }

        getMe();
    }

    @Async
    void getMe() {

        for (int i = 0; i < 10000; i++) {
            System.out.println("哈哈哈哈哈哈哈哈");
        }
    }

    @Test
    public void t16() {



        for (int i = 2; i < 20; i++) {
//            Boolean is = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
//                    is = false;
                    continue;
                }
            }
//            if (is == true) {
                System.out.println(i);
//            }
        }
    }

//    @Test
    public static void t17(Long timeStamp) {

//        Long timeStamp = 18752466L;

        Long days = (timeStamp / (1000 * 60 * 60 * 24));
        Long hours = ((timeStamp % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        Long minutes = ((timeStamp % (1000 * 60 * 60)) / (1000 * 60));
        Long seconds = ((timeStamp % (1000 * 60)) / 1000);
        System.out.println(days+"天"+hours+"时"+minutes+"分"+seconds+"秒");
    }

    public static void main(String[] args) {
        Test1.t17(3378000L);
    }

    public static String timeDifference2Minute(Date date1, Date date2) {

        long minuend = date1.getTime();
        long subtrahend = date2.getTime();
        long difference = minuend - subtrahend;
        Long minute = ((difference % (1000 * 60 * 60)) / (1000 * 60));
        return minute.toString() + "分";
    }

    @Test
    public void t18() {

        int[] arr ={34, 12, 9, 18, 6, 119};


        for (int i = 0; i < arr.length -1; i++) {

            int minIndex = i;
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {

                if (min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i+1) + "轮后");
            System.out.println(Arrays.toString(arr));

        }

    }

    @Test
    public void t19() {

        // 根据随机数，或者伪随机数生成UUID。
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replaceAll("-", "");
        System.out.println("uuid = " + uuid);
        System.out.println("s = " + s);
        System.out.println("---------------------------------------- 根据随机数，或者伪随机数生成UUID。 ----------------------------------------");

        // 基于名字的UUID通过计算名字和名字空间的MD5散列值得到。
        byte[] node = {10, 20, 30};
        UUID uuid_byte = UUID.nameUUIDFromBytes(node);
        String s1 = uuid_byte.toString().replaceAll("-", "");
        System.out.println("uuid_byte = " + uuid_byte);
        System.out.println("s1 = " + s1);
        System.out.println("---------------------------------------- 基于名字的UUID通过计算名字和名字空间的MD5散列值得到。 ----------------------------------------");

        UUID uuid_name = UUID.fromString("是名字呀");
        String s2 = uuid_name.toString().replaceAll("-", "");
        System.out.println("uuid_name = " + uuid_name);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void t20() {

        // 从缓存中拿数据
        String result = "缓存内容"; // getDataFromRedis(key)
        // 如果缓存中没有数据
        if (result == null) {
            // 去获取锁 , 拿到锁的去数据库读数据
//            if (reenLock.)
        }
    }


}
