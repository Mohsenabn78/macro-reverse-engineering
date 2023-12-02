package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzyv extends HandlerThread implements Handler.Callback {
    private zzee zza;
    private Handler zzb;
    @Nullable
    private Error zzc;
    @Nullable
    private RuntimeException zzd;
    @Nullable
    private zzyx zze;

    public zzyv() {
        super("ExoPlayer:PlaceholderSurface");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        boolean z3;
        int i4 = message.what;
        try {
            if (i4 != 1) {
                if (i4 != 2) {
                    return true;
                }
                try {
                    zzee zzeeVar = this.zza;
                    zzeeVar.getClass();
                    zzeeVar.zzc();
                } finally {
                    try {
                        return true;
                    } finally {
                    }
                }
                return true;
            }
            try {
                int i5 = message.arg1;
                zzee zzeeVar2 = this.zza;
                zzeeVar2.getClass();
                zzeeVar2.zzb(i5);
                SurfaceTexture zza = this.zza.zza();
                if (i5 != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.zze = new zzyx(this, zza, z3, null);
                synchronized (this) {
                    notify();
                }
            } catch (zzef e4) {
                zzer.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                this.zzd = new IllegalStateException(e4);
                synchronized (this) {
                    notify();
                }
            } catch (Error e5) {
                zzer.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e5);
                this.zzc = e5;
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e6) {
                zzer.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e6);
                this.zzd = e6;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }

    public final zzyx zza(int i4) {
        boolean z3;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzee(this.zzb, null);
        synchronized (this) {
            z3 = false;
            this.zzb.obtainMessage(1, i4, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException == null) {
            Error error = this.zzc;
            if (error == null) {
                zzyx zzyxVar = this.zze;
                zzyxVar.getClass();
                return zzyxVar;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
