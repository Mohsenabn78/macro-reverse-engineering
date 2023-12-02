package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbz implements Parcelable {
    public static final Parcelable.Creator<zzbz> CREATOR = new zzbx();
    public final long zza;
    private final zzby[] zzb;

    public zzbz(long j4, zzby... zzbyVarArr) {
        this.zza = j4;
        this.zzb = zzbyVarArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbz.class == obj.getClass()) {
            zzbz zzbzVar = (zzbz) obj;
            if (Arrays.equals(this.zzb, zzbzVar.zzb) && this.zza == zzbzVar.zza) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.zza;
        return (Arrays.hashCode(this.zzb) * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        String str;
        String arrays = Arrays.toString(this.zzb);
        long j4 = this.zza;
        if (j4 == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j4;
        }
        return "entries=" + arrays + str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.zzb.length);
        for (zzby zzbyVar : this.zzb) {
            parcel.writeParcelable(zzbyVar, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzby zzb(int i4) {
        return this.zzb[i4];
    }

    public final zzbz zzc(zzby... zzbyVarArr) {
        int length = zzbyVarArr.length;
        if (length == 0) {
            return this;
        }
        long j4 = this.zza;
        zzby[] zzbyVarArr2 = this.zzb;
        int i4 = zzfj.zza;
        int length2 = zzbyVarArr2.length;
        Object[] copyOf = Arrays.copyOf(zzbyVarArr2, length2 + length);
        System.arraycopy(zzbyVarArr, 0, copyOf, length2, length);
        return new zzbz(j4, (zzby[]) copyOf);
    }

    public final zzbz zzd(@Nullable zzbz zzbzVar) {
        if (zzbzVar == null) {
            return this;
        }
        return zzc(zzbzVar.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbz(Parcel parcel) {
        this.zzb = new zzby[parcel.readInt()];
        int i4 = 0;
        while (true) {
            zzby[] zzbyVarArr = this.zzb;
            if (i4 < zzbyVarArr.length) {
                zzbyVarArr[i4] = (zzby) parcel.readParcelable(zzby.class.getClassLoader());
                i4++;
            } else {
                this.zza = parcel.readLong();
                return;
            }
        }
    }

    public zzbz(List list) {
        this(-9223372036854775807L, (zzby[]) list.toArray(new zzby[0]));
    }
}
