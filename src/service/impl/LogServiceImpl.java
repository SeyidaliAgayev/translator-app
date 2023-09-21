package service.impl;

import data.GlobalStrings;
import service.LogServiceInter;

import java.io.*;
import java.time.LocalDateTime;

public class LogServiceImpl implements LogServiceInter {
    GlobalStrings globalStrings = new GlobalStrings();
    @Override
    public void writeHistoryToLogFile(String operation, int point, double gameTime) {
        File file = new File(globalStrings.GAME_LOGS_FILE_NAME);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("\n" + operation + " started at --> Time: " + LocalDateTime.now() + " Point --> " + point +
                    " Game Time --> " + gameTime + "seconds");

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }

    @Override
    public void readHistoryFromLogFile() {
        File file = new File(globalStrings.GAME_LOGS_FILE_NAME);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            fileReader.close();;
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
