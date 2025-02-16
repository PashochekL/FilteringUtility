package org.example.filteringutility;

import java.util.Arrays;

public class FilteringUtilityApplication {
    public static void main(String[] args) {
        CommandLineParser parser = new CommandLineParser();
        Options options = parser.parse(args);

        FileProcessor fileProcessor = new FileProcessor(options);
        fileProcessor.processFiles();
    }
}

