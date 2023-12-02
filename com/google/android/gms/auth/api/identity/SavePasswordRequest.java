package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "SavePasswordRequestCreator")
/* loaded from: classes4.dex */
public class SavePasswordRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SavePasswordRequest> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getSignInPassword", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final SignInPassword f19772a;
    @Nullable
    @SafeParcelable.Field(getter = "getSessionId", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f19773b;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private SignInPassword f19774a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private String f19775b;

        public final SavePasswordRequest build() {
            return new SavePasswordRequest(this.f19774a, this.f19775b);
        }

        public final Builder setSignInPassword(@NonNull SignInPassword signInPassword) {
            this.f19774a = signInPassword;
            return this;
        }

        public final Builder zzg(@NonNull String str) {
            this.f19775b = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public SavePasswordRequest(@SafeParcelable.Param(id = 1) SignInPassword signInPassword, @Nullable @SafeParcelable.Param(id = 2) String str) {
        this.f19772a = (SignInPassword) Preconditions.checkNotNull(signInPassword);
        this.f19773b = str;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder zzc(SavePasswordRequest savePasswordRequest) {
        Preconditions.checkNotNull(savePasswordRequest);
        Builder signInPassword = builder().setSignInPassword(savePasswordRequest.getSignInPassword());
        String str = savePasswordRequest.f19773b;
        if (str != null) {
            signInPassword.zzg(str);
        }
        return signInPassword;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SavePasswordRequest)) {
            return false;
        }
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
        if (!Objects.equal(this.f19772a, savePasswordRequest.f19772a) || !Objects.equal(this.f19773b, savePasswordRequest.f19773b)) {
            return false;
        }
        return true;
    }

    public SignInPassword getSignInPassword() {
        return this.f19772a;
    }

    public int hashCode() {
        return Objects.hashCode(this.f19772a, this.f19773b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getSignInPassword(), i4, false);
        SafeParcelWriter.writeString(parcel, 2, this.f19773b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
