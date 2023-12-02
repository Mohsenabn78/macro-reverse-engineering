package com.firebase.ui.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AuthMethodPickerLayout implements Parcelable {
    public static final Parcelable.Creator<AuthMethodPickerLayout> CREATOR = new a();
    @LayoutRes

    /* renamed from: a  reason: collision with root package name */
    private int f17909a;
    @IdRes

    /* renamed from: b  reason: collision with root package name */
    private int f17910b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Integer> f17911c;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Integer> f17912a;

        /* renamed from: b  reason: collision with root package name */
        private AuthMethodPickerLayout f17913b;

        public Builder(@LayoutRes int i4) {
            AuthMethodPickerLayout authMethodPickerLayout = new AuthMethodPickerLayout((a) null);
            this.f17913b = authMethodPickerLayout;
            authMethodPickerLayout.f17909a = i4;
            this.f17912a = new HashMap();
        }

        public AuthMethodPickerLayout build() {
            if (!this.f17912a.isEmpty()) {
                for (String str : this.f17912a.keySet()) {
                    if (!AuthUI.SUPPORTED_PROVIDERS.contains(str) && !AuthUI.SUPPORTED_OAUTH_PROVIDERS.contains(str)) {
                        throw new IllegalArgumentException("Unknown provider: " + str);
                    }
                }
                this.f17913b.f17911c = this.f17912a;
                return this.f17913b;
            }
            throw new IllegalArgumentException("Must configure at least one button.");
        }

        public Builder setAnonymousButtonId(@IdRes int i4) {
            this.f17912a.put(AuthUI.ANONYMOUS_PROVIDER, Integer.valueOf(i4));
            return this;
        }

        public Builder setAppleButtonId(@IdRes int i4) {
            this.f17912a.put(AuthUI.APPLE_PROVIDER, Integer.valueOf(i4));
            return this;
        }

        public Builder setEmailButtonId(@IdRes int i4) {
            this.f17912a.put("password", Integer.valueOf(i4));
            return this;
        }

        public Builder setFacebookButtonId(@IdRes int i4) {
            this.f17912a.put("facebook.com", Integer.valueOf(i4));
            return this;
        }

        public Builder setGithubButtonId(@IdRes int i4) {
            this.f17912a.put("github.com", Integer.valueOf(i4));
            return this;
        }

        public Builder setGoogleButtonId(@IdRes int i4) {
            this.f17912a.put("google.com", Integer.valueOf(i4));
            return this;
        }

        public Builder setMicrosoftButtonId(@IdRes int i4) {
            this.f17912a.put(AuthUI.MICROSOFT_PROVIDER, Integer.valueOf(i4));
            return this;
        }

        public Builder setPhoneButtonId(@IdRes int i4) {
            this.f17912a.put("phone", Integer.valueOf(i4));
            return this;
        }

        public Builder setTosAndPrivacyPolicyId(@IdRes int i4) {
            this.f17913b.f17910b = i4;
            return this;
        }

        public Builder setTwitterButtonId(@IdRes int i4) {
            this.f17912a.put("twitter.com", Integer.valueOf(i4));
            return this;
        }

        public Builder setYahooButtonId(@IdRes int i4) {
            this.f17912a.put(AuthUI.YAHOO_PROVIDER, Integer.valueOf(i4));
            return this;
        }
    }

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<AuthMethodPickerLayout> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AuthMethodPickerLayout createFromParcel(Parcel parcel) {
            return new AuthMethodPickerLayout(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AuthMethodPickerLayout[] newArray(int i4) {
            return new AuthMethodPickerLayout[i4];
        }
    }

    /* synthetic */ AuthMethodPickerLayout(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @LayoutRes
    public int getMainLayout() {
        return this.f17909a;
    }

    public Map<String, Integer> getProvidersButton() {
        return this.f17911c;
    }

    @IdRes
    public int getTosPpView() {
        return this.f17910b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f17909a);
        parcel.writeInt(this.f17910b);
        Bundle bundle = new Bundle();
        for (String str : this.f17911c.keySet()) {
            bundle.putInt(str, this.f17911c.get(str).intValue());
        }
        parcel.writeBundle(bundle);
    }

    /* synthetic */ AuthMethodPickerLayout(a aVar) {
        this();
    }

    private AuthMethodPickerLayout() {
        this.f17910b = -1;
    }

    private AuthMethodPickerLayout(@NonNull Parcel parcel) {
        this.f17910b = -1;
        this.f17909a = parcel.readInt();
        this.f17910b = parcel.readInt();
        Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
        this.f17911c = new HashMap();
        for (String str : readBundle.keySet()) {
            this.f17911c.put(str, Integer.valueOf(readBundle.getInt(str)));
        }
    }
}
