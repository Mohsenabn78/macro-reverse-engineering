package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes4.dex */
public final class zzxx extends Handler implements Runnable {
    final /* synthetic */ zzyc zza;
    private final zzxy zzb;
    private final long zzc;
    @Nullable
    private zzxu zzd;
    @Nullable
    private IOException zze;
    private int zzf;
    @Nullable
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzxx(zzyc zzycVar, Looper looper, zzxy zzxyVar, zzxu zzxuVar, int i4, long j4) {
        super(looper);
        this.zza = zzycVar;
        this.zzb = zzxyVar;
        this.zzd = zzxuVar;
        this.zzc = j4;
    }

    private final void zzd() {
        ExecutorService executorService;
        zzxx zzxxVar;
        this.zze = null;
        zzyc zzycVar = this.zza;
        executorService = zzycVar.zze;
        zzxxVar = zzycVar.zzf;
        zzxxVar.getClass();
        executorService.execute(zzxxVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i4;
        int i5;
        int i6;
        long j4;
        long min;
        if (this.zzi) {
            return;
        }
        int i7 = message.what;
        if (i7 == 0) {
            zzd();
        } else if (i7 != 3) {
            this.zza.zzf = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j5 = elapsedRealtime - this.zzc;
            zzxu zzxuVar = this.zzd;
            zzxuVar.getClass();
            if (this.zzh) {
                zzxuVar.zzI(this.zzb, elapsedRealtime, j5, false);
                return;
            }
            int i8 = message.what;
            if (i8 != 1) {
                if (i8 == 2) {
                    IOException iOException = (IOException) message.obj;
                    this.zze = iOException;
                    int i9 = this.zzf + 1;
                    this.zzf = i9;
                    zzxw zzt = zzxuVar.zzt(this.zzb, elapsedRealtime, j5, iOException, i9);
                    i4 = zzt.zza;
                    if (i4 != 3) {
                        i5 = zzt.zza;
                        if (i5 != 2) {
                            i6 = zzt.zza;
                            if (i6 == 1) {
                                this.zzf = 1;
                            }
                            j4 = zzt.zzb;
                            if (j4 != -9223372036854775807L) {
                                min = zzt.zzb;
                            } else {
                                min = Math.min((this.zzf - 1) * 1000, 5000);
                            }
                            zzc(min);
                            return;
                        }
                        return;
                    }
                    this.zza.zzg = this.zze;
                    return;
                }
                return;
            }
            try {
                zzxuVar.zzJ(this.zzb, elapsedRealtime, j5);
            } catch (RuntimeException e4) {
                zzer.zzd("LoadTask", "Unexpected exception handling load completed", e4);
                this.zza.zzg = new zzyb(e4);
            }
        } else {
            throw ((Error) message.obj);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        try {
            synchronized (this) {
                z3 = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z3) {
                int i4 = zzfj.zza;
                Trace.beginSection("load:" + this.zzb.getClass().getSimpleName());
                try {
                    this.zzb.zzh();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(1);
            }
        } catch (IOException e4) {
            if (!this.zzi) {
                obtainMessage(2, e4).sendToTarget();
            }
        } catch (Exception e5) {
            if (!this.zzi) {
                zzer.zzd("LoadTask", "Unexpected exception loading stream", e5);
                obtainMessage(2, new zzyb(e5)).sendToTarget();
            }
        } catch (OutOfMemoryError e6) {
            if (!this.zzi) {
                zzer.zzd("LoadTask", "OutOfMemory error loading stream", e6);
                obtainMessage(2, new zzyb(e6)).sendToTarget();
            }
        } catch (Error e7) {
            if (!this.zzi) {
                zzer.zzd("LoadTask", "Unexpected error loading stream", e7);
                obtainMessage(3, e7).sendToTarget();
            }
            throw e7;
        }
    }

    public final void zza(boolean z3) {
        this.zzi = z3;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z3) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z3) {
            this.zza.zzf = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzxu zzxuVar = this.zzd;
            zzxuVar.getClass();
            zzxuVar.zzI(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i4) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i4) {
            throw iOException;
        }
    }

    public final void zzc(long j4) {
        zzxx zzxxVar;
        boolean z3;
        zzxxVar = this.zza.zzf;
        if (zzxxVar == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        this.zza.zzf = this;
        if (j4 > 0) {
            sendEmptyMessageDelayed(0, j4);
        } else {
            zzd();
        }
    }
}
