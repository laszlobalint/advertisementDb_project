package Advertisement.extra;

public class Encryption {

    private final int[] chain = {
            1941, 12394, 37913, 9023, 21111, 193, 459, 834
    };

    public String encrypt(String key) {
        StringBuilder result = new StringBuilder();
        int length = key.length();
        char ch;
        int ck = 0;
        for (int i = 0; i < length; i++) {
            if (ck >= chain.length - 1) {
                ck = 0;
            }
            ch = key.charAt(i);
            ch += chain[ck];
            result.append(ch);
            ck++;
        }
        return result.toString();
    }

    public String decrypt(String key) {
        StringBuilder result = new StringBuilder();
        int length = key.length();
        char ch;
        int ck = 0;
        for (int i = 0; i < length; i++) {
            if (ck >= chain.length - 1) {
                ck = 0;
            }
            ch = key.charAt(i);
            ch -= chain[ck];
            result.append(ch);
            ck++;
        }
        return result.toString();
    }
}
