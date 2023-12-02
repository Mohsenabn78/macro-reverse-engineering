package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "CapabilityInfoParcelableCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzao extends AbstractSafeParcelable implements CapabilityInfo {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    @SafeParcelable.Field(getter = "getName", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f22673b;
    @SafeParcelable.Field(getter = "getNodeParcelables", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final List f22674c;

    /* renamed from: a  reason: collision with root package name */
    private final Object f22672a = new Object();
    @GuardedBy("lock")

    /* renamed from: d  reason: collision with root package name */
    private Set f22675d = null;

    @SafeParcelable.Constructor
    public zzao(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List list) {
        this.f22673b = str;
        this.f22674c = list;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzao.class != obj.getClass()) {
            return false;
        }
        zzao zzaoVar = (zzao) obj;
        String str = this.f22673b;
        if (str == null ? zzaoVar.f22673b != null : !str.equals(zzaoVar.f22673b)) {
            return false;
        }
        List list = this.f22674c;
        if (list == null ? zzaoVar.f22674c == null : list.equals(zzaoVar.f22674c)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final String getName() {
        return this.f22673b;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.f22672a) {
            if (this.f22675d == null) {
                this.f22675d = new HashSet(this.f22674c);
            }
            set = this.f22675d;
        }
        return set;
    }

    public final int hashCode() {
        int i4;
        String str = this.f22673b;
        int i5 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = (i4 + 31) * 31;
        List list = this.f22674c;
        if (list != null) {
            i5 = list.hashCode();
        }
        return i6 + i5;
    }

    public final String toString() {
        String str = this.f22673b;
        String valueOf = String.valueOf(this.f22674c);
        return "CapabilityInfo{" + str + ", " + valueOf + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f22673b, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.f22674c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
