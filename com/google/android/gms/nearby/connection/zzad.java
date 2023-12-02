package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "WifiLanConnectivityInfoCreator")
/* loaded from: classes4.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();
    @Nullable
    @SafeParcelable.Field(getter = "getPort", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f22227a;
    @Nullable
    @SafeParcelable.Field(getter = "getIpAddress", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22228b;
    @Nullable
    @SafeParcelable.Field(getter = "getBssid", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f22229c;
    @Nullable
    @SafeParcelable.Field(getter = "getActions", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f22230d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzad(@Nullable @SafeParcelable.Param(id = 1) byte[] bArr, @Nullable @SafeParcelable.Param(id = 2) byte[] bArr2, @Nullable @SafeParcelable.Param(id = 3) byte[] bArr3, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr4) {
        this.f22227a = bArr;
        this.f22228b = bArr2;
        this.f22229c = bArr3;
        this.f22230d = bArr4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzad) {
            zzad zzadVar = (zzad) obj;
            if (Arrays.equals(this.f22227a, zzadVar.f22227a) && Arrays.equals(this.f22228b, zzadVar.f22228b) && Arrays.equals(this.f22229c, zzadVar.f22229c) && Arrays.equals(this.f22230d, zzadVar.f22230d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22227a)), Integer.valueOf(Arrays.hashCode(this.f22228b)), Integer.valueOf(Arrays.hashCode(this.f22229c)), Integer.valueOf(Arrays.hashCode(this.f22230d)));
    }

    public final String toString() {
        return String.format("WifiLanConnectivityInfo:<wifiLanPort hash: %s>, <wifiLanIp hash: %s>, <BSSID hash: %s>, <actions hash: %s>", Integer.valueOf(Arrays.hashCode(this.f22227a)), Integer.valueOf(Arrays.hashCode(this.f22228b)), Integer.valueOf(Arrays.hashCode(this.f22229c)), Integer.valueOf(Arrays.hashCode(this.f22230d)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        byte[] bArr4 = this.f22227a;
        byte[] bArr5 = null;
        if (bArr4 == null) {
            bArr = null;
        } else {
            bArr = (byte[]) bArr4.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 1, bArr, false);
        byte[] bArr6 = this.f22228b;
        if (bArr6 == null) {
            bArr2 = null;
        } else {
            bArr2 = (byte[]) bArr6.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr2, false);
        byte[] bArr7 = this.f22229c;
        if (bArr7 == null) {
            bArr3 = null;
        } else {
            bArr3 = (byte[]) bArr7.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 3, bArr3, false);
        byte[] bArr8 = this.f22230d;
        if (bArr8 != null) {
            bArr5 = (byte[]) bArr8.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 4, bArr5, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
