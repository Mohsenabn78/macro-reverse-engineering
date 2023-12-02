package com.google.android.gms.internal.nearby;

import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzlu {
    private final ExecutorService zza;
    private final SimpleArrayMap zzb;
    private volatile boolean zzc;
    private final SimpleArrayMap zzd;
    private final SimpleArrayMap zze;

    public zzlu() {
        zzg.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 6, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zza = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zzb = new SimpleArrayMap();
        this.zzc = false;
        this.zzd = new SimpleArrayMap();
        this.zze = new SimpleArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zza(zzlu zzluVar, OutputStream outputStream, boolean z3, long j4) {
        try {
            outputStream.write(z3 ? 1 : 0);
        } catch (IOException e4) {
            Log.w("NearbyConnections", String.format("Unable to deliver status for Payload %d", Long.valueOf(j4)), e4);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzb(long j4) {
        SimpleArrayMap simpleArrayMap = this.zzb;
        Long valueOf = Long.valueOf(j4);
        IOUtils.closeQuietly((Closeable) simpleArrayMap.get(valueOf));
        this.zzb.remove(valueOf);
        IOUtils.closeQuietly((Closeable) this.zzd.get(valueOf));
        this.zzd.remove(valueOf);
        zzmc zzmcVar = (zzmc) this.zze.remove(valueOf);
        if (zzmcVar != null) {
            IOUtils.closeQuietly(zzmcVar.zze());
            IOUtils.closeQuietly(zzmcVar.zzf());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzc(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2, zzmc zzmcVar, long j4) {
        SimpleArrayMap simpleArrayMap = this.zzb;
        Long valueOf = Long.valueOf(j4);
        simpleArrayMap.put(valueOf, inputStream);
        this.zzd.put(valueOf, outputStream);
        this.zze.put(valueOf, zzmcVar);
        this.zza.execute(new zzlt(this, inputStream, outputStream, j4, outputStream2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzd() {
        this.zzc = true;
        this.zza.shutdownNow();
        for (int i4 = 0; i4 < this.zzb.size(); i4++) {
            IOUtils.closeQuietly((Closeable) this.zzb.valueAt(i4));
        }
        this.zzb.clear();
        for (int i5 = 0; i5 < this.zzd.size(); i5++) {
            IOUtils.closeQuietly((Closeable) this.zzd.valueAt(i5));
        }
        this.zzd.clear();
        for (int i6 = 0; i6 < this.zze.size(); i6++) {
            zzmc zzmcVar = (zzmc) this.zze.valueAt(i6);
            IOUtils.closeQuietly(zzmcVar.zze());
            IOUtils.closeQuietly(zzmcVar.zzf());
        }
        this.zze.clear();
    }
}
