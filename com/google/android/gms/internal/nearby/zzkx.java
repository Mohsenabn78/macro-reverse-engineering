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
@SafeParcelable.Class(creator = "OnConnectionResponseParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzkx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkx> CREATOR = new zzky();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getStatusCode", id = 2)
    private int zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getHandshakeData", id = 3)
    private byte[] zzc;

    private zzkx() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkx) {
            zzkx zzkxVar = (zzkx) obj;
            if (Objects.equal(this.zza, zzkxVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzkxVar.zzb)) && Arrays.equals(this.zzc, zzkxVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    @Nullable
    public final byte[] zzc() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzkx(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i4, @Nullable @SafeParcelable.Param(id = 3) byte[] bArr) {
        this.zza = str;
        this.zzb = i4;
        this.zzc = bArr;
    }
}
