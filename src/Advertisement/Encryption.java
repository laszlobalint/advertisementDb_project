package Advertisement;

public class Encryption {

    private static final int[] chain = {
            1941, 12394, 37913, 9023, 21111, 193, 459, 834
    };

    public static String encrypt(String key) {
        String result = "";
        int length = key.length();
        char ch;
        int ck = 0;
        for (int i = 0; i < length; i++) {
            if (ck >= chain.length - 1) {
                ck = 0;
            }
            ch = key.charAt(i);
            ch += chain[ck];
            result += ch;
            ck++;
        }
        return result;
    }

    public static String decrypt(String key) {
        String result = "";
        int length = key.length();
        char ch;
        int ck = 0;
        for (int i = 0; i < length; i++) {
            if (ck >= chain.length - 1) {
                ck = 0;
            }
            ch = key.charAt(i);
            ch -= chain[ck];
            result += ch;
            ck++;
        }
        return result;
    }
}
