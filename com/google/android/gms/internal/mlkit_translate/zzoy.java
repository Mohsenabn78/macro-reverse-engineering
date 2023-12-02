package com.google.android.gms.internal.mlkit_translate;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public class zzoy {
    private final zzps zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzoy(zzps zzpsVar) {
        this.zza = zzpsVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzle zzleVar, zzox zzoxVar) {
        zzps zzpsVar = this.zza;
        zzlf zzlfVar = new zzlf();
        zzlfVar.zzk(zzoxVar.zza().zzi());
        zzpsVar.zze(zzpx.zzf(zzlfVar), zzleVar, "o:a:mlkit:1.0.0");
    }

    public zzoy(Context context) {
        this.zza = new zzps(context, new SharedPrefManager(context), new zzpm(context, zzpl.zzd("shared-installation-id").zzd()), "shared-installation-id");
    }
}
