package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnStoppedAdvertisingParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzlp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlp> CREATOR = new zzlq();
    @SafeParcelable.Field(getter = "getReason", id = 1)
    private int zza;

    private zzlp() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlp) {
            return Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(((zzlp) obj).zza));
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzlp(@SafeParcelable.Param(id = 1) int i4) {
        this.zza = i4;
    }
}
