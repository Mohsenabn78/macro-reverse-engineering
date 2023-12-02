package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzrs extends zznq {
    final /* synthetic */ zzpn zza;
    final /* synthetic */ zzru zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrs(zzru zzruVar, zzpn zzpnVar) {
        this.zzb = zzruVar;
        this.zza = zzpnVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        UwbDevice createForAddress;
        zzru zzruVar = this.zzb;
        createForAddress = UwbDevice.createForAddress(this.zza.zzb().zza().zzb());
        ((RangingSessionCallback) obj).onRangingResult(createForAddress, zzru.zzb(this.zzb, this.zza.zza()));
    }
}
