import java.util.*;

public class OurHashMap<K, V> implements Map<K, V> {

    private final int SIZE = 16;

    class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    List<Entry> values[] = new List[SIZE];

    @Override
    public int size() {
        int size = 0;
        for (List<Entry> value : values) {
            if (value != null) {
                for (Entry entry : value) {
                    size++;
                }
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (List<Entry> value : values) {
            if (value != null) {
                for (Entry entry : value) {
                    if (entry.key == key) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<Entry> val : values) {
            if (val != null) {
                for (Entry entry : val) {
                    if (entry.value == value) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List<Entry> list = values[index];
        if (list == null) {
            return null;
        }
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return (V) entry.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode();
        int index = Math.abs(hashcode) % SIZE;
        List list = values[index];
        if (list == null) {
            list = new ArrayList<Entry>();
            values[index] = list;
        }

        for (Entry<K, V> entry : (List<Entry<K, V>>) list) {
            if (entry.key.equals(key)) {
                V saved = entry.value;
                entry.value = value;
                return saved;
            }
        }

        Entry entry = new Entry(key, value);
        list.add(entry);

        return null;
    }

    @Override
    public V remove(Object key) {
        V saved = null;
        for (List<Entry> val : values) {
            if (val != null) {
                for (Entry entry : val) {
                    if (entry.key == key) {
                        saved = (V) entry.value;
                        val.remove(entry);
                    }
                }
            }
        }
        return saved;
    }

    @Override
    public void putAll(Map m) {
        for (List<Entry> val : values) {
            if (val != null) {
                for (Entry entry : val) {
                    m.put(entry.key, entry.value);
                }
            }
        }
    }

    @Override
    public void clear() {
        values = new List[SIZE];
    }

    @Override
    public Set keySet() {
        Set set = new HashSet();
        for (List<Entry> val : values) {
            if (val != null) {
                for (Entry entry : val) {
                    set.add(entry.key);
                }
            }
        }
        return set;
    }

    @Override
    public Collection values() {
        Collection collection = new ArrayList();
        for (List<Entry> val : values) {
            if (val != null) {
                for (Entry entry : val) {
                    collection.add(entry.value);
                }
            }
        }
        return collection;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return null;
    }
}