package com.google.android.ump;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes5.dex */
public class ConsentRequestParameters {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f25374a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f25375b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final ConsentDebugSettings f25376c;

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f25377a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private String f25378b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private ConsentDebugSettings f25379c;

        @RecentlyNonNull
        public ConsentRequestParameters build() {
            return new ConsentRequestParameters(this, null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAdMobAppId(@Nullable String str) {
            this.f25378b = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setConsentDebugSettings(@Nullable ConsentDebugSettings consentDebugSettings) {
            this.f25379c = consentDebugSettings;
            return this;
        }

        @RecentlyNonNull
        public Builder setTagForUnderAgeOfConsent(boolean z3) {
            this.f25377a = z3;
            return this;
        }
    }

    /* synthetic */ ConsentRequestParameters(Builder builder, zzb zzbVar) {
        this.f25374a = builder.f25377a;
        this.f25375b = builder.f25378b;
        this.f25376c = builder.f25379c;
    }

    @RecentlyNullable
    public ConsentDebugSettings getConsentDebugSettings() {
        return this.f25376c;
    }

    public boolean isTagForUnderAgeOfConsent() {
        return this.f25374a;
    }

    @RecentlyNullable
    public final String zza() {
        return this.f25375b;
    }
}
