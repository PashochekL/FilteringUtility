package org.example.filteringutility;

import java.util.List;

public class FileProcessor {
    private Options options;

    public FileProcessor(Options options) {
        this.options = options;
    }

    public void processFiles() {
        StatisticsCollector statsCollector = new StatisticsCollector(options.isFullStats());
        DataProcessor dataProcessor = new DataProcessor(statsCollector);

        for (String inputFile : options.getInputFiles()) {
            List<String> lines = FileUtils.readLines(inputFile);

            for (String line : lines) {
                dataProcessor.processLine(line);
            }
            dataProcessor.writeToFiles(options);
            statsCollector.printStatistics();
        }
    }
}



