import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class writeFile{
    private String filename;
    private boolean writetofile = false;
    public writeFile(String file_name){
        filename = file_name;
    }
    public writeFile ( String file_name, boolean writevalue){
        filename = file_name;
        writetofile = writevalue;
    }
    public void write_file(String text) throws IOException{
        FileWriter write = new FileWriter(filename, writetofile);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("%s" + "%n", text);
        print_line.close();
    }
}
