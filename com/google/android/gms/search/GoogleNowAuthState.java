package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@SafeParcelable.Class(creator = "GoogleNowAuthStateCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class GoogleNowAuthState extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
    @Nullable
    @SafeParcelable.Field(getter = "getAuthCode", id = 1)

    /* renamed from: a  reason: collision with root package name */
    String f22560a;
    @Nullable
    @SafeParcelable.Field(getter = "getAccessToken", id = 2)

    /* renamed from: b  reason: collision with root package name */
    String f22561b;
    @SafeParcelable.Field(getter = "getNextAllowedTimeMillis", id = 3)

    /* renamed from: c  reason: collision with root package name */
    long f22562c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GoogleNowAuthState(@SafeParcelable.Param(id = 1) @Nullable String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) long j4) {
        this.f22560a = str;
        this.f22561b = str2;
        this.f22562c = j4;
    }

    @androidx.annotation.Nullable
    public String getAccessToken() {
        return this.f22561b;
    }

    @androidx.annotation.Nullable
    public String getAuthCode() {
        return this.f22560a;
    }

    public long getNextAllowedTimeMillis() {
        return this.f22562c;
    }

    @NonNull
    public String toString() {
        String str = this.f22560a;
        String str2 = this.f22561b;
        long j4 = this.f22562c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74 + String.valueOf(str2).length());
        sb.append("mAuthCode = ");
        sb.append(str);
        sb.append("\nmAccessToken = ");
        sb.append(str2);
        sb.append("\nmNextAllowedTimeMillis = ");
        sb.append(j4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAuthCode(), false);
        SafeParcelWriter.writeString(parcel, 2, getAccessToken(), false);
        SafeParcelWriter.writeLong(parcel, 3, getNextAllowedTimeMillis());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
