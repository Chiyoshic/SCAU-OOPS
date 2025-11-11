package Framework_Experiment.Point;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("需要输入的坐标个数: ");
        int n = scanner.nextInt();

        Set<Point> points = new HashSet<>();

        for (int i = 0; i < n; i++) {
            System.out.printf("第%d个横坐标和纵坐标(x y): ", i + 1);
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x, y));
        }

        Point[] pointArray = points.toArray(new Point[0]);

        System.out.println("\n实际共有" + pointArray.length + "个点");
        System.out.println(points);

        if (pointArray.length < 2) {
            System.out.println("至少需要2个不同的点才能计算距离");
            return;
        }

        Point closest1 = null, closest2 = null;
        Point farthest1 = null, farthest2 = null;
        double minDistance = Double.MAX_VALUE;
        double maxDistance = Double.MIN_VALUE;

        for (int i = 0; i < pointArray.length; i++) {
            for (int j = i + 1; j < pointArray.length; j++) {
                double distance = pointArray[i].distanceTo(pointArray[j]);

                if (distance < minDistance) {
                    minDistance = distance;
                    closest1 = pointArray[i];
                    closest2 = pointArray[j];
                }

                if (distance > maxDistance) {
                    maxDistance = distance;
                    farthest1 = pointArray[i];
                    farthest2 = pointArray[j];
                }
            }
        }

        System.out.printf("距离最近: [%s , %s], 距离是: %.2f\n",
                closest1, closest2, minDistance);
        System.out.printf("距离最远: [%s , %s], 距离是: %.2f\n",
                farthest1, farthest2, maxDistance);

        scanner.close();
    }
}
