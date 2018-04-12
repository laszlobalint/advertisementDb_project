package Advertisement;

import java.util.Map;
import java.util.TreeMap;

public class ForSell {
    static int id = 0;
    protected int userId;
    protected String text;
    protected String county;
    protected int wasBuilt;
    protected int price;
    protected boolean isMortgaged;
    protected String canBeMoved;

    static Map<Integer, ForSell> sellAds = new TreeMap <>();

    public ForSell(int userId, String text, String county, int wasBuilt, int price, boolean isMortgaged, String canBeMoved) {
        id++;
        this.userId = userId;
        this.text = text;
        this.county = county;
        this.wasBuilt = wasBuilt;
        this.price = price;
        this.isMortgaged = isMortgaged;
        this.canBeMoved = canBeMoved;
    }

    @Override
    public String toString() {
        return "Flat/House for sell: " + '\n' +
                "Text of advertisement: " + text + '\n' +
                "County: " + county + '\n' +
                "Estate was built in: " + wasBuilt + '\n' +
                "Normative price ($): " + price + '\n' +
                "Mortgage on the estate: " + (isMortgaged ? " yes" : " no") + '\n' +
                "Earliest date of moving in: " + canBeMoved + '\n';
    }
}
