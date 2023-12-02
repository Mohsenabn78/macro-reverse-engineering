package com.google.android.gms.maps.internal;

/* loaded from: classes4.dex */
public final class zza {
    public static Boolean zza(byte b4) {
        if (b4 != 0) {
            if (b4 != 1) {
                return null;
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static byte zza(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue() ? (byte) 1 : (byte) 0;
        }
        return (byte) -1;
    }
}
