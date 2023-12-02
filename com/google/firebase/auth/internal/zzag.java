package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "DefaultMultiFactorSessionCreator")
/* loaded from: classes5.dex */
public final class zzag extends MultiFactorSession {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    @Nullable
    @SafeParcelable.Field(getter = "getIdToken", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private String f28975a;
    @Nullable
    @SafeParcelable.Field(getter = "getPendingCredential", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private String f28976b;
    @Nullable
    @SafeParcelable.Field(getter = "getPhoneMultiFactorInfoList", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private List f28977c;
    @Nullable
    @SafeParcelable.Field(getter = "getTotpMultiFactorInfoList", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private List f28978d;
    @Nullable
    @SafeParcelable.Field(getter = "getFirebaseUser", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private zzx f28979e;

    private zzag() {
    }

    public static zzag zzb(String str, @Nullable zzx zzxVar) {
        Preconditions.checkNotEmpty(str);
        zzag zzagVar = new zzag();
        zzagVar.f28975a = str;
        zzagVar.f28979e = zzxVar;
        return zzagVar;
    }

    public static zzag zzc(List list, String str) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotEmpty(str);
        zzag zzagVar = new zzag();
        zzagVar.f28977c = new ArrayList();
        zzagVar.f28978d = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MultiFactorInfo multiFactorInfo = (MultiFactorInfo) it.next();
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                zzagVar.f28977c.add((PhoneMultiFactorInfo) multiFactorInfo);
            } else if (multiFactorInfo instanceof TotpMultiFactorInfo) {
                zzagVar.f28978d.add((TotpMultiFactorInfo) multiFactorInfo);
            } else {
                throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: ".concat(String.valueOf(multiFactorInfo.getFactorId())));
            }
        }
        zzagVar.f28976b = str;
        return zzagVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f28975a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f28976b, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.f28977c, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.f28978d, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f28979e, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzx zza() {
        return this.f28979e;
    }

    @Nullable
    public final String zzd() {
        return this.f28975a;
    }

    @Nullable
    public final String zze() {
        return this.f28976b;
    }

    public final boolean zzf() {
        if (this.f28975a != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzag(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) List list, @SafeParcelable.Param(id = 4) List list2, @SafeParcelable.Param(id = 5) zzx zzxVar) {
        this.f28975a = str;
        this.f28976b = str2;
        this.f28977c = list;
        this.f28978d = list2;
        this.f28979e = zzxVar;
    }
}
