package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "DefaultAdditionalUserInfoCreator")
/* loaded from: classes5.dex */
public final class zzp implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzp> CREATOR = new zzq();
    @SafeParcelable.Field(getter = "getProviderId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f29080a;
    @SafeParcelable.Field(getter = "getRawUserInfo", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f29081b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f29082c;
    @SafeParcelable.Field(getter = "isNewUser", id = 3)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f29083d;

    public zzp(boolean z3) {
        this.f29083d = z3;
        this.f29081b = null;
        this.f29080a = null;
        this.f29082c = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    @Nullable
    public final Map<String, Object> getProfile() {
        return this.f29082c;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    @Nullable
    public final String getProviderId() {
        return this.f29080a;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    @Nullable
    public final String getUsername() {
        if ("github.com".equals(this.f29080a)) {
            return (String) this.f29082c.get(FirebaseAnalytics.Event.LOGIN);
        }
        if ("twitter.com".equals(this.f29080a)) {
            return (String) this.f29082c.get(FirebaseAnalytics.Param.SCREEN_NAME);
        }
        return null;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final boolean isNewUser() {
        return this.f29083d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f29080a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f29081b, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f29083d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzp(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) boolean z3) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.f29080a = str;
        this.f29081b = str2;
        this.f29082c = zzbb.c(str2);
        this.f29083d = z3;
    }
}
