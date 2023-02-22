package practice.problem_solving.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GreatThanRight {

    /*
    * Given a list print all the elements in the list that are greater than
    * all the remaining elements on it's right hand side.
    * */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(17,5,8,13,16,1,2);
        list = new LinkedList<>();
        int ele = 0;
        boolean flag = true;
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                flag = list.get(i) > list.get(j);
                if(!flag)
                    break;
            }
            if(flag || i == list.size() - 1)
                System.out.println(list.get(i));
        }
    }
}
