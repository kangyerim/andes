package com.andes.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

@Component @Lazy
public class Proxy {
    public String string(Object o){
        Function<Object, String> f = String :: valueOf;
        return f.apply(o);
    }

    public Integer integer(String s) {
        Function<String, Integer> f = Integer :: parseInt;
        return f.apply(s);
    }

    public boolean equals(String s, String u){
        BiPredicate<String, String> f = String :: equals;
        return f.test(s, u);
    }

    public void print(String t) {
        Consumer<String> c = System.out :: print;
        c.accept(t);
    }
}
