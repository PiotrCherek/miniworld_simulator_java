package org.example;
import java.util.Queue;
import java.util.LinkedList;
public class Report {
    private Queue<String> report;
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
    public void reportOfTheTurn() {
        System.out.println("REPORT:");
        while (!report.isEmpty()) {
            System.out.println(report.remove());
        }
    }
}
