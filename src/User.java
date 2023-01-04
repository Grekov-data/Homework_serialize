import java.io.Serializable;

public class User implements Serializable {

    private String nickname;
    private String password;


    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;

    }

    public String getNickname() {return nickname;}

    public String getPassword() {return password;}


    public String toString() {
        return "\nпользователь:\n" +
                "логин: " + nickname +
                ", пароль: " + password;
    }
}
