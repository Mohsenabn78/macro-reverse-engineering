package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzflc {
    final /* synthetic */ zzfld zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzflc(zzfld zzfldVar, byte[] bArr, zzflb zzflbVar) {
        this.zza = zzfldVar;
        this.zzb = bArr;
    }

    public final zzflc zza(int i4) {
        this.zzd = i4;
        return this;
    }

    public final zzflc zzb(int i4) {
        this.zzc = i4;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzfld zzfldVar = this.zza;
            if (zzfldVar.zzb) {
                zzfldVar.zza.zzj(this.zzb);
                this.zza.zza.zzi(this.zzc);
                this.zza.zza.zzg(this.zzd);
                this.zza.zza.zzh(null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException unused) {
        }
    }
}
