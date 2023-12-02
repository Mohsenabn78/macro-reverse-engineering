package com.google.android.gms.internal.icing;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public enum zzft {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzcf.zzb),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    zzft(Object obj) {
        this.zzj = obj;
    }
}
