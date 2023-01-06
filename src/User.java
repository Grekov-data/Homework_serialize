import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String nickname;
    private String password;
    private Date registrationDate;


    public User(String nickname, String password, Date registrationDate) {
        this.nickname = nickname;
        this.password = password;
        this.registrationDate = registrationDate;

    }

    public String getNickname() {return nickname;}

    public String getPassword() {return password;}

    public Date getRegistrationDate() {return registrationDate;}

    public String toString() {
        return "\nпользователь:\n" +
                "логин: " + nickname +
                ", пароль: " + password +
                "\nДата регистрации: " + registrationDate;
    }
}
