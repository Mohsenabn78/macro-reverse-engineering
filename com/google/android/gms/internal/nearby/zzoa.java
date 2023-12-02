package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "DlTdoaMeasurementParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzoa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzoa> CREATOR = new zzob();
    @SafeParcelable.Field(getter = "getMessageType", id = 1)
    private int zza;
    @SafeParcelable.Field(getter = "getMessageControl", id = 2)
    private int zzb;
    @SafeParcelable.Field(getter = "getBlockIndex", id = 3)
    private int zzc;
    @SafeParcelable.Field(getter = "getRoundIndex", id = 4)
    private int zzd;
    @SafeParcelable.Field(getter = "getNlos", id = 5)
    private int zze;
    @SafeParcelable.Field(getter = "getTxTimestamp", id = 6)
    private long zzf;
    @SafeParcelable.Field(getter = "getRxTimestamp", id = 7)
    private long zzg;
    @SafeParcelable.Field(getter = "getAnchroCfo", id = 8)
    private float zzh;
    @SafeParcelable.Field(getter = "getCfo", id = 9)
    private float zzi;
    @SafeParcelable.Field(getter = "getInitiatorReplyTime", id = 10)
    private long zzj;
    @SafeParcelable.Field(getter = "getResponderReplyTime", id = 11)
    private long zzk;
    @SafeParcelable.Field(getter = "getInitiatorResponderTof", id = 12)
    private int zzl;
    @SafeParcelable.Field(getter = "getAnchorLocation", id = 13)
    private byte[] zzm;
    @SafeParcelable.Field(getter = "getActiveRangingRounds", id = 14)
    private byte[] zzn;

    private zzoa() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzoa) {
            zzoa zzoaVar = (zzoa) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzoaVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzoaVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzoaVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzoaVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzoaVar.zze)) && Objects.equal(Long.valueOf(this.zzf), Long.valueOf(zzoaVar.zzf)) && Objects.equal(Long.valueOf(this.zzg), Long.valueOf(zzoaVar.zzg)) && Objects.equal(Float.valueOf(this.zzh), Float.valueOf(zzoaVar.zzh)) && Objects.equal(Float.valueOf(this.zzi), Float.valueOf(zzoaVar.zzi)) && Objects.equal(Long.valueOf(this.zzj), Long.valueOf(zzoaVar.zzj)) && Objects.equal(Long.valueOf(this.zzk), Long.valueOf(zzoaVar.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(zzoaVar.zzl)) && Arrays.equals(this.zzm, zzoaVar.zzm) && Arrays.equals(this.zzn, zzoaVar.zzn)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Long.valueOf(this.zzf), Long.valueOf(this.zzg), Float.valueOf(this.zzh), Float.valueOf(this.zzi), Long.valueOf(this.zzj), Long.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(Arrays.hashCode(this.zzm)), Integer.valueOf(Arrays.hashCode(this.zzn)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.writeLong(parcel, 7, this.zzg);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzh);
        SafeParcelWriter.writeFloat(parcel, 9, this.zzi);
        SafeParcelWriter.writeLong(parcel, 10, this.zzj);
        SafeParcelWriter.writeLong(parcel, 11, this.zzk);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.writeByteArray(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeByteArray(parcel, 14, this.zzn, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzoa(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) int i7, @SafeParcelable.Param(id = 5) int i8, @SafeParcelable.Param(id = 6) long j4, @SafeParcelable.Param(id = 7) long j5, @SafeParcelable.Param(id = 8) float f4, @SafeParcelable.Param(id = 9) float f5, @SafeParcelable.Param(id = 10) long j6, @SafeParcelable.Param(id = 11) long j7, @SafeParcelable.Param(id = 12) int i9, @SafeParcelable.Param(id = 13) byte[] bArr, @SafeParcelable.Param(id = 14) byte[] bArr2) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = i7;
        this.zze = i8;
        this.zzf = j4;
        this.zzg = j5;
        this.zzh = f4;
        this.zzi = f5;
        this.zzj = j6;
        this.zzk = j7;
        this.zzl = i9;
        this.zzm = bArr;
        this.zzn = bArr2;
    }
}
