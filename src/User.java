/**
 * Created by ilyav on 21.01.2017.
 */
public class User {
    private String firstName;
    private String secondName;
    private int age;
    private String email;
    private long userId;
    private static long count = 0;


    public User(String firstName, String secondName, int age, String email) throws Exception {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;

        if (firstName == null || firstName.isEmpty() || secondName == null || secondName.isEmpty() || email == null || email.isEmpty()){
            throw new Exception("First name, Last name and email should be filled");
        }

        this.userId = count+1;
        User.count ++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(user.email);

    }

    @Override
    public int hashCode() {
        return email.hashCode();
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

    public long getUserId() {
        return userId;
    }

    public static long getCount() {
        return count;
    }
}
