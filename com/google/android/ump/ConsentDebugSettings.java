package com.google.android.ump;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.consent_sdk.zzbx;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes5.dex */
public class ConsentDebugSettings {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f25368a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25369b;

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: b  reason: collision with root package name */
        private final Context f25371b;

        /* renamed from: d  reason: collision with root package name */
        private boolean f25373d;

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f25370a = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private int f25372c = 0;

        public Builder(@RecentlyNonNull Context context) {
            this.f25371b = context.getApplicationContext();
        }

        @RecentlyNonNull
        public Builder addTestDeviceHashedId(@RecentlyNonNull String str) {
            this.f25370a.add(str);
            return this;
        }

        @RecentlyNonNull
        public ConsentDebugSettings build() {
            Context context = this.f25371b;
            List<String> list = this.f25370a;
            boolean z3 = true;
            if (!zzbx.zzb() && !list.contains(zzbx.zza(context)) && !this.f25373d) {
                z3 = false;
            }
            return new ConsentDebugSettings(z3, this, null);
        }

        @RecentlyNonNull
        public Builder setDebugGeography(int i4) {
            this.f25372c = i4;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setForceTesting(boolean z3) {
            this.f25373d = z3;
            return this;
        }
    }

    /* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface DebugGeography {
        public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
        public static final int DEBUG_GEOGRAPHY_EEA = 1;
        public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
    }

    /* synthetic */ ConsentDebugSettings(boolean z3, Builder builder, zza zzaVar) {
        this.f25368a = z3;
        this.f25369b = builder.f25372c;
    }

    public int getDebugGeography() {
        return this.f25369b;
    }

    public boolean isTestDevice() {
        return this.f25368a;
    }
}
