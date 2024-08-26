package za.ac.cput.novacinemaapp.util;

import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(Object obj) {
        return obj == null || obj.toString().isEmpty() || obj == "";
    }

    public static Long generateId() {
        return UUID.randomUUID().toString();
    }
}
