package com.firebase.ui.auth;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.auth.util.ExtraConstants;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* loaded from: classes3.dex */
public class IdpResponse implements Parcelable {
    public static final Parcelable.Creator<IdpResponse> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final User f17952a;

    /* renamed from: b  reason: collision with root package name */
    private final AuthCredential f17953b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17954c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17955d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17956e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseUiException f17957f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<IdpResponse> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IdpResponse createFromParcel(Parcel parcel) {
            User user = (User) parcel.readParcelable(User.class.getClassLoader());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z3 = true;
            if (parcel.readInt() != 1) {
                z3 = false;
            }
            return new IdpResponse(user, readString, readString2, z3, (FirebaseUiException) parcel.readSerializable(), (AuthCredential) parcel.readParcelable(AuthCredential.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IdpResponse[] newArray(int i4) {
            return new IdpResponse[i4];
        }
    }

    /* synthetic */ IdpResponse(User user, String str, String str2, AuthCredential authCredential, boolean z3, a aVar) {
        this(user, str, str2, authCredential, z3);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static IdpResponse from(@NonNull Exception exc) {
        if (exc instanceof FirebaseUiException) {
            return new IdpResponse((FirebaseUiException) exc);
        }
        if (exc instanceof FirebaseAuthAnonymousUpgradeException) {
            return ((FirebaseAuthAnonymousUpgradeException) exc).getResponse();
        }
        if (exc instanceof FirebaseUiUserCollisionException) {
            FirebaseUiUserCollisionException firebaseUiUserCollisionException = (FirebaseUiUserCollisionException) exc;
            return new IdpResponse(new User.Builder(firebaseUiUserCollisionException.getProviderId(), firebaseUiUserCollisionException.getEmail()).build(), (String) null, (String) null, false, new FirebaseUiException(firebaseUiUserCollisionException.getErrorCode(), firebaseUiUserCollisionException.getMessage()), firebaseUiUserCollisionException.getCredential());
        }
        FirebaseUiException firebaseUiException = new FirebaseUiException(0, exc.getMessage());
        firebaseUiException.setStackTrace(exc.getStackTrace());
        return new IdpResponse(firebaseUiException);
    }

    @Nullable
    public static IdpResponse fromResultIntent(@Nullable Intent intent) {
        if (intent != null) {
            return (IdpResponse) intent.getParcelableExtra(ExtraConstants.IDP_RESPONSE);
        }
        return null;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Intent getErrorIntent(@NonNull Exception exc) {
        return from(exc).toIntent();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        FirebaseUiException firebaseUiException;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IdpResponse idpResponse = (IdpResponse) obj;
        User user = this.f17952a;
        if (user != null ? user.equals(idpResponse.f17952a) : idpResponse.f17952a == null) {
            String str = this.f17954c;
            if (str != null ? str.equals(idpResponse.f17954c) : idpResponse.f17954c == null) {
                String str2 = this.f17955d;
                if (str2 != null ? str2.equals(idpResponse.f17955d) : idpResponse.f17955d == null) {
                    if (this.f17956e == idpResponse.f17956e && ((firebaseUiException = this.f17957f) != null ? firebaseUiException.equals(idpResponse.f17957f) : idpResponse.f17957f == null)) {
                        AuthCredential authCredential = this.f17953b;
                        if (authCredential == null) {
                            if (idpResponse.f17953b == null) {
                                return true;
                            }
                        } else if (authCredential.getProvider().equals(idpResponse.f17953b.getProvider())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public AuthCredential getCredentialForLinking() {
        return this.f17953b;
    }

    @Nullable
    public String getEmail() {
        User user = this.f17952a;
        if (user != null) {
            return user.getEmail();
        }
        return null;
    }

    @Nullable
    public FirebaseUiException getError() {
        return this.f17957f;
    }

    @Nullable
    public String getIdpSecret() {
        return this.f17955d;
    }

    @Nullable
    public String getIdpToken() {
        return this.f17954c;
    }

    @Nullable
    public String getPhoneNumber() {
        User user = this.f17952a;
        if (user != null) {
            return user.getPhoneNumber();
        }
        return null;
    }

    @Nullable
    public String getProviderType() {
        User user = this.f17952a;
        if (user != null) {
            return user.getProviderId();
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public User getUser() {
        return this.f17952a;
    }

    @Nullable
    public boolean hasCredentialForLinking() {
        if (this.f17953b != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        User user = this.f17952a;
        int i4 = 0;
        if (user == null) {
            hashCode = 0;
        } else {
            hashCode = user.hashCode();
        }
        int i5 = hashCode * 31;
        String str = this.f17954c;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str2 = this.f17955d;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i7 = (((i6 + hashCode3) * 31) + (this.f17956e ? 1 : 0)) * 31;
        FirebaseUiException firebaseUiException = this.f17957f;
        if (firebaseUiException == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = firebaseUiException.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        AuthCredential authCredential = this.f17953b;
        if (authCredential != null) {
            i4 = authCredential.getProvider().hashCode();
        }
        return i8 + i4;
    }

    public boolean isNewUser() {
        return this.f17956e;
    }

    public boolean isRecoverableErrorResponse() {
        if (this.f17953b == null && getEmail() == null) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isSuccessful() {
        if (this.f17957f == null) {
            return true;
        }
        return false;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Builder mutate() {
        if (isSuccessful()) {
            return new Builder(this);
        }
        throw new IllegalStateException("Cannot mutate an unsuccessful response.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Intent toIntent() {
        return new Intent().putExtra(ExtraConstants.IDP_RESPONSE, this);
    }

    public String toString() {
        return "IdpResponse{mUser=" + this.f17952a + ", mToken='" + this.f17954c + "', mSecret='" + this.f17955d + "', mIsNewUser='" + this.f17956e + "', mException=" + this.f17957f + ", mPendingCredential=" + this.f17953b + '}';
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public IdpResponse withResult(AuthResult authResult) {
        return mutate().setNewUser(authResult.getAdditionalUserInfo().isNewUser()).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.firebase.ui.auth.FirebaseUiException, java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.os.Parcel] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f17952a, i4);
        parcel.writeString(this.f17954c);
        parcel.writeString(this.f17955d);
        parcel.writeInt(this.f17956e ? 1 : 0);
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
                try {
                    objectOutputStream2.writeObject(this.f17957f);
                    ?? r02 = this.f17957f;
                    parcel.writeSerializable(r02);
                    objectOutputStream2.close();
                    objectOutputStream = r02;
                } catch (IOException unused) {
                    objectOutputStream = objectOutputStream2;
                    FirebaseUiException firebaseUiException = new FirebaseUiException(0, "Exception serialization error, forced wrapping. Original: " + this.f17957f + ", original cause: " + this.f17957f.getCause());
                    firebaseUiException.setStackTrace(this.f17957f.getStackTrace());
                    parcel.writeSerializable(firebaseUiException);
                    objectOutputStream = objectOutputStream;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                        objectOutputStream = objectOutputStream;
                    }
                    parcel.writeParcelable(this.f17953b, 0);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            }
            parcel.writeParcelable(this.f17953b, 0);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private User f17958a;

        /* renamed from: b  reason: collision with root package name */
        private AuthCredential f17959b;

        /* renamed from: c  reason: collision with root package name */
        private String f17960c;

        /* renamed from: d  reason: collision with root package name */
        private String f17961d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f17962e;

        public Builder() {
        }

        public Builder(@NonNull User user) {
            this.f17958a = user;
        }

        public IdpResponse build() {
            if (this.f17959b != null && this.f17958a == null) {
                return new IdpResponse(this.f17959b, new FirebaseUiException(5), null);
            }
            String providerId = this.f17958a.getProviderId();
            if (AuthUI.SOCIAL_PROVIDERS.contains(providerId) && TextUtils.isEmpty(this.f17960c)) {
                throw new IllegalStateException("Token cannot be null when using a non-email provider.");
            }
            if (providerId.equals("twitter.com") && TextUtils.isEmpty(this.f17961d)) {
                throw new IllegalStateException("Secret cannot be null when using the Twitter provider.");
            }
            return new IdpResponse(this.f17958a, this.f17960c, this.f17961d, this.f17959b, this.f17962e, (a) null);
        }

        public Builder setNewUser(boolean z3) {
            this.f17962e = z3;
            return this;
        }

        public Builder setPendingCredential(AuthCredential authCredential) {
            this.f17959b = authCredential;
            return this;
        }

        public Builder setSecret(String str) {
            this.f17961d = str;
            return this;
        }

        public Builder setToken(String str) {
            this.f17960c = str;
            return this;
        }

        public Builder(@NonNull IdpResponse idpResponse) {
            this.f17958a = idpResponse.f17952a;
            this.f17960c = idpResponse.f17954c;
            this.f17961d = idpResponse.f17955d;
            this.f17962e = idpResponse.f17956e;
            this.f17959b = idpResponse.f17953b;
        }
    }

    /* synthetic */ IdpResponse(User user, String str, String str2, boolean z3, FirebaseUiException firebaseUiException, AuthCredential authCredential, a aVar) {
        this(user, str, str2, z3, firebaseUiException, authCredential);
    }

    /* synthetic */ IdpResponse(AuthCredential authCredential, FirebaseUiException firebaseUiException, a aVar) {
        this(authCredential, firebaseUiException);
    }

    private IdpResponse(@NonNull FirebaseUiException firebaseUiException) {
        this((User) null, (String) null, (String) null, false, firebaseUiException, (AuthCredential) null);
    }

    private IdpResponse(@NonNull User user, @Nullable String str, @Nullable String str2, @Nullable AuthCredential authCredential, boolean z3) {
        this(user, str, str2, z3, (FirebaseUiException) null, authCredential);
    }

    private IdpResponse(AuthCredential authCredential, FirebaseUiException firebaseUiException) {
        this((User) null, (String) null, (String) null, false, firebaseUiException, authCredential);
    }

    private IdpResponse(User user, String str, String str2, boolean z3, FirebaseUiException firebaseUiException, AuthCredential authCredential) {
        this.f17952a = user;
        this.f17954c = str;
        this.f17955d = str2;
        this.f17956e = z3;
        this.f17957f = firebaseUiException;
        this.f17953b = authCredential;
    }
}
