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
@SafeParcelable.Class(creator = "UwbSenderInfoCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();
    @SafeParcelable.Field(getter = "getAddress", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private byte[] f22224a;
    @SafeParcelable.Field(getter = "getChannel", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private int f22225b;
    @SafeParcelable.Field(getter = "getPreambleIndex", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private int f22226c;

    private zzab() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzab) {
            zzab zzabVar = (zzab) obj;
            if (Arrays.equals(this.f22224a, zzabVar.f22224a) && Objects.equal(Integer.valueOf(this.f22225b), Integer.valueOf(zzabVar.f22225b)) && Objects.equal(Integer.valueOf(this.f22226c), Integer.valueOf(zzabVar.f22226c))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22224a)), Integer.valueOf(this.f22225b), Integer.valueOf(this.f22226c));
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f22224a);
        int i4 = this.f22225b;
        int i5 = this.f22226c;
        return "UwbSenderInfo{address=" + arrays + ", channel=" + i4 + ", preambleIndex=" + i5 + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, this.f22224a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f22225b);
        SafeParcelWriter.writeInt(parcel, 3, this.f22226c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzab(@SafeParcelable.Param(id = 1) byte[] bArr, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) int i5) {
        this.f22224a = bArr;
        this.f22225b = i4;
        this.f22226c = i5;
    }
}
