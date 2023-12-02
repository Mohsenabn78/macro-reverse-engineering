package com.google.android.gms.internal.nearby;

import android.annotation.SuppressLint;
import com.google.android.gms.nearby.uwb.RangingSessionCallback;
import com.google.android.gms.nearby.uwb.UwbDevice;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzrt extends zznq {
    final /* synthetic */ zzpp zza;
    final /* synthetic */ zzru zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrt(zzru zzruVar, zzpp zzppVar) {
        this.zzb = zzruVar;
        this.zza = zzppVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    @SuppressLint({"WrongConstant"})
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        UwbDevice createForAddress;
        zzru zzruVar = this.zzb;
        createForAddress = UwbDevice.createForAddress(this.zza.zzb().zza().zzb());
        ((RangingSessionCallback) obj).onRangingSuspended(createForAddress, this.zza.zza());
    }

    @Override // com.google.android.gms.internal.nearby.zznq, com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    @SuppressLint({"WrongConstant"})
    public final void onNotifyListenerFailed() {
        RangingSessionCallback rangingSessionCallback;
        UwbDevice createForAddress;
        rangingSessionCallback = this.zzb.zzc;
        createForAddress = UwbDevice.createForAddress(this.zza.zzb().zza().zzb());
        rangingSessionCallback.onRangingSuspended(createForAddress, this.zza.zza());
    }
}
