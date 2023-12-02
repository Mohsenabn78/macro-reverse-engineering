package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "UwbAddressParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzqt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqt> CREATOR = new zzqu();
    @SafeParcelable.Field(getter = "getAddress", id = 1)
    private byte[] zza;
    @SafeParcelable.Field(getter = "getStatusCode", id = 2)
    private int zzb;

    private zzqt() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqt) {
            zzqt zzqtVar = (zzqt) obj;
            if (Arrays.equals(this.zza, zzqtVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzqtVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), Integer.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final byte[] zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzqt(zzqs zzqsVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzqt(@SafeParcelable.Param(id = 1) byte[] bArr, @SafeParcelable.Param(id = 2) int i4) {
        this.zza = bArr;
        this.zzb = i4;
    }
}
