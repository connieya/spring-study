package hello.springdbjdbc.test;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ConditionIf {
    int LOOP_COUNT = 1000;

    @Benchmark
    public void randomOnly() {
        Random random = new Random();
        int data = 1000+random.nextInt();
        for (int loop=0; loop <LOOP_COUNT; loop++) {
            resultProcess("dummy");
        }
    }
    @Benchmark
    public void if10() {
        Random random = new Random();
        String result =null;
        int data = 1000+random.nextInt();
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            if (data < 50) {
                result="50";
            } else if (data < 150) {
                result = "150";
            }else if (data < 250) {
                result = "250";
            }else if (data < 350) {
                result = "350";
            }else if (data < 450) {
                result = "450";
            }else if (data < 550) {
                result = "550";
            }else if (data < 650) {
                result = "650";
            }else if (data < 750) {
                result = "750";
            }else if (data < 850) {
                result = "850";
            }else if (data < 950) {
                result = "950";
            }else {
                result = "over";
            }
            resultProcess(result);
        }
    }

    @Benchmark
    public void if100(){
        Random random = new Random();
        String result =null;
        int data = 1000+random.nextInt();
        for (int loop=0; loop<LOOP_COUNT; loop++) {
            if (data < 50) {
                result="50";
            } else if (data < 150) {
                result = "150";
            }else if (data < 250) {
                result = "250";
            }else if (data < 350) {
                result = "350";
            }else if (data < 450) {
                result = "450";
            }else if (data < 550) {
                result = "550";
            }else if (data < 650) {
                result = "650";
            }else if (data < 750) {
                result = "750";
            }else if (data < 850) {
                result = "850";
            }else if (data < 950) {
                result = "950";
            }else if (data < 9950){
                result = "9950";
            }else {
                result ="over";
            }
            resultProcess(result);
        }
    }



    String current;
    private void resultProcess(String result) {
        current = result;
    }
}
