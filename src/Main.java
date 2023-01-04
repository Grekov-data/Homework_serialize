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

        System.out.println("\n����� ���������� � ������� ����������� �������������!");
        while(true) {
            System.out.println("�� ������...\n" +
                    "1. ����������������;\n" +
                    "2. ������������������;\n" +
                    "3.��������� ����� (�����).");
            System.out.print("������� �����(�) ����������� ��������: ");
            int action = Saction.nextInt();
            //�����������
            if (action == 1) {
                System.out.println("������� ����� � ������ ��� ����� � �������:");
                System.out.print("�����: ");
                nickname=S1.nextLine();
                System.out.print("������: ");
                password=S1.nextLine();
                if (registrationSystem.login(nickname, password) != null)
                    System.out.println("�� ������� ������������");
                if (registrationSystem.login(nickname, password) == null)
                    System.out.println("�������� ����� ��� ������");
            }


            //�����������
            if (action == 2) {
                System.out.println("������� ����� � ������ ��� ����������� ������ ������������:");
                System.out.print("�����: ");
                nickname=S2.nextLine();
                System.out.print("������: ");
                password=S2.nextLine();

                if (registrationSystem.register(nickname, password))
                    System.out.println("����� ������������ ��� ����������");
                else {
                    users.add(new User(nickname, password));
                    System.out.println("�� ������� ������������������!");
                }
            }


            //����� �� ���������
            if (action == 3)
                break;
        }
        registrationSystem.saveData(users);
    }
}

