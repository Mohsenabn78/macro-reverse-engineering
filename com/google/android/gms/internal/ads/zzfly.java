package com.google.android.gms.internal.ads;

import android.net.Network;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfly extends zzflm {
    private zzfpx<Integer> zza;
    private zzfpx<Integer> zzb;
    @Nullable
    private zzflx zzc;
    @Nullable
    private HttpURLConnection zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfly(zzfpx<Integer> zzfpxVar, zzfpx<Integer> zzfpxVar2, @Nullable zzflx zzflxVar) {
        this.zza = zzfpxVar;
        this.zzb = zzfpxVar2;
        this.zzc = zzflxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer zzf() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(@Nullable HttpURLConnection httpURLConnection) {
        zzfln.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfln.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzflx zzflxVar = this.zzc;
        zzflxVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzflxVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzflx zzflxVar, final int i4, final int i5) throws IOException {
        this.zza = new zzfpx() { // from class: com.google.android.gms.internal.ads.zzflo
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i4);
                return valueOf;
            }
        };
        this.zzb = new zzfpx() { // from class: com.google.android.gms.internal.ads.zzflp
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i5);
                return valueOf;
            }
        };
        this.zzc = zzflxVar;
        return zzm();
    }

    @RequiresApi(21)
    public HttpURLConnection zzo(@NonNull final Network network, @NonNull final URL url, final int i4, final int i5) throws IOException {
        this.zza = new zzfpx() { // from class: com.google.android.gms.internal.ads.zzflq
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i4);
                return valueOf;
            }
        };
        this.zzb = new zzfpx() { // from class: com.google.android.gms.internal.ads.zzflr
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i5);
                return valueOf;
            }
        };
        this.zzc = new zzflx() { // from class: com.google.android.gms.internal.ads.zzfls
            @Override // com.google.android.gms.internal.ads.zzflx
            public final URLConnection zza() {
                URLConnection openConnection;
                openConnection = network.openConnection(url);
                return openConnection;
            }
        };
        return zzm();
    }

    public URLConnection zzr(@NonNull final URL url, final int i4) throws IOException {
        this.zza = new zzfpx() { // from class: com.google.android.gms.internal.ads.zzflt
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i4);
                return valueOf;
            }
        };
        this.zzc = new zzflx() { // from class: com.google.android.gms.internal.ads.zzflu
            @Override // com.google.android.gms.internal.ads.zzflx
            public final URLConnection zza() {
                URLConnection openConnection;
                openConnection = url.openConnection();
                return openConnection;
            }
        };
        return zzm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfly() {
        this(new zzfpx() { // from class: com.google.android.gms.internal.ads.zzflv
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                return zzfly.zzf();
            }
        }, new zzfpx() { // from class: com.google.android.gms.internal.ads.zzflw
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                return zzfly.zzg();
            }
        }, null);
    }
}
