package com.google.android.gms.internal.ads;

import android.app.Activity;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzeas extends zzebn {
    private final Activity zza;
    private final com.google.android.gms.ads.internal.overlay.zzl zzb;
    private final com.google.android.gms.ads.internal.util.zzbr zzc;
    private final String zzd;
    private final String zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeas(Activity activity, com.google.android.gms.ads.internal.overlay.zzl zzlVar, com.google.android.gms.ads.internal.util.zzbr zzbrVar, String str, String str2, zzear zzearVar) {
        this.zza = activity;
        this.zzb = zzlVar;
        this.zzc = zzbrVar;
        this.zzd = str;
        this.zze = str2;
    }

    public final boolean equals(Object obj) {
        com.google.android.gms.ads.internal.overlay.zzl zzlVar;
        com.google.android.gms.ads.internal.util.zzbr zzbrVar;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzebn) {
            zzebn zzebnVar = (zzebn) obj;
            if (this.zza.equals(zzebnVar.zza()) && ((zzlVar = this.zzb) != null ? zzlVar.equals(zzebnVar.zzb()) : zzebnVar.zzb() == null) && ((zzbrVar = this.zzc) != null ? zzbrVar.equals(zzebnVar.zzc()) : zzebnVar.zzc() == null) && ((str = this.zzd) != null ? str.equals(zzebnVar.zzd()) : zzebnVar.zzd() == null) && ((str2 = this.zze) != null ? str2.equals(zzebnVar.zze()) : zzebnVar.zze() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = this.zza.hashCode() ^ 1000003;
        com.google.android.gms.ads.internal.overlay.zzl zzlVar = this.zzb;
        int i4 = 0;
        if (zzlVar == null) {
            hashCode = 0;
        } else {
            hashCode = zzlVar.hashCode();
        }
        int i5 = ((hashCode4 * 1000003) ^ hashCode) * 1000003;
        com.google.android.gms.ads.internal.util.zzbr zzbrVar = this.zzc;
        if (zzbrVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = zzbrVar.hashCode();
        }
        int i6 = (i5 ^ hashCode2) * 1000003;
        String str = this.zzd;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int i7 = (i6 ^ hashCode3) * 1000003;
        String str2 = this.zze;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return i7 ^ i4;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String str = this.zzd;
        String str2 = this.zze;
        return "OfflineUtilsParams{activity=" + obj + ", adOverlay=" + valueOf + ", workManagerUtil=" + valueOf2 + ", gwsQueryId=" + str + ", uri=" + str2 + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzebn
    public final Activity zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzebn
    @Nullable
    public final com.google.android.gms.ads.internal.overlay.zzl zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzebn
    @Nullable
    public final com.google.android.gms.ads.internal.util.zzbr zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzebn
    @Nullable
    public final String zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzebn
    @Nullable
    public final String zze() {
        return this.zze;
    }
}
