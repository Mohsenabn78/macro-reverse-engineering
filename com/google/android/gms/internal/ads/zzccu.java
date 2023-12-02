package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzccu implements zzge {
    private final Context zza;
    private final zzge zzb;
    private final String zzc;
    private final int zzd;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzawl zzi;
    private zzgj zzm;
    private boolean zzj = false;
    private boolean zzk = false;
    private final AtomicLong zzl = new AtomicLong(-1);
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue();

    public zzccu(Context context, zzge zzgeVar, String str, int i4, zzhg zzhgVar, zzcct zzcctVar) {
        this.zza = context;
        this.zzb = zzgeVar;
        this.zzc = str;
        this.zzd = i4;
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeb)).booleanValue() && !this.zzj) {
            return true;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzec)).booleanValue() || this.zzk) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws IOException {
        if (this.zzg) {
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                return inputStream.read(bArr, i4, i5);
            }
            return this.zzb.zza(bArr, i4, i5);
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v11 */
    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws IOException {
        Long l4;
        if (!this.zzg) {
            this.zzg = true;
            Uri uri = zzgjVar.zza;
            this.zzh = uri;
            this.zzm = zzgjVar;
            this.zzi = zzawl.zza(uri);
            zzawi zzawiVar = 0;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdY)).booleanValue()) {
                if (this.zzi != null) {
                    this.zzi.zzh = zzgjVar.zzf;
                    this.zzi.zzi = zzfpw.zzc(this.zzc);
                    this.zzi.zzj = this.zzd;
                    if (this.zzi.zzg) {
                        l4 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzea);
                    } else {
                        l4 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdZ);
                    }
                    long longValue = l4.longValue();
                    com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                    com.google.android.gms.ads.internal.zzt.zzd();
                    Future zza = zzaww.zza(this.zza, this.zzi);
                    try {
                        zzawx zzawxVar = (zzawx) zza.get(longValue, TimeUnit.MILLISECONDS);
                        zzawxVar.zzd();
                        this.zzj = zzawxVar.zzf();
                        this.zzk = zzawxVar.zze();
                        zzawxVar.zza();
                        if (!zzg()) {
                            this.zzf = zzawxVar.zzc();
                            com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                            throw null;
                        }
                        com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                        throw null;
                    } catch (InterruptedException unused) {
                        zza.cancel(false);
                        Thread.currentThread().interrupt();
                        com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                        throw null;
                    } catch (ExecutionException | TimeoutException unused2) {
                        zza.cancel(false);
                        com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                        throw null;
                    }
                }
            } else {
                if (this.zzi != null) {
                    this.zzi.zzh = zzgjVar.zzf;
                    this.zzi.zzi = zzfpw.zzc(this.zzc);
                    this.zzi.zzj = this.zzd;
                    zzawiVar = com.google.android.gms.ads.internal.zzt.zzc().zzb(this.zzi);
                }
                if (zzawiVar != 0 && zzawiVar.zze()) {
                    this.zzj = zzawiVar.zzg();
                    this.zzk = zzawiVar.zzf();
                    if (!zzg()) {
                        this.zzf = zzawiVar.zzc();
                        return -1L;
                    }
                }
            }
            if (this.zzi != null) {
                this.zzm = new zzgj(Uri.parse(this.zzi.zza), null, zzgjVar.zze, zzgjVar.zzf, zzgjVar.zzg, null, zzgjVar.zzi);
            }
            return this.zzb.zzb(this.zzm);
        }
        throw new IOException("Attempt to open an already open CacheDataSource.");
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws IOException {
        if (this.zzg) {
            this.zzg = false;
            this.zzh = null;
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
                this.zzf = null;
                return;
            }
            this.zzb.zzd();
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzf(zzhg zzhgVar) {
    }
}
