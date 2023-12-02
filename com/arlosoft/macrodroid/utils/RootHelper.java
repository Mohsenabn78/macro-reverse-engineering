package com.arlosoft.macrodroid.utils;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RootHelper {
    public static int getIdForMethodInClass(String str, String str2) {
        Field[] declaredFields;
        try {
            Class<?>[] declaredClasses = Class.forName(str).getDeclaredClasses();
            int length = declaredClasses.length;
            for (int i4 = 0; i4 < length; i4++) {
                for (Field field : declaredClasses[i4].getDeclaredFields()) {
                    String name = field.getName();
                    if (name != null) {
                        if (name.equals("TRANSACTION_" + str2)) {
                            try {
                                field.setAccessible(true);
                                return field.getInt(field);
                            } catch (Exception unused) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return -1;
        } catch (Exception e4) {
            Log.e("++++++", "+++++++++++++++ " + e4.toString());
            return -1;
        }
    }
}
