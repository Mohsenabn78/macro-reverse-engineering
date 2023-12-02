package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "SignInAccountCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zzd();
    @SafeParcelable.Field(defaultValue = "", id = 4)
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private String f19842a;
    @SafeParcelable.Field(getter = "getGoogleSignInAccount", id = 7)

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f19843b;
    @SafeParcelable.Field(defaultValue = "", id = 8)
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private String f19844c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public SignInAccount(@SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 7) GoogleSignInAccount googleSignInAccount, @SafeParcelable.Param(id = 8) String str2) {
        this.f19843b = googleSignInAccount;
        this.f19842a = Preconditions.checkNotEmpty(str, "8.3 and 8.4 SDKs require non-null email");
        this.f19844c = Preconditions.checkNotEmpty(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    @Nullable
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.f19843b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 4, this.f19842a, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f19843b, i4, false);
        SafeParcelWriter.writeString(parcel, 8, this.f19844c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
