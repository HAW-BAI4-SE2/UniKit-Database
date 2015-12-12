package net.unikit.database.implementations;

import net.unikit.database.interfaces.entities.AbstractEntity;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Created by Andreas on 12.12.2015.
 */
abstract class AbstractEntityImpl {
    static class IDImpl<T extends Serializable> implements AbstractEntity.ID<T> {
        private T value;

        public IDImpl(T value) {
            this.value = value;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IDImpl)) return false;

            IDImpl<?> id = (IDImpl<?>) o;

            return !(getValue() != null ? !getValue().equals(id.getValue()) : id.getValue() != null);

        }

        @Override
        public int hashCode() {
            return getValue() != null ? getValue().hashCode() : 0;
        }

        @Override
        public String toString() {
            String packageName = AbstractEntity.class.getCanonicalName();
            packageName = packageName.replaceFirst(Pattern.quote(".AbstractEntity"), "");

            String className = (this.getClass().getInterfaces()[0]).getCanonicalName();
            className = className.replaceFirst(Pattern.quote(packageName + "."), "");

            return className + "{" +
                    "value=" + value +
                    '}';
        }
    }
}
