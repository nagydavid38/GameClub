package gameclub.view;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ConsoleView implements IConsoleView {

    String username;

    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ConsoleView(){

    }

    Scanner scanner = new Scanner(System.in);
    @Override
    public void printLogin(){
        System.out.println("Welcome to Board Game Club Application!\n Please log in.");
        System.out.print("Login name: "); username = scanner.next();
        System.out.print("\nPassword: "); password = scanner.next();


    }

    @Override
    public void printLoginSuccess(List<String> roleList){
        System.out.println("Login successful. Your role: " + roleList);
    }

    @Override
    public void printLoginFailure(){
        System.out.println("Login failure, bye");
    }

    @Override
    public void printUserInformation(List<String> roleList, String name, String groupName, List<String> requestList, List<String> gameList, List<String> groupList){
        System.out.println("Hi " + name);

        if(roleList.contains("SUPERUSER"))
            return;

        if(roleList.contains("GROUPADMIN")){
            System.out.print("Your group:\n" +
                             "- " + groupName + "\n\n" +
                             "Group join request:\n"
            );
            for(String request : requestList){
                System.out.println("- " + request);
            }
        }

        if(roleList.contains("PLAYER")){
            System.out.println("Your games:");
            for(String game : gameList){
                System.out.println("- " + game);
            }
            System.out.println("Group membership:");
            if(groupList.stream().findAny().isPresent()){
                for(String group : groupList){
                    System.out.println("- " + group);
                }
            }else{
                System.out.println("N/A");
            }
        }
    }

    @Override
    public int printMenu(List<String> roleList){

        int input;

        System.out.print("Here are the possible actions:\n" +
                         "1. View list of all games\n");
        if(roleList.contains("PLAYER")){
            System.out.print("2. Add my game\n" +
                             "3. Create Join request\n");
        }
        if(roleList.contains("GROUPADMIN")){
            System.out.println("4. Handle Join request");
        }
        System.out.println("5. Quit application\n");
        System.out.print("Please choose an item: "); input = Integer.parseInt(scanner.next());

        return input;

    }

    @Override
    public void printGameList(List<Map<String, String>> gameAttributeList){
        printDoubleLine();
        for(Map<String,String> gameMap : gameAttributeList){
            System.out.print("- id: " + gameMap.get("id") + "\n" +
                             "  Name: " + gameMap.get("name") + "\n" +
                             "  Description: " + gameMap.get("desc") + "\n" +
                             "  Categories: " + gameMap.get("categories")+ "\n" +
                             "  Minimum age: " + gameMap.get("min_age") + "\n" +
                             "  Number of players: " + gameMap.get("player_num")+ "\n" +
                             "  Play time: " + gameMap.get("play_time") + "\n");
        }
        printDoubleLine();
    }

    @Override
    public String printAddGame(List<String> missingGameList){
        int index;
        int counter = 0;
        missingGameList.sort(Comparator.naturalOrder());

        if(missingGameList.stream().findAny().isPresent()){
            System.out.println("Please choose from the following list:");
            for(String game : missingGameList){
                System.out.println(++counter +". " + game);
            }
            System.out.println(++counter + ". Back to main menu");
            System.out.println("\nPlease choose game: "); index = Integer.parseInt(scanner.next());

            if(index == counter){
                System.out.println("Returning...");
                return "N/A";
            }
            else{
                System.out.println("\nGame has been added to your games collection.");
                return missingGameList.get(index - 1);
            }
        }
        else{
            System.out.println("No new games at the moment, please check later.");
            return "N/A";
        }

    }

    @Override
    public String printJoinGroup(List<String> notJoinedGroupList){
        int index = 0;
        int counter = 0;
        notJoinedGroupList.sort(Comparator.naturalOrder());

        if(notJoinedGroupList.stream().findAny().isPresent()){
            System.out.println("Please choose the group you would like to join:");
            for(String group : notJoinedGroupList){
                System.out.println(++counter + ". " + group);
            }
            System.out.println(++counter + ". Back to main menu");
            System.out.println("\nPlease choose group: "); index=Integer.parseInt(scanner.next());

            if(index == counter){
                System.out.println("Returning...");
                return "N/A";
            }
            else{
                System.out.println("Join request sent.");
                return notJoinedGroupList.get(index - 1);
            }
        }
        else{
            System.out.println("No available groups at the moment, please check later.");
            return "N/A";
        }
    }

    @Override
    public String printJoinRequestDecision(List<String> userList){
        String input;
        int counter = 0;
        int index;

        if(userList.stream().findAny().isPresent()){

            System.out.println("List of players who would like to join your group. Please select player number and (A)ccept or (R)eject:");
            for(String user : userList){
                System.out.println(++counter + ". " + user);
            }
            System.out.println(++counter + ". Back to main menu");
            System.out.println("\nPlease answer: "); input = scanner.next();

            if(input.charAt(0) == counter){
                System.out.println("Returning...");
                return "N/A";
            }
            if(input.charAt(1) == 'A'){
                System.out.println("Player has joined your group.");
            }
            if(input.charAt(1) == 'R'){
                System.out.println("Player has been rejected from group.");
            }
            index = Integer.parseInt(String.valueOf(input.charAt(0))) - 1;
            String userChosen = userList.get(index);
            String realInput =String.valueOf(index) + String.valueOf(input.charAt(1)) + '#' + userChosen;
            return realInput;
        }
        else{
            System.out.println("No new requests for your group.");
            return "N/A";
        }
    }

    @Override
    public void printDoubleLine() {
        System.out.print("\n\n");
    }

    @Override
    public void printMenuWrongNumber() {
        System.out.println("Please choose a valid option");
    }
}
