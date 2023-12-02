package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@SafeParcelable.Class(creator = "ActionCodeSettingsCreator")
/* loaded from: classes5.dex */
public class ActionCodeSettings extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getUrl", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f28841a;
    @SafeParcelable.Field(getter = "getIOSBundle", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f28842b;
    @SafeParcelable.Field(getter = "getIOSAppStoreId", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f28843c;
    @SafeParcelable.Field(getter = "getAndroidPackageName", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f28844d;
    @SafeParcelable.Field(getter = "getAndroidInstallApp", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final boolean f28845e;
    @Nullable
    @SafeParcelable.Field(getter = "getAndroidMinimumVersion", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f28846f;
    @SafeParcelable.Field(getter = "canHandleCodeInApp", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final boolean f28847g;
    @SafeParcelable.Field(getter = "getLocaleHeader", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private String f28848h;
    @SafeParcelable.Field(getter = "getRequestType", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private int f28849i;
    @SafeParcelable.Field(getter = "getDynamicLinkDomain", id = 10)

    /* renamed from: j  reason: collision with root package name */
    private String f28850j;

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f28851a;

        /* renamed from: b  reason: collision with root package name */
        private String f28852b;

        /* renamed from: c  reason: collision with root package name */
        private String f28853c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f28854d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f28855e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f28856f = false;

        /* renamed from: g  reason: collision with root package name */
        private String f28857g;

        private Builder() {
        }

        @NonNull
        public ActionCodeSettings build() {
            if (this.f28851a != null) {
                return new ActionCodeSettings(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        @NonNull
        @KeepForSdk
        public String getDynamicLinkDomain() {
            return this.f28857g;
        }

        @KeepForSdk
        public boolean getHandleCodeInApp() {
            return this.f28856f;
        }

        @Nullable
        @KeepForSdk
        public String getIOSBundleId() {
            return this.f28852b;
        }

        @NonNull
        @KeepForSdk
        public String getUrl() {
            return this.f28851a;
        }

        @NonNull
        public Builder setAndroidPackageName(@NonNull String str, boolean z3, @Nullable String str2) {
            this.f28853c = str;
            this.f28854d = z3;
            this.f28855e = str2;
            return this;
        }

        @NonNull
        public Builder setDynamicLinkDomain(@NonNull String str) {
            this.f28857g = str;
            return this;
        }

        @NonNull
        public Builder setHandleCodeInApp(boolean z3) {
            this.f28856f = z3;
            return this;
        }

        @NonNull
        public Builder setIOSBundleId(@NonNull String str) {
            this.f28852b = str;
            return this;
        }

        @NonNull
        public Builder setUrl(@NonNull String str) {
            this.f28851a = str;
            return this;
        }

        /* synthetic */ Builder(zza zzaVar) {
        }
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder(null);
    }

    @NonNull
    public static ActionCodeSettings zzb() {
        return new ActionCodeSettings(new Builder(null));
    }

    public boolean canHandleCodeInApp() {
        return this.f28847g;
    }

    public boolean getAndroidInstallApp() {
        return this.f28845e;
    }

    @Nullable
    public String getAndroidMinimumVersion() {
        return this.f28846f;
    }

    @Nullable
    public String getAndroidPackageName() {
        return this.f28844d;
    }

    @Nullable
    public String getIOSBundle() {
        return this.f28842b;
    }

    @NonNull
    public String getUrl() {
        return this.f28841a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUrl(), false);
        SafeParcelWriter.writeString(parcel, 2, getIOSBundle(), false);
        SafeParcelWriter.writeString(parcel, 3, this.f28843c, false);
        SafeParcelWriter.writeString(parcel, 4, getAndroidPackageName(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, getAndroidInstallApp());
        SafeParcelWriter.writeString(parcel, 6, getAndroidMinimumVersion(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, canHandleCodeInApp());
        SafeParcelWriter.writeString(parcel, 8, this.f28848h, false);
        SafeParcelWriter.writeInt(parcel, 9, this.f28849i);
        SafeParcelWriter.writeString(parcel, 10, this.f28850j, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.f28849i;
    }

    @NonNull
    public final String zzc() {
        return this.f28850j;
    }

    @Nullable
    public final String zzd() {
        return this.f28843c;
    }

    @NonNull
    public final String zze() {
        return this.f28848h;
    }

    public final void zzf(@NonNull String str) {
        this.f28848h = str;
    }

    public final void zzg(int i4) {
        this.f28849i = i4;
    }

    private ActionCodeSettings(Builder builder) {
        this.f28841a = builder.f28851a;
        this.f28842b = builder.f28852b;
        this.f28843c = null;
        this.f28844d = builder.f28853c;
        this.f28845e = builder.f28854d;
        this.f28846f = builder.f28855e;
        this.f28847g = builder.f28856f;
        this.f28850j = builder.f28857g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ActionCodeSettings(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) boolean z4, @SafeParcelable.Param(id = 8) String str6, @SafeParcelable.Param(id = 9) int i4, @SafeParcelable.Param(id = 10) String str7) {
        this.f28841a = str;
        this.f28842b = str2;
        this.f28843c = str3;
        this.f28844d = str4;
        this.f28845e = z3;
        this.f28846f = str5;
        this.f28847g = z4;
        this.f28848h = str6;
        this.f28849i = i4;
        this.f28850j = str7;
    }
}
