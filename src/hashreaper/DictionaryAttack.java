package hashreaper;

import java.util.List;

public class DictionaryAttack {
    private final Hasher hasher;

    public DictionaryAttack(Hasher hasher){
        this.hasher = hasher;
    }

    public String crack(String targetHash, List<String> candidates){
        for (String candidate : candidates) {
            if (hasher.hash(candidate).equalsIgnoreCase(targetHash)){
                return candidate;
            }
        }
        return null;
    }
}
