package Generic_Experiment.Class;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(10);

        System.out.println("测试进队: ");
        for (int i = 1; i < 20; i++) {
            if (!queue.isFull()) {
                queue.add(i);
                System.out.printf("[%d] 进队. \n", i);
            } else {
                System.out.println("队列已满");
            }
        }

        System.out.println("测试出队: ");
        while (!queue.isEmpty()) {
            System.out.printf("[%d] 出队\n", queue.remove());
        }
    }
}