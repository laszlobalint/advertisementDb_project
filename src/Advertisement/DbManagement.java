package Advertisement;

import java.io.*;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

import static Advertisement.Users.details;

public class DbManagement {
    static NavigableMap <Integer, Users> users = new TreeMap <>();
    static Users activeUser = new Users();

    public static boolean loadUsers() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./adsUsers.txt"));
            String line;
            line = null;
            while ((line = reader.readLine()) != null) {
                details = line.split(";");
                Users newUser = new Users(Integer.parseInt(details[0]), details[1], details[2], details[3], details[4], details[5], details[6]);
                users.put(newUser.getId(), newUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean loginUser() {
        System.out.println("\n Login menu");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String usernameLogin = input.next();
        System.out.println("Enter your password: ");
        String passwordLogin = input.next();
        for (Users hm : users.values()) {
            String userUn = hm.getUsername();
            String userPw = hm.getPassword();
            if (userUn.equals(usernameLogin) && userPw.equals(passwordLogin) && !activeUser.isIsLoggedIn()) {
                activeUser.setId(hm.getId());
                activeUser.setName(hm.getName());
                activeUser.setUsername(hm.getUsername());
                activeUser.setPassword(hm.getPassword());
                activeUser.setDateOfBirth(hm.getDateOfBirth());
                activeUser.setPhone(hm.getPhone());
                activeUser.setEmail(hm.getEmail());
                activeUser.setIsLoggedIn(true);
                System.out.println("\n" + activeUser.toString());
                System.out.println("\nDear " + activeUser.getName() + "! You are logged in now!");
                break;
            }
        }
        if (!activeUser.isIsLoggedIn()) {
            System.err.println("Wrong username or password!");
        }
        return true;
    }

    public static boolean logoutUser() {
        System.out.println("\nLogout menu");
        Scanner input = new Scanner(System.in);
        String answer;
        System.out.println("Do you really want to logout? (Y / N): ");
        answer = input.nextLine().trim().toLowerCase();
        switch (answer) {
            case "y":
                activeUser.setIsLoggedIn(false);
                break;
            case "n":
                activeUser.setIsLoggedIn(true);
                break;
            default:
                System.out.println("Please, answer 'Y' or 'N'. ");
                break;
        }
        return true;
    }

    public static boolean addUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("\tUser registration");

        System.out.println("Enter your e-mail address: ");
        while (!input.hasNext("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            System.out.println("That's not a regular e-mail address!");
            input.nextLine();
        }
        String email = input.nextLine();

        System.out.println("Enter your phone number: ");
        while (!input.hasNext("[0-9\\-]*")) {
            System.out.println("That's not a regular phone number!");
            input.nextLine();
        }
        String phone = input.nextLine();

        System.out.println("Enter your first and last name: ");
        while (!input.hasNext("(^[A-Z][,.]?[ ]?\\w+|[A-Z]+['-]?\\w+)")) {
            System.out.println("That's not a regular first and/or last name!");
            input.nextLine();
        }
        String name = input.nextLine();

        System.out.println("Enter your username: ");
        while (!input.hasNext("[a-z0-9_]+")) {
            System.out.println("Cannot use irregular characters in the username!");
            input.nextLine();
        }
        String username = input.nextLine();

        System.out.println("Enter your password: ");
        while (!input.hasNext("([a-zA-Z0-9])\\w+")) {
            System.out.println("Password can contain just number, lower and uppercase fonts!");
            input.nextLine();
        }
        String password = input.nextLine();

        System.out.println("Enter your date of birth using numbers (yyyy-MM-dd): ");
        while (!input.hasNext("\\d{4}.[01]\\d.[0-3]\\d")) {
            System.out.println("Irregular date format. Try again!");
            input.nextLine();
        }
        String date = input.next();

        int lastId = 0;
        for (Integer id : users.keySet()) {
            if (id > lastId) {
                lastId = id;
            }
        }

        Users newUser = new Users(lastId + 1, name, username, password, date, phone, email);
        users.put(newUser.getId(), newUser);
        System.out.println("You registered successfully!" + '\n' + newUser.toString());
        return true;
    }

    public static boolean editUser() {
        System.out.println("\nYou can change your profile here: ");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your e-mail address: ");
        while (!input.hasNext("^(.+)@(.+)$")) {
            System.out.println("That's not a regular e-mail address!");
            input.next();
        }
        String email = input.next();
        activeUser.setEmail(email);

        System.out.println("Enter your phone number: ");
        while (!input.hasNext("[0-9\\-]*")) {
            System.out.println("That's not a regular phone number!");
            input.next();
        }
        String phone = input.next();
        activeUser.setPhone(phone);

        System.out.println("Enter your first and last name: ");
        while (!input.hasNext("(^[A-Z][,.]?[ ]?\\w+|[A-Z]+['-]?\\w+)")) {
            System.out.println("That's not a regular first and/or last name!");
            input.next();
        }
        String name = input.next();
        activeUser.setName(name);

        System.out.println("Enter your username: ");
        while (!input.hasNext("[a-z0-9_]+")) {
            System.out.println("Cannot use irregular characters in the username!");
            input.next();
        }
        String username = input.next();
        activeUser.setUsername(username);

        System.out.println("Enter your password: ");
        while (!input.hasNext("([a-zA-Z0-9])\\w+")) {
            System.out.println("Password can contain just number, lower and uppercase fonts!");
            input.next();
        }
        String password = input.next();
        activeUser.setPassword(password);

        System.out.println("Enter your date of birth using numbers (yyyy-MM-dd): ");
        while (!input.hasNext("\\d{4}.[01]\\d.[0-3]\\d")) {
            System.out.println("Irregular date format. Try again!");
            input.next();
        }
        String date = input.next();
        activeUser.setDateOfBirth(date);

        users.put(activeUser.getId(), activeUser);
        System.out.println("You updated your profile successfully!" + '\n' + activeUser.toString());
        return true;
    }

    public static boolean deleteUser() {
        BufferedReader reader = null;
        String line;
        System.out.println("\nYou can change your profile here: ");
        Scanner in = new Scanner(System.in);
        System.out.println("\nDear " + details[1] + "!");
        System.out.println("Do you really want to delete your profile? (Y / N): ");
        String answer;
        answer = in.nextLine().trim().toLowerCase();
        switch (answer) {
            case "y":
                try {
                    line = reader.readLine();
                    users.remove(activeUser.getId());
                    System.out.println("\nYou deleted this profile!");
                    Users.setIsLoggedIn(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "n":
                return false;
            default:
                System.out.println("Please, answer 'Y' or 'N'. ");
                break;
        }
        return true;
    }

    public static boolean writeToFileUsers() throws IOException {
        BufferedWriter bw = null;
        bw = new BufferedWriter(new FileWriter("./adsUsers.txt"));
        String content;
        for (Users uP : users.values()) {
            content = uP.getId() + ";" + uP.getName() + ";" + uP.getUsername() + ";" + uP.getPassword() + ";" + uP.getDateOfBirth() + ";" + uP.getPhone() + ";" + uP.getEmail() + "\n";
            bw.write(content);
        }
        bw.flush();
        bw.close();
        System.out.println("User database was saved to file!");

        BufferedWriter writeRent = null;
        writeRent = new BufferedWriter(new FileWriter("adsForRent.txt"));
        for (ForRent fR : ForRent.getRentAds().values()) {
            content = fR.getId() + ";" + fR.getUserId() + ";" + fR.getText() + ";" + fR.getCounty() + ";" + fR.getCautionMonths() + ";" + fR.getMonthlyRent() + ";" + fR.getCurrentExpenses() + ";" + fR.isSmoking() + ";" + fR.isForStudents() + ";" + fR.getCanBeMoved() + "\n";
            writeRent.write(content);
        }
        writeRent.flush();
        writeRent.close();
        System.out.println("For rent advertisements were saved to file!");

        return true;
    }

    public static Map <Integer, Users> getUsers() {
        return users;
    }

    public static void setUsers(Map <Integer, Users> users) {
        DbManagement.users = (NavigableMap <Integer, Users>) users;
    }

    public static Users getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(Users activeUser) {
        DbManagement.activeUser = activeUser;
    }
}
