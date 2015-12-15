package net.unikit.database.test_utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class EntityValueMapImpl implements EntityValueMap {
    private Map<String, Object> entityValueMap;
    private boolean complete;
    private boolean immutable;

    private EntityValueMapImpl() {
        entityValueMap = new HashMap<>();
        complete = false;
        immutable = false;
    }

    public static EntityValueMap create() {
        return new EntityValueMapImpl();
    }

    @Override
    public Object get(Object key) {
        return entityValueMap.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        if (immutable)
            throw new RuntimeException("entity value map '" + this + "' is immutable!");
        if (complete && !entityValueMap.containsKey(key))
            throw new RuntimeException("entity value map '" + this + "' does not contains key '" + key + "'!");

        return entityValueMap.put(key, value);
    }

    @Override
    public Set<String> keySet() {
        return entityValueMap.keySet();
    }

    @Override
    public Collection<Object> values() {
        return entityValueMap.values();
    }

    @Override
    public Set<Map.Entry<String, Object>> entrySet() {
        return entityValueMap.entrySet();
    }

    @Override
    public void makeComplete() {
        complete = true;
    }

    @Override
    public void makeImmutable() {
        immutable = true;
    }

    @Override
    public boolean equals(Object o) {
        return entityValueMap.equals(o);
    }

    @Override
    public int hashCode() {
        return entityValueMap.hashCode();
    }

    @Override
    public String toString() {
        return entityValueMap.toString();
    }
}
