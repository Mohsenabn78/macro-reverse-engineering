package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "IconParcelableCreator")
/* loaded from: classes4.dex */
public final class zziv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zziv> CREATOR = new zzfc();
    @SafeParcelable.Field(id = 1)
    public final String zza;
    @SafeParcelable.Field(id = 2)
    public final int zzb;
    @SafeParcelable.Field(id = 3)
    public final int zzc;

    @SafeParcelable.Constructor
    public zziv(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) int i5) {
        this.zza = str;
        this.zzb = i4;
        this.zzc = i5;
    }

    public final boolean equals(@Nullable Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (obj != null && zziv.class == obj.getClass()) {
            zziv zzivVar = (zziv) obj;
            if (this.zzb == zzivVar.zzb && this.zzc == zzivVar.zzc && ((str = this.zza) == (str2 = zzivVar.zza) || (str != null && str.equals(str2)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public final String toString() {
        return String.format(Locale.US, "WebIconParcelable{%dx%d - %s}", Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
