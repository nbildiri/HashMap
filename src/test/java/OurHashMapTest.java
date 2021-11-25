import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {

    @Test
    void getNull() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when

        // then
        assertNull(map.get("ENGLISH1"));
    }

    @Test
    void put() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("ENGLISH2", "HI");
        map.put("ENGLISH3", "HEY");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("RUSSIAN", "PRIVIT");
        map.put("JAPANESE", "NE HOW");
        map.put("MANDARIN", "CONICHIWA");

        // then
        assertEquals("HELLO", map.get("ENGLISH1"));
        assertEquals("HI", map.get("ENGLISH2"));
        assertEquals("HEY", map.get("ENGLISH3"));
        assertEquals("HOLA", map.get("SPANISH"));
        assertEquals("SHALOM", map.get("HEBREW"));
        assertEquals("BONJOUR", map.get("FRENCH"));
        assertEquals("PRIVIT", map.get("RUSSIAN"));
        assertEquals("NE HOW", map.get("JAPANESE"));
        assertEquals("CONICHIWA", map.get("MANDARIN"));
    }

    @Test
    void putSameKeys() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("ENGLISH1", "HI");

        // then
        assertEquals("HI", map.get("ENGLISH1"));
    }

    @Test
    void size() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");


        // then
        assertEquals(4, map.size());

    }

    @Test
    void isEmptyFalse() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");


        // then
        assertFalse(map.isEmpty());

    }

    @Test
    void isEmpty() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // then
        assertTrue(map.isEmpty());

    }

    @Test
    void containsKey() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");


        // then
        assertTrue(map.containsKey("ENGLISH1"));
    }

    @Test
    void containsKeyFalse() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");


        // then
        assertFalse(map.containsKey("ENGLISH123"));
    }

    @Test
    void containsValue() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");


        // then
        assertTrue(map.containsValue("HELLO"));
    }

    @Test
    void containsValueFalse() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");


        // then
        assertFalse(map.containsValue("HELLO123"));
    }


    @Test
    void remove() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");


        // then
        assertEquals("HELLO", map.remove("ENGLISH1"));
        assertFalse(map.containsKey("ENGLISH1"));
        assertFalse(map.containsValue("HELLO"));
        assertEquals(3, map.size());
    }


    @Test
    void putAll() {
        // given
        HashMap<String, String> m = new HashMap<>();
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        m.put("ENGLISH1", "HELLO");
        m.put("SPANISH", "HOLA");
        m.put("HEBREW", "SHALOM");
        m.put("FRENCH", "BONJOUR");

        map.putAll(m);


        // then
        assertEquals(4, map.size());
        assertTrue(m.containsKey("ENGLISH1"));
    }

    @Test
    void clear() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");

        map.clear();

        // then
        assertEquals(0, map.size());
        assertFalse(map.containsValue("HELLO"));
    }


    @Test
    void keySet() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();
        Set set = new HashSet();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");

        set = map.keySet();

        // then
        assertEquals(4, set.size());
        assertTrue(set.contains("ENGLISH1"));
        assertFalse(set.contains("HELLO"));
    }

    @Test
    void values() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();
        Collection collection = new ArrayList();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");

        collection = map.values();

        // then
        assertEquals(4, collection.size());
        assertTrue(collection.contains("HELLO"));
        assertFalse(collection.contains("ENGLISH1"));
    }

}



