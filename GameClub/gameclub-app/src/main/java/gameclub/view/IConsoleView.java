package gameclub.view;

import java.util.List;
import java.util.Map;

public interface IConsoleView {
    void printLogin();

    void printLoginSuccess(List<String> roleList);

    void printLoginFailure();

    void printUserInformation(List<String> roleList, String name, String groupName, List<String> requestList, List<String> gameList, List<String> groupList);

    int printMenu(List<String> roleList);

    void printGameList(List<Map<String, String>> gameAttributeList);

    String printAddGame(List<String> missingGameList);

    String printJoinGroup(List<String> notJoinedGroupList);

    String printJoinRequestDecision(List<String> userList);

    void printDoubleLine();

    void printMenuWrongNumber();


}
