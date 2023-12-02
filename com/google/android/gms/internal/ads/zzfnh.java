package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfnh extends zzfnx {
    final /* synthetic */ zzfnq zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzfno zzc;
    final /* synthetic */ TaskCompletionSource zzd;
    final /* synthetic */ zzfnj zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfnh(zzfnj zzfnjVar, TaskCompletionSource taskCompletionSource, zzfnq zzfnqVar, int i4, zzfno zzfnoVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zze = zzfnjVar;
        this.zza = zzfnqVar;
        this.zzb = i4;
        this.zzc = zzfnoVar;
        this.zzd = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfnt] */
    @Override // com.google.android.gms.internal.ads.zzfnx
    protected final void zza() {
        zzfnw zzfnwVar;
        String str;
        String str2;
        try {
            ?? zze = this.zze.zza.zze();
            zzfnq zzfnqVar = this.zza;
            str2 = this.zze.zzd;
            int i4 = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfnqVar.zzb());
            bundle.putInt("displayMode", i4);
            bundle.putString("callerPackage", str2);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, zzfnqVar.zza());
            zze.zzg(bundle, new zzfni(this.zze, this.zzc));
        } catch (RemoteException e4) {
            zzfnwVar = zzfnj.zzb;
            str = this.zze.zzd;
            zzfnwVar.zzb(e4, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(this.zzb), str);
            this.zzd.trySetException(new RuntimeException(e4));
        }
    }
}
