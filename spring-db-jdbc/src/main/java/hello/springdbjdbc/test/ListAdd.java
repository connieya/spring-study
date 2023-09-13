package hello.springdbjdbc.test;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ListAdd {
    int LOOP_COUNT = 1000;
    List<Integer> arrayList;
    List<Integer> vector;
    List<Integer> linkedList;

    @Benchmark
    public void addArrayList() {
        arrayList = new ArrayList<>();
        for (int loop=0; loop < LOOP_COUNT; loop++) {
            arrayList.add(loop);
        }
    }

    @Benchmark
    public void addVector() {
        vector = new Vector<>();
        for (int loop=0; loop < LOOP_COUNT; loop++) {
            vector.add(loop);
        }
    }
    @Benchmark
    public void addLinkedList() {
        linkedList = new LinkedList<>();
        for (int loop=0; loop < LOOP_COUNT; loop++) {
            linkedList.add(loop);
        }
    }
}
