package gameclub.webapplication.controller;

import gameclub.domain.*;
import gameclub.service.IGameClubService;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GameClubController {

    IGameClubService gameClubService;
    Mapper mapper;


    String userName;

    @Autowired
    public GameClubController(IGameClubService gameClubService) {
        this.gameClubService = gameClubService;
        mapper = new Mapper();
    }

    String getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken))
            userName = authentication.getName();
            return userName;

    }

    @RequestMapping("test")
    public String test(){
        return "view";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String getMenu(){
        getUserName();
        return "menu";
    }

    @GetMapping("/user")
    public String getUserDetails(Model model){
        Map<String, String> player = gameClubService.playerBaseAttributes(userName);
        model.addAttribute("name", player.get("name"));
        model.addAttribute("login", player.get("login"));
        model.addAttribute("email", player.get("email"));
        return "user-details";
    }

    @GetMapping("/user/games")
    public String getUserGames(Model model){
        List<Game> userGamesList = gameClubService.gamesOfPlayer(userName);
        List<Game> gamesNotOwnedByPlayer = gameClubService.gamesNotOwnedByPlayer(userName);

        List<GameModel> userGames = new ArrayList<>();
        for (Game game : userGamesList){
            userGames.add(mapper.toGameModel(game));
        }

        List<GameModel> notOwnedGames = new ArrayList<>();
        for(Game game : gamesNotOwnedByPlayer){
            notOwnedGames.add(mapper.toGameModel(game));
        }

        model.addAttribute("userGames", userGames);
        model.addAttribute("gamesNotOwnedByPlayer", notOwnedGames);
        return "games-list";
    }

    @GetMapping("/user/groups")
    public String getUserGroups(Model model){

        List<Group> groupList = gameClubService.groupsOfPlayer(userName);
        List<Group> notJoinedGroups = gameClubService.notJoinedGroups(userName);



        List<GroupModel> modelGroupList = new ArrayList<>();
        for(Group group : groupList){
            String requestState = gameClubService.groupRequestState(group.getId(), userName).toString();
            modelGroupList.add(mapper.toGroupModel(group, requestState));
        }

        List<GroupModel> modelNotJoinedGroups = new ArrayList<>();
        for(Group group : notJoinedGroups){
            String requestState = gameClubService.groupRequestState(group.getId(), userName).toString();
            modelNotJoinedGroups.add(mapper.toGroupModel(group, requestState));
        }

        model.addAttribute("groupList", modelGroupList);
        model.addAttribute("notJoinedGroups", modelNotJoinedGroups);

        return "groups-list";
    }

    @GetMapping("/user/groups/{groupId}")
    public String getGroupDetails(@PathVariable Long groupId, Model model){
        Group group = gameClubService.getGroup(groupId);
        Player currentPlayer = gameClubService.getPlayer(userName);

        GroupModel groupModel = mapper.toGroupModel(group, currentPlayer);


        model.addAttribute("groupName", groupModel.getName());
        model.addAttribute("groupAdmin", groupModel.getAdminName());
        model.addAttribute("groupPlayers", groupModel.getPlayerList());
        model.addAttribute("groupEvents", groupModel.getEventList());

        return "group-details";
    }

    @GetMapping("/user/mygroup")
    public String getAdminGroupDetails(Model model){
        Group group = gameClubService.playerAdminGroup(userName);

        Player currentPlayer = gameClubService.getPlayer(userName);

        GroupModel groupModel = mapper.toGroupModel(group, currentPlayer);
        List<JoinRequestModel> joinRequestModelList = new ArrayList<>();

        for (JoinRequest request : gameClubService.groupJoinRequests(group.getId())){
            joinRequestModelList.add(mapper.toJoinRequestModel(request));
        }

        model.addAttribute("groupId", groupModel.getId());
        model.addAttribute("groupName", groupModel.getName());
        model.addAttribute("groupPlayers", groupModel.getPlayerList());
        model.addAttribute("groupJoinRequests", joinRequestModelList);

        return "admin_group-details";
    }

    @GetMapping("/user/mygroup/events-{groupId}")
    public String getGroupEvents(@PathVariable Long groupId, Model model){
        List<Event> eventList = gameClubService.getGroupEvents(groupId);
        List<EventModel> eventModelList = new ArrayList<>();
        Player currentPlayer = gameClubService.getPlayer(userName);

        if(!model.containsAttribute("eventModel"))
            model.addAttribute("eventModel", new EventModel());

        for (Event event : eventList){
            eventModelList.add(mapper.toEventModel(event, currentPlayer));
        }

        model.addAttribute("events", eventModelList);

        return "events-list";
    }

    @GetMapping("/admin_page")
    public String getSuHome(Model model){
        List<Game> gameList = gameClubService.listAllGames();
        List<GameModel> modelList = new ArrayList<>();
        for (Game game : gameList){
            modelList.add(mapper.toGameModel(game));
        }

        model.addAttribute("gameList", modelList);
        return "su-home";
    }

    @GetMapping("/add-game")
    public String getNewGame(Model model){

        GameModel gameModel = new GameModel();

        model.addAttribute("game", gameModel);
        return "add-game-form";
    }


    @PostMapping("/add-game")
    public String addNewGame(@Valid @ModelAttribute("game") GameModel game, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {

            return "add-game-form";
        }
        else{
            Game newGame = mapper.toGame(game);
            gameClubService.addGame(newGame);


            System.out.println(game);

            return "redirect:/admin_page";
        }
    }

    @PostMapping("/user/games")
    public String addGameToCollection(@ModelAttribute("game") GameModel game){
        gameClubService.addMyGame(userName, game.getId());

        System.out.println(game);
        return "redirect:/user/games";
    }

    @PostMapping("/user/mygroup/events-{groupId}")
    public String addGroupEvent(@PathVariable Long groupId, @Valid @ModelAttribute("eventModel") EventModel eventModel, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.eventModel", bindingResult);
            redirectAttributes.addFlashAttribute("eventModel", eventModel);
            return "redirect:/user/mygroup/events-" + groupId;
        }
        else {
            Group group = gameClubService.getGroup(groupId);
            Event event = mapper.toEvent(eventModel);

            gameClubService.addEventToGroup(group.getId(), event);
            System.out.println(event);

            return "redirect:/user/mygroup/events-" + groupId;
        }
    }

    @PostMapping("/user/groups")
    public String createJoinRequest(@ModelAttribute("group") GroupModel group){

        gameClubService.createJoinRequest(userName, group.getId());

        return "redirect:/user/groups";

    }

    @PostMapping("/user/groups/{groupId}")
    public String addPlayerToEvent(@PathVariable Long groupId, @ModelAttribute("event") EventModel event){
        gameClubService.attendEvent(event.getId(),userName);

        return "redirect:/user/groups/"+groupId;
    }

    @PostMapping("/user/mygroup")
    public String acceptJoinRequest(@ModelAttribute("joinRequest") JoinRequestModel joinRequest){

        gameClubService.decideJoinRequest(joinRequest.getUserName(), joinRequest.getGroupId(), joinRequest.getDecision());

        return "redirect:/user/mygroup";
    }

}
