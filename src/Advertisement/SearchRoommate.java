package Advertisement;

import java.util.Date;

public class SearchRoommate {
    static int id = 0;
    protected int userId;
    protected String text;
    protected String county;
    protected int cautionMonths;
    protected boolean isSmoking;
    protected boolean isForStudents;
    protected int currentInmate;
    protected boolean isMan;
    protected Date canBeMoved;

    public SearchRoommate(int userId, String text, String county, int cautionMonths, boolean isSmoking, boolean isForStudents, int currentInmate, boolean isMan, Date canBeMoved) {
        id++;
        this.userId = userId;
        this.text = text;
        this.county = county;
        this.cautionMonths = cautionMonths;
        this.isSmoking = isSmoking;
        this.isForStudents = isForStudents;
        this.currentInmate = currentInmate;
        this.isMan = isMan;
        this.canBeMoved = canBeMoved;
    }

    @Override
    public String toString() {
        return "Searching for roommate: " + '\n' +
                "Text of advertisement: " + text + '\n' +
                "County: " + county + '\n' +
                "Months of caution: " + cautionMonths + '\n' +
                "Smoking allowed: " + (isSmoking ? " yes" : " no") + '\n' +
                "Available for students: " + (isForStudents ? " yes" : " no") + '\n' +
                "Current number of inmates: " + currentInmate + '\n' +
                "Looking for: " + (isMan ? " man" : " woman") + '\n' +
                "Earliest date of moving in: " + canBeMoved + '\n';
    }
}
