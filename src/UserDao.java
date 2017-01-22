import java.util.HashSet;
import java.util.Set;

/**
 * Created by ilyav on 22.01.2017.
 */
public class UserDao <T extends User> implements AbstactDao <T>{

    Set <User> allUsers = new HashSet<>();
    Set <User> allRegisteredUsers = new HashSet<>();


    public User registerUser (User user) throws Exception {
//        check if user is already created and added to general database
        if (!allUsers.stream().anyMatch(user1 -> user1.equals(user))) throw new Exception("User is not added to database");

//        check if user can be added to register list
        else if (!allRegisteredUsers.add(user)) throw new Exception("User is already registered");
        else allRegisteredUsers.add(user);
        return  user;
    }

    @Override
    public User save(User user) throws Exception {
//        check if user is in database already
        if(!allUsers.add(user)) throw new Exception("Failed to saved");
        else allUsers.add(user);
        return user;
    }

    @Override
    public User delete(User user) throws Exception {
        if(!allUsers.remove(user)) throw new Exception("Failed to delete User");
        else {
            allUsers.remove(user);
            allRegisteredUsers.remove(user);
        }
        return user;
    }
}
