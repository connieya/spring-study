package hello.springdbjdbc.test;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MapGet {
    int LOOP_COUNT = 1000;
    Map<Integer, String > hashMap;
    Map<Integer,String > hashTable;
    Map<Integer,String > treeMap;
    Map<Integer, String > linkedHashMap;
    int keys[];

    @Setup(Level.Trial)
    public void setUp() {
        if (keys == null || keys.length != LOOP_COUNT) {
            hashMap = new HashMap<>();
            hashTable = new Hashtable<>();
            treeMap = new TreeMap<>();
            linkedHashMap = new LinkedHashMap<>();
            String data = "abcedfgijklmnopqrstuvwxyz";
            for (int loop =0; loop <LOOP_COUNT;loop++) {
                String tempData = data+loop;
                hashMap.put(loop,tempData);
                hashTable.put(loop,tempData);
                treeMap.put(loop,tempData);
                linkedHashMap.put(loop,tempData);
            }

        }
    }

    @Benchmark
    public void getSeqHashMap() {
        for (int loop=0; loop<LOOP_COUNT; loop++){
            hashMap.get(loop);
        }
    }

    @Benchmark
    public void getRandomHashMap() {
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            hashMap.get(keys[loop]);
        }
    }

    @Benchmark
    public void getSeqHashtable() {
        for (int loop =0; loop<LOOP_COUNT; loop++) {
            hashTable.get(loop);
        }
    }

    @Benchmark
    public void getRandomHashtable() {
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            hashTable.get(keys[loop]);
        }
    }

    @Benchmark
    public void getSeqTreeMap() {
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            treeMap.get(loop);
        }
    }

    @Benchmark
    public void getRandomTreeMap() {
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            treeMap.get(keys[loop]);
        }
    }

    @Benchmark
    public void getSeqLinkedHashMap() {
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            linkedHashMap.get(loop);
        }
    }

    @Benchmark
    public void getRandomLinkedHashMap() {
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            linkedHashMap.get(keys[loop]);
        }
    }

}
