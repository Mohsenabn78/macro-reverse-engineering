package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcm  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzcm {
    private final ConcurrentMap zza;
    private final List zzb;
    private final zzci zzc;
    private final Class zzd;
    private final zzom zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcm(ConcurrentMap concurrentMap, List list, zzci zzciVar, zzom zzomVar, Class cls, zzcl zzclVar) {
        this.zza = concurrentMap;
        this.zzb = list;
        this.zzc = zzciVar;
        this.zzd = cls;
        this.zze = zzomVar;
    }

    @Nullable
    public final zzci zza() {
        return this.zzc;
    }

    public final zzom zzb() {
        return this.zze;
    }

    public final Class zzc() {
        return this.zzd;
    }

    public final Collection zzd() {
        return this.zza.values();
    }

    public final List zze(byte[] bArr) {
        List list = (List) this.zza.get(new zzck(bArr, null));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final boolean zzf() {
        if (!this.zze.zza().isEmpty()) {
            return true;
        }
        return false;
    }
}
