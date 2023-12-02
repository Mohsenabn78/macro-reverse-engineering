package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzt(zzu zzuVar, zzx zzxVar, CharSequence charSequence) {
        super(zzxVar, charSequence);
        this.zza = zzuVar;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzc(int i4) {
        return i4 + 1;
    }

    @Override // com.google.android.gms.internal.common.zzw
    final int zzd(int i4) {
        zzo zzoVar = this.zza.zza;
        CharSequence charSequence = ((zzw) this).zzb;
        int length = charSequence.length();
        zzs.zzb(i4, length, FirebaseAnalytics.Param.INDEX);
        while (i4 < length) {
            if (!zzoVar.zza(charSequence.charAt(i4))) {
                i4++;
            } else {
                return i4;
            }
        }
        return -1;
    }
}
