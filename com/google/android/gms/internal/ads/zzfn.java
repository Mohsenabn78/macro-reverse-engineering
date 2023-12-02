package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfn implements zzby {
    public static final Parcelable.Creator<zzfn> CREATOR = new zzfl();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzfn(String str, byte[] bArr, int i4, int i5) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i4;
        this.zzd = i5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfn.class == obj.getClass()) {
            zzfn zzfnVar = (zzfn) obj;
            if (this.zza.equals(zzfnVar.zza) && Arrays.equals(this.zzb, zzfnVar.zzb) && this.zzc == zzfnVar.zzc && this.zzd == zzfnVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        String sb;
        if (this.zzd == 23) {
            sb = Float.toString(ByteBuffer.wrap(this.zzb).getFloat());
        } else {
            byte[] bArr = this.zzb;
            int length = bArr.length;
            StringBuilder sb2 = new StringBuilder(length + length);
            for (int i4 = 0; i4 < bArr.length; i4++) {
                sb2.append(Character.forDigit((bArr[i4] >> 4) & 15, 16));
                sb2.append(Character.forDigit(bArr[i4] & Ascii.SI, 16));
            }
            sb = sb2.toString();
        }
        String str = this.zza;
        return "mdta: key=" + str + ", value=" + sb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfn(Parcel parcel, zzfm zzfmVar) {
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    @Override // com.google.android.gms.internal.ads.zzby
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
