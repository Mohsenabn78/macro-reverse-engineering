package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmr  reason: invalid package */
/* loaded from: classes4.dex */
final class zzmr extends zzkl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmr(zzms zzmsVar, Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ zzaii zza(zzaii zzaiiVar) throws GeneralSecurityException {
        zzpa zzpaVar = (zzpa) zzaiiVar;
        zzow zzb = zzox.zzb();
        zzb.zzc(0);
        byte[] zzb2 = zzlx.zzb(zzpaVar.zza());
        zzb.zza(zzafy.zzn(zzb2, 0, zzb2.length));
        zzb.zzb(zzpaVar.zze());
        return (zzox) zzb.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* synthetic */ zzaii zzb(zzafy zzafyVar) throws zzahl {
        return zzpa.zzd(zzafyVar, zzagq.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzoz zzb = zzpa.zzb();
        zzb.zza(32);
        zzpc zzb2 = zzpd.zzb();
        zzb2.zza(16);
        zzb.zzb((zzpd) zzb2.zzi());
        hashMap.put("AES_CMAC", new zzkk((zzpa) zzb.zzi(), 1));
        zzoz zzb3 = zzpa.zzb();
        zzb3.zza(32);
        zzpc zzb4 = zzpd.zzb();
        zzb4.zza(16);
        zzb3.zzb((zzpd) zzb4.zzi());
        hashMap.put("AES256_CMAC", new zzkk((zzpa) zzb3.zzi(), 1));
        zzoz zzb5 = zzpa.zzb();
        zzb5.zza(32);
        zzpc zzb6 = zzpd.zzb();
        zzb6.zza(16);
        zzb5.zzb((zzpd) zzb6.zzi());
        hashMap.put("AES256_CMAC_RAW", new zzkk((zzpa) zzb5.zzi(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzkl
    public final /* bridge */ /* synthetic */ void zzd(zzaii zzaiiVar) throws GeneralSecurityException {
        zzpa zzpaVar = (zzpa) zzaiiVar;
        zzms.zzn(zzpaVar.zze());
        zzms.zzo(zzpaVar.zza());
    }
}
