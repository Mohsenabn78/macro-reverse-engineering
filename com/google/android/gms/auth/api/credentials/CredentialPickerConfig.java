package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
@SafeParcelable.Class(creator = "CredentialPickerConfigCreator")
/* loaded from: classes4.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zze();
    @SafeParcelable.Field(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    private final int f19701a;
    @SafeParcelable.Field(getter = "shouldShowAddAccountButton", id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19702b;
    @SafeParcelable.Field(getter = "shouldShowCancelButton", id = 2)

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19703c;
    @SafeParcelable.Field(getter = "isForNewAccount", id = 3)
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private final boolean f19704d;
    @SafeParcelable.Field(getter = "getPromptInternalId", id = 4)

    /* renamed from: e  reason: collision with root package name */
    private final int f19705e;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19706a = false;

        /* renamed from: b  reason: collision with root package name */
        private boolean f19707b = true;

        /* renamed from: c  reason: collision with root package name */
        private int f19708c = 1;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        @Deprecated
        public Builder setForNewAccount(boolean z3) {
            int i4;
            if (z3) {
                i4 = 3;
            } else {
                i4 = 1;
            }
            this.f19708c = i4;
            return this;
        }

        public Builder setPrompt(int i4) {
            this.f19708c = i4;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z3) {
            this.f19706a = z3;
            return this;
        }

        public Builder setShowCancelButton(boolean z3) {
            this.f19707b = z3;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public CredentialPickerConfig(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) boolean z4, @SafeParcelable.Param(id = 3) boolean z5, @SafeParcelable.Param(id = 4) int i5) {
        this.f19701a = i4;
        this.f19702b = z3;
        this.f19703c = z4;
        if (i4 < 2) {
            this.f19704d = z5;
            this.f19705e = z5 ? 3 : 1;
            return;
        }
        this.f19704d = i5 == 3;
        this.f19705e = i5;
    }

    @Deprecated
    public final boolean isForNewAccount() {
        if (this.f19705e == 3) {
            return true;
        }
        return false;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.f19702b;
    }

    public final boolean shouldShowCancelButton() {
        return this.f19703c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, shouldShowAddAccountButton());
        SafeParcelWriter.writeBoolean(parcel, 2, shouldShowCancelButton());
        SafeParcelWriter.writeBoolean(parcel, 3, isForNewAccount());
        SafeParcelWriter.writeInt(parcel, 4, this.f19705e);
        SafeParcelWriter.writeInt(parcel, 1000, this.f19701a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.f19706a, builder.f19707b, false, builder.f19708c);
    }
}
