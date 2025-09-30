package Object_and_Class_Experiment.Stock;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入股票数据
        System.out.print("输入股票代码: ");
        String symbol = scanner.nextLine();

        System.out.print("输入股票名称: ");
        String name = scanner.nextLine();

        System.out.print("输入股票昨日收盘价: ");
        double previousClosingPrice = scanner.nextDouble();

        System.out.print("输入股票当前价格: ");
        double currentPrice = scanner.nextDouble();

        // 创建股票对象
        Stock stock = new Stock(symbol, name, previousClosingPrice, currentPrice);

        // 输出股票信息
        System.out.println("\n股票代码: " + stock.getSymbol());
        System.out.println("股票名称: " + stock.getName());
        System.out.printf("股票昨日收盘价: %.2f\n", stock.getPreviousClosingPrice());
        System.out.printf("股票当前价格: %.2f\n", stock.getCurrentPrice());
        System.out.printf("股票涨跌幅: %.2f%%\n", stock.getChangePercent());

        scanner.close();
    }
}
