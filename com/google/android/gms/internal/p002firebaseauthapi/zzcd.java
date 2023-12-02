package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcd  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzcd {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzcc zza(String str) throws GeneralSecurityException {
        Iterator it = zza.iterator();
        while (it.hasNext()) {
            zzcc zzccVar = (zzcc) it.next();
            if (zzccVar.zzb(str)) {
                return zzccVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
