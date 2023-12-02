package com.google.android.gms.internal.ads;

import android.os.IBinder;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfms extends zzfnl {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfms(IBinder iBinder, boolean z3, String str, int i4, float f4, int i5, String str2, int i6, String str3, zzfmr zzfmrVar) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i4;
        this.zzd = f4;
        this.zze = i6;
        this.zzf = str3;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfnl) {
            zzfnl zzfnlVar = (zzfnl) obj;
            if (this.zza.equals(zzfnlVar.zze())) {
                zzfnlVar.zzi();
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfnlVar.zzg()) : zzfnlVar.zzg() == null) {
                    if (this.zzc == zzfnlVar.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzfnlVar.zza())) {
                        zzfnlVar.zzb();
                        zzfnlVar.zzh();
                        if (this.zze == zzfnlVar.zzd() && ((str = this.zzf) != null ? str.equals(zzfnlVar.zzf()) : zzfnlVar.zzf() == null)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int floatToIntBits = ((((((((((hashCode2 * 1000003) ^ 1237) * 1000003) ^ hashCode) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd)) * 583896283) ^ this.zze) * 1000003;
        String str2 = this.zzf;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return floatToIntBits ^ i4;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String str = this.zzb;
        int i4 = this.zzc;
        float f4 = this.zzd;
        int i5 = this.zze;
        String str2 = this.zzf;
        return "OverlayDisplayShowRequest{windowToken=" + obj + ", stableSessionToken=false, appId=" + str + ", layoutGravity=" + i4 + ", layoutVerticalMargin=" + f4 + ", displayMode=0, sessionToken=null, windowWidthPx=" + i5 + ", adFieldEnifd=" + str2 + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    public final float zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    public final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    public final int zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    public final IBinder zze() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    @Nullable
    public final String zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    @Nullable
    public final String zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    @Nullable
    public final String zzh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfnl
    public final boolean zzi() {
        return false;
    }
}
