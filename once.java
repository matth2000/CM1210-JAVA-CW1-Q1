import java.util.Scanner;

public class once{
    Scanner in;
    public once() {
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
