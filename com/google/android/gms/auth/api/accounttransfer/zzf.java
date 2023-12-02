package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.auth.api.accounttransfer.AccountTransferClient;

/* loaded from: classes4.dex */
final class zzf extends AccountTransferClient.zza<byte[]> {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zze f19651b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(zze zzeVar, AccountTransferClient.zzb zzbVar) {
        super(zzbVar);
        this.f19651b = zzeVar;
    }

    @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
    public final void zza(byte[] bArr) {
        this.f19651b.setResult(bArr);
    }
}
