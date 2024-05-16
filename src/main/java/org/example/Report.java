package org.example;
import java.util.Queue;
import java.util.LinkedList;
public class Report {
    private final Queue<String> report;
    public Report() {
        this.report = new LinkedList<>();
    }
    public void addReport(String text) {
        report.add(text);
    }
    public void spawnReport(String organismName) {
        report.add("New " + organismName + " has spawned!");
    }
    public void fightReport(String winnerName, String loserName) {
        report.add(winnerName + " has killed " + loserName + " [*]");
    }
    public String reportOfTheTurn() {
        StringBuilder finalReport = new StringBuilder();
        finalReport.append("REPORT:\n");
        while (!report.isEmpty()) {
            finalReport.append(report.remove());
            finalReport.append("\n");
        }
        return finalReport.toString();
    }
}
