package hello.springdbjdbc.test;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)

public class ForLoop {

    int LOOP_COUNT = 100000;
    List<Integer> list;

    @Setup
    public void setUp() {
        list = new ArrayList<>(LOOP_COUNT);
        for (int loop=0; loop < LOOP_COUNT; loop++){
            list.add(loop);
        }
    }

}
