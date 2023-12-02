package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzads implements zzby {
    public static final Parcelable.Creator<zzads> CREATOR = new zzadr();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzads(int i4, String str, String str2, int i5, int i6, int i7, int i8, byte[] bArr) {
        this.zza = i4;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = bArr;
    }

    public static zzads zzb(zzfa zzfaVar) {
        int zze = zzfaVar.zze();
        String zzx = zzfaVar.zzx(zzfaVar.zze(), zzfot.zza);
        String zzx2 = zzfaVar.zzx(zzfaVar.zze(), zzfot.zzc);
        int zze2 = zzfaVar.zze();
        int zze3 = zzfaVar.zze();
        int zze4 = zzfaVar.zze();
        int zze5 = zzfaVar.zze();
        int zze6 = zzfaVar.zze();
        byte[] bArr = new byte[zze6];
        zzfaVar.zzB(bArr, 0, zze6);
        return new zzads(zze, zzx, zzx2, zze2, zze3, zze4, zze5, bArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzads.class == obj.getClass()) {
            zzads zzadsVar = (zzads) obj;
            if (this.zza == zzadsVar.zza && this.zzb.equals(zzadsVar.zzb) && this.zzc.equals(zzadsVar.zzc) && this.zzd == zzadsVar.zzd && this.zze == zzadsVar.zze && this.zzf == zzadsVar.zzf && this.zzg == zzadsVar.zzg && Arrays.equals(this.zzh, zzadsVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + 527) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        return "Picture: mimeType=" + str + ", description=" + str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzby
    public final void zza(zzbt zzbtVar) {
        zzbtVar.zza(this.zzh, this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzads(Parcel parcel) {
        this.zza = parcel.readInt();
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zzb = readString;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = parcel.createByteArray();
    }
}
