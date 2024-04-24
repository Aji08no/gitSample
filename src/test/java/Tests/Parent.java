package Tests;

public class Parent {

    String name="hardik";

    public Parent(String name){
        System.out.println(name);
    }


    public static void main(String[] args) {

        Parent p=new Parent("aji");
        String out = p.name;
        System.out.println(out);


   }
}
