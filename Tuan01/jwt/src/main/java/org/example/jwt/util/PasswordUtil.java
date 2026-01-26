package org.example.jwt.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encode(String raw) {
        return encoder.encode(raw);
    }

    public static boolean match(String raw, String encoded) {
        return encoder.matches(raw, encoded);
    }
}
