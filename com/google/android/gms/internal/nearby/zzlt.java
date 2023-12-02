package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzlt implements Runnable {
    final /* synthetic */ InputStream zza;
    final /* synthetic */ OutputStream zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ OutputStream zzd;
    final /* synthetic */ zzlu zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlt(zzlu zzluVar, InputStream inputStream, OutputStream outputStream, long j4, OutputStream outputStream2) {
        this.zze = zzluVar;
        this.zza = inputStream;
        this.zzb = outputStream;
        this.zzc = j4;
        this.zzd = outputStream2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z3;
        boolean z4 = false;
        try {
            IOUtils.copyStream(this.zza, this.zzb, false, 65536);
            IOUtils.closeQuietly(this.zza);
            zzlu.zza(this.zze, this.zzd, false, this.zzc);
        } catch (IOException e4) {
            try {
                z3 = this.zze.zzc;
                if (!z3) {
                    Log.w("NearbyConnections", String.format("Exception copying stream for Payload %d", Long.valueOf(this.zzc)), e4);
                } else {
                    String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.zzc));
                }
                IOUtils.closeQuietly(this.zza);
                zzlu.zza(this.zze, this.zzd, true, this.zzc);
            } catch (Throwable th) {
                th = th;
                z4 = true;
                IOUtils.closeQuietly(this.zza);
                zzlu.zza(this.zze, this.zzd, z4, this.zzc);
                IOUtils.closeQuietly(this.zzb);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(this.zza);
            zzlu.zza(this.zze, this.zzd, z4, this.zzc);
            IOUtils.closeQuietly(this.zzb);
            throw th;
        }
        IOUtils.closeQuietly(this.zzb);
    }
}
