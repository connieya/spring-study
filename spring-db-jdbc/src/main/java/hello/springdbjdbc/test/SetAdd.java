package hello.springdbjdbc.test;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SetAdd {
    int LOOP_COUNT = 1000;
    Set<String > set;
    String data = "abcdefghijklmnopqrstuvwxyz";

    @Benchmark
    public void addHashSet(){
        set = new HashSet<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            set.add(data+loop);
        }
    }
    @Benchmark
    public void addTreeSet(){
        set = new TreeSet<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            set.add(data+loop);
        }
    }
    @Benchmark
    public void addLinkedHashSet(){
        set = new LinkedHashSet<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            set.add(data+loop);
        }
    }
}
