package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakf  reason: invalid package */
/* loaded from: classes4.dex */
public enum zzakf {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzafy.zzb),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzk;

    zzakf(Object obj) {
        this.zzk = obj;
    }
}
