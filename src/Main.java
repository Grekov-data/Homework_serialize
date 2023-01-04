import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Saction = new Scanner(System.in);
        Scanner S1 = new Scanner(System.in);
        Scanner S2 = new Scanner(System.in);
        String nickname, password;
        RegistrationSystem registrationSystem = new RegistrationSystem();

        List <User> users = new ArrayList<>();

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("users.bin"))){
            users = (List<User>)objectInputStream.readObject();

        }
        catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        registrationSystem.setUsers(users);

        System.out.println("\nДобро пожаловать в систему регистрации пользователей!");
        while(true) {
            System.out.println("Вы можете...\n" +
                    "1. Авторизироваться;\n" +
                    "2. Зарегистрироваться;\n" +
                    "3.Завершить сеанс (выйти).");
            System.out.print("Введите номер(№) необходимой операции: ");
            int action = Saction.nextInt();
            //АВТОРИЗАЦИЯ
            if (action == 1) {
                System.out.println("Введите логин и пароль для входа в систему:");
                System.out.print("логин: ");
                nickname=S1.nextLine();
                System.out.print("пароль: ");
                password=S1.nextLine();
                if (registrationSystem.login(nickname, password) != null)
                    System.out.println("Вы успешно авторизованы");
                if (registrationSystem.login(nickname, password) == null)
                    System.out.println("Неверный логин или пароль");
            }


            //РЕГИСТРАЦИЯ
            if (action == 2) {
                System.out.println("Введите логин и пароль для регистрации нового пользователя:");
                System.out.print("логин: ");
                nickname=S2.nextLine();
                System.out.print("пароль: ");
                password=S2.nextLine();

                if (registrationSystem.register(nickname, password))
                    System.out.println("Такой пользователь уже существует");
                else {
                    users.add(new User(nickname, password));
                    System.out.println("Вы успешно зарегистрировались!");
                }
            }


            //ВЫХОД ИЗ ПРОГРАММЫ
            if (action == 3)
                break;
        }
        registrationSystem.saveData(users);
    }
}

