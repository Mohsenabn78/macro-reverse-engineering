package com.firebase.ui.auth.data.model;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.util.ExtraConstants;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f17982a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17983b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17984c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17985d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri f17986e;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f17987a;

        /* renamed from: b  reason: collision with root package name */
        private String f17988b;

        /* renamed from: c  reason: collision with root package name */
        private String f17989c;

        /* renamed from: d  reason: collision with root package name */
        private String f17990d;

        /* renamed from: e  reason: collision with root package name */
        private Uri f17991e;

        public Builder(@NonNull String str, @Nullable String str2) {
            this.f17987a = str;
            this.f17988b = str2;
        }

        public User build() {
            return new User(this.f17987a, this.f17988b, this.f17989c, this.f17990d, this.f17991e, null);
        }

        public Builder setName(String str) {
            this.f17990d = str;
            return this;
        }

        public Builder setPhoneNumber(String str) {
            this.f17989c = str;
            return this;
        }

        public Builder setPhotoUri(Uri uri) {
            this.f17991e = uri;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<User> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public User createFromParcel(Parcel parcel) {
            return new User(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Uri) parcel.readParcelable(Uri.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public User[] newArray(int i4) {
            return new User[i4];
        }
    }

    /* synthetic */ User(String str, String str2, String str3, String str4, Uri uri, a aVar) {
        this(str, str2, str3, str4, uri);
    }

    public static User getUser(Intent intent) {
        return (User) intent.getParcelableExtra(ExtraConstants.USER);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.f17982a.equals(user.f17982a) && ((str = this.f17983b) != null ? str.equals(user.f17983b) : user.f17983b == null) && ((str2 = this.f17984c) != null ? str2.equals(user.f17984c) : user.f17984c == null) && ((str3 = this.f17985d) != null ? str3.equals(user.f17985d) : user.f17985d == null)) {
            Uri uri = this.f17986e;
            Uri uri2 = user.f17986e;
            if (uri == null) {
                if (uri2 == null) {
                    return true;
                }
            } else if (uri.equals(uri2)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public String getEmail() {
        return this.f17983b;
    }

    @Nullable
    public String getName() {
        return this.f17985d;
    }

    @Nullable
    public String getPhoneNumber() {
        return this.f17984c;
    }

    @Nullable
    public Uri getPhotoUri() {
        return this.f17986e;
    }

    @NonNull
    public String getProviderId() {
        return this.f17982a;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = this.f17982a.hashCode() * 31;
        String str = this.f17983b;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode4 + hashCode) * 31;
        String str2 = this.f17984c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.f17985d;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        Uri uri = this.f17986e;
        if (uri != null) {
            i4 = uri.hashCode();
        }
        return i7 + i4;
    }

    public String toString() {
        return "User{mProviderId='" + this.f17982a + "', mEmail='" + this.f17983b + "', mPhoneNumber='" + this.f17984c + "', mName='" + this.f17985d + "', mPhotoUri=" + this.f17986e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeString(this.f17982a);
        parcel.writeString(this.f17983b);
        parcel.writeString(this.f17984c);
        parcel.writeString(this.f17985d);
        parcel.writeParcelable(this.f17986e, i4);
    }

    private User(String str, String str2, String str3, String str4, Uri uri) {
        this.f17982a = str;
        this.f17983b = str2;
        this.f17984c = str3;
        this.f17985d = str4;
        this.f17986e = uri;
    }

    public static User getUser(Bundle bundle) {
        return (User) bundle.getParcelable(ExtraConstants.USER);
    }
}
