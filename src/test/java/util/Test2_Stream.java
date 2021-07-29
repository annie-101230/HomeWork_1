package util;

import com.bibiboom.entity.User;
import org.junit.Test;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test2_Stream {

    @Test
    public void t1() {

        String s1 = "abc";
        String s2 = "DEF";

        Map<String, Object> map = new HashMap<String, Object>();
       map.put("王五",12);
       map.put("张三",13);
       map.put("李四",14);
       map.put("刘六",15);

        System.out.println(map.get("张三"));

        int i = map.hashCode();
        System.out.println(i);
    }

    @Test
    public void t2() {

        // 去重
        Stream.of("ABC1","DEF","ghi","ABC2","DEF","ghi").distinct().forEach(System.out::println);
    }

    @Test
    public void t3() {

        // MAP转换元素 小写转大写
        Stream.of("aBc","Def","gH").map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void t4() {

        // 生成一个整数集合的平方数集合
        IntStream.of(1,2,3,4,5,6).map(num -> (num * num)).forEach(System.out::println);
        System.out.println("----------  整数  ----------");

        // 生成一个浮点数集合的平方数集合
        DoubleStream.of(1.2,2.2,3.2,6.8,5.2).map(num -> (num * num)).forEach(System.out::println);
        System.out.println("----------  浮点  ----------");
    }

    @Test
    public void t5() {

        // 取出属性
        List<User> users = Arrays.asList(new User("张三", 16), new User("李四", 18));
        List<String> list = users.stream().map(User::getUserName).collect(Collectors.toList());
        List<Integer> list1 = users.stream().map(User::getAge).collect(Collectors.toList());
        System.out.println("list = " + list);
        System.out.println(list1);
    }

    @Test
    public void t6() {

        // 扁平化合并
        Stream.of(
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(4,5,6)
        ).flatMap(Collection::stream).forEach(System.out::print);
    }

    @Test
    public void t7() {

        // 过滤 != null
        Stream.of(null,"123").filter(Objects::nonNull).forEach(System.out::println);
        // 过滤 偶数
        Stream.of(1,2,3,4,5,6,7,8).filter(num -> num % 2 == 0).forEach(a -> System.out.print(" "+a));
    }

    @Test
    public void t8() {

        // char转换为int数值
        Stream.of('a','b','c').mapToInt(Character::charValue).forEach(System.out::println);
        System.out.println("-------------   类型装换   -------------");
        // 合并字符串
        System.out.println(Stream.of("a", "b", "c").reduce("", String::concat));
        System.out.println("-------------   合并字符串   -------------");
        // 求最小值  --> 浮点类型
        System.out.println("Double::min = " + DoubleStream.of(-1.5, 1.0, 3.0, 2.0, -2.0).reduce(Double.MIN_VALUE, Double::min));
        System.out.println("-------------   求最小值  --> 浮点类型   -------------");
        // 求最小值  --> 整数类型
        System.out.println("Integer::min = " + IntStream.of(6, 1, 2, 3, 0).reduce(Integer.MIN_VALUE, Integer::min));
        System.out.println("-------------   求最小值  --> 整数类型   -------------");
    }

    @Test
    public void t9() {

        // 正序排序
        Stream.of(3,5,2,1,6,7,0,-12).sorted(Comparator.naturalOrder()).forEach(a -> System.out.print(a + " "));
        System.out.print("  |  ");
        // 正序排序
        IntStream.of(3,5,2,1,6,7,0,-12).sorted().forEach(a -> System.out.print(a + " "));
        System.out.println("");
        System.out.println("------ ↑ 正序排序 ↑ ------ ↓ 倒叙排序 ↓ ------");
        // 倒序排序
        Stream.of(3,5,2,1,6,7,0,-12).sorted(Comparator.reverseOrder()).forEach(a -> System.out.print(a + " "));
    }

    @Test
    public void t10() {

        // 创建集合
        List<String> list = new ArrayList<>();
        list.add("Google");
        list.add("BaiDu");
        list.add("TikTok");
        list.add("TaoBao");

        // 迭代器 Iterator
        Iterator<String> iterator = list.iterator();

//        System.out.println(iterator.next());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void t11() {

        // 创建集合
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-12);
        list.add(13);
        list.add(-14);
        list.add(15);
        // 创建迭代器
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next =  iterator.next();
            if (next > 0) {
               iterator.remove();
            }
        }
        System.out.println(list);
    }

    @Test
    public void t12() {

        String s1 = "111";
        String s2 = "";
        if (  s2 == null ){
            System.out.println("存");
        } else {
            System.out.println("bu 存");
        }
        System.out.println(StringUtils.isEmpty(s2));
    }

    @Test
    public void t13() {

        int i = 1;
        /* ↓↓ */
        switch (i){

                case 1 :
                System.out.println("两只老虎~两只老虎");
                case 2 :
                System.out.println("跑得快~跑得快~");
                case 3 :
                System.out.println("一直没有耳朵~");
                case 4 :
                System.out.println("一只没有尾巴~");
                case 5 :
                System.out.println("真奇怪~真奇怪~");
        }
    }

    @Test
    public void t14() {

        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;

        i1 = 1 << 1 << 1 << 1 << 1 << 1 >> 1 << 1;
        i2 = 1 << 2;
        i3 = 1 << 3;
        i4 = 1 << 4;
        i5 = 1 << 5;
        System.out.println("i = " + i1);
        System.out.println("i = " + i2);
        System.out.println("i = " + i3);
        System.out.println("i = " + i4);
        System.out.println("i = " + i5);

    }

    @Test
    public void t15() {

        String url = "www";
        String t = "baidu";
        String t3 = "com";

        System.out.println(url.concat(t).concat(t3));
        System.out.println(url.join(".", url, t, t3));
    }

    @Test
    public void t16() {
        Integer id = 1;
        String EVALUATE_URL = "www.baidu.com";
        String url = String.join("?",EVALUATE_URL,"customerServiceId=",id.toString());
        System.out.println(url);
    }

    @Test
    public void  t17() {


        Integer i = 2;

        assert i == 1 : "错了";

    }

    @Test
    public void t18() {

        String s = "wmYecJEAAAPPh3ybsXmVYwHOQXVLDVNg";

        System.out.println(s.length());
    }

    @Test
    public void t19() {

        List<Object> list = new ArrayList<>();
        list.add("第一位");
        list.add("第二位");
        list.add("第三位");
        list.add("第四位");
        list.add("第五位");


        for (Object o : list) {
            System.out.println("o = " + o);
        }

        System.out.println(list.stream().map(result -> result.toString()).collect(Collectors.toList()));
    }

    @Test
    public void t20() {

        String s = "留";

        for (int i = 1; i < 16; i++) {
            System.out.println(i + s);
        }
    }

    @Test
    public  void getLastDay() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        String yesterday = dateFormatMap.get(yyyyMMdd).format(cal.getTime());
        System.out.println(yesterday);
    }

    /***
     * 初始化日期格式化静态池
     */
    public static Map<String, SimpleDateFormat> dateFormatMap = new HashMap<String,SimpleDateFormat>();


    public static final String yyyyMM = "yyyyMM";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyMMddHHmmss = "yyMMddHHmmss";
    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String yyyy_MM_dd_HH_mm_ss_SSS="YYYY/MM/dd HH:mm:ss.SSS";
}