package pers.haike.demo.data_structure;

import org.junit.Test;
import pers.haike.demo.MyUncheckException;

import java.util.concurrent.CompletableFuture;

public class UncheckException {

    void call() {
        throw new MyUncheckException();
    }

    @Test
    public void test() {
        CompletableFuture.supplyAsync(() -> {
            if (new String().hashCode() == 1) {
                throw new MyUncheckException();
            }
            return "";
        });
        call();
    }
}
