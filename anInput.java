import java.util.Scanner;

public class anInput{
    Scanner in;
    public anInput() {
        in = new Scanner(System.in);
    }
    public int getInt ( String prompt ){
        System.out.print(prompt + "\n- ");
        int result = in.nextInt();
        return result;
    }
    public String getStr (String prompt ){
        System.out.print(prompt + "\n- ");
        String result = in.nextLine();
        return result;
    }
}
