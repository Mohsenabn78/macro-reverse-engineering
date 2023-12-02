package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfng extends zzfnx {
    final /* synthetic */ zzfna zza;
    final /* synthetic */ zzfno zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfnj zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfng(zzfnj zzfnjVar, TaskCompletionSource taskCompletionSource, zzfna zzfnaVar, zzfno zzfnoVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzd = zzfnjVar;
        this.zza = zzfnaVar;
        this.zzb = zzfnoVar;
        this.zzc = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfnt] */
    @Override // com.google.android.gms.internal.ads.zzfnx
    protected final void zza() {
        zzfnw zzfnwVar;
        String str;
        String str2;
        try {
            ?? zze = this.zzd.zza.zze();
            zzfna zzfnaVar = this.zza;
            str2 = this.zzd.zzd;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfnaVar.zzb());
            bundle.putString("callerPackage", str2);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, zzfnaVar.zza());
            zze.zze(bundle, new zzfni(this.zzd, this.zzb));
        } catch (RemoteException e4) {
            zzfnwVar = zzfnj.zzb;
            str = this.zzd.zzd;
            zzfnwVar.zzb(e4, "dismiss overlay display from: %s", str);
            this.zzc.trySetException(new RuntimeException(e4));
        }
    }
}
