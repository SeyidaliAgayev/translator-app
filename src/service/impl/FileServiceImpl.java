package service.impl;

import data.GlobalStrings;
import model.Word;
import service.FileServiceInter;

import java.io.*;

public class FileServiceImpl implements FileServiceInter {
    GlobalStrings globalStrings = new GlobalStrings();
    @Override
    public Word[] readFile() {
        File file = new File(globalStrings.GAME_DICTIONARY_FILE_NAME);
        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = bufferedInputStream.readAllBytes();
            String wordFile = new String(bytes);
            String[] keyAndValues = wordFile.split("\n");
            Word[] words = new Word[keyAndValues.length];
            for (int i = 0; i < words.length; i++) {
                String[] keyAndValue = keyAndValues[i].split(":");
                if (keyAndValue.length != 1) {
                    words[i] = new Word(keyAndValue[0], keyAndValue[1]);
                }
            }
            inputStream.close();
            bufferedInputStream.close();
            return words;
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        return new Word[0];
    }

    @Override
    public void writeFile(Word word) {
        File file = new File(globalStrings.GAME_DICTIONARY_FILE_NAME);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(word.toString().getBytes());
            outputStream.close();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
