package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Util;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ParcelablePayloadCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmc> CREATOR = new zzmd();
    @SafeParcelable.Field(getter = "getId", id = 1)
    private long zza;
    @SafeParcelable.Field(getter = "getType", id = 2)
    private int zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getBytes", id = 3)
    private byte[] zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getDataPfd", id = 4)
    private ParcelFileDescriptor zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getJavaFilePath", id = 5)
    private String zze;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getJavaFileSize", id = 6)
    private long zzf;
    @Nullable
    @SafeParcelable.Field(getter = "getStatusPfd", id = 7)
    private ParcelFileDescriptor zzg;
    @Nullable
    @SafeParcelable.Field(getter = "getUri", id = 8)
    private Uri zzh;
    @SafeParcelable.Field(defaultValue = "0", getter = "getOffset", id = 9)
    private long zzi;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIsSensitive", id = 10)
    private boolean zzj;
    @Nullable
    @SafeParcelable.Field(getter = "getSharedBytes", id = 11)
    private zzly zzk;
    @SafeParcelable.Field(defaultValue = "0", getter = "getPayloadSize", id = 12)
    private long zzl;
    @Nullable
    @SafeParcelable.Field(getter = "getFileName", id = 13)
    private String zzm;
    @Nullable
    @SafeParcelable.Field(getter = "getParentFolder", id = 14)
    private String zzn;

    private zzmc() {
        this.zzf = -1L;
        this.zzi = 0L;
        this.zzj = false;
        this.zzl = 0L;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmc) {
            zzmc zzmcVar = (zzmc) obj;
            if (Objects.equal(Long.valueOf(this.zza), Long.valueOf(zzmcVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzmcVar.zzb)) && Arrays.equals(this.zzc, zzmcVar.zzc) && Objects.equal(this.zzd, zzmcVar.zzd) && Objects.equal(this.zze, zzmcVar.zze) && Objects.equal(Long.valueOf(this.zzf), Long.valueOf(zzmcVar.zzf)) && Objects.equal(this.zzg, zzmcVar.zzg) && Objects.equal(this.zzh, zzmcVar.zzh) && Objects.equal(Long.valueOf(this.zzi), Long.valueOf(zzmcVar.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(zzmcVar.zzj)) && Objects.equal(this.zzk, zzmcVar.zzk) && Objects.equal(Long.valueOf(this.zzl), Long.valueOf(zzmcVar.zzl)) && Objects.equal(this.zzm, zzmcVar.zzm) && Objects.equal(this.zzn, zzmcVar.zzn)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, Long.valueOf(this.zzf), this.zzg, this.zzh, Long.valueOf(this.zzi), Boolean.valueOf(this.zzj), this.zzk, Long.valueOf(this.zzl), this.zzm, this.zzn);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i4, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i4, false);
        SafeParcelWriter.writeLong(parcel, 12, this.zzl);
        SafeParcelWriter.writeString(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final long zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzf;
    }

    @Nullable
    public final Uri zzd() {
        return this.zzh;
    }

    @Nullable
    public final ParcelFileDescriptor zze() {
        return this.zzd;
    }

    @Nullable
    public final ParcelFileDescriptor zzf() {
        return this.zzg;
    }

    @Nullable
    public final zzly zzg() {
        return this.zzk;
    }

    @Nullable
    public final String zzh() {
        return this.zze;
    }

    @Nullable
    public final byte[] zzv() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzmc(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) int i4, @Nullable @SafeParcelable.Param(id = 3) byte[] bArr, @Nullable @SafeParcelable.Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @Nullable @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) long j5, @Nullable @SafeParcelable.Param(id = 7) ParcelFileDescriptor parcelFileDescriptor2, @Nullable @SafeParcelable.Param(id = 8) Uri uri, @SafeParcelable.Param(id = 9) long j6, @SafeParcelable.Param(id = 10) boolean z3, @Nullable @SafeParcelable.Param(id = 11) zzly zzlyVar, @SafeParcelable.Param(id = 12) long j7, @Nullable @SafeParcelable.Param(id = 13) String str2, @Nullable @SafeParcelable.Param(id = 14) String str3) {
        this.zza = j4;
        this.zzb = i4;
        this.zzc = bArr;
        this.zzd = parcelFileDescriptor;
        this.zze = str;
        this.zzf = j5;
        this.zzg = parcelFileDescriptor2;
        this.zzh = uri;
        this.zzi = j6;
        this.zzj = z3;
        this.zzk = zzlyVar;
        this.zzl = j7;
        this.zzm = str2;
        this.zzn = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmc(zzmb zzmbVar) {
        this.zzf = -1L;
        this.zzi = 0L;
        this.zzj = false;
        this.zzl = 0L;
    }
}
