import java.util.HashSet;
import java.util.Set;


public class UserDao <T extends User> implements AbstactDao <User>{

    private Set <User> allRegisteredUsers = new HashSet<>();

    @Override
    public User save (User user) throws Exception {
        if (!allRegisteredUsers.add(user)) throw new Exception("User is already registered");
        else {
            allRegisteredUsers.add(user);
            user.setRegistered(true);
        }
        return  user;
    }

    @Override
    public User delete(User user) throws Exception {
        if(!allRegisteredUsers.remove(user)) throw new Exception("Failed to delete User");
        else {
            allRegisteredUsers.remove(user);
        }
        return user;
    }

    @Override
    public Set<User> getAll() {
        return allRegisteredUsers;
    }
}
