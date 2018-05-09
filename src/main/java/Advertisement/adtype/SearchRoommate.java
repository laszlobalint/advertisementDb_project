package Advertisement.adtype;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static Advertisement.user.DbManagement.activeUser;
import static Advertisement.user.Users.details;

public class SearchRoommate {
    private int id;
    private int userId;
    private String text;
    private String county;
    private int cautionMonths;
    private int monthlyRent;
    private boolean isSmoking;
    private boolean isForStudents;
    private int currentInmate;
    private boolean isMan;
    private String canBeMoved;

    public static Map <Integer, SearchRoommate> searchAds = new TreeMap <>();

    public SearchRoommate(int id, int userId, String text, String county, int cautionMonths, int monthlyRent, boolean isSmoking, boolean isForStudents, int currentInmate, boolean isMan, String canBeMoved) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.county = county;
        this.cautionMonths = cautionMonths;
        this.monthlyRent = monthlyRent;
        this.isSmoking = isSmoking;
        this.isForStudents = isForStudents;
        this.currentInmate = currentInmate;
        this.isMan = isMan;
        this.canBeMoved = canBeMoved;
    }

    public SearchRoommate() {
    }

    public boolean loadSearchMate() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("adsSearchMate.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                details = line.split(";");
                SearchRoommate newSearchMate = new SearchRoommate(Integer.parseInt(details[0]), Integer.parseInt(details[1]), details[2], details[3], Integer.parseInt(details[4]), Integer.parseInt(details[5]), Boolean.parseBoolean(details[6]), Boolean.parseBoolean(details[7]), Integer.parseInt(details[8]), Boolean.parseBoolean(details[9]), details[10]);
                searchAds.put(newSearchMate.getId(), newSearchMate);
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

    public boolean addSearchMate() {
        Scanner input = new Scanner(System.in);
        System.out.println("\tAdd new advertisement (looking for flatmate) ");

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

        System.out.println("How many monthly deposits are required: ");
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

        System.out.println("How many flatmates are already sharing the flat/house: ");
        while (!input.hasNext("\\d+")) {
            System.out.println("Give a regular number!");
            input.nextLine();
        }
        int currentInMate = Integer.parseInt(input.next());

        System.out.println("Are you looking for a male flatmate? (true or false) ");
        while (!input.hasNext("true|false")) {
            System.out.println("Choose 'true' or 'false'!");
            input.nextLine();
        }
        boolean isMan = Boolean.parseBoolean(input.next());

        System.out.println("Enter the earliest date of moving in (yyyy-MM-dd): ");
        while (!input.hasNext("\\d{4}.[01]\\d.[0-3]\\d")) {
            System.out.println("Irregular date format. Try again!");
            input.nextLine();
        }
        String moveIn = input.next();

        int lastId = 0;
        for (Integer id : searchAds.keySet()) {
            if (id > lastId) {
                lastId = id;
            }
        }

        SearchRoommate newSearch = new SearchRoommate(lastId + 1, activeUser.getId(), text, county, cautionMonths, monthlyRent, isSmoking, isStudent, currentInMate, isMan, moveIn);
        searchAds.put(activeUser.getId(), newSearch);
        System.out.println("You picked up an advertisement successfully! " + '\n' + newSearch.toString());
        return true;
    }

    public boolean editSearchMate() {
        Scanner input = new Scanner(System.in);
        System.out.println("\tYou can change your advertisement here ");
        System.out.println("Give an ID of your advertisement: ");
        while (!input.hasNext("\\d+")) {
            input.nextLine();
        }
        int idEdit = Integer.parseInt(input.next());
        for (SearchRoommate search : searchAds.values()) {
            if ((search.getUserId() == activeUser.getId()) && search.getId() == idEdit) {
                System.out.println(search.toString() + "\n");

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

                System.out.println("How many monthly deposits are required: ");
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

                System.out.println("How many flatmates are already sharing the flat/house: ");
                while (!input.hasNext("\\d+")) {
                    System.out.println("Give a regular number!");
                    input.nextLine();
                }
                int currentInMate = Integer.parseInt(input.next());

                System.out.println("Are you looking for a male flatmate? (true or false) ");
                while (!input.hasNext("true|false")) {
                    System.out.println("Choose 'true' or 'false'!");
                    input.nextLine();
                }
                boolean isMan = Boolean.parseBoolean(input.next());

                System.out.println("Enter the earliest date of moving in (yyyy-MM-dd): ");
                while (!input.hasNext("\\d{4}.[01]\\d.[0-3]\\d")) {
                    System.out.println("Irregular date format. Try again!");
                    input.nextLine();
                }
                String moveIn = input.next();

                int lastId = 0;
                for (Integer id : searchAds.keySet()) {
                    if (id > lastId) {
                        lastId = id;
                    }
                }
                SearchRoommate editSearch = new SearchRoommate(idEdit, activeUser.getId(), text, county, cautionMonths, monthlyRent, isSmoking, isStudent, currentInMate, isMan, moveIn);
                searchAds.replace(idEdit, editSearch);
                System.out.println("You changed an advertisement successfully!" + '\n' + editSearch.toString());
            }
        }
        return true;
    }

    public boolean deleteSearchMate() throws IOException {
        BufferedReader reader = null;
        String line;
        System.out.println("\nYou can delete your looking for flatmate advertisement here: ");
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
                for (SearchRoommate search: searchAds.values()) {
                    if ((search.getUserId() == activeUser.getId()) && search.getId() == idRemove) {
                        System.out.println(search.toString() + "\n");
                        searchAds.remove(idRemove);
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

    public int getMonthlyRent() { return monthlyRent; }

    public void setMonthlyRent(int monthlyRent) { this.monthlyRent = monthlyRent; }

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

    public int getCurrentInmate() {
        return currentInmate;
    }

    public void setCurrentInmate(int currentInmate) {
        this.currentInmate = currentInmate;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public String getCanBeMoved() {
        return canBeMoved;
    }

    public void setCanBeMoved(String canBeMoved) {
        this.canBeMoved = canBeMoved;
    }

    public static Map <Integer, SearchRoommate> getMateAds() {
        return searchAds;
    }

    public static void setMateAds(Map <Integer, SearchRoommate> searchAds) {
        SearchRoommate.searchAds = searchAds;
    }

    @Override
    public String toString() {
        return "\nLooking for flatmate: " + '\n' +
                "\nDescription of the advertisement: " + text + '\n' +
                "County: " + county + '\n' +
                "Months of deposit: " + cautionMonths + '\n' +
                "Smoking allowed: " + (isSmoking ? " yes" : " no") + '\n' +
                "Available for students: " + (isForStudents ? " yes" : " no") + '\n' +
                "Current number of flatmates: " + currentInmate + '\n' +
                "Looking for flatmate: " + (isMan ? " man" : " woman") + '\n' +
                "Earliest date of moving in: " + canBeMoved + '\n';
    }
}
