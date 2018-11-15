package com.slin.authority.Utils;

import java.util.UUID;

public class IdUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
