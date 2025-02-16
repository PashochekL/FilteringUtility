package org.example.filteringutility;

import java.util.Arrays;

public class CommandLineParser {
    public Options parse(String[] args) {
        Options options = new Options();
        boolean fileProvided = false;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 < args.length) {
                        options.setOutputDir(args[i + 1]);
                        i++;
                    } else {
                        System.err.println("Ошибка: путь не указан для флага -o");
                    }
                    break;
                case "-p":
                    if (i + 1 < args.length) {
                        options.setPrefix(args[i + 1]);
                        i++;
                    } else {
                        System.err.println("Ошибка: для флага -p не указан префикс");
                    }
                    break;
                case "-a":
                    options.setAppend(true);
                    break;
                case "-s":
                    options.setShortStats(true);
                    options.setFullStats(false);
                    break;
                case "-f":
                    options.setFullStats(true);
                    options.setShortStats(false);
                    break;
                default:
                    if (!fileProvided) {
                        options.setInputFile(args[i]);
                        fileProvided = true;
                    } else {
                        System.err.println("Неизвестный аргумент: " + args[i]);
                    }
                    break;
            }
        }
        return options;
    }
}

