package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "MultiFactorInfoListCreator")
/* loaded from: classes5.dex */
public final class zzbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();
    @SafeParcelable.Field(getter = "getPhoneMultiFactorInfoList", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List f29020a;
    @SafeParcelable.Field(getter = "getTotpMultiFactorInfoList", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final List f29021b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbd(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) List list2) {
        this.f29020a = list == null ? new ArrayList() : list;
        this.f29021b = list2 == null ? new ArrayList() : list2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f29020a, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f29021b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo phoneMultiFactorInfo : this.f29020a) {
            arrayList.add(phoneMultiFactorInfo);
        }
        for (TotpMultiFactorInfo totpMultiFactorInfo : this.f29021b) {
            arrayList.add(totpMultiFactorInfo);
        }
        return arrayList;
    }
}
