package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "AppWearDetailsParcelableCreator")
/* loaded from: classes4.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();
    @SafeParcelable.Field(id = 1)
    public final boolean zza;
    @Nullable
    @SafeParcelable.Field(id = 2)
    public final List zzb;

    @SafeParcelable.Constructor
    public zzs(@SafeParcelable.Param(id = 1) boolean z3, @Nullable @SafeParcelable.Param(id = 2) List list) {
        this.zza = z3;
        this.zzb = list;
    }

    public final boolean equals(@Nullable Object obj) {
        List list;
        List list2;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzs.class == obj.getClass()) {
            zzs zzsVar = (zzs) obj;
            if (this.zza == zzsVar.zza && ((list = this.zzb) == (list2 = zzsVar.zzb) || (list != null && list.equals(list2)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        boolean z3 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return "AppWearDetailsParcelable{isWatchface=" + z3 + ", watchfaceCategories=" + valueOf + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
