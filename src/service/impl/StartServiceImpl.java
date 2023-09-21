package service.impl;

import enums.ExceptionEnums;
import exceptions.AppExceptions;
import model.Word;
import service.StartServiceInter;

import java.time.LocalTime;

import static util.InputUtil.*;
import static helper.RandomHelper.*;
import static helper.TimeHelper.*;
import static helper.ResultHelper.*;

public class StartServiceImpl implements StartServiceInter {
    FileServiceImpl fileService = new FileServiceImpl();
    LogServiceImpl logService = new LogServiceImpl();
    int point = 0;
    int correctWordPoint = 0;
    int wrongWordPoint = 0;
    @Override
    public void start() {
        Word[] words = fileService.readFile();
        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < 10; i++) {
            Word word = words[randomIndexGenerator(words.length)];

            if (!word.isShowed()) {
                String engWord = inputRequiredString(word.getKey() + "-->");

                if (word.getValue().equals(engWord)) {
                    correctWordPoint++;
                } else {
                    wrongWordPoint++;
                }
            } else {
                i--;
            }
            word.setShowed(true);
        }
        LocalTime endTime = LocalTime.now();

        int totalPoint = (correctWordPoint - wrongWordPoint/3);
        if (totalPoint < 0) {
            throw new AppExceptions(ExceptionEnums.ILLEGAL_POINT_EXCEPTION);
        }
        System.out.println("Your total point is: " + totalPoint + "\nWrong Word Point is: " + wrongWordPoint
                + "\nCorrect Word Point is: " + correctWordPoint
        );
        levelGenerator(point);
        logService.writeHistoryToLogFile("New Game ", point, timeCalculator(startTime, endTime));
    }

    @Override
    public void addWord() {
        int wordCount = inputRequiredInt("How many words do you want to add: ");
        for (int i = 0; i < wordCount; i++) {
            String engWord = inputRequiredString("In English: ");
            String azWord = inputRequiredString("In Azerbaijani: ");
            if (engWord.contains("ə")) {
                throw new AppExceptions(ExceptionEnums.ILLEGAL_CHARACTER_EXCEPTION);
            }
            fileService.writeFile(new Word(engWord, azWord));
        }
    }

    @Override
    public void seeHistory() {
        logService.readHistoryFromLogFile();
    }

    @Override
    public void exit() {
        System.exit(-1);
    }
}
