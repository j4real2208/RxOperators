package org.example.FlagMapConcatMap;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class FlagMapConcatMapRuner {
    public static void main(String[] args) {
        List<String> stringList = List.of("Hello","Reactive","Programming");
        // FlatMap()

        Observable.fromIterable(stringList)
                .flatMap( e -> Observable.fromArray(e.split("")))
                .subscribe(s -> System.out.println("Output : "+s) );

        System.out.println("****************************************************************************************");

        Observable.fromIterable(stringList)
                .concatMap( e -> Observable.fromArray(e.split("")))
                .subscribe(s -> System.out.println("Output : "+s) );
    }
}
