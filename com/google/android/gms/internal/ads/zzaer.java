package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaer extends zzaen {
    public static final Parcelable.Creator<zzaer> CREATOR = new zzaeq();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzaer(int i4, int i5, int i6, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.zza = i4;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzaen, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaer.class == obj.getClass()) {
            zzaer zzaerVar = (zzaer) obj;
            if (this.zza == zzaerVar.zza && this.zzb == zzaerVar.zzb && this.zzc == zzaerVar.zzc && Arrays.equals(this.zzd, zzaerVar.zzd) && Arrays.equals(this.zze, zzaerVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeIntArray(this.zzd);
        parcel.writeIntArray(this.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaer(Parcel parcel) {
        super("MLLT");
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        int i4 = zzfj.zza;
        this.zzd = createIntArray;
        this.zze = parcel.createIntArray();
    }
}
