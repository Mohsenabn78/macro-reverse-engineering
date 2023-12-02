package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzady extends zzaen {
    public static final Parcelable.Creator<zzady> CREATOR = new zzadx();
    public final String zza;
    @Nullable
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzady(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzady.class == obj.getClass()) {
            zzady zzadyVar = (zzady) obj;
            if (this.zzc == zzadyVar.zzc && zzfj.zzC(this.zza, zzadyVar.zza) && zzfj.zzC(this.zzb, zzadyVar.zzb) && Arrays.equals(this.zzd, zzadyVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5 = this.zzc + 527;
        String str = this.zza;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = i5 * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return ((((i7 + i4) * 31) + i6) * 31) + Arrays.hashCode(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        return str + ": mimeType=" + str2 + ", description=" + str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaen, com.google.android.gms.internal.ads.zzby
    public final void zza(zzbt zzbtVar) {
        zzbtVar.zza(this.zzd, this.zzc);
    }

    public zzady(String str, @Nullable String str2, int i4, byte[] bArr) {
        super("APIC");
        this.zza = str;
        this.zzb = str2;
        this.zzc = i4;
        this.zzd = bArr;
    }
}
