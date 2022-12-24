
import java.math.BigInteger;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BigInteger m = new BigInteger("3215031751");
        System.out.println(rabinMiller(m, "3"));
    }

    public static Boolean rabinMiller(BigInteger n, String l) {
        int i = 0, t = 0, k = 0;

        if (n.compareTo(BigInteger.ONE) == 0) {
            return false;
        }
        if (n.compareTo(new BigInteger(l)) < 0) {
            return true;
        }
        BigInteger s = n.subtract(BigInteger.ONE);
        while ((s.mod(BigInteger.valueOf(2))).equals(BigInteger.valueOf(0))) {
            t++;
            s = s.divide(BigInteger.valueOf(2));
        }
        while (k < 9){
            BigInteger a = generateRandom(BigInteger.valueOf(2), n.subtract(BigInteger.valueOf(1)));
            BigInteger v = a.modPow(s, n);
            if (v.equals(BigInteger.valueOf(1))) {
                continue;
            }
            while (!v.equals(n.subtract(BigInteger.ONE))) {
                if (i == t) {
                    return false;
                } else {
                    v = v.modPow(BigInteger.valueOf(2), n);
                    i++;
                }
            }
            k = k + 2;
        }
        return true;
    }

    private static BigInteger generateRandom (BigInteger min, BigInteger max){
        Random rnd = new Random();
        BigInteger res;
        do {
            res = new BigInteger(max.bitLength(), rnd);
        } while (res.compareTo(min) < 0 || res.compareTo(max) > 0);
            return res;
        }

}

