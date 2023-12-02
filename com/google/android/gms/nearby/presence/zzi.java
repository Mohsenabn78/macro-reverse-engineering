package com.google.android.gms.nearby.presence;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.nearby.zzst;
import com.google.android.gms.nearby.connection.zzr;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@RequiresApi(26)
@SafeParcelable.Class(creator = "PresenceDeviceCreator")
/* loaded from: classes4.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();

    /* renamed from: o  reason: collision with root package name */
    private static final String[] f22491o = {"UNKNOWN", "PHONE", "TABLET", "DISPLAY", "LAPTOP", "TV", "WATCH", "CHROMEOS", "FOLDABLE", "AUTOMOTIVE"};
    @SafeParcelable.Field(getter = "getDeviceId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final long f22492a;
    @SafeParcelable.Field(getter = "getDeviceName", id = 2)
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final String f22493b;
    @SafeParcelable.Field(getter = "getDeviceType", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f22494c;
    @Nullable
    @SafeParcelable.Field(getter = "getDeviceImageUrl", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f22495d;
    @SafeParcelable.Field(getter = "getDiscoveryTimestampMillis", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final long f22496e;
    @SafeParcelable.Field(getter = "getEndpointId", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f22497f;
    @Nullable
    @SafeParcelable.Field(getter = "getEndpointInfo", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f22498g;
    @Nullable
    @SafeParcelable.Field(getter = "getBluetoothMacAddress", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f22499h;
    @SafeParcelable.Field(getter = "getActions", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private final List f22500i;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.nearby.presence.PresenceIdentity.IdentityType.PRIVATE", getter = "getIdentityType", id = 10)

    /* renamed from: j  reason: collision with root package name */
    private final int f22501j;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectivityBytes", id = 11)

    /* renamed from: k  reason: collision with root package name */
    private final byte[] f22502k;
    @Nullable
    @SafeParcelable.Field(getter = "getDataElements", id = 12)

    /* renamed from: l  reason: collision with root package name */
    private final zzc f22503l;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDiscoveryMedium", id = 13)

    /* renamed from: m  reason: collision with root package name */
    private final int f22504m;
    @SafeParcelable.Field(defaultValue = "0", getter = "getInstanceType", id = 14)

    /* renamed from: n  reason: collision with root package name */
    private final int f22505n;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i4, @Nullable @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) long j5, @SafeParcelable.Param(id = 6) String str3, @Nullable @SafeParcelable.Param(id = 7) byte[] bArr, @Nullable @SafeParcelable.Param(id = 8) byte[] bArr2, @SafeParcelable.Param(id = 9) List list, @SafeParcelable.Param(id = 10) int i5, @Nullable @SafeParcelable.Param(id = 11) byte[] bArr3, @Nullable @SafeParcelable.Param(id = 12) zzc zzcVar, @SafeParcelable.Param(id = 13) int i6, @SafeParcelable.Param(id = 14) int i7) {
        this.f22492a = j4;
        this.f22493b = str;
        this.f22494c = i4;
        this.f22495d = str2;
        this.f22496e = j5;
        this.f22497f = str3;
        this.f22498g = bArr;
        this.f22499h = bArr2;
        this.f22500i = list;
        this.f22501j = i5;
        this.f22502k = bArr3;
        this.f22503l = zzcVar;
        this.f22504m = i6;
        this.f22505n = i7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            if (Objects.equal(Long.valueOf(this.f22492a), Long.valueOf(zziVar.f22492a)) && Objects.equal(this.f22493b, zziVar.f22493b) && Objects.equal(Integer.valueOf(this.f22494c), Integer.valueOf(zziVar.f22494c)) && Objects.equal(this.f22495d, zziVar.f22495d) && Objects.equal(this.f22497f, zziVar.f22497f) && Arrays.equals(this.f22498g, zziVar.f22498g) && Arrays.equals(this.f22499h, zziVar.f22499h) && Objects.equal(this.f22500i, zziVar.f22500i) && Objects.equal(Integer.valueOf(this.f22501j), Integer.valueOf(zziVar.f22501j)) && Arrays.equals(this.f22502k, zziVar.f22502k) && Objects.equal(this.f22503l, zziVar.f22503l) && Objects.equal(Integer.valueOf(this.f22504m), Integer.valueOf(zziVar.f22504m)) && Objects.equal(Integer.valueOf(this.f22505n), Integer.valueOf(zziVar.f22505n))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f22492a), this.f22493b, Integer.valueOf(this.f22494c), this.f22495d, this.f22497f, Integer.valueOf(Arrays.hashCode(this.f22498g)), Integer.valueOf(Arrays.hashCode(this.f22499h)), this.f22500i, Integer.valueOf(this.f22501j), Integer.valueOf(Arrays.hashCode(this.f22502k)), this.f22503l, Integer.valueOf(this.f22504m), Integer.valueOf(this.f22505n));
    }

    public final String toString() {
        String arrays;
        Integer valueOf;
        Object[] objArr = new Object[13];
        char c4 = 0;
        objArr[0] = Long.valueOf(this.f22492a);
        switch (this.f22494c) {
            case 1:
                c4 = 1;
                break;
            case 2:
                c4 = 2;
                break;
            case 3:
                c4 = 3;
                break;
            case 4:
                c4 = 4;
                break;
            case 5:
                c4 = 5;
                break;
            case 6:
                c4 = 6;
                break;
            case 7:
                c4 = 7;
                break;
            case 8:
                c4 = '\b';
                break;
            case 9:
                c4 = '\t';
                break;
        }
        objArr[1] = f22491o[c4];
        objArr[2] = this.f22495d;
        objArr[3] = Long.valueOf(this.f22496e);
        objArr[4] = this.f22497f;
        byte[] bArr = this.f22498g;
        String str = null;
        if (bArr == null) {
            arrays = null;
        } else {
            arrays = Arrays.toString(bArr);
        }
        objArr[5] = arrays;
        byte[] bArr2 = this.f22499h;
        if (bArr2 == null) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(Arrays.hashCode(bArr2));
        }
        objArr[6] = valueOf;
        objArr[7] = this.f22500i;
        objArr[8] = Integer.valueOf(this.f22501j);
        byte[] bArr3 = this.f22502k;
        if (bArr3 != null) {
            str = Arrays.toString(bArr3);
        }
        objArr[9] = str;
        objArr[10] = this.f22503l;
        objArr[11] = Integer.valueOf(this.f22504m);
        objArr[12] = zzr.zza(this.f22505n);
        return String.format("PresenceDevice:<deviceId: %s, deviceType: %s, deviceImageUrl: %s, discoveryTimestampMillis: %s, endpointId: %s, endpointInfo: %s, bluetoothMacAddress hash: %s, actions: %s, identityType: %s, connectivityBytes hash: %s, dataElements: %s, discoveryMedium: %s, instance type %s>", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        byte[] bArr;
        zzst zzj;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f22492a);
        SafeParcelWriter.writeString(parcel, 2, this.f22493b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f22494c);
        SafeParcelWriter.writeString(parcel, 4, this.f22495d, false);
        SafeParcelWriter.writeLong(parcel, 5, this.f22496e);
        SafeParcelWriter.writeString(parcel, 6, this.f22497f, false);
        byte[] bArr2 = this.f22498g;
        byte[] bArr3 = null;
        if (bArr2 == null) {
            bArr = null;
        } else {
            bArr = (byte[]) bArr2.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 7, bArr, false);
        byte[] bArr4 = this.f22499h;
        if (bArr4 != null) {
            bArr3 = (byte[]) bArr4.clone();
        }
        SafeParcelWriter.writeByteArray(parcel, 8, bArr3, false);
        List list = this.f22500i;
        if (list == null) {
            zzj = zzst.zzk();
        } else {
            zzj = zzst.zzj(list);
        }
        SafeParcelWriter.writeTypedList(parcel, 9, zzj, false);
        SafeParcelWriter.writeInt(parcel, 10, this.f22501j);
        SafeParcelWriter.writeByteArray(parcel, 11, this.f22502k, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.f22503l, i4, false);
        SafeParcelWriter.writeInt(parcel, 13, this.f22504m);
        SafeParcelWriter.writeInt(parcel, 14, this.f22505n);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
