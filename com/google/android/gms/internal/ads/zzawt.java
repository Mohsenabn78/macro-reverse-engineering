package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawt implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzawl zza;
    final /* synthetic */ zzcaj zzb;
    final /* synthetic */ zzawv zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawt(zzawv zzawvVar, zzawl zzawlVar, zzcaj zzcajVar) {
        this.zzc = zzawvVar;
        this.zza = zzawlVar;
        this.zzb = zzcajVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        Object obj;
        boolean z3;
        final zzawk zzawkVar;
        obj = this.zzc.zzd;
        synchronized (obj) {
            zzawv zzawvVar = this.zzc;
            z3 = zzawvVar.zzb;
            if (!z3) {
                zzawvVar.zzb = true;
                zzawkVar = this.zzc.zza;
                if (zzawkVar == null) {
                    return;
                }
                zzfwn zzfwnVar = zzcae.zza;
                final zzawl zzawlVar = this.zza;
                final zzcaj zzcajVar = this.zzb;
                final zzfwm zza = zzfwnVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzawq
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzawi zzf;
                        zzawt zzawtVar = zzawt.this;
                        zzawk zzawkVar2 = zzawkVar;
                        zzawl zzawlVar2 = zzawlVar;
                        zzcaj zzcajVar2 = zzcajVar;
                        try {
                            zzawn zzq = zzawkVar2.zzq();
                            if (zzawkVar2.zzp()) {
                                zzf = zzq.zzg(zzawlVar2);
                            } else {
                                zzf = zzq.zzf(zzawlVar2);
                            }
                            if (!zzf.zze()) {
                                zzcajVar2.zze(new RuntimeException("No entry contents."));
                                zzawv.zze(zzawtVar.zzc);
                                return;
                            }
                            zzaws zzawsVar = new zzaws(zzawtVar, zzf.zzc(), 1);
                            int read = zzawsVar.read();
                            if (read != -1) {
                                zzawsVar.unread(read);
                                zzcajVar2.zzd(zzawx.zzb(zzawsVar, zzf.zzd(), zzf.zzg(), zzf.zza(), zzf.zzf()));
                                return;
                            }
                            throw new IOException("Unable to read from cache.");
                        } catch (RemoteException | IOException e4) {
                            zzbzr.zzh("Unable to obtain a cache service instance.", e4);
                            zzcajVar2.zze(e4);
                            zzawv.zze(zzawtVar.zzc);
                        }
                    }
                });
                final zzcaj zzcajVar2 = this.zzb;
                zzcajVar2.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzawr
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcaj zzcajVar3 = zzcaj.this;
                        Future future = zza;
                        if (zzcajVar3.isCancelled()) {
                            future.cancel(true);
                        }
                    }
                }, zzcae.zzf);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
    }
}
