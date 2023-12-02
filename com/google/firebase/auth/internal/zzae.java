package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "DefaultMultiFactorResolverCreator")
/* loaded from: classes5.dex */
public final class zzae extends MultiFactorResolver {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    @SafeParcelable.Field(getter = "getPhoneMultiFactorInfoList", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List f28969a;
    @SafeParcelable.Field(getter = "getSession", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final zzag f28970b;
    @SafeParcelable.Field(getter = "getFirebaseAppName", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f28971c;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.auth.zze f28972d;
    @SafeParcelable.Field(getter = "getReauthUser", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final zzx f28973e;
    @SafeParcelable.Field(getter = "getTotpMultiFactorInfoList", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final List f28974f;

    @SafeParcelable.Constructor
    public zzae(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) zzag zzagVar, @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 4) com.google.firebase.auth.zze zzeVar, @Nullable @SafeParcelable.Param(id = 5) zzx zzxVar, @SafeParcelable.Param(id = 6) List list2) {
        this.f28969a = (List) Preconditions.checkNotNull(list);
        this.f28970b = (zzag) Preconditions.checkNotNull(zzagVar);
        this.f28971c = Preconditions.checkNotEmpty(str);
        this.f28972d = zzeVar;
        this.f28973e = zzxVar;
        this.f28974f = (List) Preconditions.checkNotNull(list2);
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.f28971c));
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo phoneMultiFactorInfo : this.f28969a) {
            arrayList.add(phoneMultiFactorInfo);
        }
        for (TotpMultiFactorInfo totpMultiFactorInfo : this.f28974f) {
            arrayList.add(totpMultiFactorInfo);
        }
        return arrayList;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final MultiFactorSession getSession() {
        return this.f28970b;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final Task<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.f28971c)).zzj(multiFactorAssertion, this.f28970b, this.f28973e).continueWithTask(new zzad(this));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f28969a, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f28970b, i4, false);
        SafeParcelWriter.writeString(parcel, 3, this.f28971c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f28972d, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f28973e, i4, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.f28974f, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
