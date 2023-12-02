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
@SafeParcelable.Class(creator = "ConnectionsDeviceCreator")
/* loaded from: classes4.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    @SafeParcelable.Field(getter = "getEndpointId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f22248a;
    @Nullable
    @SafeParcelable.Field(getter = "getEndpointInfo", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22249b;
    @Nullable
    @SafeParcelable.Field(getter = "getBluetoothMacAddress", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f22250c;
    @Nullable
    @SafeParcelable.Field(id = 4)

    /* renamed from: d  reason: collision with root package name */
    final byte[] f22251d;
    @SafeParcelable.Field(defaultValue = "0", getter = "getInstanceType", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f22252e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) byte[] bArr, @Nullable @SafeParcelable.Param(id = 3) byte[] bArr2, @Nullable @SafeParcelable.Param(id = 4) byte[] bArr3, @SafeParcelable.Param(id = 5) int i4) {
        this.f22248a = str;
        this.f22249b = bArr;
        this.f22250c = bArr2;
        this.f22251d = bArr3;
        this.f22252e = i4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzo) {
            zzo zzoVar = (zzo) obj;
            if (Objects.equal(this.f22248a, zzoVar.f22248a) && Arrays.equals(this.f22249b, zzoVar.f22249b) && Arrays.equals(this.f22250c, zzoVar.f22250c) && Arrays.equals(this.f22251d, zzoVar.f22251d) && this.f22252e == zzoVar.f22252e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22248a, Integer.valueOf(Arrays.hashCode(this.f22249b)), Integer.valueOf(Arrays.hashCode(this.f22250c)), Integer.valueOf(Arrays.hashCode(this.f22251d)), Integer.valueOf(this.f22252e));
    }

    public final String toString() {
        String arrays;
        Object[] objArr = new Object[4];
        objArr[0] = this.f22248a;
        byte[] bArr = this.f22249b;
        String str = null;
        if (bArr == null) {
            arrays = null;
        } else {
            arrays = Arrays.toString(bArr);
        }
        objArr[1] = arrays;
        byte[] bArr2 = this.f22251d;
        if (bArr2 != null) {
            str = Arrays.toString(bArr2);
        }
        objArr[2] = str;
        objArr[3] = zzr.zza(this.f22252e);
        return String.format("ConnectionsDevice:<endpointId: %s, endpointInfo: %s, connectivityBytes: %s, instanceType : %s>", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        byte[] bArr;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f22248a, false);
        byte[] bArr2 = this.f22249b;
        byte[] bArr3 = null;
        if (bArr2 == null) {
            bArr = null;
        } else {
            bArr = (byte[]) bArr2.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        byte[] bArr4 = this.f22250c;
        if (bArr4 != null) {
            bArr3 = (byte[]) bArr4.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 3, bArr3, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22251d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f22252e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
