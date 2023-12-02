package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzct  reason: invalid package */
/* loaded from: classes4.dex */
final class zzct {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zztu zza(zztp zztpVar) {
        zztr zza2 = zztu.zza();
        zza2.zzb(zztpVar.zzb());
        for (zzto zztoVar : zztpVar.zzh()) {
            zzts zzb = zztt.zzb();
            zzb.zzc(zztoVar.zzb().zzf());
            zzb.zzd(zztoVar.zzk());
            zzb.zzb(zztoVar.zze());
            zzb.zza(zztoVar.zza());
            zza2.zza((zztt) zzb.zzi());
        }
        return (zztu) zza2.zzi();
    }
}
