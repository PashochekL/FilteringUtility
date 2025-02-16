package org.example.filteringutility;

public class StatisticsCollector {
    private boolean fullStats;
    private int integerCount;
    private int floatCount;
    private int stringCount;
    private int minInteger;
    private int maxInteger;
    private double sumInteger;
    private double avgInteger;
    private double minFloat;
    private double maxFloat;
    private double sumFloat;
    private double avgFloat;
    private int minStringLength;
    private int maxStringLength;

    public StatisticsCollector(boolean fullStats) {
        this.fullStats = fullStats;
        this.minInteger = Integer.MAX_VALUE;
        this.maxInteger = Integer.MIN_VALUE;
        this.sumInteger = 0;
        this.avgInteger = 0;
        this.minFloat = Double.MAX_VALUE;
        this.maxFloat = Double.MIN_VALUE;
        this.sumFloat = 0;
        this.avgFloat = 0;
        this.minStringLength = Integer.MAX_VALUE;
        this.maxStringLength = 0;
    }

    public void updateIntegerStats(int value) {
        integerCount++;
        sumInteger += value;
        minInteger = Math.min(minInteger, value);
        maxInteger = Math.max(maxInteger, value);
    }

    public void updateFloatStats(double value) {
        floatCount++;
        sumFloat += value;
        minFloat = Math.min(minFloat, value);
        maxFloat = Math.max(maxFloat, value);
    }

    public void updateStringStats(String value) {
        stringCount++;
        minStringLength = Math.min(minStringLength, value.length());
        maxStringLength = Math.max(maxStringLength, value.length());
    }

    public void printStatistics() {
        System.out.println("Краткая статистика:");
        System.out.println("Целых чисел: " + integerCount);
        System.out.println("Вещественных чисел: " + floatCount);
        System.out.println("Строк: " + stringCount);

        if (fullStats) {
            System.out.println("Полная статистика:");
            System.out.println("Целых чисел:");
            System.out.println("  Минимум: " + minInteger);
            System.out.println("  Максимум: " + maxInteger);
            System.out.println("  Сумма: " + sumInteger);
            System.out.println("  Среднее: " + (integerCount > 0 ? sumInteger / integerCount : 0));

            System.out.println("Вещественных чисел:");
            System.out.println("  Минимум: " + minFloat);
            System.out.println("  Максимум: " + maxFloat);
            System.out.println("  Сумма: " + sumFloat);
            System.out.println("  Среднее: " + (floatCount > 0 ? sumFloat / floatCount : 0));

            System.out.println("Строк:");
            System.out.println("  Количество: " + stringCount);
            System.out.println("  Минимальная длина строки: " + minStringLength);
            System.out.println("  Максимальная длина строки: " + maxStringLength);
        }
    }

    public void updateStats(Object value) {
        if (value instanceof Integer) {
            updateIntegerStats((Integer) value);
        } else if (value instanceof Double) {
            updateFloatStats((Double) value);
        } else if (value instanceof String) {
            updateStringStats((String) value);
        }
    }
}