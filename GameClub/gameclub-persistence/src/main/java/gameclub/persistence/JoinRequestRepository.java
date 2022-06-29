/*package gameclub.persistence;

import gameclub.domain.JoinRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class JoinRequestRepository implements IJoinRequestRepository {
    List<JoinRequest> joinRequestList;
    DataStore dataStore;

    public JoinRequestRepository(DataStore dataStore){
        this.dataStore = dataStore;
        joinRequestList = this.dataStore.getInstance().getJoinRequestList();
    }

    @Override
    public List<JoinRequest> GetAll() {
        return joinRequestList;
    }

    @Override
    public void Create(JoinRequest entity) {
        joinRequestList.add(entity);
    }

    @Override
    public JoinRequest GetOne(Long id) {
        JoinRequest joinRequestToGet = new JoinRequest();

        try{
            joinRequestToGet = joinRequestList.stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("No such request exists");
        }

        return joinRequestToGet;
    }
}
*/