package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "EmailAuthCredentialCreator")
/* loaded from: classes5.dex */
public class EmailAuthCredential extends AuthCredential {
    @NonNull
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getEmail", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f28865a;
    @Nullable
    @SafeParcelable.Field(getter = "getPassword", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private String f28866b;
    @Nullable
    @SafeParcelable.Field(getter = "getSignInLink", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f28867c;
    @Nullable
    @SafeParcelable.Field(getter = "getCachedState", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private String f28868d;
    @SafeParcelable.Field(getter = "isForLinking", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private boolean f28869e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public EmailAuthCredential(@SafeParcelable.Param(id = 1) String str, @Nullable @SafeParcelable.Param(id = 2) String str2, @Nullable @SafeParcelable.Param(id = 3) String str3, @Nullable @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) boolean z3) {
        this.f28865a = Preconditions.checkNotEmpty(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.f28866b = str2;
        this.f28867c = str3;
        this.f28868d = str4;
        this.f28869e = z3;
    }

    public static boolean zzi(@NonNull String str) {
        ActionCodeUrl parseLink;
        if (TextUtils.isEmpty(str) || (parseLink = ActionCodeUrl.parseLink(str)) == null || parseLink.getOperation() != 4) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public String getProvider() {
        return "password";
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public String getSignInMethod() {
        if (!TextUtils.isEmpty(this.f28866b)) {
            return "password";
        }
        return "emailLink";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f28865a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f28866b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f28867c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f28868d, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f28869e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.firebase.auth.AuthCredential
    @NonNull
    public final AuthCredential zza() {
        return new EmailAuthCredential(this.f28865a, this.f28866b, this.f28867c, this.f28868d, this.f28869e);
    }

    @NonNull
    public final EmailAuthCredential zzb(@NonNull FirebaseUser firebaseUser) {
        this.f28868d = firebaseUser.zzf();
        this.f28869e = true;
        return this;
    }

    @Nullable
    public final String zzc() {
        return this.f28868d;
    }

    @NonNull
    public final String zzd() {
        return this.f28865a;
    }

    @Nullable
    public final String zze() {
        return this.f28866b;
    }

    @Nullable
    public final String zzf() {
        return this.f28867c;
    }

    public final boolean zzg() {
        if (!TextUtils.isEmpty(this.f28867c)) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        return this.f28869e;
    }
}
