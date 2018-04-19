package Advertisement;

public class Users {
    static boolean isLoggedIn = false;
    protected int id;
    protected String name;
    protected String username;
    protected String password;
    protected String dateOfBirth;
    protected String phone;
    protected String email;
    static String[] details;

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

    public static boolean isIsLoggedIn() { return isLoggedIn; }

    public static void setIsLoggedIn(boolean isLoggedIn) { Users.isLoggedIn = isLoggedIn; }

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
                "Password: " + Encryption.encrypt(password) + '\n' +
                "Date of Birth: " + dateOfBirth + '\n' +
                "Phone number: " + phone + '\n' +
                "E-mail address: " + email + '\n';
    }
}
