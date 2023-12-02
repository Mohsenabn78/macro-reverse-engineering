package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.messaging.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcdu extends zzcdl implements zzcbq {
    public static final /* synthetic */ int zzd = 0;
    private zzcbr zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcdd zzi;
    private long zzj;
    private long zzk;

    public zzcdu(zzcca zzccaVar, zzcbz zzcbzVar) {
        super(zzccaVar);
        zzcem zzcemVar = new zzcem(zzccaVar.getContext(), zzcbzVar, (zzcca) this.zzc.get(), null);
        zzbzr.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzcemVar;
        zzcemVar.zzL(this);
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(zzbzk.zze(str)));
    }

    private static String zzd(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + RemoteSettings.FORWARD_SLASH_STRING + canonicalName + ":" + message;
    }

    private final void zzx(long j4) {
        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdt
            @Override // java.lang.Runnable
            public final void run() {
                zzcdu.this.zzb();
            }
        }, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzcdl, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcbr zzcbrVar = this.zze;
        if (zzcbrVar != null) {
            zzcbrVar.zzL(null);
            this.zze.zzH();
        }
    }

    public final zzcbr zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcbr zzcbrVar = this.zze;
        this.zze = null;
        return zzcbrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.google.android.gms.internal.ads.zzcdu, com.google.android.gms.internal.ads.zzcdl] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [com.google.android.gms.internal.ads.zzcdu] */
    /* JADX WARN: Type inference failed for: r2v31 */
    public final /* synthetic */ void zzb() {
        String str;
        zzcdu zzcduVar;
        zzcdu zzcduVar2;
        zzbbk zzc;
        long longValue;
        long intValue;
        zzcdu zzcduVar3;
        long j4;
        long j5;
        String str2;
        long j6;
        boolean z3;
        String str3;
        long j7;
        long j8;
        long j9;
        long j10;
        String zzc2 = zzc(this.zzf);
        String str4 = Constants.IPC_BUNDLE_KEY_SEND_ERROR;
        try {
            zzbbe zzbbeVar = zzbbm.zzx;
            zzc = com.google.android.gms.ads.internal.client.zzba.zzc();
            longValue = ((Long) zzc.zzb(zzbbeVar)).longValue() * 1000;
            intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzw)).intValue();
            zzcduVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue();
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e4) {
            e = e4;
            str = zzc2;
            zzcduVar = this;
        }
        synchronized (this) {
            try {
                int i4 = ((com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zzj) > longValue ? 1 : ((com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zzj) == longValue ? 0 : -1));
                if (i4 <= 0) {
                    try {
                        if (!this.zzg) {
                            if (this.zzh) {
                                zzcduVar2 = this;
                            } else if (this.zze.zzV()) {
                                long zzz = this.zze.zzz();
                                if (zzz > 0) {
                                    long zzv = this.zze.zzv();
                                    if (zzv != this.zzk) {
                                        if (zzv > 0) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        try {
                                            str3 = this.zzf;
                                            if (zzcduVar != 0) {
                                                j7 = this.zze.zzA();
                                            } else {
                                                j7 = -1;
                                            }
                                            if (zzcduVar != 0) {
                                                j8 = this.zze.zzx();
                                            } else {
                                                j8 = -1;
                                            }
                                            if (zzcduVar != 0) {
                                                j9 = this.zze.zzB();
                                            } else {
                                                j9 = -1;
                                            }
                                            j10 = j7;
                                            j5 = intValue;
                                            str2 = zzc2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            zzcduVar = this;
                                            str = zzc2;
                                        }
                                        try {
                                            zzo(str3, zzc2, zzv, zzz, z3, j10, j8, j9, zzcbr.zzs(), zzcbr.zzu());
                                            zzcduVar = this;
                                            j4 = zzv;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            zzcduVar = this;
                                            str = str2;
                                            throw th;
                                        }
                                        try {
                                            zzcduVar.zzk = j4;
                                            j6 = zzz;
                                            zzcduVar = zzcduVar;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            str = str2;
                                            throw th;
                                        }
                                    } else {
                                        j4 = zzv;
                                        j5 = intValue;
                                        str2 = zzc2;
                                        zzcduVar = this;
                                        j6 = zzz;
                                    }
                                    if (j4 >= j6) {
                                        zzcduVar.zzj(zzcduVar.zzf, str2, j6);
                                        zzcduVar2 = zzcduVar;
                                    } else {
                                        int i5 = (zzcduVar.zze.zzw() > j5 ? 1 : (zzcduVar.zze.zzw() == j5 ? 0 : -1));
                                        zzcduVar3 = zzcduVar;
                                        if (i5 >= 0) {
                                            zzcduVar3 = zzcduVar;
                                            if (j4 > 0) {
                                                zzcduVar2 = zzcduVar;
                                            }
                                        }
                                    }
                                } else {
                                    zzcduVar3 = this;
                                }
                                zzcduVar3.zzx(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzy)).longValue());
                                return;
                            } else {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            com.google.android.gms.ads.internal.zzt.zzy().zzc(zzcduVar2.zzi);
                        }
                        throw new IOException("Abort requested before buffering finished. ");
                    } catch (Throwable th5) {
                        th = th5;
                        str4 = zzc;
                        str = i4;
                    }
                } else {
                    str = zzc2;
                    zzcduVar = this;
                    try {
                        throw new IOException("Timeout reached. Limit: " + longValue + " ms");
                    } catch (Throwable th6) {
                        th = th6;
                        str4 = "downloadTimeout";
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                str = zzc2;
                zzcduVar = this;
            }
            try {
                throw th;
            } catch (Exception e5) {
                e = e5;
                String str5 = str4;
                zzbzr.zzj("Failed to preload url " + zzcduVar.zzf + " Exception: " + e.getMessage());
                com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "VideoStreamExoPlayerCache.preload");
                release();
                zzcduVar.zzg(zzcduVar.zzf, str, str5, zzd(str5, e));
                zzcduVar2 = zzcduVar;
                com.google.android.gms.ads.internal.zzt.zzy().zzc(zzcduVar2.zzi);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzi(final boolean z3, final long j4) {
        final zzcca zzccaVar = (zzcca) this.zzc.get();
        if (zzccaVar != null) {
            zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcds
                @Override // java.lang.Runnable
                public final void run() {
                    zzcca.this.zzv(z3, j4);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzk(String str, Exception exc) {
        zzbzr.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzt(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzl(String str, Exception exc) {
        zzbzr.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzt(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final void zzp(int i4) {
        this.zze.zzJ(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final void zzq(int i4) {
        this.zze.zzK(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final void zzr(int i4) {
        this.zze.zzM(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final void zzs(int i4) {
        this.zze.zzN(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzcdl] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r6v19 */
    @Override // com.google.android.gms.internal.ads.zzcdl
    public final boolean zzu(String str, String[] strArr) {
        String str2;
        String str3;
        zzcdu zzcduVar;
        long j4;
        long j5;
        long j6;
        ?? r12;
        long j7;
        String str4;
        long j8;
        long j9;
        boolean z3;
        long j10;
        long j11;
        long j12;
        zzcdu zzcduVar2 = this;
        String str5 = str;
        zzcduVar2.zzf = str5;
        String str6 = Constants.IPC_BUNDLE_KEY_SEND_ERROR;
        String zzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i4 = 0; i4 < strArr.length; i4++) {
                uriArr[i4] = Uri.parse(strArr[i4]);
            }
            zzcduVar2.zze.zzF(uriArr, zzcduVar2.zzb);
            zzcca zzccaVar = (zzcca) zzcduVar2.zzc.get();
            if (zzccaVar != null) {
                zzccaVar.zzt(zzc, zzcduVar2);
            }
            Clock zzB = com.google.android.gms.ads.internal.zzt.zzB();
            long currentTimeMillis = zzB.currentTimeMillis();
            long longValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzy)).longValue();
            long longValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzx)).longValue() * 1000;
            long intValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzw)).intValue();
            boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue();
            long j13 = -1;
            while (true) {
                synchronized (this) {
                    try {
                        if (zzB.currentTimeMillis() - currentTimeMillis <= longValue2) {
                            if (!zzcduVar2.zzg) {
                                if (zzcduVar2.zzh) {
                                    break;
                                } else if (zzcduVar2.zze.zzV()) {
                                    long zzz = zzcduVar2.zze.zzz();
                                    if (zzz > 0) {
                                        long zzv = zzcduVar2.zze.zzv();
                                        if (zzv != j13) {
                                            if (zzv > 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (booleanValue) {
                                                j10 = zzcduVar2.zze.zzA();
                                            } else {
                                                j10 = -1;
                                            }
                                            if (booleanValue) {
                                                j11 = zzcduVar2.zze.zzx();
                                            } else {
                                                j11 = -1;
                                            }
                                            if (booleanValue) {
                                                j12 = zzcduVar2.zze.zzB();
                                            } else {
                                                j12 = -1;
                                            }
                                            try {
                                                j4 = intValue;
                                                long j14 = zzz;
                                                j5 = longValue2;
                                                j7 = longValue;
                                                str4 = zzc;
                                                try {
                                                    zzo(str, zzc, zzv, j14, z3, j10, j11, j12, zzcbr.zzs(), zzcbr.zzu());
                                                    j9 = zzv;
                                                    j8 = zzz;
                                                    str2 = j14;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zzcduVar = this;
                                                    str2 = str;
                                                    str3 = str4;
                                                    try {
                                                        throw th;
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        String str7 = str6;
                                                        zzbzr.zzj("Failed to preload url " + str2 + " Exception: " + e.getMessage());
                                                        com.google.android.gms.ads.internal.zzt.zzo().zzt(e, "VideoStreamExoPlayerCache.preload");
                                                        release();
                                                        zzcduVar.zzg(str2, str3, str7, zzd(str7, e));
                                                        return false;
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                zzcduVar = this;
                                                str2 = str;
                                                str3 = zzc;
                                            }
                                        } else {
                                            j4 = intValue;
                                            j5 = longValue2;
                                            j7 = longValue;
                                            str4 = zzc;
                                            j8 = zzz;
                                            j9 = j13;
                                            str2 = intValue;
                                        }
                                        zzcduVar = (zzv > j8 ? 1 : (zzv == j8 ? 0 : -1));
                                        if (zzcduVar >= 0) {
                                            zzj(str, str4, j8);
                                        } else {
                                            try {
                                                zzcdu zzcduVar3 = this;
                                                str2 = str;
                                                str3 = str4;
                                                if (zzcduVar3.zze.zzw() < j4 || zzv <= 0) {
                                                    j6 = j7;
                                                    r12 = j9;
                                                    zzcduVar = zzcduVar3;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                throw th;
                                            }
                                        }
                                    } else {
                                        j4 = intValue;
                                        j5 = longValue2;
                                        str2 = str5;
                                        str3 = zzc;
                                        zzcduVar = zzcduVar2;
                                        j6 = longValue;
                                        r12 = j13;
                                    }
                                    try {
                                        try {
                                            zzcduVar.wait(j6);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            str6 = r12;
                                            throw th;
                                        }
                                    } catch (InterruptedException unused) {
                                        throw new IOException("Wait interrupted.");
                                    }
                                } else {
                                    throw new IOException("ExoPlayer was released during preloading.");
                                }
                            } else {
                                throw new IOException("Abort requested before buffering finished. ");
                            }
                        } else {
                            throw new IOException("Timeout reached. Limit: " + longValue2 + " ms");
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        str2 = str5;
                        str3 = zzc;
                        zzcduVar = zzcduVar2;
                    }
                }
                longValue = j6;
                zzcduVar2 = zzcduVar;
                str5 = str2;
                zzc = str3;
                intValue = j4;
                longValue2 = j5;
                j13 = r12;
            }
            return true;
        } catch (Exception e5) {
            e = e5;
            str2 = str5;
            str3 = zzc;
            zzcduVar = zzcduVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzv() {
        zzbzr.zzj("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final boolean zzw(String str, String[] strArr, zzcdd zzcddVar) {
        this.zzf = str;
        this.zzi = zzcddVar;
        String zzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i4 = 0; i4 < strArr.length; i4++) {
                uriArr[i4] = Uri.parse(strArr[i4]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcca zzccaVar = (zzcca) this.zzc.get();
            if (zzccaVar != null) {
                zzccaVar.zzt(zzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e4) {
            String message = e4.getMessage();
            zzbzr.zzj("Failed to preload url " + str + " Exception: " + message);
            com.google.android.gms.ads.internal.zzt.zzo().zzt(e4, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, zzc, Constants.IPC_BUNDLE_KEY_SEND_ERROR, zzd(Constants.IPC_BUNDLE_KEY_SEND_ERROR, e4));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzm(int i4) {
    }

    @Override // com.google.android.gms.internal.ads.zzcbq
    public final void zzD(int i4, int i5) {
    }
}
