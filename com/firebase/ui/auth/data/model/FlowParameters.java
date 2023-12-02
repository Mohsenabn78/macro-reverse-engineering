package com.firebase.ui.auth.data.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.firebase.ui.auth.AuthMethodPickerLayout;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.Preconditions;
import com.google.firebase.auth.ActionCodeSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class FlowParameters implements Parcelable {
    public static final Parcelable.Creator<FlowParameters> CREATOR = new a();
    public final boolean alwaysShowProviderChoice;
    @NonNull
    public final String appName;
    @Nullable
    public final AuthMethodPickerLayout authMethodPickerLayout;
    @Nullable
    public final AuthUI.IdpConfig defaultProvider;
    @Nullable
    public String emailLink;
    public final boolean enableAnonymousUpgrade;
    public final boolean enableCredentials;
    public final boolean enableHints;
    public final boolean lockOrientation;
    @DrawableRes
    public final int logoId;
    @Nullable
    public final ActionCodeSettings passwordResetSettings;
    @Nullable
    public final String privacyPolicyUrl;
    @NonNull
    public final List<AuthUI.IdpConfig> providers;
    @Nullable
    public final String termsOfServiceUrl;
    @StyleRes
    public final int themeId;

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<FlowParameters> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FlowParameters createFromParcel(Parcel parcel) {
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            String readString = parcel.readString();
            ArrayList createTypedArrayList = parcel.createTypedArrayList(AuthUI.IdpConfig.CREATOR);
            AuthUI.IdpConfig idpConfig = (AuthUI.IdpConfig) parcel.readParcelable(AuthUI.IdpConfig.class.getClassLoader());
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (parcel.readInt() != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (parcel.readInt() != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (parcel.readInt() != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (parcel.readInt() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            return new FlowParameters(readString, createTypedArrayList, idpConfig, readInt, readInt2, readString2, readString3, z3, z4, z5, z6, z7, parcel.readString(), (ActionCodeSettings) parcel.readParcelable(ActionCodeSettings.class.getClassLoader()), (AuthMethodPickerLayout) parcel.readParcelable(AuthMethodPickerLayout.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FlowParameters[] newArray(int i4) {
            return new FlowParameters[i4];
        }
    }

    public FlowParameters(@NonNull String str, @NonNull List<AuthUI.IdpConfig> list, @Nullable AuthUI.IdpConfig idpConfig, @StyleRes int i4, @DrawableRes int i5, @Nullable String str2, @Nullable String str3, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, @Nullable String str4, @Nullable ActionCodeSettings actionCodeSettings, @Nullable AuthMethodPickerLayout authMethodPickerLayout) {
        this.appName = (String) Preconditions.checkNotNull(str, "appName cannot be null", new Object[0]);
        this.providers = Collections.unmodifiableList((List) Preconditions.checkNotNull(list, "providers cannot be null", new Object[0]));
        this.defaultProvider = idpConfig;
        this.themeId = i4;
        this.logoId = i5;
        this.termsOfServiceUrl = str2;
        this.privacyPolicyUrl = str3;
        this.enableCredentials = z3;
        this.enableHints = z4;
        this.enableAnonymousUpgrade = z5;
        this.alwaysShowProviderChoice = z6;
        this.lockOrientation = z7;
        this.emailLink = str4;
        this.passwordResetSettings = actionCodeSettings;
        this.authMethodPickerLayout = authMethodPickerLayout;
    }

    public static FlowParameters fromIntent(Intent intent) {
        return (FlowParameters) intent.getParcelableExtra(ExtraConstants.FLOW_PARAMS);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AuthUI.IdpConfig getDefaultOrFirstProvider() {
        AuthUI.IdpConfig idpConfig = this.defaultProvider;
        if (idpConfig == null) {
            return this.providers.get(0);
        }
        return idpConfig;
    }

    public boolean isAnonymousUpgradeEnabled() {
        return this.enableAnonymousUpgrade;
    }

    public boolean isPlayServicesRequired() {
        if (!isProviderEnabled("google.com") && !this.enableHints && !this.enableCredentials) {
            return false;
        }
        return true;
    }

    public boolean isPrivacyPolicyUrlProvided() {
        return !TextUtils.isEmpty(this.privacyPolicyUrl);
    }

    public boolean isProviderEnabled(String str) {
        for (AuthUI.IdpConfig idpConfig : this.providers) {
            if (idpConfig.getProviderId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSingleProviderFlow() {
        if (this.providers.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean isTermsOfServiceUrlProvided() {
        return !TextUtils.isEmpty(this.termsOfServiceUrl);
    }

    public boolean shouldShowProviderChoice() {
        if (this.defaultProvider == null && (!isSingleProviderFlow() || this.alwaysShowProviderChoice)) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.appName);
        parcel.writeTypedList(this.providers);
        parcel.writeParcelable(this.defaultProvider, i4);
        parcel.writeInt(this.themeId);
        parcel.writeInt(this.logoId);
        parcel.writeString(this.termsOfServiceUrl);
        parcel.writeString(this.privacyPolicyUrl);
        parcel.writeInt(this.enableCredentials ? 1 : 0);
        parcel.writeInt(this.enableHints ? 1 : 0);
        parcel.writeInt(this.enableAnonymousUpgrade ? 1 : 0);
        parcel.writeInt(this.alwaysShowProviderChoice ? 1 : 0);
        parcel.writeInt(this.lockOrientation ? 1 : 0);
        parcel.writeString(this.emailLink);
        parcel.writeParcelable(this.passwordResetSettings, i4);
        parcel.writeParcelable(this.authMethodPickerLayout, i4);
    }
}
