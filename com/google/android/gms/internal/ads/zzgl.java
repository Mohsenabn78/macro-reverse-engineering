package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgl implements zzge {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzge zzc;
    @Nullable
    private zzge zzd;
    @Nullable
    private zzge zze;
    @Nullable
    private zzge zzf;
    @Nullable
    private zzge zzg;
    @Nullable
    private zzge zzh;
    @Nullable
    private zzge zzi;
    @Nullable
    private zzge zzj;
    @Nullable
    private zzge zzk;

    public zzgl(Context context, zzge zzgeVar) {
        this.zza = context.getApplicationContext();
        this.zzc = zzgeVar;
    }

    private final zzge zzg() {
        if (this.zze == null) {
            zzfx zzfxVar = new zzfx(this.zza);
            this.zze = zzfxVar;
            zzh(zzfxVar);
        }
        return this.zze;
    }

    private final void zzh(zzge zzgeVar) {
        for (int i4 = 0; i4 < this.zzb.size(); i4++) {
            zzgeVar.zzf((zzhg) this.zzb.get(i4));
        }
    }

    private static final void zzi(@Nullable zzge zzgeVar, zzhg zzhgVar) {
        if (zzgeVar != null) {
            zzgeVar.zzf(zzhgVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws IOException {
        zzge zzgeVar = this.zzk;
        zzgeVar.getClass();
        return zzgeVar.zza(bArr, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final long zzb(zzgj zzgjVar) throws IOException {
        boolean z3;
        zzge zzgeVar;
        if (this.zzk == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        String scheme = zzgjVar.zza.getScheme();
        Uri uri = zzgjVar.zza;
        int i4 = zzfj.zza;
        String scheme2 = uri.getScheme();
        if (!TextUtils.isEmpty(scheme2) && !"file".equals(scheme2)) {
            if ("asset".equals(scheme)) {
                this.zzk = zzg();
            } else if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
                if (this.zzf == null) {
                    zzgb zzgbVar = new zzgb(this.zza);
                    this.zzf = zzgbVar;
                    zzh(zzgbVar);
                }
                this.zzk = this.zzf;
            } else if ("rtmp".equals(scheme)) {
                if (this.zzg == null) {
                    try {
                        zzge zzgeVar2 = (zzge) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                        this.zzg = zzgeVar2;
                        zzh(zzgeVar2);
                    } catch (ClassNotFoundException unused) {
                        zzer.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (Exception e4) {
                        throw new RuntimeException("Error instantiating RTMP extension", e4);
                    }
                    if (this.zzg == null) {
                        this.zzg = this.zzc;
                    }
                }
                this.zzk = this.zzg;
            } else if ("udp".equals(scheme)) {
                if (this.zzh == null) {
                    zzhi zzhiVar = new zzhi(2000);
                    this.zzh = zzhiVar;
                    zzh(zzhiVar);
                }
                this.zzk = this.zzh;
            } else if ("data".equals(scheme)) {
                if (this.zzi == null) {
                    zzgc zzgcVar = new zzgc();
                    this.zzi = zzgcVar;
                    zzh(zzgcVar);
                }
                this.zzk = this.zzi;
            } else {
                if (!"rawresource".equals(scheme) && !"android.resource".equals(scheme)) {
                    zzgeVar = this.zzc;
                } else {
                    if (this.zzj == null) {
                        zzhe zzheVar = new zzhe(this.zza);
                        this.zzj = zzheVar;
                        zzh(zzheVar);
                    }
                    zzgeVar = this.zzj;
                }
                this.zzk = zzgeVar;
            }
        } else {
            String path = zzgjVar.zza.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                this.zzk = zzg();
            } else {
                if (this.zzd == null) {
                    zzgu zzguVar = new zzgu();
                    this.zzd = zzguVar;
                    zzh(zzguVar);
                }
                this.zzk = this.zzd;
            }
        }
        return this.zzk.zzb(zzgjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzge
    @Nullable
    public final Uri zzc() {
        zzge zzgeVar = this.zzk;
        if (zzgeVar == null) {
            return null;
        }
        return zzgeVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzd() throws IOException {
        zzge zzgeVar = this.zzk;
        if (zzgeVar != null) {
            try {
                zzgeVar.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final Map zze() {
        zzge zzgeVar = this.zzk;
        if (zzgeVar == null) {
            return Collections.emptyMap();
        }
        return zzgeVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzf(zzhg zzhgVar) {
        zzhgVar.getClass();
        this.zzc.zzf(zzhgVar);
        this.zzb.add(zzhgVar);
        zzi(this.zzd, zzhgVar);
        zzi(this.zze, zzhgVar);
        zzi(this.zzf, zzhgVar);
        zzi(this.zzg, zzhgVar);
        zzi(this.zzh, zzhgVar);
        zzi(this.zzi, zzhgVar);
        zzi(this.zzj, zzhgVar);
    }
}
