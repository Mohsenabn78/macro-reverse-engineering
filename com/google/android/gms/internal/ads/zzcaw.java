package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcaw implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcbe zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcaw(zzcbe zzcbeVar, MediaPlayer mediaPlayer) {
        this.zzb = zzcbeVar;
        this.zza = mediaPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar;
        zzcbf zzcbfVar2;
        zzcbe.zzl(this.zzb, this.zza);
        zzcbe zzcbeVar = this.zzb;
        zzcbfVar = zzcbeVar.zzq;
        if (zzcbfVar != null) {
            zzcbfVar2 = zzcbeVar.zzq;
            zzcbfVar2.zzf();
        }
    }
}
