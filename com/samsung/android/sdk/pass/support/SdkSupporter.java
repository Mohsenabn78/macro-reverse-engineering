package com.samsung.android.sdk.pass.support;

import android.util.Log;
import com.samsung.android.sdk.pass.SpassFingerprint;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class SdkSupporter {
    public static final String CLASSNAME_FINGERPRINT_MANAGER = "com.samsung.android.fingerprint.FingerprintManager";

    public static boolean copyStaticFields(Object obj, Class cls, String str, String str2) {
        Field[] fields;
        Field field;
        try {
            Field[] fields2 = Class.forName(str).getFields();
            HashMap hashMap = new HashMap();
            for (Field field2 : fields2) {
                hashMap.put(field2.getName(), field2);
            }
            for (Field field3 : cls.getFields()) {
                String name = field3.getName();
                if ((str2 == null || name.startsWith(str2)) && (field = (Field) hashMap.get(name)) != null && field.getType().equals(field3.getType())) {
                    field3.set(obj, field.get(null));
                }
            }
            return true;
        } catch (Exception e4) {
            Log.w(SpassFingerprint.TAG, "copyFields: failed - " + e4);
            return true;
        }
    }
}
