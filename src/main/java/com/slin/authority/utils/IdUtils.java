package com.slin.authority.utils;

import java.util.UUID;

public class IdUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
