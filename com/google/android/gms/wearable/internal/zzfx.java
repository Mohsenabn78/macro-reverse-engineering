package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "MessageEventParcelableCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzfx extends AbstractSafeParcelable implements MessageEvent {
    public static final Parcelable.Creator<zzfx> CREATOR = new zzfy();
    @SafeParcelable.Field(getter = "getRequestId", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final int f22775a;
    @SafeParcelable.Field(getter = "getPath", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final String f22776b;
    @SafeParcelable.Field(getter = "getData", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f22777c;
    @SafeParcelable.Field(getter = "getSourceNodeId", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private final String f22778d;

    @SafeParcelable.Constructor
    public zzfx(@SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) String str2) {
        this.f22775a = i4;
        this.f22776b = str;
        this.f22777c = bArr;
        this.f22778d = str2;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final byte[] getData() {
        return this.f22777c;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final String getPath() {
        return this.f22776b;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final int getRequestId() {
        return this.f22775a;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public final String getSourceNodeId() {
        return this.f22778d;
    }

    public final String toString() {
        Object valueOf;
        int i4 = this.f22775a;
        String str = this.f22776b;
        byte[] bArr = this.f22777c;
        if (bArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(bArr.length);
        }
        String obj = valueOf.toString();
        return "MessageEventParcelable[" + i4 + "," + str + ", size=" + obj + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f22775a);
        SafeParcelWriter.writeString(parcel, 3, this.f22776b, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22777c, false);
        SafeParcelWriter.writeString(parcel, 5, this.f22778d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
