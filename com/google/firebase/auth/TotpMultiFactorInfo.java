package com.google.firebase.auth;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaet;
import com.google.android.gms.internal.p002firebaseauthapi.zzwk;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "TotpMultiFactorInfoCreator")
/* loaded from: classes5.dex */
public class TotpMultiFactorInfo extends MultiFactorInfo {
    @NonNull
    public static final Parcelable.Creator<TotpMultiFactorInfo> CREATOR = new zzau();
    @SafeParcelable.Field(getter = "getUid", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f28944a;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f28945b;
    @SafeParcelable.Field(getter = "getEnrollmentTimestamp", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final long f28946c;
    @SafeParcelable.Field(getter = "getTotpInfo", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final zzaet f28947d;

    @SafeParcelable.Constructor
    public TotpMultiFactorInfo(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) long j4, @SafeParcelable.Param(id = 4) zzaet zzaetVar) {
        this.f28944a = Preconditions.checkNotEmpty(str);
        this.f28945b = str2;
        this.f28946c = j4;
        this.f28947d = (zzaet) Preconditions.checkNotNull(zzaetVar, "totpInfo cannot be null.");
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @androidx.annotation.Nullable
    public String getDisplayName() {
        return this.f28945b;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public long getEnrollmentTimestamp() {
        return this.f28946c;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @NonNull
    public String getFactorId() {
        return TotpMultiFactorGenerator.FACTOR_ID;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @NonNull
    public String getUid() {
        return this.f28944a;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @androidx.annotation.Nullable
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, TotpMultiFactorGenerator.FACTOR_ID);
            jSONObject.putOpt("uid", this.f28944a);
            jSONObject.putOpt("displayName", this.f28945b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f28946c));
            jSONObject.putOpt("totpInfo", this.f28947d);
            return jSONObject;
        } catch (JSONException e4) {
            throw new zzwk(e4);
        }
    }

    @Override // android.os.Parcelable
    @SuppressLint({"FirebaseUnknownNullness"})
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeLong(parcel, 3, getEnrollmentTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 4, this.f28947d, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
