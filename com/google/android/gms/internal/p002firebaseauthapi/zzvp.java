package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvp  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzvp {
    public static final zzvp zza = new zzvp(new zzvq());
    public static final zzvp zzb = new zzvp(new zzvu());
    public static final zzvp zzc = new zzvp(new zzvw());
    public static final zzvp zzd = new zzvp(new zzvv());
    public static final zzvp zze = new zzvp(new zzvr());
    public static final zzvp zzf = new zzvp(new zzvt());
    public static final zzvp zzg = new zzvp(new zzvs());
    private final zzvo zzh;

    public zzvp(zzvx zzvxVar) {
        if (zzhl.zzb()) {
            this.zzh = new zzvn(zzvxVar, null);
        } else if (zzwe.zza()) {
            this.zzh = new zzvj(zzvxVar, null);
        } else {
            this.zzh = new zzvl(zzvxVar, null);
        }
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }
}
