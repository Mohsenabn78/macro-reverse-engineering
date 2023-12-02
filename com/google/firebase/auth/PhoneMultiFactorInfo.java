package com.google.firebase.auth;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzwk;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "PhoneMultiFactorInfoCreator")
/* loaded from: classes5.dex */
public class PhoneMultiFactorInfo extends MultiFactorInfo {
    @NonNull
    public static final Parcelable.Creator<PhoneMultiFactorInfo> CREATOR = new zzas();
    @SafeParcelable.Field(getter = "getUid", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f28936a;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f28937b;
    @SafeParcelable.Field(getter = "getEnrollmentTimestamp", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final long f28938c;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f28939d;

    @SafeParcelable.Constructor
    public PhoneMultiFactorInfo(@NonNull @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) long j4, @NonNull @SafeParcelable.Param(id = 4) String str3) {
        this.f28936a = Preconditions.checkNotEmpty(str);
        this.f28937b = str2;
        this.f28938c = j4;
        this.f28939d = Preconditions.checkNotEmpty(str3);
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @androidx.annotation.Nullable
    public String getDisplayName() {
        return this.f28937b;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public long getEnrollmentTimestamp() {
        return this.f28938c;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @NonNull
    public String getFactorId() {
        return "phone";
    }

    @NonNull
    public String getPhoneNumber() {
        return this.f28939d;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @NonNull
    public String getUid() {
        return this.f28936a;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    @androidx.annotation.Nullable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, "phone");
            jSONObject.putOpt("uid", this.f28936a);
            jSONObject.putOpt("displayName", this.f28937b);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.f28938c));
            jSONObject.putOpt(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.f28939d);
            return jSONObject;
        } catch (JSONException e4) {
            throw new zzwk(e4);
        }
    }

    @Override // android.os.Parcelable
    @SuppressLint({"FirebaseUnknownNullness"})
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeLong(parcel, 3, getEnrollmentTimestamp());
        SafeParcelWriter.writeString(parcel, 4, getPhoneNumber(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
