package service;
import model.Word;

public interface FileServiceInter {
    Word[] readFile();
    void writeFile(Word word);
}
