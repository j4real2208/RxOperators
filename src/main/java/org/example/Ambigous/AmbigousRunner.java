package org.example.Ambigous;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AmbigousRunner {
    public static void main(String[] args) throws InterruptedException {

        // Allows to pick up faster source

        Observable<String> obs1 = Observable.interval(1, TimeUnit.SECONDS).take(10)
                .map( e1 -> "$Observerable 1 : "+e1 );
        Observable<String> obs2 = Observable.interval(1, TimeUnit.MILLISECONDS).take(10)
                .map( e2 -> "@Observerable 2 : "+e2 );

        Observable.amb(Arrays.asList(obs1,obs2))
                .subscribe(s -> System.out.println(" received : "+s));
        Thread.sleep(15000);
    }
}
