package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcfv extends com.google.android.gms.ads.internal.client.zzdp {
    private final zzcca zza;
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    @Nullable
    private com.google.android.gms.ads.internal.client.zzdt zzf;
    private boolean zzg;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbfz zzn;
    private final Object zzb = new Object();
    private boolean zzh = true;

    public zzcfv(zzcca zzccaVar, float f4, boolean z3, boolean z4) {
        this.zza = zzccaVar;
        this.zzi = f4;
        this.zzc = z3;
        this.zzd = z4;
    }

    private final void zzw(final int i4, final int i5, final boolean z3, final boolean z4) {
        zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfu
            @Override // java.lang.Runnable
            public final void run() {
                zzcfv.this.zzd(i4, i5, z3, z4);
            }
        });
    }

    private final void zzx(String str, @Nullable Map map) {
        final HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("action", str);
        zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcft
            @Override // java.lang.Runnable
            public final void run() {
                zzcfv.this.zzr(hashMap);
            }
        });
    }

    public final void zzc(float f4, float f5, int i4, boolean z3, float f6) {
        boolean z4;
        boolean z5;
        int i5;
        synchronized (this.zzb) {
            z4 = true;
            if (f5 == this.zzi && f6 == this.zzk) {
                z4 = false;
            }
            this.zzi = f5;
            this.zzj = f4;
            z5 = this.zzh;
            this.zzh = z3;
            i5 = this.zze;
            this.zze = i4;
            float f7 = this.zzk;
            this.zzk = f6;
            if (Math.abs(f6 - f7) > 1.0E-4f) {
                this.zza.zzF().invalidate();
            }
        }
        if (z4) {
            try {
                zzbfz zzbfzVar = this.zzn;
                if (zzbfzVar != null) {
                    zzbfzVar.zze();
                }
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
            }
        }
        zzw(i5, i4, z5, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(int i4, int i5, boolean z3, boolean z4) {
        int i6;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        com.google.android.gms.ads.internal.client.zzdt zzdtVar;
        com.google.android.gms.ads.internal.client.zzdt zzdtVar2;
        com.google.android.gms.ads.internal.client.zzdt zzdtVar3;
        synchronized (this.zzb) {
            boolean z10 = this.zzg;
            boolean z11 = false;
            if (!z10 && i5 == 1) {
                i5 = 1;
                i6 = 1;
                z5 = true;
            } else {
                i6 = i5;
                z5 = false;
            }
            if (i4 != i5) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6 && i6 == 1) {
                z7 = true;
                i6 = 1;
            } else {
                z7 = false;
            }
            if (z6 && i6 == 2) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z6 && i6 == 3) {
                z9 = true;
            } else {
                z9 = false;
            }
            this.zzg = (z10 || z5) ? true : true;
            if (z5) {
                try {
                    com.google.android.gms.ads.internal.client.zzdt zzdtVar4 = this.zzf;
                    if (zzdtVar4 != null) {
                        zzdtVar4.zzi();
                    }
                } catch (RemoteException e4) {
                    zzbzr.zzl("#007 Could not call remote method.", e4);
                }
            }
            if (z7 && (zzdtVar3 = this.zzf) != null) {
                zzdtVar3.zzh();
            }
            if (z8 && (zzdtVar2 = this.zzf) != null) {
                zzdtVar2.zzg();
            }
            if (z9) {
                com.google.android.gms.ads.internal.client.zzdt zzdtVar5 = this.zzf;
                if (zzdtVar5 != null) {
                    zzdtVar5.zze();
                }
                this.zza.zzw();
            }
            if (z3 != z4 && (zzdtVar = this.zzf) != null) {
                zzdtVar.zzf(z4);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final float zze() {
        float f4;
        synchronized (this.zzb) {
            f4 = this.zzk;
        }
        return f4;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final float zzf() {
        float f4;
        synchronized (this.zzb) {
            f4 = this.zzj;
        }
        return f4;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final float zzg() {
        float f4;
        synchronized (this.zzb) {
            f4 = this.zzi;
        }
        return f4;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final int zzh() {
        int i4;
        synchronized (this.zzb) {
            i4 = this.zze;
        }
        return i4;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdt zzi() throws RemoteException {
        com.google.android.gms.ads.internal.client.zzdt zzdtVar;
        synchronized (this.zzb) {
            zzdtVar = this.zzf;
        }
        return zzdtVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzj(boolean z3) {
        String str;
        if (true != z3) {
            str = "unmute";
        } else {
            str = "mute";
        }
        zzx(str, null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzk() {
        zzx("pause", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzl() {
        zzx("play", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzm(@Nullable com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        synchronized (this.zzb) {
            this.zzf = zzdtVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzn() {
        zzx("stop", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final boolean zzo() {
        boolean z3;
        boolean zzp = zzp();
        synchronized (this.zzb) {
            z3 = false;
            if (!zzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z3 = true;
                    }
                } finally {
                }
            }
        }
        return z3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final boolean zzp() {
        boolean z3;
        synchronized (this.zzb) {
            z3 = false;
            if (this.zzc && this.zzl) {
                z3 = true;
            }
        }
        return z3;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final boolean zzq() {
        boolean z3;
        synchronized (this.zzb) {
            z3 = this.zzh;
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(Map map) {
        this.zza.zzd("pubVideoCmd", map);
    }

    public final void zzs(com.google.android.gms.ads.internal.client.zzfl zzflVar) {
        String str;
        String str2;
        String str3;
        boolean z3 = zzflVar.zza;
        boolean z4 = zzflVar.zzb;
        boolean z5 = zzflVar.zzc;
        synchronized (this.zzb) {
            this.zzl = z4;
            this.zzm = z5;
        }
        if (true != z3) {
            str = "0";
        } else {
            str = "1";
        }
        String str4 = str;
        if (true != z4) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        String str5 = str2;
        if (true != z5) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        zzx("initialState", CollectionUtils.mapOf("muteStart", str4, "customControlsRequested", str5, "clickToExpandRequested", str3));
    }

    public final void zzt(float f4) {
        synchronized (this.zzb) {
            this.zzj = f4;
        }
    }

    public final void zzu() {
        boolean z3;
        int i4;
        synchronized (this.zzb) {
            z3 = this.zzh;
            i4 = this.zze;
            this.zze = 3;
        }
        zzw(i4, 3, z3, z3);
    }

    public final void zzv(zzbfz zzbfzVar) {
        synchronized (this.zzb) {
            this.zzn = zzbfzVar;
        }
    }
}
