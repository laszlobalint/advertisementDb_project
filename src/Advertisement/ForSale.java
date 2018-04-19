package Advertisement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static Advertisement.DbManagement.activeUser;
import static Advertisement.Users.details;

public class ForSale {
    protected int id;
    protected int userId;
    protected String text;
    protected String county;
    protected int wasBuilt;
    protected int price;
    protected boolean isMortgaged;
    protected String canBeMoved;

    static Map <Integer, ForSale> saleAds = new TreeMap <>();

    public ForSale(int id, int userId, String text, String county, int wasBuilt, int price, boolean isMortgaged, String canBeMoved) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.county = county;
        this.wasBuilt = wasBuilt;
        this.price = price;
        this.isMortgaged = isMortgaged;
        this.canBeMoved = canBeMoved;
    }

    public static boolean loadForSale() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("adsForSale.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                details = line.split(";");
                ForSale newForSale = new ForSale(Integer.parseInt(details[0]), Integer.parseInt(details[1]), details[2], details[3], Integer.parseInt(details[4]), Integer.parseInt(details[5]), Boolean.parseBoolean(details[6]), details[7]);
                saleAds.put(newForSale.getId(), newForSale);
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

    public static boolean addForSale() {
        Scanner input = new Scanner(System.in);
        System.out.println("\tAdd new advertisement (for sale)");

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

        System.out.println("Year of building: ");
        while (!input.hasNext("\\d+")) {
            System.out.println("Give a regular number!");
            input.nextLine();
        }
        int wasBuilt = Integer.parseInt(input.next());

        System.out.println("Price of the estate: ");
        while (!input.hasNext("\\d+")) {
            System.out.println("Give a regular number!");
            input.nextLine();
        }
        int price = Integer.parseInt(input.next());

        System.out.println("Does the property come with a mortgage? (true or false) ");
        while (!input.hasNext("true|false")) {
            System.out.println("Choose 'true' or 'false'!");
            input.nextLine();
        }
        boolean isMortgaged = Boolean.parseBoolean(input.next());

        System.out.println("Enter the earliest date of moving in (yyyy-MM-dd): ");
        while (!input.hasNext("\\d{4}.[01]\\d.[0-3]\\d")) {
            System.out.println("Irregular date format. Try again!");
            input.nextLine();
        }
        String moveIn = input.next();

        int lastId = 0;
        for (Integer id : saleAds.keySet()) {
            if (id > lastId) {
                lastId = id;
            }
        }

        ForSale newSale = new ForSale(lastId + 1, activeUser.getId(), text, county, wasBuilt, price, isMortgaged, moveIn);
        saleAds.put(newSale.getId(), newSale);
        System.out.println("You picked up an advertisement successfully!" + '\n' + newSale.toString());
        return true;
    }

    public static boolean editForSale() {
        Scanner input = new Scanner(System.in);
        System.out.println("\tYou can change your advertisement here");
        System.out.println("Give an ID of your advertisement: ");
        while (!input.hasNext("\\d+")) {
            input.nextLine();
        }
        int idEdit = Integer.parseInt(input.next());
        for (ForSale sale : saleAds.values()) {
            if ((sale.getUserId() == activeUser.getId()) && sale.getId() == idEdit) {
                System.out.println(sale.toString() + "\n");

                System.out.println("Advertisement information:");

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

                System.out.println("Year of building: ");
                while (!input.hasNext("\\d+")) {
                    System.out.println("Give a regular number!");
                    input.nextLine();
                }
                int wasBuilt = Integer.parseInt(input.next());

                System.out.println("Price of the estate: ");
                while (!input.hasNext("\\d+")) {
                    System.out.println("Give a regular number!");
                    input.nextLine();
                }
                int price = Integer.parseInt(input.next());

                System.out.println("Does the property come with a mortgage? (true or false) ");
                while (!input.hasNext("true|false")) {
                    System.out.println("Choose 'true' or 'false'!");
                    input.nextLine();
                }
                boolean isMortgaged = Boolean.parseBoolean(input.next());

                System.out.println("Enter the earliest date of moving in (yyyy-MM-dd): ");
                while (!input.hasNext("\\d{4}.[01]\\d.[0-3]\\d")) {
                    System.out.println("Irregular date format. Try again!");
                    input.nextLine();
                }
                String moveIn = input.next();

                int lastId = 0;
                for (Integer id : saleAds.keySet()) {
                    if (id > lastId) {
                        lastId = id;
                    }
                }
                ForSale editSale = new ForSale(idEdit, activeUser.getId(), text, county, wasBuilt, price, isMortgaged, moveIn);
                saleAds.replace(idEdit, editSale);
                System.out.println("You changed an advertisement successfully!" + '\n' + editSale.toString());
            }
        }
        return true;
    }

    public static boolean deleteForSale() throws IOException {
        BufferedReader reader = null;
        String line;
        System.out.println("\nYou can delete your for sale advertisement here: ");
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
                for (ForSale sale : saleAds.values()) {
                    if ((sale.getUserId() == activeUser.getId()) && sale.getId() == idRemove) {
                        System.out.println(sale.toString() + "\n");
                        saleAds.remove(idRemove);
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

    public int getWasBuilt() {
        return wasBuilt;
    }

    public void setWasBuilt(int wasBuilt) {
        this.wasBuilt = wasBuilt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        isMortgaged = mortgaged;
    }

    public String getCanBeMoved() {
        return canBeMoved;
    }

    public void setCanBeMoved(String canBeMoved) {
        this.canBeMoved = canBeMoved;
    }

    public static Map <Integer, ForSale> getSaleAds() {
        return saleAds;
    }

    public static void setSaleAds(Map <Integer, ForSale> saleAds) {
        ForSale.saleAds = saleAds;
    }

    @Override
    public String toString() {
        return "\nFlat/House for sale: " + '\n' +
                "\nText of advertisement: " + text + '\n' +
                "County: " + county + '\n' +
                "Estate was built in: " + wasBuilt + '\n' +
                "Normative price ($): " + price + '\n' +
                "Mortgage on the estate: " + (isMortgaged ? " yes" : " no") + '\n' +
                "Earliest date of moving in: " + canBeMoved + '\n';
    }
}
