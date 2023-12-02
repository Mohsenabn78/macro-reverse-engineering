package com.google.android.gms.internal.ads;

import com.google.android.gms.wearable.WearableStatusCodes;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfpp extends zzfps {
    final /* synthetic */ zzfpq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfpp(zzfpq zzfpqVar, zzfpu zzfpuVar, CharSequence charSequence) {
        super(zzfpuVar, charSequence);
        this.zza = zzfpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfps
    public final int zzd(int i4) {
        int length = ((zzfps) this).zzb.length();
        int i5 = i4 + WearableStatusCodes.TARGET_NODE_NOT_CONNECTED;
        if (i5 < length) {
            return i5;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzfps
    public final int zzc(int i4) {
        return i4;
    }
}
