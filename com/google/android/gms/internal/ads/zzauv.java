package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzauv implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzauz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzauv(zzauz zzauzVar, View view) {
        this.zzb = zzauzVar;
        this.zza = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
