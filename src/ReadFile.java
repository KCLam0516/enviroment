import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

    private String path;
    public  ReadFile(String file_path) {
        path = file_path;
    }

    public String[] OpenFile() throws IOException{
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);


        Long LinesNum = countLineBufferedReader(path);

        int numberOfLines =5;
        String[] textData = new String[LinesNum.intValue()];

        int i;

        for(i=0; i< LinesNum; i++){
            textData[i] = textReader.readLine();
        }

        textReader.close();
        return textData;
    }

    int readLines() throws IOException {

        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);

        String aLine;
        int numberOfLines = 0;
        while ((aLine = bf.readLine())!=null){
            numberOfLines++;
        }
        bf.close();

        return numberOfLines;
    }

    public static long countLineBufferedReader(String fileName){
        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
