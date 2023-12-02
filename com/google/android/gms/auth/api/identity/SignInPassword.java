package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "SignInPasswordCreator")
/* loaded from: classes4.dex */
public class SignInPassword extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInPassword> CREATOR = new zzo();
    @SafeParcelable.Field(getter = "getId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f19784a;
    @SafeParcelable.Field(getter = "getPassword", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f19785b;

    @SafeParcelable.Constructor
    public SignInPassword(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.f19784a = Preconditions.checkNotEmpty(((String) Preconditions.checkNotNull(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.f19785b = Preconditions.checkNotEmpty(str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInPassword)) {
            return false;
        }
        SignInPassword signInPassword = (SignInPassword) obj;
        if (!Objects.equal(this.f19784a, signInPassword.f19784a) || !Objects.equal(this.f19785b, signInPassword.f19785b)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return this.f19784a;
    }

    public String getPassword() {
        return this.f19785b;
    }

    public int hashCode() {
        return Objects.hashCode(this.f19784a, this.f19785b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getPassword(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
