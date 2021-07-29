package util;

public enum Color {

    RED , GREEN , BLUE , BLACK;

    private Color() {
        System.out.println("Constructor called for : " + this.toString());
    }

    public void colorInfo()
    {
        System.out.println("Universal Color");
    }

    public static void main(String[] args) {

        System.out.println("----start---");
        boolean isOpen = false;
        assert isOpen=true;             //如果开启了断言，会将isOpen的值改为true
        System.out.println("是否开启了断言"+isOpen);  //打印是否开启了断言
        if (isOpen)
        {
            int value=-1;
            assert 0 < value:"value="+value;
        }
        System.out.println("----end----");
    }
}
