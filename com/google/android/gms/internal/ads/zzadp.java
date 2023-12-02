package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzadp implements zzby {
    public static final Parcelable.Creator<zzadp> CREATOR;
    private static final zzam zzf;
    private static final zzam zzg;
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzh;

    static {
        zzak zzakVar = new zzak();
        zzakVar.zzS("application/id3");
        zzf = zzakVar.zzY();
        zzak zzakVar2 = new zzak();
        zzakVar2.zzS("application/x-scte35");
        zzg = zzakVar2.zzY();
        CREATOR = new zzado();
    }

    public zzadp(String str, String str2, long j4, long j5, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j4;
        this.zzd = j5;
        this.zze = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadp.class == obj.getClass()) {
            zzadp zzadpVar = (zzadp) obj;
            if (this.zzc == zzadpVar.zzc && this.zzd == zzadpVar.zzd && zzfj.zzC(this.zza, zzadpVar.zza) && zzfj.zzC(this.zzb, zzadpVar.zzb) && Arrays.equals(this.zze, zzadpVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5 = this.zzh;
        if (i5 == 0) {
            String str = this.zza;
            int i6 = 0;
            if (str != null) {
                i4 = str.hashCode();
            } else {
                i4 = 0;
            }
            String str2 = this.zzb;
            if (str2 != null) {
                i6 = str2.hashCode();
            }
            long j4 = this.zzc;
            long j5 = this.zzd;
            int hashCode = ((((((((i4 + 527) * 31) + i6) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + Arrays.hashCode(this.zze);
            this.zzh = hashCode;
            return hashCode;
        }
        return i5;
    }

    public final String toString() {
        String str = this.zza;
        long j4 = this.zzd;
        long j5 = this.zzc;
        String str2 = this.zzb;
        return "EMSG: scheme=" + str + ", id=" + j4 + ", durationMs=" + j5 + ", value=" + str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadp(Parcel parcel) {
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.createByteArray();
    }

    @Override // com.google.android.gms.internal.ads.zzby
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
