package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfpn extends zzfps {
    final /* synthetic */ zzfpo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfpn(zzfpo zzfpoVar, zzfpu zzfpuVar, CharSequence charSequence) {
        super(zzfpuVar, charSequence);
        this.zza = zzfpoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfps
    final int zzc(int i4) {
        return i4 + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzfps
    final int zzd(int i4) {
        zzfos zzfosVar = this.zza.zza;
        CharSequence charSequence = ((zzfps) this).zzb;
        int length = charSequence.length();
        zzfph.zzb(i4, length, FirebaseAnalytics.Param.INDEX);
        while (i4 < length) {
            if (!zzfosVar.zzb(charSequence.charAt(i4))) {
                i4++;
            } else {
                return i4;
            }
        }
        return -1;
    }
}
