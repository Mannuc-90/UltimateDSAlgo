package ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(5);
        numbers.insert(90);
        numbers.insert(20);
        numbers.insert(60);
        numbers.insert(40);
        numbers.insert(70);
        //numbers.print();


        Array numbers2 = new Array(5);
        numbers2.insert(10);
        numbers2.insert(20);
        numbers2.insert(30);
        numbers2.insert(40);
        numbers2.insert(40);
        //number2.print();

        //numbers.removeAt(0);
        //System.out.println(numbers.indexOf(100));

        System.out.println("max : "+Array.max(numbers));

        Array intersectArr = Array.intersect(numbers,numbers2);
        System.out.println("Intersection Array elems : ");
        intersectArr.print();

        Array.reverse(intersectArr);
        System.out.println("reversed : ");
        intersectArr.print();

        Array.insertAt(numbers2,1,90);
        System.out.println("after insertAt ");
        numbers2.print();

        int[] nn={12,23,21};
        ArrayList<Integer> l = new ArrayList();
        l.add(12);
        l.add(22);
        System.out.println(l.toString());
        Collections.reverse(l);
        System.out.println("reversed");
        System.out.println(l.toString());

    }
}
