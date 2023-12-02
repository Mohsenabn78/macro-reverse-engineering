package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.wearable.WearableStatusCodes;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzfjk implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    @VisibleForTesting
    protected final zzfki zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzfjb zzf;
    private final long zzg;
    private final int zzh;

    public zzfjk(Context context, int i4, int i5, String str, String str2, String str3, zzfjb zzfjbVar) {
        this.zzb = str;
        this.zzh = i5;
        this.zzc = str2;
        this.zzf = zzfjbVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        this.zzg = System.currentTimeMillis();
        zzfki zzfkiVar = new zzfki(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfkiVar;
        this.zzd = new LinkedBlockingQueue();
        zzfkiVar.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    static zzfku zza() {
        return new zzfku(null, 1);
    }

    private final void zze(int i4, long j4, Exception exc) {
        this.zzf.zzc(i4, System.currentTimeMillis() - j4, exc);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfkn zzd = zzd();
        if (zzd != null) {
            try {
                zzfku zzf = zzd.zzf(new zzfks(1, this.zzh, this.zzb, this.zzc));
                zze(5011, this.zzg, null);
                this.zzd.put(zzf);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i4) {
        try {
            zze(WearableStatusCodes.MODEL_ID_UNAVAILABLE, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfku zzb(int i4) {
        zzfku zzfkuVar;
        try {
            zzfkuVar = (zzfku) this.zzd.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e4) {
            zze(2009, this.zzg, e4);
            zzfkuVar = null;
        }
        zze(AuthApiStatusCodes.AUTH_TOKEN_ERROR, this.zzg, null);
        if (zzfkuVar != null) {
            if (zzfkuVar.zzc == 7) {
                zzfjb.zzg(3);
            } else {
                zzfjb.zzg(2);
            }
        }
        if (zzfkuVar == null) {
            return zza();
        }
        return zzfkuVar;
    }

    public final void zzc() {
        zzfki zzfkiVar = this.zza;
        if (zzfkiVar != null) {
            if (zzfkiVar.isConnected() || this.zza.isConnecting()) {
                this.zza.disconnect();
            }
        }
    }

    protected final zzfkn zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
