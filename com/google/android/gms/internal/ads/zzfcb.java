package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "PoolConfigurationCreator")
/* loaded from: classes4.dex */
public final class zzfcb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfcb> CREATOR = new zzfcc();
    @Nullable
    public final Context zza;
    public final zzfby zzb;
    @SafeParcelable.Field(id = 2)
    public final int zzc;
    @SafeParcelable.Field(id = 3)
    public final int zzd;
    @SafeParcelable.Field(id = 4)
    public final int zze;
    @SafeParcelable.Field(id = 5)
    public final String zzf;
    public final int zzg;
    private final zzfby[] zzh;
    @SafeParcelable.Field(getter = "getFormatInt", id = 1)
    private final int zzi;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", id = 6)
    private final int zzj;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", id = 7)
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    @SafeParcelable.Constructor
    public zzfcb(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) int i7, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i8, @SafeParcelable.Param(id = 7) int i9) {
        zzfby[] values = zzfby.values();
        this.zzh = values;
        int[] zza = zzfbz.zza();
        this.zzl = zza;
        int[] zza2 = zzfca.zza();
        this.zzm = zza2;
        this.zza = null;
        this.zzi = i4;
        this.zzb = values[i4];
        this.zzc = i5;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = str;
        this.zzj = i8;
        this.zzg = zza[i8];
        this.zzk = i9;
        int i10 = zza2[i9];
    }

    @Nullable
    public static zzfcb zza(zzfby zzfbyVar, Context context) {
        if (zzfbyVar == zzfby.Rewarded) {
            return new zzfcb(context, zzfbyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgg)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgm)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgo)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgq), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgi), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgk));
        } else if (zzfbyVar == zzfby.Interstitial) {
            return new zzfcb(context, zzfbyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgh)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgn)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgp)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgr), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgj), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgl));
        } else if (zzfbyVar == zzfby.AppOpen) {
            return new zzfcb(context, zzfbyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgu)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgw)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgx)).intValue(), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgs), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgt), (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgv));
        } else {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzi);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzfcb(@Nullable Context context, zzfby zzfbyVar, int i4, int i5, int i6, String str, String str2, String str3) {
        int i7;
        this.zzh = zzfby.values();
        this.zzl = zzfbz.zza();
        this.zzm = zzfca.zza();
        this.zza = context;
        this.zzi = zzfbyVar.ordinal();
        this.zzb = zzfbyVar;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i7 = 1;
        } else {
            i7 = (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        }
        this.zzg = i7;
        this.zzj = i7 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
