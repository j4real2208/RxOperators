package org.example.Grouping;

import io.reactivex.rxjava3.core.Observable;
import org.example.Operators.Employee;

public class GroupingRunner {
    public static void main(String[] args) {
        Observable<Employee> employeeObservable = Observable.just(
                new Employee(101,"Alexa",60000,4.0),
                new Employee(298,"Bob",65000,4.7),
                new Employee(709,"Rob",70000,3.0),
                new Employee(393,"Alenn",85000,4.89),
                new Employee(871,"Alister",50000,3.85),
                new Employee(531,"Brenda",90000,4.7),
                new Employee(651,"Jason",40000,4.52),
                new Employee(167,"Manu",72000,3.00),
                new Employee(141,"Sharma",86000,3.85),
                new Employee(132,"Kartik",25000,4.29)
        );
        employeeObservable.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toMultimap(key -> e.getKey() , employee -> employee.getName()))
                .subscribe(System.out::println);

    }
}
