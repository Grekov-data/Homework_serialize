import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class RegistrationSystem {

    public static Object saveData;
    private String filename;
    private List <User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public User login (String nickname, String password){
        for (User user: users) {
            if (user.getNickname().equals(nickname) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public boolean register (String nickname, String password){
        for (User user: users) {
            if (user.getNickname().equals(nickname))
                return true;
        }
        return false;
    }

    public void saveData (List<User> users){
        String fileName = "users.bin";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))){

            objectOutputStream.writeObject(users);

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
