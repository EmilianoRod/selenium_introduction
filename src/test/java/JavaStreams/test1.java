package JavaStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {

    // Count the number of names starting with alphabet A in list
    @Test
    public void regular(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Emiliano");
        names.add("Julieta");
        names.add("Ana");
        names.add("Jorgito");
        names.add("Ignacio");

        int count = 0;
        for(int i=0; i<names.size(); i++){
            String actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }

        System.out.println(count);
    }



    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Emiliano");
        names.add("Julieta");
        names.add("Ana");
        names.add("Jorgito");
        names.add("Ignacio");

        // There is no life for intermediate operation if there is no terminal operation
        // Terminal operation will execute only if internal operation (filter) returns true
        // We can create stream with stream package, we don't need arraylist first
        // How to use filter in Stream API
       Long count = names.stream().filter(s -> s.startsWith("A")).count();
       System.out.println(count);

      long d = Stream.of("Emiliano", "Julieta", "Ana", "AAAAJorgito", "Ignacio").filter(s ->
               {
                   s.startsWith("A");
                   return true;
               }).count();
      System.out.println(d);

      // Print all the names of ArrayList
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

        // Limit the result to 1
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap(){
        ArrayList<String> names = new ArrayList<>();
        names.add("man");
        names.add("Don");
        names.add("women");


        // Print names which have last letter as "a" on Uppercase
        Stream.of("Emiliano", "Julieta", "Ana", "AAAAJorgito", "Ignacio").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        // Print names which have first letter as a with uppercase and sorted
        List<String> names1 = Arrays.asList("AEmiliano", "Julieta", "Ana", "AAAAJorgito", "Ignacio");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //Merging 2 different lists
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
//        newStream.sorted().forEach(s -> System.out.println(s));
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("AAAAJorgito"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }





    @Test
    public void streamCollect(){
        List<String> ls = Stream.of("Emiliano", "Julieta", "Ana", "AAAAJorgito", "Ignacio").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));



        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        // Print unique number from this array
        // Sort the array - 3rd index - 1,2,3,5,7,9
        values.stream().distinct().forEach(s -> System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }











}