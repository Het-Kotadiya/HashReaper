package hashreaper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; // built-in hashing engine
import java.security.NoSuchAlgorithmException;

public class Hasher {
    private final String algorithm; // Hashing algorithms such as SHA-1, SHA-256 and MD5

    public Hasher(String algorithm){
        this.algorithm = algorithm;
    }

    public String hash(String input){
        try{
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return toHex(digest);
        } catch (NoSuchAlgorithmException e){
            throw new IllegalArgumentException("Unknown Algorithm: " + algorithm, e);
        }
    }

    private static String toHex(byte[] bytes){
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b: bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
