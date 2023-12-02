package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "NearbyDeviceCreator")
/* loaded from: classes4.dex */
public final class zzni extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzni> CREATOR = new zznj();
    public static final zzni zza = new zzni(1, "", null);
    @SafeParcelable.VersionField(id = 1000)
    final int zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getHandle", id = 3)
    private final String zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getBluetoothAddress", id = 6)
    private final String zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzni(@SafeParcelable.Param(id = 1000) int i4, @Nullable @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 6) String str2) {
        this.zzb = ((Integer) Preconditions.checkNotNull(Integer.valueOf(i4))).intValue();
        this.zzc = str == null ? "" : str;
        this.zzd = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzni)) {
            return false;
        }
        zzni zzniVar = (zzni) obj;
        if (Objects.equal(this.zzc, zzniVar.zzc) && Objects.equal(this.zzd, zzniVar.zzd)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, this.zzd);
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zzd;
        return "NearbyDevice{handle=" + str + ", bluetoothAddress=" + str2 + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
