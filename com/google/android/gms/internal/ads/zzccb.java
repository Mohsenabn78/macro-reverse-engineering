package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzfmd;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzccb {
    private final Context zza;
    private final String zzb;
    private final zzbzx zzc;
    @Nullable
    private final zzbcb zzd;
    @Nullable
    private final zzbce zze;
    private final com.google.android.gms.ads.internal.util.zzbf zzf;
    private final long[] zzg;
    private final String[] zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private zzcbg zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;

    public zzccb(Context context, zzbzx zzbzxVar, String str, @Nullable zzbce zzbceVar, @Nullable zzbcb zzbcbVar) {
        com.google.android.gms.ads.internal.util.zzbd zzbdVar = new com.google.android.gms.ads.internal.util.zzbd();
        zzbdVar.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbdVar.zza("1_5", 1.0d, 5.0d);
        zzbdVar.zza("5_10", 5.0d, 10.0d);
        zzbdVar.zza("10_20", 10.0d, 20.0d);
        zzbdVar.zza("20_30", 20.0d, 30.0d);
        zzbdVar.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzf = zzbdVar.zzb();
        this.zzi = false;
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzq = -1L;
        this.zza = context;
        this.zzc = zzbzxVar;
        this.zzb = str;
        this.zze = zzbceVar;
        this.zzd = zzbcbVar;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzA);
        if (str2 == null) {
            this.zzh = new String[0];
            this.zzg = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzh = new String[length];
        this.zzg = new long[length];
        for (int i4 = 0; i4 < split.length; i4++) {
            try {
                this.zzg[i4] = Long.parseLong(split[i4]);
            } catch (NumberFormatException e4) {
                zzbzr.zzk("Unable to parse frame hash target time number.", e4);
                this.zzg[i4] = -1;
            }
        }
    }

    public final void zza(zzcbg zzcbgVar) {
        zzbbw.zza(this.zze, this.zzd, "vpc2");
        this.zzi = true;
        this.zze.zzd("vpn", zzcbgVar.zzj());
        this.zzn = zzcbgVar;
    }

    public final void zzb() {
        if (this.zzi && !this.zzj) {
            zzbbw.zza(this.zze, this.zzd, "vfr2");
            this.zzj = true;
        }
    }

    public final void zzc() {
        this.zzm = true;
        if (this.zzj && !this.zzk) {
            zzbbw.zza(this.zze, this.zzd, "vfp2");
            this.zzk = true;
        }
    }

    public final void zzd() {
        if (((Boolean) zzbdt.zza.zze()).booleanValue() && !this.zzo) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzb);
            bundle.putString("player", this.zzn.zzj());
            for (com.google.android.gms.ads.internal.util.zzbc zzbcVar : this.zzf.zza()) {
                String valueOf = String.valueOf(zzbcVar.zza);
                bundle.putString("fps_c_".concat(valueOf), Integer.toString(zzbcVar.zze));
                String valueOf2 = String.valueOf(zzbcVar.zza);
                bundle.putString("fps_p_".concat(valueOf2), Double.toString(zzbcVar.zzd));
            }
            int i4 = 0;
            while (true) {
                long[] jArr = this.zzg;
                if (i4 < jArr.length) {
                    String str = this.zzh[i4];
                    if (str != null) {
                        bundle.putString("fh_".concat(Long.valueOf(jArr[i4]).toString()), str);
                    }
                    i4++;
                } else {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    final Context context = this.zza;
                    final String str2 = this.zzc.zza;
                    com.google.android.gms.ads.internal.zzt.zzp();
                    bundle.putString("device", com.google.android.gms.ads.internal.util.zzs.zzp());
                    zzbbe zzbbeVar = zzbbm.zza;
                    bundle.putString("eids", TextUtils.join(",", com.google.android.gms.ads.internal.client.zzba.zza().zza()));
                    com.google.android.gms.ads.internal.client.zzay.zzb();
                    zzbzk.zzw(context, str2, "gmob-apps", bundle, true, new zzbzj() { // from class: com.google.android.gms.ads.internal.util.zzk
                        @Override // com.google.android.gms.internal.ads.zzbzj
                        public final boolean zza(String str3) {
                            Context context2 = context;
                            String str4 = str2;
                            zzfmd zzfmdVar = zzs.zza;
                            com.google.android.gms.ads.internal.zzt.zzp();
                            zzs.zzH(context2, str4, str3);
                            return true;
                        }
                    });
                    this.zzo = true;
                    return;
                }
            }
        }
    }

    public final void zze() {
        this.zzm = false;
    }

    public final void zzf(zzcbg zzcbgVar) {
        long j4;
        if (this.zzk && !this.zzl) {
            if (com.google.android.gms.ads.internal.util.zze.zzc() && !this.zzl) {
                com.google.android.gms.ads.internal.util.zze.zza("VideoMetricsMixin first frame");
            }
            zzbbw.zza(this.zze, this.zzd, "vff2");
            this.zzl = true;
        }
        long nanoTime = com.google.android.gms.ads.internal.zzt.zzB().nanoTime();
        if (this.zzm && this.zzp && this.zzq != -1) {
            this.zzf.zzb(TimeUnit.SECONDS.toNanos(1L) / (nanoTime - this.zzq));
        }
        this.zzp = this.zzm;
        this.zzq = nanoTime;
        long longValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzB)).longValue();
        long zza = zzcbgVar.zza();
        int i4 = 0;
        while (true) {
            String[] strArr = this.zzh;
            if (i4 < strArr.length) {
                if (strArr[i4] == null && longValue > Math.abs(zza - this.zzg[i4])) {
                    String[] strArr2 = this.zzh;
                    int i5 = 8;
                    Bitmap bitmap = zzcbgVar.getBitmap(8, 8);
                    long j5 = 63;
                    long j6 = 0;
                    int i6 = 0;
                    while (i6 < i5) {
                        int i7 = 0;
                        while (i7 < i5) {
                            int pixel = bitmap.getPixel(i7, i6);
                            if (Color.blue(pixel) + Color.red(pixel) + Color.green(pixel) > 128) {
                                j4 = 1;
                            } else {
                                j4 = 0;
                            }
                            j6 |= j4 << ((int) j5);
                            j5--;
                            i7++;
                            i5 = 8;
                        }
                        i6++;
                        i5 = 8;
                    }
                    strArr2[i4] = String.format("%016X", Long.valueOf(j6));
                    return;
                }
                i4++;
            } else {
                return;
            }
        }
    }
}
