package net.unikit.database.test_utils;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface EntityValueMap /*extends Map<String, Object>*/ {
    Object get(Object key);
    Object put(String key, Object value);

    Set<String> keySet();
    Collection<Object> values();
    Set<Map.Entry<String, Object>> entrySet();

    void makeComplete();
    void makeImmutable();
}
