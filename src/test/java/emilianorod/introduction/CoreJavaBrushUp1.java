package emilianorod.introduction;

public class CoreJavaBrushUp1 {

    public static void main(String[] args) {

        int num = 5;
        String string = "Emiliano Rod";
        char letter = 'r';
        double dec = 5.99;
        boolean myCard = true;

        System.out.println(num + " is the value stored in the myNum variable" );
        System.out.println(string);

        //Arrays
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //for loop

        for(int i=0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }


        String[] name = {"Emiliano", "Rod", "Selenium"};

        for(int i=0; i < name.length; i++) {
            System.out.println(name[i]);
        }

        for( String str : name){
            System.out.println(str);
        }


    }
}
