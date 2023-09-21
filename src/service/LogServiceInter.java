package service;

public interface LogServiceInter {
    void writeHistoryToLogFile(String operation, int point, double gameTime);
    void readHistoryFromLogFile();
}
