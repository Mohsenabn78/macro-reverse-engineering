package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzpw extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzpz zza;
    final /* synthetic */ zzpx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpw(zzpx zzpxVar, zzpz zzpzVar) {
        this.zzb = zzpxVar;
        this.zza = zzpzVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i4) {
        AudioTrack audioTrack2;
        zzow zzowVar;
        boolean z3;
        zzow zzowVar2;
        audioTrack2 = this.zzb.zza.zzt;
        if (!audioTrack.equals(audioTrack2)) {
            return;
        }
        zzpz zzpzVar = this.zzb.zza;
        zzowVar = zzpzVar.zzp;
        if (zzowVar != null) {
            z3 = zzpzVar.zzQ;
            if (z3) {
                zzowVar2 = zzpzVar.zzp;
                zzowVar2.zzb();
            }
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        AudioTrack audioTrack2;
        zzow zzowVar;
        boolean z3;
        zzow zzowVar2;
        audioTrack2 = this.zzb.zza.zzt;
        if (!audioTrack.equals(audioTrack2)) {
            return;
        }
        zzpz zzpzVar = this.zzb.zza;
        zzowVar = zzpzVar.zzp;
        if (zzowVar != null) {
            z3 = zzpzVar.zzQ;
            if (z3) {
                zzowVar2 = zzpzVar.zzp;
                zzowVar2.zzb();
            }
        }
    }
}
