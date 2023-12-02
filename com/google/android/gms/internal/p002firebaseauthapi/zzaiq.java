package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiq  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaiq {
    private static final zzaiq zza = new zzaiq();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzaiv zzb = new zzaia();

    private zzaiq() {
    }

    public static zzaiq zza() {
        return zza;
    }

    public final zzaiu zzb(Class cls) {
        zzahj.zzc(cls, "messageType");
        zzaiu zzaiuVar = (zzaiu) this.zzc.get(cls);
        if (zzaiuVar == null) {
            zzaiuVar = this.zzb.zza(cls);
            zzahj.zzc(cls, "messageType");
            zzaiu zzaiuVar2 = (zzaiu) this.zzc.putIfAbsent(cls, zzaiuVar);
            if (zzaiuVar2 != null) {
                return zzaiuVar2;
            }
        }
        return zzaiuVar;
    }
}
