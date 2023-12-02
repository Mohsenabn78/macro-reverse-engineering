package com.google.android.gms.internal.mlkit_translate;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzqw extends zzoy {
    public zzqw(Context context) {
        super(new zzps(context, new SharedPrefManager(context), new zzpm(context, zzpl.zzd("shared-remote-config").zzd()), "shared-remote-config"));
    }

    public final void zzb(zzox zzoxVar) {
        zza(zzle.REMOTE_CONFIG_ACTIVATE, zzoxVar);
    }

    public final void zzc(zzox zzoxVar) {
        zza(zzle.REMOTE_CONFIG_FETCH, zzoxVar);
    }

    public final void zzd(zzox zzoxVar) {
        zza(zzle.REMOTE_CONFIG_FRC_FETCH, zzoxVar);
    }
}
