package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzelf implements zzeqx {
    public final com.google.android.gms.ads.internal.client.zzq zza;
    @Nullable
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    @Nullable
    public final String zzh;
    public final boolean zzi;

    public zzelf(com.google.android.gms.ads.internal.client.zzq zzqVar, @Nullable String str, boolean z3, String str2, float f4, int i4, int i5, @Nullable String str3, boolean z4) {
        Preconditions.checkNotNull(zzqVar, "the adSize must not be null");
        this.zza = zzqVar;
        this.zzb = str;
        this.zzc = z3;
        this.zzd = str2;
        this.zze = f4;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = str3;
        this.zzi = z4;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        boolean z3;
        boolean z4;
        String str;
        String str2;
        Bundle bundle = (Bundle) obj;
        if (this.zza.zze == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzfat.zzf(bundle, "smart_w", "full", z3);
        if (this.zza.zzb == -2) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzfat.zzf(bundle, "smart_h", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, z4);
        zzfat.zzg(bundle, "ene", true, this.zza.zzj);
        zzfat.zzf(bundle, "rafmt", "102", this.zza.zzm);
        zzfat.zzf(bundle, "rafmt", "103", this.zza.zzn);
        zzfat.zzf(bundle, "rafmt", "105", this.zza.zzo);
        zzfat.zzg(bundle, "inline_adaptive_slot", true, this.zzi);
        zzfat.zzg(bundle, "interscroller_slot", true, this.zza.zzo);
        zzfat.zzc(bundle, "format", this.zzb);
        zzfat.zzf(bundle, "fluid", "height", this.zzc);
        zzfat.zzf(bundle, "sz", this.zzd, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt(TranslateLanguage.SWAHILI, this.zzf);
        bundle.putInt("sh", this.zzg);
        zzfat.zzf(bundle, "sc", this.zzh, !TextUtils.isEmpty(str2));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        com.google.android.gms.ads.internal.client.zzq[] zzqVarArr = this.zza.zzg;
        if (zzqVarArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zza.zzb);
            bundle2.putInt("width", this.zza.zze);
            bundle2.putBoolean("is_fluid_height", this.zza.zzi);
            arrayList.add(bundle2);
        } else {
            for (com.google.android.gms.ads.internal.client.zzq zzqVar : zzqVarArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzqVar.zzi);
                bundle3.putInt("height", zzqVar.zzb);
                bundle3.putInt("width", zzqVar.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
