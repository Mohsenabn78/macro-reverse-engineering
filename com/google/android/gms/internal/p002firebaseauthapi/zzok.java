package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzok  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzok {
    private HashMap zza = new HashMap();

    public final zzom zza() {
        if (this.zza != null) {
            zzom zzomVar = new zzom(Collections.unmodifiableMap(this.zza), null);
            this.zza = null;
            return zzomVar;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
