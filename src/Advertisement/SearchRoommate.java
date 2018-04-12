package Advertisement;

import java.util.Map;
import java.util.TreeMap;

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
    protected String canBeMoved;

    static Map<Integer, SearchRoommate> mateAds = new TreeMap <>();

    public SearchRoommate(int userId, String text, String county, int cautionMonths, boolean isSmoking, boolean isForStudents, int currentInmate, boolean isMan, String canBeMoved) {
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
        return "\nSearching for roommate: " + '\n' +
                "\nText of advertisement: " + text + '\n' +
                "County: " + county + '\n' +
                "Months of caution: " + cautionMonths + '\n' +
                "Smoking allowed: " + (isSmoking ? " yes" : " no") + '\n' +
                "Available for students: " + (isForStudents ? " yes" : " no") + '\n' +
                "Current number of inmates: " + currentInmate + '\n' +
                "Looking for: " + (isMan ? " man" : " woman") + '\n' +
                "Earliest date of moving in: " + canBeMoved + '\n';
    }
}
