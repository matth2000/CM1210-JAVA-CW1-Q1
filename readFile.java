import java.io.IOException;

import javafx.scene.chart.PieChart.Data;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class readFile {
    private String filename;
    public readFile (String file_name){
        filename = file_name;
    }
    public List<String> openFile() throws IOException{
        FileReader reader = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(reader);
        String currentLine;
        List<String> text = new ArrayList<>();
        while ((currentLine = textReader.readLine())!= null){
            text.add(currentLine);
        }
        textReader.close();
        return text;
    }
}