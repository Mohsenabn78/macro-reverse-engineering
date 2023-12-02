package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "NodeParcelableCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzgm extends AbstractSafeParcelable implements Node {
    public static final Parcelable.Creator<zzgm> CREATOR = new zzgn();
    @SafeParcelable.Field(getter = "getId", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final String f22788a;
    @SafeParcelable.Field(getter = "getDisplayName", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final String f22789b;
    @SafeParcelable.Field(getter = "getHopCount", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final int f22790c;
    @SafeParcelable.Field(getter = "isNearby", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22791d;

    @SafeParcelable.Constructor
    public zzgm(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) boolean z3) {
        this.f22788a = str;
        this.f22789b = str2;
        this.f22790c = i4;
        this.f22791d = z3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgm)) {
            return false;
        }
        return ((zzgm) obj).f22788a.equals(this.f22788a);
    }

    @Override // com.google.android.gms.wearable.Node
    public final String getDisplayName() {
        return this.f22789b;
    }

    @Override // com.google.android.gms.wearable.Node
    public final String getId() {
        return this.f22788a;
    }

    public final int hashCode() {
        return this.f22788a.hashCode();
    }

    @Override // com.google.android.gms.wearable.Node
    public final boolean isNearby() {
        return this.f22791d;
    }

    public final String toString() {
        String str = this.f22789b;
        String str2 = this.f22788a;
        int i4 = this.f22790c;
        boolean z3 = this.f22791d;
        return "Node{" + str + ", id=" + str2 + ", hops=" + i4 + ", isNearby=" + z3 + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f22788a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22789b, false);
        SafeParcelWriter.writeInt(parcel, 4, this.f22790c);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f22791d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
