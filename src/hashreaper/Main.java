package hashreaper;

import java.util.List;

public class Main {
    static void main() {
        Hasher hasher = new Hasher("MD5");
        String target = hasher.hash("password");

        List<String> candidates = List.of("123456", "admin", "password", "qwerty");

        String result = new DictionaryAttack(hasher).crack(target, candidates);

        if (result != null) {
            System.out.println("[+] Cracked! " + target + " -> " + result);
        } else {
            System.out.println("[-] No match found.");
        }
    }
}
