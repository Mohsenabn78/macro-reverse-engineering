package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawh {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzawd(this);
    private final Object zzc = new Object();
    @Nullable
    private zzawk zzd;
    @Nullable
    private Context zze;
    @Nullable
    private zzawn zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzh(zzawh zzawhVar) {
        synchronized (zzawhVar.zzc) {
            zzawk zzawkVar = zzawhVar.zzd;
            if (zzawkVar == null) {
                return;
            }
            if (zzawkVar.isConnected() || zzawhVar.zzd.isConnecting()) {
                zzawhVar.zzd.disconnect();
            }
            zzawhVar.zzd = null;
            zzawhVar.zzf = null;
            Binder.flushPendingCommands();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        synchronized (this.zzc) {
            if (this.zze != null && this.zzd == null) {
                zzawk zzd = zzd(new zzawf(this), new zzawg(this));
                this.zzd = zzd;
                zzd.checkAvailabilityAndConnect();
            }
        }
    }

    public final long zza(zzawl zzawlVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2L;
            }
            if (this.zzd.zzp()) {
                try {
                    return this.zzf.zze(zzawlVar);
                } catch (RemoteException e4) {
                    zzbzr.zzh("Unable to call into cache service.", e4);
                }
            }
            return -2L;
        }
    }

    public final zzawi zzb(zzawl zzawlVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzawi();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzg(zzawlVar);
                }
                return this.zzf.zzf(zzawlVar);
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call into cache service.", e4);
                return new zzawi();
            }
        }
    }

    @VisibleForTesting
    protected final synchronized zzawk zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzawk(this.zze, com.google.android.gms.ads.internal.zzt.zzt().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    public final void zzi(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            if (this.zze != null) {
                return;
            }
            this.zze = context.getApplicationContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdU)).booleanValue()) {
                zzl();
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdT)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzb().zzc(new zzawe(this));
                }
            }
        }
    }

    public final void zzj() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdV)).booleanValue()) {
            synchronized (this.zzc) {
                zzl();
                ScheduledFuture scheduledFuture = this.zza;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.zza = zzcae.zzd.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdW)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }
}
