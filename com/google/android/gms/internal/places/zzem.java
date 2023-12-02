package com.google.android.gms.internal.places;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes4.dex */
public enum zzem {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzw.zzeg),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzjr;

    zzem(Object obj) {
        this.zzjr = obj;
    }
}
