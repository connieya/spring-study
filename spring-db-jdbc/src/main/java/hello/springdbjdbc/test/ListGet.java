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
public class ListGet {
    int LOOP_COUNT = 1000;
    List<Integer> arrayList;
    List<Integer> vector;
    LinkedList<Integer> linkedList;

    int result = 0;

    @Setup
    public void setUp() {
        arrayList = new ArrayList<>();
        vector = new Vector<>();
        linkedList = new LinkedList<>();

        for(int loop=0; loop<LOOP_COUNT; loop++) {
            arrayList.add(loop);
            vector.add(loop);
            linkedList.add(loop);
        }
    }

    @Benchmark
    public void getArrayList(){
        for (int loop=0; loop <LOOP_COUNT; loop++) {
            result = arrayList.get(loop);
        }
    }

    @Benchmark
    public void getVector() {
        for(int loop=0; loop<LOOP_COUNT; loop++) {
            result = vector.get(loop);
        }
    }

    @Benchmark
    public void getLinkedList() {
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            result = linkedList.get(loop);
        }
    }

    @Benchmark
    public void peekLinkedList() {
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            result = linkedList.peek();
        }
    }
}
