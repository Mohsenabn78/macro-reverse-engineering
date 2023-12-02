package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfq implements zzby {
    public static final Parcelable.Creator<zzfq> CREATOR = new zzfo();
    public final float zza;
    public final float zzb;

    public zzfq(@FloatRange(from = -90.0d, to = 90.0d) float f4, @FloatRange(from = -180.0d, to = 180.0d) float f5) {
        boolean z3 = false;
        if (f4 >= -90.0f && f4 <= 90.0f && f5 >= -180.0f && f5 <= 180.0f) {
            z3 = true;
        }
        zzdy.zze(z3, "Invalid latitude or longitude");
        this.zza = f4;
        this.zzb = f5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfq.class == obj.getClass()) {
            zzfq zzfqVar = (zzfq) obj;
            if (this.zza == zzfqVar.zza && this.zzb == zzfqVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + Float.valueOf(this.zzb).hashCode();
    }

    public final String toString() {
        float f4 = this.zza;
        float f5 = this.zzb;
        return "xyz: latitude=" + f4 + ", longitude=" + f5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.zza);
        parcel.writeFloat(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfq(Parcel parcel, zzfp zzfpVar) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzby
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
