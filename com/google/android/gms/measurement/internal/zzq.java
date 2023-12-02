package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1, 17, 20})
/* loaded from: classes4.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @Nullable
    @SafeParcelable.Field(id = 2)
    public final String zza;
    @Nullable
    @SafeParcelable.Field(id = 3)
    public final String zzb;
    @Nullable
    @SafeParcelable.Field(id = 4)
    public final String zzc;
    @Nullable
    @SafeParcelable.Field(id = 5)
    public final String zzd;
    @SafeParcelable.Field(id = 6)
    public final long zze;
    @SafeParcelable.Field(id = 7)
    public final long zzf;
    @Nullable
    @SafeParcelable.Field(id = 8)
    public final String zzg;
    @SafeParcelable.Field(defaultValue = "true", id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(id = 10)
    public final boolean zzi;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MIN_VALUE", id = 11)
    public final long zzj;
    @Nullable
    @SafeParcelable.Field(id = 12)
    public final String zzk;
    @SafeParcelable.Field(id = 13)
    @Deprecated
    public final long zzl;
    @SafeParcelable.Field(id = 14)
    public final long zzm;
    @SafeParcelable.Field(id = 15)
    public final int zzn;
    @SafeParcelable.Field(defaultValue = "true", id = 16)
    public final boolean zzo;
    @SafeParcelable.Field(id = 18)
    public final boolean zzp;
    @Nullable
    @SafeParcelable.Field(id = 19)
    public final String zzq;
    @Nullable
    @SafeParcelable.Field(id = 21)
    public final Boolean zzr;
    @SafeParcelable.Field(id = 22)
    public final long zzs;
    @Nullable
    @SafeParcelable.Field(id = 23)
    public final List zzt;
    @Nullable
    @SafeParcelable.Field(id = 24)
    public final String zzu;
    @SafeParcelable.Field(defaultValue = "", id = 25)
    public final String zzv;
    @SafeParcelable.Field(defaultValue = "", id = 26)
    public final String zzw;
    @Nullable
    @SafeParcelable.Field(id = 27)
    public final String zzx;
    @SafeParcelable.Field(defaultValue = "false", id = 28)
    public final boolean zzy;
    @SafeParcelable.Field(id = 29)
    public final long zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(@Nullable String str, @Nullable String str2, @Nullable String str3, long j4, @Nullable String str4, long j5, long j6, @Nullable String str5, boolean z3, boolean z4, @Nullable String str6, long j7, long j8, int i4, boolean z5, boolean z6, @Nullable String str7, @Nullable Boolean bool, long j9, @Nullable List list, @Nullable String str8, String str9, String str10, @Nullable String str11, boolean z7, long j10) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = true == TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j4;
        this.zzd = str4;
        this.zze = j5;
        this.zzf = j6;
        this.zzg = str5;
        this.zzh = z3;
        this.zzi = z4;
        this.zzk = str6;
        this.zzl = 0L;
        this.zzm = j8;
        this.zzn = i4;
        this.zzo = z5;
        this.zzp = z6;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j9;
        this.zzt = list;
        this.zzu = null;
        this.zzv = str9;
        this.zzw = str10;
        this.zzx = str11;
        this.zzy = z7;
        this.zzz = j10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzl);
        SafeParcelWriter.writeLong(parcel, 14, this.zzm);
        SafeParcelWriter.writeInt(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzp);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzr, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzs);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzt, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzv, false);
        SafeParcelWriter.writeString(parcel, 26, this.zzw, false);
        SafeParcelWriter.writeString(parcel, 27, this.zzx, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.zzy);
        SafeParcelWriter.writeLong(parcel, 29, this.zzz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzq(@Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) String str3, @Nullable @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) long j4, @SafeParcelable.Param(id = 7) long j5, @Nullable @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) boolean z3, @SafeParcelable.Param(id = 10) boolean z4, @SafeParcelable.Param(id = 11) long j6, @Nullable @SafeParcelable.Param(id = 12) String str6, @SafeParcelable.Param(id = 13) long j7, @SafeParcelable.Param(id = 14) long j8, @SafeParcelable.Param(id = 15) int i4, @SafeParcelable.Param(id = 16) boolean z5, @SafeParcelable.Param(id = 18) boolean z6, @Nullable @SafeParcelable.Param(id = 19) String str7, @Nullable @SafeParcelable.Param(id = 21) Boolean bool, @SafeParcelable.Param(id = 22) long j9, @Nullable @SafeParcelable.Param(id = 23) List list, @Nullable @SafeParcelable.Param(id = 24) String str8, @SafeParcelable.Param(id = 25) String str9, @SafeParcelable.Param(id = 26) String str10, @SafeParcelable.Param(id = 27) String str11, @SafeParcelable.Param(id = 28) boolean z7, @SafeParcelable.Param(id = 29) long j10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j6;
        this.zzd = str4;
        this.zze = j4;
        this.zzf = j5;
        this.zzg = str5;
        this.zzh = z3;
        this.zzi = z4;
        this.zzk = str6;
        this.zzl = j7;
        this.zzm = j8;
        this.zzn = i4;
        this.zzo = z5;
        this.zzp = z6;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j9;
        this.zzt = list;
        this.zzu = str8;
        this.zzv = str9;
        this.zzw = str10;
        this.zzx = str11;
        this.zzy = z7;
        this.zzz = j10;
    }
}
