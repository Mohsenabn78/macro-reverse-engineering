package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaec extends zzaen {
    public static final Parcelable.Creator<zzaec> CREATOR = new zzaeb();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzaen[] zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaec(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzg = new zzaen[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            this.zzg[i5] = (zzaen) parcel.readParcelable(zzaen.class.getClassLoader());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaen, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaec.class == obj.getClass()) {
            zzaec zzaecVar = (zzaec) obj;
            if (this.zzb == zzaecVar.zzb && this.zzc == zzaecVar.zzc && this.zzd == zzaecVar.zzd && this.zze == zzaecVar.zze && zzfj.zzC(this.zza, zzaecVar.zza) && Arrays.equals(this.zzg, zzaecVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5 = ((this.zzb + 527) * 31) + this.zzc;
        int i6 = (int) this.zzd;
        int i7 = (int) this.zze;
        String str = this.zza;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        return (((((i5 * 31) + i6) * 31) + i7) * 31) + i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        for (zzaen zzaenVar : this.zzg) {
            parcel.writeParcelable(zzaenVar, 0);
        }
    }

    public zzaec(String str, int i4, int i5, long j4, long j5, zzaen[] zzaenVarArr) {
        super("CHAP");
        this.zza = str;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = j4;
        this.zze = j5;
        this.zzg = zzaenVarArr;
    }
}
