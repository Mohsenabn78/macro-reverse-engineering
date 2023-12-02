package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "DefaultFirebaseUserMetadataCreator")
/* loaded from: classes5.dex */
public final class zzz implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    @SafeParcelable.Field(getter = "getLastSignInTimestamp", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final long f29112a;
    @SafeParcelable.Field(getter = "getCreationTimestamp", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final long f29113b;

    @SafeParcelable.Constructor
    public zzz(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) long j5) {
        this.f29112a = j4;
        this.f29113b = j5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final long getCreationTimestamp() {
        return this.f29113b;
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final long getLastSignInTimestamp() {
        return this.f29112a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f29112a);
        SafeParcelWriter.writeLong(parcel, 2, this.f29113b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.f29112a);
            jSONObject.put("creationTimestamp", this.f29113b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
