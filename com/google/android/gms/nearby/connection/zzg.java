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
@SafeParcelable.Class(creator = "BleConnectivityInfoCreator")
/* loaded from: classes4.dex */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzh();
    @Nullable
    @SafeParcelable.Field(getter = "getBleMacAddress", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f22233a;
    @Nullable
    @SafeParcelable.Field(getter = "getBleGattCharacteristic", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22234b;
    @Nullable
    @SafeParcelable.Field(getter = "getActions", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f22235c;
    @Nullable
    @SafeParcelable.Field(getter = "getPsm", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f22236d;
    @Nullable
    @SafeParcelable.Field(getter = "getDeviceToken", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f22237e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzg(@Nullable @SafeParcelable.Param(id = 1) byte[] bArr, @Nullable @SafeParcelable.Param(id = 2) byte[] bArr2, @Nullable @SafeParcelable.Param(id = 3) byte[] bArr3, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr4, @Nullable @SafeParcelable.Param(id = 5) byte[] bArr5) {
        this.f22233a = bArr;
        this.f22234b = bArr2;
        this.f22235c = bArr3;
        this.f22236d = bArr4;
        this.f22237e = bArr5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzg) {
            zzg zzgVar = (zzg) obj;
            if (Arrays.equals(this.f22233a, zzgVar.f22233a) && Arrays.equals(this.f22234b, zzgVar.f22234b) && Arrays.equals(this.f22235c, zzgVar.f22235c) && Arrays.equals(this.f22236d, zzgVar.f22236d) && Arrays.equals(this.f22237e, zzgVar.f22237e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22233a)), Integer.valueOf(Arrays.hashCode(this.f22234b)), Integer.valueOf(Arrays.hashCode(this.f22235c)), Integer.valueOf(Arrays.hashCode(this.f22236d)), Integer.valueOf(Arrays.hashCode(this.f22237e)));
    }

    public final String toString() {
        Integer valueOf;
        Integer valueOf2;
        Integer valueOf3;
        Integer valueOf4;
        Object[] objArr = new Object[5];
        byte[] bArr = this.f22233a;
        Integer num = null;
        if (bArr == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(Arrays.hashCode(bArr));
        }
        objArr[0] = valueOf;
        byte[] bArr2 = this.f22234b;
        if (bArr2 == null) {
            valueOf2 = null;
        } else {
            valueOf2 = Integer.valueOf(Arrays.hashCode(bArr2));
        }
        objArr[1] = valueOf2;
        byte[] bArr3 = this.f22235c;
        if (bArr3 == null) {
            valueOf3 = null;
        } else {
            valueOf3 = Integer.valueOf(Arrays.hashCode(bArr3));
        }
        objArr[2] = valueOf3;
        byte[] bArr4 = this.f22236d;
        if (bArr4 == null) {
            valueOf4 = null;
        } else {
            valueOf4 = Integer.valueOf(Arrays.hashCode(bArr4));
        }
        objArr[3] = valueOf4;
        byte[] bArr5 = this.f22237e;
        if (bArr5 != null) {
            num = Integer.valueOf(Arrays.hashCode(bArr5));
        }
        objArr[4] = num;
        return String.format("BleConnectivityInfo:<bleMacAddress hash: %s, bleGattCharacteristic hash: %s, actions hash: %s, psm hash: %s, deviceToken hash : %s>", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        byte[] bArr5 = this.f22233a;
        byte[] bArr6 = null;
        if (bArr5 == null) {
            bArr = null;
        } else {
            bArr = (byte[]) bArr5.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 1, bArr, false);
        byte[] bArr7 = this.f22234b;
        if (bArr7 == null) {
            bArr2 = null;
        } else {
            bArr2 = (byte[]) bArr7.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr2, false);
        byte[] bArr8 = this.f22235c;
        if (bArr8 == null) {
            bArr3 = null;
        } else {
            bArr3 = (byte[]) bArr8.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 3, bArr3, false);
        byte[] bArr9 = this.f22236d;
        if (bArr9 == null) {
            bArr4 = null;
        } else {
            bArr4 = (byte[]) bArr9.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 4, bArr4, false);
        byte[] bArr10 = this.f22237e;
        if (bArr10 != null) {
            bArr6 = (byte[]) bArr10.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 5, bArr6, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
