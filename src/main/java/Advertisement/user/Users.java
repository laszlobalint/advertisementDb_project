package Advertisement.user;

import Advertisement.extra.Encryption;

public class Users {

    private Encryption encryption = new Encryption();

    private static boolean isLoggedIn = false;
    private int id;
    private String name;
    private String username;
    private String password;
    private String dateOfBirth;
    private String phone;
    private String email;
    public static String[] details;

    public Users(int id, String name, String username, String password, String dateOfBirth, String phone, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.details = details;
    }

    public Users() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public boolean isIsLoggedIn() { return isLoggedIn; }

    public void setIsLoggedIn(boolean isLoggedIn) { Users.isLoggedIn = isLoggedIn; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "\nUser details: " + '\n' +
                "\nUser ID: " + id + '\n' +
                "Name: " + name + '\n' +
                "Username: " + username + '\n' +
                "Password: " + encryption.encrypt(password) + '\n' +
                "Date of Birth: " + dateOfBirth + '\n' +
                "Phone number: " + phone + '\n' +
                "E-mail address: " + email + '\n';
    }
}
