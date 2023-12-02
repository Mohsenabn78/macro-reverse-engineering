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
@SafeParcelable.Class(creator = "BluetoothConnectivityInfoCreator")
/* loaded from: classes4.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    @Nullable
    @SafeParcelable.Field(getter = "getBluetoothMacAddress", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f22238a;
    @Nullable
    @SafeParcelable.Field(getter = "getBluetoothUuid", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22239b;
    @Nullable
    @SafeParcelable.Field(getter = "getActions", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f22240c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzi(@Nullable @SafeParcelable.Param(id = 1) byte[] bArr, @Nullable @SafeParcelable.Param(id = 2) byte[] bArr2, @Nullable @SafeParcelable.Param(id = 3) byte[] bArr3) {
        this.f22238a = bArr;
        this.f22239b = bArr2;
        this.f22240c = bArr3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            if (Arrays.equals(this.f22238a, zziVar.f22238a) && Arrays.equals(this.f22239b, zziVar.f22239b) && Arrays.equals(this.f22240c, zziVar.f22240c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22238a)), Integer.valueOf(Arrays.hashCode(this.f22239b)), Integer.valueOf(Arrays.hashCode(this.f22240c)));
    }

    public final String toString() {
        Integer valueOf;
        Integer valueOf2;
        Object[] objArr = new Object[3];
        byte[] bArr = this.f22238a;
        Integer num = null;
        if (bArr == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(Arrays.hashCode(bArr));
        }
        objArr[0] = valueOf;
        byte[] bArr2 = this.f22239b;
        if (bArr2 == null) {
            valueOf2 = null;
        } else {
            valueOf2 = Integer.valueOf(Arrays.hashCode(bArr2));
        }
        objArr[1] = valueOf2;
        byte[] bArr3 = this.f22240c;
        if (bArr3 != null) {
            num = Integer.valueOf(Arrays.hashCode(bArr3));
        }
        objArr[2] = num;
        return String.format("BluetoothConnectivityInfo:<bluetoothMacAddress hash: %s, bluetoothUuid hash: %s, actions hash: %s>", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        byte[] bArr;
        byte[] bArr2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        byte[] bArr3 = this.f22238a;
        byte[] bArr4 = null;
        if (bArr3 == null) {
            bArr = null;
        } else {
            bArr = (byte[]) bArr3.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 1, bArr, false);
        byte[] bArr5 = this.f22239b;
        if (bArr5 == null) {
            bArr2 = null;
        } else {
            bArr2 = (byte[]) bArr5.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr2, false);
        byte[] bArr6 = this.f22240c;
        if (bArr6 != null) {
            bArr4 = (byte[]) bArr6.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 3, bArr4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
