package org.example.filteringutility;

public class Options {
    private String outputDir;
    private String prefix;
    private boolean append;
    private boolean fullStats;
    private boolean shortStats;
    private String inputFile;

    public Options() {
        this.outputDir = ".";
        this.prefix = "";
        this.append = false;
        this.fullStats = false;
        this.shortStats = true;
        this.inputFile = ""; // по умолчанию пусто
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    public boolean isFullStats() {
        return fullStats;
    }

    public void setFullStats(boolean fullStats) {
        this.fullStats = fullStats;
    }

    public boolean isShortStats() {
        return shortStats;
    }

    public void setShortStats(boolean shortStats) {
        this.shortStats = shortStats;
    }
}
