package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaee extends zzaen {
    public static final Parcelable.Creator<zzaee> CREATOR = new zzaed();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzaen[] zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaee(Parcel parcel) {
        super("CTOC");
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readByte() != 0;
        this.zzc = parcel.readByte() != 0;
        this.zzd = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.zze = new zzaen[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            this.zze[i5] = (zzaen) parcel.readParcelable(zzaen.class.getClassLoader());
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaee.class == obj.getClass()) {
            zzaee zzaeeVar = (zzaee) obj;
            if (this.zzb == zzaeeVar.zzb && this.zzc == zzaeeVar.zzc && zzfj.zzC(this.zza, zzaeeVar.zza) && Arrays.equals(this.zzd, zzaeeVar.zzd) && Arrays.equals(this.zze, zzaeeVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5 = (((this.zzb ? 1 : 0) + 527) * 31) + (this.zzc ? 1 : 0);
        String str = this.zza;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        return (i5 * 31) + i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zza);
        parcel.writeByte(this.zzb ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zzc ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.zzd);
        parcel.writeInt(this.zze.length);
        for (zzaen zzaenVar : this.zze) {
            parcel.writeParcelable(zzaenVar, 0);
        }
    }

    public zzaee(String str, boolean z3, boolean z4, String[] strArr, zzaen[] zzaenVarArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z3;
        this.zzc = z4;
        this.zzd = strArr;
        this.zze = zzaenVarArr;
    }
}
