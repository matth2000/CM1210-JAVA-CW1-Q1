public class players {
    private playerEntry[] entries;
    private int length;
    final private static int max_length = 10;
    
    public players( ){
        entries = new playerEntry[max_length];
    }
    public void add(String Name, String PlayerID, String CareerTries, String TeamName, String TeamID, String StdName, String StdStr,  String StdTwn, String StdPscd){
        System.out.println("Length: " + length );
        if (length != max_length){
            entries[length] = new playerEntry( Name, PlayerID, CareerTries, TeamName, TeamID, StdName, StdStr, StdTwn, StdPscd);
            length++;
        }
    }
    public String toString(){
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i< length; ++i){
            temp.append( entries[i].toString() + "\n");
        }
        return temp.toString();
    }
}