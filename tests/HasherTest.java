import static org.junit.jupiter.api.Assertions.assertEquals;

import hashreaper.Hasher;
import org.junit.jupiter.api.Test;

public class HasherTest {
    @Test
    void md5OfPasswordMatchesKnownDigest(){
        assertEquals("5f4dcc3b5aa765d61d8327deb882cf99",
                new Hasher("MD5").hash("password"));
    }

    @Test
    void sha256OfEmptyStringMatchesKnownDigest() {
        assertEquals(
                "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
                new Hasher("SHA-256").hash(""));
    }
}
