package Advertisement;

import java.util.Date;

public class ForRent {
    static int id = 0;
    protected int userId;
    protected String text;
    protected String county;
    protected int cautionMonths;
    protected int monthlyRent;
    protected int currentExpenses;
    protected boolean isSmoking;
    protected boolean isForStudents;
    protected Date canBeMoved;

    public ForRent(int userId, String text, String county, int cautionMonths, int monthlyRent, int currentExpenses, boolean isSmoking, boolean isForStudents, Date canBeMoved) {
        id++;
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

    @Override
    public String toString() {
        return "Flat/House for rent: " + '\n' +
                "Text of advertisement: " + text + '\n' +
                "County: " + county + '\n' +
                "Months of caution: " + cautionMonths + '\n' +
                "Monthly rent ($/M): " + monthlyRent + '\n' +
                "Estimated current expenses ($/M): " + currentExpenses + '\n' +
                "Smoking allowed: " + (isSmoking ? " yes" : " no") + '\n' +
                "Available for students: " + (isForStudents ? " yes" : " no") + '\n' +
                "Earliest date of moving in: " + canBeMoved + '\n';
    }
}
