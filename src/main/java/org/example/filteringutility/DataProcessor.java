package org.example.filteringutility;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {
    private List<Integer> integers = new ArrayList<>();
    private List<Double> floats = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private StatisticsCollector statsCollector;

    public DataProcessor(StatisticsCollector statsCollector) {
        this.statsCollector = statsCollector;
    }

    public void processLine(String line) {

        if (isInteger(line)) {
            integers.add(Integer.parseInt(line));
            statsCollector.updateStats(Integer.parseInt(line));
        } else if (isFloat(line)) {
            floats.add(Double.parseDouble(line));
            statsCollector.updateStats(Double.parseDouble(line));
        } else {
            strings.add(line);
            statsCollector.updateStats(line);
        }
    }

    private boolean isInteger(String line) {
        if (line == null || line.trim().isEmpty()) return false;
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFloat(String line) {
        if (line == null || line.trim().isEmpty()) return false;
        try {
            Double.parseDouble(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void writeToFiles(Options options) {
        if (!integers.isEmpty()) {
            FileUtils.writeToFile(options.getOutputDir() + "/" + options.getPrefix() + "integers.txt", integers, options.isAppend());
        }
        if (!floats.isEmpty()) {
            FileUtils.writeToFile(options.getOutputDir() + "/" + options.getPrefix() + "floats.txt", floats, options.isAppend());
        }
        if (!strings.isEmpty()) {
            FileUtils.writeToFile(options.getOutputDir() + "/" + options.getPrefix() + "strings.txt", strings, options.isAppend());
        }
    }
}

