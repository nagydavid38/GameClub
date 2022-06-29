/*package gameclub.persistence;

import gameclub.domain.Group;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class GroupRepository implements IGroupRepository{
    List<Group> groupList;

    DataStore dataStore;

    public GroupRepository(DataStore dataStore){
        this.dataStore = dataStore;
        groupList = this.dataStore.getInstance().getGroupList();
    }

    @Override
    public List<Group> GetAll() {
        return groupList;
    }

    @Override
    public void Create(Group entity) {
        groupList.add(entity);
    }

    @Override
    public Group GetOne(Long id) {
        Group groupToGet = new Group();
        try{
            groupToGet = groupList.stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("No such group exists");
        }

        return groupToGet;
    }

    @Override
    public Group GetOne(String groupName) {
        Group groupToGet = new Group();
        try{
            groupToGet = groupList.stream().filter(x -> x.getName().equals(groupName)).findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("No such group exists");
        }

        return groupToGet;
    }
}
*/