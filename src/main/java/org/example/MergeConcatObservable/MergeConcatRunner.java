package org.example.MergeConcatObservable;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeConcatRunner {
    public static void main(String[] args) throws InterruptedException {
//        Observable<String> stringObservable1 = Observable.just("Ella","Ted","Ram");
//        Observable<String> stringObservable2 = Observable.just("Seleena","Kartik");
//
//        Observable.merge(stringObservable1,stringObservable2)
//                .subscribe(System.out::println);


        // Non sequential

        Observable<String> stringObservable1 = Observable.interval(1, TimeUnit.SECONDS)
                .map( ( e ) -> "src1 :"+e);
        Observable<String> stringObservable2 = Observable.interval(1, TimeUnit.SECONDS)
                .map( ( e ) -> "src2 :"+e);
        Observable.merge(stringObservable1,stringObservable2)
            .subscribe(x -> System.out.println("Received :" + x));
        Thread.sleep(10000);

        System.out.println("****************************************************************************************");


        // sequential concat()
        Observable.concat(stringObservable1,stringObservable2)
                .subscribe(x -> System.out.println("Received :" + x));
        Thread.sleep(20000);

        System.out.println("****************************************************************************************");


        // sequential concat()
        stringObservable1.concatWith(stringObservable2)
                .subscribe(x -> System.out.println("Received with concat method :" + x));
        Thread.sleep(10000);


    }
}
