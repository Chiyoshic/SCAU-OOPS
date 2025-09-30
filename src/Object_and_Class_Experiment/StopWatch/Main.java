package Object_and_Class_Experiment.StopWatch;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        long sum1 = 0;
        for (long i = 0; i < 100000000; i++) {
            sum1 += i;
        }

        stopWatch.end();

        System.out.println("循环100000000次, 执行了" + stopWatch.getElapsedTime() + "毫秒");

        stopWatch.start();

        long sum2 = 0;
        for (long i = 0; i < 1000000000; i++) {
            sum2 += i;
        }

        stopWatch.end();

        System.out.println("循环100000000000次, 执行了" + stopWatch.getElapsedTime() + "毫秒");
    }
}
