package org.example.ZipCombineLatest;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ZipCombineLatestRunner {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);
        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS).take(10);

        // concurent zip()
//        Observable.zip(src1,src2, (s1 , s2) ->"Source 1 : "+s1+" || Source 2 : "+s2)
//                .subscribe(System.out::println);
          Observable.combineLatest (src1,src2, (s1 , s2) ->"Source 1 : "+s1+" || Source 2 : "+s2)
                .subscribe(System.out::println);



        Thread.sleep(20000);
    }
}
