package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkm  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzkm {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public zzkm(Class cls, zzlm... zzlmVarArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 <= 0; i4++) {
            zzlm zzlmVar = zzlmVarArr[i4];
            if (!hashMap.containsKey(zzlmVar.zzb())) {
                hashMap.put(zzlmVar.zzb(), zzlmVar);
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzlmVar.zzb().getCanonicalName())));
            }
        }
        this.zzc = zzlmVarArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public zzkl zza() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zztb zzb();

    public abstract zzaii zzc(zzafy zzafyVar) throws zzahl;

    public abstract String zzd();

    public abstract void zze(zzaii zzaiiVar) throws GeneralSecurityException;

    public int zzf() {
        return 1;
    }

    public final Class zzj() {
        return this.zzc;
    }

    public final Class zzk() {
        return this.zza;
    }

    public final Object zzl(zzaii zzaiiVar, Class cls) throws GeneralSecurityException {
        zzlm zzlmVar = (zzlm) this.zzb.get(cls);
        if (zzlmVar != null) {
            return zzlmVar.zza(zzaiiVar);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException("Requested primitive class " + canonicalName + " not supported.");
    }

    public final Set zzm() {
        return this.zzb.keySet();
    }
}
