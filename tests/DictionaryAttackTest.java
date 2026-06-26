import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import hashreaper.Hasher;
import hashreaper.DictionaryAttack;

public class DictionaryAttackTest {
    @Test
    void findsPasswordWhenPresentInWordlist() {
        Hasher hasher = new Hasher("MD5");
        String target = hasher.hash("letmein");
        assertEquals("letmein", new DictionaryAttack(hasher)
                .crack(target, List.of("admin", "letmein", "root")));
    }

    @Test
    void returnsNullWhenPasswordNotInWordlist() {
        Hasher hasher = new Hasher("MD5");
        String target = hasher.hash("s3cr3t");
        assertNull(new DictionaryAttack(hasher)
                .crack(target, List.of("admin", "letmein", "root")));
    }
}
