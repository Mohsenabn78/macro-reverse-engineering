package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

@ShowFirstParty
@SafeParcelable.Class(creator = "UserDataTypeCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR;

    /* renamed from: c  reason: collision with root package name */
    private static final zzp f21177c;

    /* renamed from: d  reason: collision with root package name */
    private static final zzp f21178d;

    /* renamed from: e  reason: collision with root package name */
    private static final zzp f21179e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<zzp> f21180f;
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f21181a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f21182b;

    static {
        zzp b4 = b("test_type", 1);
        f21177c = b4;
        zzp b5 = b("labeled_place", 6);
        f21178d = b5;
        zzp b6 = b("here_content", 7);
        f21179e = b6;
        f21180f = CollectionUtils.setOf(b4, b5, b6);
        CREATOR = new zzo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzp(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i4) {
        Preconditions.checkNotEmpty(str);
        this.f21181a = str;
        this.f21182b = i4;
    }

    private static zzp b(String str, int i4) {
        return new zzp(str, i4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp zzpVar = (zzp) obj;
        if (this.f21181a.equals(zzpVar.f21181a) && this.f21182b == zzpVar.f21182b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f21181a.hashCode();
    }

    public final String toString() {
        return this.f21181a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f21181a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f21182b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
