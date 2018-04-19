package Advertisement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static Advertisement.DbManagement.activeUser;
import static Advertisement.Users.details;

public class ForRent {

    static Map <Integer, ForRent> rentAds = new TreeMap <>();

    protected int id;
    protected int userId;
    protected String text;
    protected String county;
    protected int cautionMonths;
    protected int monthlyRent;
    protected int currentExpenses;
    protected boolean isSmoking;
    protected boolean isForStudents;
    protected String canBeMoved;

    public ForRent(int id, int userId, String text, String county, int cautionMonths, int monthlyRent, int currentExpenses, boolean isSmoking, boolean isForStudents, String canBeMoved) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.county = county;
        this.cautionMonths = cautionMonths;
        this.monthlyRent = monthlyRent;
        this.currentExpenses = currentExpenses;
        this.isSmoking = isSmoking;
        this.isForStudents = isForStudents;
        this.canBeMoved = canBeMoved;
    }

    public static boolean loadForRent() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("adsForRent.txt"));
            String line;
            line = null;
            while ((line = reader.readLine()) != null) {
                details = line.split(";");
                ForRent newForRent = new ForRent(Integer.parseInt(details[0]), Integer.parseInt(details[1]), details[2], details[3], Integer.parseInt(details[4]), Integer.parseInt(details[5]), Integer.parseInt(details[6]), Boolean.parseBoolean(details[7]), Boolean.parseBoolean(details[8]), details[9]);
                rentAds.put(newForRent.getId(), newForRent);
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

    public static boolean addForRent() {
        Scanner input = new Scanner(System.in);
        System.out.println("\tAdd new advertisement (for rent)");

        System.out.println("Advertisement information: ");
        while (!input.hasNext("\\w+")) {
            System.out.println("Give a text description for your advertisement!");
            input.nextLine();
        }
        String text = input.nextLine();

        System.out.println("County of the estate: ");
        while (!input.hasNext("\\w+")) {
            System.out.println("Give the county of the estate!");
            input.nextLine();
        }
        String county = input.nextLine();

        System.out.println("How many deposits do you require: ");
        while (!input.hasNext("\\d")) {
            System.out.println("Give a regular number!");
            input.nextLine();
        }
        int cautionMonths = Integer.parseInt(input.next());

        System.out.println("Monthly rent in dollars: ");
        while (!input.hasNext("\\d+")) {
            System.out.println("Give a regular number!");
            input.nextLine();
        }
        int monthlyRent = Integer.parseInt(input.next());

        System.out.println("Current expenses (approximately) per month: ");
        while (!input.hasNext("\\d+")) {
            System.out.println("Give a regular number!");
            input.nextLine();
        }
        int currentExpenses = Integer.parseInt(input.next());

        System.out.println("Is smoking allowed? (true or false) ");
        while (!input.hasNext("true|false")) {
            System.out.println("Choose 'true' or 'false'!");
            input.nextLine();
        }
        boolean isSmoking = Boolean.parseBoolean(input.next());

        System.out.println("Is it available for students? (true or false) ");
        while (!input.hasNext("true|false")) {
            System.out.println("Choose 'true' or 'false'!");
            input.nextLine();
        }
        boolean isStudent = Boolean.parseBoolean(input.next());

        System.out.println("Enter the earliest date of moving in (yyyy-MM-dd): ");
        while (!input.hasNext("\\d{4}.[01]\\d.[0-3]\\d")) {
            System.out.println("Irregular date format. Try again!");
            input.nextLine();
        }
        String moveIn = input.next();

        int lastId = 0;
        for (Integer id : rentAds.keySet()) {
            if (id > lastId) {
                lastId = id;
            }
        }

        ForRent newRent = new ForRent(lastId + 1, activeUser.getId(), text, county, cautionMonths, monthlyRent, currentExpenses, isSmoking, isStudent, moveIn);
        rentAds.put(newRent.getId(), newRent);
        System.out.println("You picked up an advertisement successfully! " + '\n' + newRent.toString());
        return true;
    }

    public static boolean editForRent() {
        Scanner input = new Scanner(System.in);
        System.out.println("\tYou can change your advertisement here ");
        System.out.println("Give an ID of your advertisement: ");
        while (!input.hasNext("\\d+")) {
            input.nextLine();
        }
        int idEdit = Integer.parseInt(input.next());
        for (ForRent rent : rentAds.values()) {
            if ((rent.getUserId() == activeUser.getId()) && rent.getId() == idEdit) {
                System.out.println(rent.toString() + "\n");

                System.out.println("Advertisement information: ");

                while (!input.hasNext("\\w+")) {
                    System.out.println("Give a text description for your advertisement!");
                    input.nextLine();
                }
                String text = input.nextLine();

                System.out.println("County of the estate: ");
                while (!input.hasNext("\\w+")) {
                    System.out.println("Give the county of the estate!");
                    input.nextLine();
                }
                String county = input.nextLine();

                System.out.println("How many deposits do you require: ");
                while (!input.hasNext("\\d")) {
                    System.out.println("Give a regular number!");
                    input.nextLine();
                }
                int cautionMonths = Integer.parseInt(input.next());

                System.out.println("Monthly rent in dollars: ");
                while (!input.hasNext("\\d+")) {
                    System.out.println("Give a regular number!");
                    input.nextLine();
                }
                int monthlyRent = Integer.parseInt(input.nextLine());

                System.out.println("Current expenses (approximately) per month: ");
                while (!input.hasNext("\\d+")) {
                    System.out.println("Give a regular number!");
                    input.nextLine();
                }
                int currentExpenses = Integer.parseInt(input.nextLine());

                System.out.println("Is smoking allowed? (true or false) ");
                while (!input.hasNext("true|false")) {
                    System.out.println("Choose 'true' or 'false'!");
                    input.nextLine();
                }
                boolean isSmoking = Boolean.parseBoolean(input.nextLine());

                System.out.println("Is it available for students? (true or false) ");
                while (!input.hasNext("true|false")) {
                    System.out.println("Choose 'true' or 'false'!");
                    input.nextLine();
                }
                boolean isStudent = Boolean.parseBoolean(input.nextLine());

                System.out.println("Enter the earliest date of moving in (yyyy-MM-dd): ");
                while (!input.hasNext("\\d{4}.[01]\\d.[0-3]\\d")) {
                    System.out.println("Irregular date format. Try again!");
                    input.next();
                }
                String moveIn = input.next();

                int lastId = 0;
                for (Integer id : rentAds.keySet()) {
                    if (id > lastId) {
                        lastId = id;
                    }
                }
                ForRent editRent = new ForRent(idEdit, activeUser.getId(), text, county, cautionMonths, monthlyRent, currentExpenses, isSmoking, isStudent, moveIn);
                rentAds.replace(idEdit, editRent);
                System.out.println("You changed an advertisement successfully! " + '\n' + editRent.toString());
            }
        }
        return true;
    }

    public static boolean deleteForRent() throws IOException {
        BufferedReader reader = null;
        String line;
        System.out.println("\nYou can delete your for rent advertisement here: ");
        Scanner in = new Scanner(System.in);
        System.out.println("Give an ID of your advertisement: ");
        while (!in.hasNext("\\d+")) {
            in.nextLine();
        }
        int idRemove = Integer.parseInt(in.next());
        Scanner input = new Scanner(System.in);
        System.out.println("Do you really want to delete this advertisement? (Y / N): ");
        String answer = input.nextLine().trim().toLowerCase();
        switch (answer) {
            case "y":
                for (ForRent rent : rentAds.values()) {
                    if ((rent.getUserId() == activeUser.getId()) && rent.getId() == idRemove) {
                        System.out.println(rent.toString() + "\n");
                        rentAds.remove(idRemove);
                        System.out.println("\nYou deleted this advertisement!");
                    } else {
                        System.out.println("No such advertisement with the given ID!");
                    }
                    break;
                }
            case "n":
                return false;
            default:
                System.out.println("Please, answer 'Y' or 'N'. ");
                break;
        }
        return true;
    }

    public static Map <Integer, ForRent> getRentAds() {
        return rentAds;
    }

    public static void setRentAds(Map <Integer, ForRent> rentAds) {
        ForRent.rentAds = rentAds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getCautionMonths() {
        return cautionMonths;
    }

    public void setCautionMonths(int cautionMonths) {
        this.cautionMonths = cautionMonths;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getCurrentExpenses() {
        return currentExpenses;
    }

    public void setCurrentExpenses(int currentExpenses) {
        this.currentExpenses = currentExpenses;
    }

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public boolean isForStudents() {
        return isForStudents;
    }

    public void setForStudents(boolean forStudents) {
        isForStudents = forStudents;
    }

    public String getCanBeMoved() {
        return canBeMoved;
    }

    public void setCanBeMoved(String canBeMoved) {
        this.canBeMoved = canBeMoved;
    }

    @Override
    public String toString() {
        return "\nFlat/House for rent: " + '\n' +
                "\nText of advertisement: " + text + '\n' +
                "County: " + county + '\n' +
                "Months of caution: " + cautionMonths + '\n' +
                "Monthly rent ($/M): " + monthlyRent + '\n' +
                "Estimated current expenses ($/M): " + currentExpenses + '\n' +
                "Smoking allowed: " + (isSmoking ? " yes" : " no") + '\n' +
                "Available for students: " + (isForStudents ? " yes" : " no") + '\n' +
                "Earliest date of moving in: " + canBeMoved + '\n';
    }
}
