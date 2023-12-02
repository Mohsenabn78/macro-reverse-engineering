package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzrr extends zznq {
    final /* synthetic */ zzpl zza;
    final /* synthetic */ zzru zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrr(zzru zzruVar, zzpl zzplVar) {
        this.zzb = zzruVar;
        this.zza = zzplVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        UwbDevice createForAddress;
        zzru zzruVar = this.zzb;
        createForAddress = UwbDevice.createForAddress(this.zza.zza().zza().zzb());
        ((RangingSessionCallback) obj).onRangingInitialized(createForAddress);
    }
}
