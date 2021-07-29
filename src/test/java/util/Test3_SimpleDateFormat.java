package util;

import com.bibiboom.jdbc.pojo;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3_SimpleDateFormat {

    @Test
    public void t1() {

        String format1 = "yyyyMMdd a hh点mm分ss秒 E ";
        String format2 = "现在是yyyy年MM月 - 今年的第W周 - 今年的第D天 - 本月第F周  ";

//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format1);
//        System.out.println(simpleDateFormat.format(date));
        System.out.println(new SimpleDateFormat(format1).format(new Date()));
        System.out.println(new SimpleDateFormat(format2).format(new Date()));
    }

    @Test
    public void t2(){

        String pattern = "^(http|https).*?.(JPG|jpg|PNG|png|gif|GIF)";
        String context1 = "https://wechat-ss.yinxianggame.com/wechat-dir-prefix/1607578716265.jpg";
        String context2 = "http://wechat-ss.yinxianggame.com/wechat-dir-prefix/1607578716265.jpg";

        Pattern r = Pattern.compile(pattern);
        Matcher m1 = r.matcher(context1);
        Matcher m2 = r.matcher(context2);
        System.out.println(m1.matches()+"有s");
        System.out.println(m2.matches()+"没s");
    }

    @Test
    public void t3() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = format.format(new Date());
        System.out.println();
    }

    @Test
    public void t4() {

        List<String> strings = new ArrayList<>();
        strings.add("张三");
//        strings.add("李四");
//        strings.add("王五");
        System.out.println(String.join(",", strings));
    }

//    @Test
//    public void t5() {
//
//        List<pojo> pojo = new ArrayList<>();
//        com.bibiboom.jdbc.pojo pojo1 = new pojo();
//        pojo1.setId(1);
//        pojo1.setName("张三");
//        com.bibiboom.jdbc.pojo pojo2 = new pojo();
//        pojo1.setId(2);
//        pojo1.setName("李四");
//        pojo.add(pojo1);
//        pojo.add(pojo2);
//
//        System.out.println(pojo.toString());
//
//    }
}
