import java.util.regex.*;

class playerEntry{

    private String name;
    private String playerID;
    private String careerTries;
    private String teamName;
    private String teamID;
    private String stdName;
    private String stdStr;
    private String stdTwn;
    private String stdPscd;
    anInput in = new anInput();


    public void playerEntry(String inName, String inPlayerID, String inCareerTries, String inTeamName, String inTeamID, String inStdName, String inStdStr,  String inStdTwn, String inStdPscd){
        name = inName;
        playerID = inPlayerID;
        careerTries = inCareerTries;
        teamName = inTeamName;
        teamID = inTeamID;
        stdName = inStdName;
        stdStr = inStdStr;
        stdTwn = inStdTwn;
        stdPscd = inStdPscd;
    }


    public String getName(){
        boolean match = false;
        while (match == false) {
            name = in.getStr(("Enter Player Name: "));
            String pattern = "[a-zA-Z]{2,} [a-zA-Z]{2,}";
            match = Pattern.matches(pattern, name);
            if (match ==  false){
                System.out.println("INVALID INPUT Must be a Name followed by Surname");
            }
        }
        return name;
    }

    public String getplayerID(){
        boolean match = false;
        while(match == false){
            playerID = in.getStr(("Enter Player ID: "));
            String pattern = "RFU\\d{5}";
            match = Pattern.matches(pattern, playerID);
            if (match ==  false){
                System.out.println("INVALID INPUT Must be RFU Followed by 5 digits");
            }
        }
        return playerID; 
    }

    public String getTries(){
        boolean match = false;
        while(match == false){
            careerTries = in.getStr(("Enter Career Tries: "));
            String pattern = "\\d+";
            match = Pattern.matches(pattern, careerTries);
            if (match ==  false){
                System.out.println("INVALID INPUT Must be a Number");
            }
        }
        return careerTries; 
    }

    public String getTeamName(){
        boolean match = false;
        while(match == false){
            teamName = in.getStr(("Enter Team Name: "));
            String pattern = "([a-zA-Z]+\\s*)+";
            match = Pattern.matches(pattern, teamName);
            if (match ==  false){
                System.out.println("INVALID INPUT Must be characters");
            }
        }
        return teamName;
    }
    public String getTeamID(){
        boolean match = false;
        while(match == false){
            teamID = in.getStr(("Enter Team ID: "));
            String pattern = "([A-Z]){3}(\\d){4}";
            match = Pattern.matches(pattern, teamID);
            if (match ==  false){
                System.out.println("INVALID INPUT must be 3 letters followed by 4 digits");
            }
        }
        return teamID;
    }

    public String getStdName(){
        boolean match = false;
        while(match == false){
            stdName = in.getStr(("Enter Stadium Name: "));
            String pattern = "([a-zA-Z]+\\s*)+";
            match = Pattern.matches(pattern, stdName);
            if (match ==  false){
                System.out.println("INVALID INPUT must be Characters");
            }
        }
        return stdName; 
    }

    public String getStdStr(){
        boolean match = false;
        while(match == false){
            stdStr = in.getStr(("Enter Stadium Street: "));
            String pattern = "([a-zA-Z_0-9]+\\s*)+";
            match = Pattern.matches(pattern, stdStr);
            if (match ==  false){
                System.out.println("INVALID INPUT must be Chracters");
            }
        }
        return stdStr; 
    }

    public String getStdTwn(){
        boolean match = false;
        while(match == false){
            stdTwn = in.getStr(("Enter Stadium Town: "));
            String pattern = "([a-zA-Z]+\\s*)+";
            match = Pattern.matches(pattern, stdTwn);
            if (match ==  false){
                System.out.println("INVALID INPUT must be Characters");
            }
        }
        return stdTwn; 
    }

    public String getStdPC(){
        boolean match = false;
        while(match == false){
            stdPscd = in.getStr(("Enter Stadium Postcode: "));
            String pattern = "[A-Z][0-9]([A-Z]{3})";
            match = Pattern.matches(pattern, stdPscd);
            if (match ==  false){
                System.out.println("INVALID INPUT must be PostCode Format");
            }
        }
        return stdPscd;
    }

    public String createString( ){
        getName();
        getplayerID();
        getTries();
        getTeamName();
        getTeamID();
        getStdName();
        getStdStr();
        getStdTwn();
        getStdPC();

        String s = name + "(" + playerID + ")" + ", " + careerTries + ", " + teamName + ", " + teamID + ", " + stdName + ", " + stdStr + ", " + stdTwn + ", " + stdPscd;
        return s;
    }
}
 