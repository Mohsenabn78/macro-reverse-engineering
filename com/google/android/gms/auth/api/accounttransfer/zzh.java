package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;

/* loaded from: classes4.dex */
final class zzh extends AccountTransferClient.zza<DeviceMetaData> {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzg f19653b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(zzg zzgVar, AccountTransferClient.zzb zzbVar) {
        super(zzbVar);
        this.f19653b = zzgVar;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zza(DeviceMetaData deviceMetaData) {
        this.f19653b.setResult(deviceMetaData);
    }
}
