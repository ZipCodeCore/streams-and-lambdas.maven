package com.zipcodewilmington.streams.tools;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by leon on 5/19/17.
 */
public class ReflectionUtils {
    public static HashMap<Field, String> getFieldMap(Object object) {
        HashMap hm = new HashMap() {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                Iterator it = this.entrySet().iterator();

                for (int i = 0; it.hasNext(); i++) {
                    Entry pair = (Entry) it.next();
                    sb
                            .append("\n" + StringUtils.repeatString(150, "-"))
                            .append(String.format("\nEntry number:\t\t%s", i))
                            .append(String.format("\nKey:\t\t\t\t%s", pair.getKey()))
                            .append(String.format("\nValue:\t\t\t\t%s", pair.getValue()));
                    it.remove(); // prevents ConcurrentModificationException
                }
                return sb.toString();
            }
        };
        for (Field f : object.getClass().getDeclaredFields()) {
            try {
                boolean defaultAccess = f.isAccessible();

                // attempt to modify visibility
                f.setAccessible(true);
                hm.put(f, f.get(object).toString());
                f.setAccessible(defaultAccess);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
                hm.put(f, null);
            }

        }
        return hm;
    }
}
