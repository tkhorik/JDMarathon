package javaAdvanced.comparatorInvestigations;

import java.util.*;

import static java.lang.System.*;

public class QweComparator {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        List<Employee> employeeLinkedList = new LinkedList<>();
        Set<Employee> emplyeeSet = new TreeSet<>();

        addEmployees(employeeList);
        addEmployees(emplyeeSet);
        addEmployees(employeeLinkedList);

        out.println(employeeList);
        out.println(emplyeeSet);
        System.out.println(employeeLinkedList + "qwe");
        Collections.sort(employeeList);
        Collections.sort(employeeLinkedList);
        System.out.println(employeeLinkedList + "qwe");
        out.println(employeeList);

    }

    private static void addEmployees(Collection collection) {
        collection.add(new Employee(3, "Grisha", "Rubcinsky"));
        collection.add(new Employee(1, "Fedea", "Sadovsky"));
        collection.add(new Employee(12, "Marck", "Liubovsky"));
    }
}

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String surname;

    public Employee(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int compareTo(Employee employee) {
        if (this.id > employee.getId()) return 1;
        else if (this.id < employee.getId()) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}