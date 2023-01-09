package org.example.Operators;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class OperatorInAction {
    public static void main(String[] args) {
        Observable<Employee> employeeObservable = Observable.just(
                new Employee(101,"Alexa",60000,4.0),
                new Employee(298,"Bob",65000,4.7),
                new Employee(709,"Rob",70000,3.0),
                new Employee(393,"Alenn",85000,4.89),
                new Employee(871,"Alister",50000,3.6),
                new Employee(531,"Brenda",90000,4.73),
                new Employee(651,"Jason",40000,4.52),
                new Employee(167,"Manu",72000,3.91),
                new Employee(141,"Sharma",86000,3.85),
                new Employee(132,"Kartik",25000,4.29)
        );

        // Top 4 employees for new project
        employeeObservable.filter(e -> e.getRating() > 4.0)
                .sorted((e1 , e2 ) -> Double.compare(e2.getRating(), e1.getRating()))
                .map(x -> x.getName())
                .take(4)
                .sorted()
                .toList()
                .subscribe(System.out::println);

        // Compute total expenses -> Sum of array
        List<Integer> expenses = List.of(200,500,300,340,129,234,999,1030,3400,1030,890,996,789);
        Observable.fromIterable(expenses)
                .scan((a,b) -> a + b)
                .subscribe(System.out::println);

        // Compute total expenses -> Sum of array
        Observable.fromIterable(expenses)
                .reduce((a,b) -> a + b)
                .subscribe(System.out::println);


    }
}
