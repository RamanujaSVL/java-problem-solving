package practice.stream.lambda_expressions;

import practice.problem_solving.easy.StringManipulationPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaExpressions_Lists {

    /*
    * 1. Write a program that sorts a list of strings in alphabetical order using a lambda expression.*/
    class CustomStringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return Character.compare(o1.charAt(o1.length() - 1), o2.charAt(o2.length()-1));
        }
    }
    public void firstSolution() {
        List<String> stringList = Arrays.asList("One","Two","Three","Four");
        System.out.println(stringList.stream().sorted().collect(Collectors.toList()));
        //Using a custom Comparator
        CustomStringComparator stringComparator = new CustomStringComparator();
        System.out.println(stringList.stream().sorted(new CustomStringComparator()).collect(Collectors.toList()));
    }
    /* 2. Write a program that takes a list of integers and returns a new list with all even numbers using a lambda expression.*/

    public void secondSolution() {
        List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> evenIntegers = listOfIntegers.stream().filter(n -> (n % 2 == 0)).collect(Collectors.toList());

        System.out.println(evenIntegers);
    }
    /* 3. Write a program that takes a list of strings and returns a list of only those strings that have a length greater than 5 using a lambda expression.*/
    public void thirdSolution() {
        List<String> stringList = Arrays.asList("Eleven","Two","Thirteen","Fourteen");
        System.out.println(stringList.stream().filter(s -> s.length() > 5).collect(Collectors.toList()));
    }
    /* 4. Write a program that takes a list of integers and returns the sum of all elements in the list using a lambda expression.*/
    public void fourthSolution() {
        List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5,6);
        System.out.println(listOfIntegers.stream().reduce(0, Integer::sum));
    }
    /* 5. Write a program that takes a list of strings and returns a list of all palindrome strings using a lambda expression.*/
    public void fifthSolution() {
        List<String> stringList = Arrays.asList("Eleven","mam","madam","Fourteen");
        StringManipulationPrograms stringManipulationPrograms  = new StringManipulationPrograms();
        System.out.println(stringList.stream().filter(s -> stringManipulationPrograms.checkPalindrome(s)).collect(Collectors.toList()));
    }

    /* 6. Write a program that takes two lists of integers and returns a new list with the result of multiplying
    each element from the first list with its corresponding element in the second list using a lambda expression.*/
    public void sixthSolution() {
        List<Integer> firstList = Arrays.asList(1,3,5,7);
        List<Integer> secondList = Arrays.asList(2,4,6,8);
        System.out.println(IntStream.range(0, firstList.size())
                                    .map(ind -> firstList.get(ind) * secondList.get(ind))
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining(",")));
    }

    /* 7. Write a program that takes a list of employee objects and returns a list of employee
      names sorted by their salary using a lambda expression.*/
    class Employee implements Comparable<Employee>{
        Long id;
        String employeeName;
        Long employeeSalary;
        Integer employeeAge;

        Employee() {}

        Employee(Long id, String employeeName, Long employeeSalary, Integer employeeAge) {
            this.id = id;
            this.employeeName = employeeName;
            this.employeeSalary = employeeSalary;
            this.employeeAge = employeeAge;
        }
        //Default Sorting Comparable by Salary
        @Override
        public int compareTo(Employee e1) {
            if(this.employeeSalary > e1.employeeSalary)
                return 1;
            else if(this.employeeSalary < e1.employeeSalary)
                return -1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", employeeName='" + employeeName + '\'' +
                    ", employeeSalary=" + employeeSalary +
                    ", employeeAge=" + employeeAge +
                    '}';
        }

        public List<Employee> getEmployeesList() {
            Employee e1 = new Employee(1l, "Tom", 1000L, 22);
            Employee e2 = new Employee(2l, "Harry", 8000L, 26);
            Employee e3 = new Employee(3l, "Dick", 3000L, 28);

            List<Employee> listOfEmployees = new ArrayList<>();

            listOfEmployees.add(e1);
            listOfEmployees.add(e2);
            listOfEmployees.add(e3);

            return listOfEmployees;
        }
    }
    public void seventhSolution() {

        System.out.println(new Employee().getEmployeesList().stream().sorted().collect(Collectors.toList()));
    }

    /* 8. Write a program that takes two lists of strings and returns a new list with all the
    elements from both lists, but with duplicates removed using a lambda expression.*/

    public void eighthSolution() {
        List<String> stringListOne = Arrays.asList("Eleven","Two","Thirteen","Four");
        List<String> stringListTwo = Arrays.asList("One","Two","Three","Four");

        List<String> resultString = new ArrayList<>();
        resultString.addAll(stringListOne);
        resultString.addAll(stringListTwo);

        System.out.println(resultString.stream().distinct().collect(Collectors.toList()));

    }

    /* 9. Write a program that takes a list of employee objects and returns the average salary of
          all employees using a lambda expression.*/

    public void ninthSolution() {

        System.out.println(new Employee().getEmployeesList().stream().mapToLong(emp -> emp.employeeSalary).average().orElse(0.0d));
    }

    /* 10. Write a program that takes two lists of integers and returns a new list with elements from
           both lists that are divisible by 3 using a lambda expression.*/

    public void tenthSolution() {
        List<Integer> integerListOne = Arrays.asList(1,4,5,3,9,15);
        List<Integer> integerListTwo = Arrays.asList(2,6,7,18,22,24);

        List<Integer> resultantIntList = new ArrayList<>();

        resultantIntList.addAll(integerListOne);
        resultantIntList.addAll(integerListTwo);

        System.out.println(resultantIntList.stream().filter(ele -> ele % 3 == 0).collect(Collectors.toList()));

    }

    public static void main(String[] args) {
        LambdaExpressions_Lists lambdaExpressions = new LambdaExpressions_Lists();
        lambdaExpressions.firstSolution();
        lambdaExpressions.secondSolution();
        lambdaExpressions.thirdSolution();
        lambdaExpressions.fourthSolution();
        lambdaExpressions.fifthSolution();
        lambdaExpressions.sixthSolution();
        lambdaExpressions.seventhSolution();
        lambdaExpressions.eighthSolution();
        lambdaExpressions.ninthSolution();
        lambdaExpressions.tenthSolution();
    }

}
