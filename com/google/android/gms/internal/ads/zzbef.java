package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
/* loaded from: classes4.dex */
public final class zzbef extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbef> CREATOR = new zzbeg();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final boolean zzb;
    @SafeParcelable.Field(id = 3)
    public final int zzc;
    @SafeParcelable.Field(id = 4)
    public final boolean zzd;
    @SafeParcelable.Field(id = 5)
    public final int zze;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final com.google.android.gms.ads.internal.client.zzfl zzf;
    @SafeParcelable.Field(id = 7)
    public final boolean zzg;
    @SafeParcelable.Field(id = 8)
    public final int zzh;
    @SafeParcelable.Field(id = 9)
    public final int zzi;
    @SafeParcelable.Field(id = 10)
    public final boolean zzj;

    @SafeParcelable.Constructor
    public zzbef(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) int i5, @SafeParcelable.Param(id = 4) boolean z4, @SafeParcelable.Param(id = 5) int i6, @SafeParcelable.Param(id = 6) com.google.android.gms.ads.internal.client.zzfl zzflVar, @SafeParcelable.Param(id = 7) boolean z5, @SafeParcelable.Param(id = 8) int i7, @SafeParcelable.Param(id = 9) int i8, @SafeParcelable.Param(id = 10) boolean z6) {
        this.zza = i4;
        this.zzb = z3;
        this.zzc = i5;
        this.zzd = z4;
        this.zze = i6;
        this.zzf = zzflVar;
        this.zzg = z5;
        this.zzh = i7;
        this.zzj = z6;
        this.zzi = i8;
    }

    @NonNull
    public static NativeAdOptions zza(@Nullable zzbef zzbefVar) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzbefVar == null) {
            return builder.build();
        }
        int i4 = zzbefVar.zza;
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 == 4) {
                    builder.setRequestCustomMuteThisAd(zzbefVar.zzg);
                    builder.setMediaAspectRatio(zzbefVar.zzh);
                    builder.enableCustomClickGestureDirection(zzbefVar.zzi, zzbefVar.zzj);
                }
                builder.setReturnUrlsForImageAssets(zzbefVar.zzb);
                builder.setRequestMultipleImages(zzbefVar.zzd);
                return builder.build();
            }
            com.google.android.gms.ads.internal.client.zzfl zzflVar = zzbefVar.zzf;
            if (zzflVar != null) {
                builder.setVideoOptions(new VideoOptions(zzflVar));
            }
        }
        builder.setAdChoicesPlacement(zzbefVar.zze);
        builder.setReturnUrlsForImageAssets(zzbefVar.zzb);
        builder.setRequestMultipleImages(zzbefVar.zzd);
        return builder.build();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Deprecated
    public zzbef(@NonNull com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new com.google.android.gms.ads.internal.client.zzfl(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio(), 0, false);
    }
}
