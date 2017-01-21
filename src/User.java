/**
 * Created by ilyav on 21.01.2017.
 */
public class User {
    private String firstName;
    private String secondName;
    private int age;
    private boolean isRegistered;
    private int id;
    static int count = 0;

    public User(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.isRegistered = false;
        this.id = count+1;
        User.count ++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public int getId() {
        return id;
    }
}
