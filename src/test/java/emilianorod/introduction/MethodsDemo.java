package emilianorod.introduction;

public class MethodsDemo {

     public static void main(String[] args) {

        MethodsDemo demo = new MethodsDemo();
        String name =  demo.getData();
        System.out.println(name);
        MethodsDemo2 demo2 = new MethodsDemo2();
        demo2.getUserData();
        getData2();
    }


    public String getData(){
        System.out.println("hello world");
        return "Emiliano Rod";
    }

    public static String getData2(){
        System.out.println("hello world");
        return "Emiliano Rod";
    }

}
