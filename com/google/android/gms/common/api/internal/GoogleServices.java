package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@Deprecated
/* loaded from: classes4.dex */
public final class GoogleServices {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f20067e = new Object();
    @Nullable
    @GuardedBy("sLock")

    /* renamed from: f  reason: collision with root package name */
    private static GoogleServices f20068f;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f20069a;

    /* renamed from: b  reason: collision with root package name */
    private final Status f20070b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20071c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20072d;

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(String str, boolean z3) {
        this.f20069a = str;
        this.f20070b = Status.RESULT_SUCCESS;
        this.f20071c = z3;
        this.f20072d = !z3;
    }

    @KeepForSdk
    private static GoogleServices b(String str) {
        GoogleServices googleServices;
        synchronized (f20067e) {
            googleServices = f20068f;
            if (googleServices == null) {
                throw new IllegalStateException("Initialize must be called before " + str + ".");
            }
        }
        return googleServices;
    }

    @Nullable
    @KeepForSdk
    public static String getGoogleAppId() {
        return b("getGoogleAppId").f20069a;
    }

    @NonNull
    @KeepForSdk
    public static Status initialize(@NonNull Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (f20067e) {
            if (f20068f == null) {
                f20068f = new GoogleServices(context);
            }
            status = f20068f.f20070b;
        }
        return status;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices b4 = b("isMeasurementEnabled");
        if (b4.f20070b.isSuccess() && b4.f20071c) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return b("isMeasurementExplicitlyDisabled").f20072d;
    }

    @VisibleForTesting
    @KeepForSdk
    Status a(String str) {
        String str2 = this.f20069a;
        if (str2 != null && !str2.equals(str)) {
            String str3 = this.f20069a;
            return new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + str3 + "'.");
        }
        return Status.RESULT_SUCCESS;
    }

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            boolean z3 = integer == 0;
            r2 = integer != 0;
            this.f20072d = z3;
        } else {
            this.f20072d = false;
        }
        this.f20071c = r2;
        String zzb = zzag.zzb(context);
        zzb = zzb == null ? new StringResourceValueReader(context).getString("google_app_id") : zzb;
        if (TextUtils.isEmpty(zzb)) {
            this.f20070b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f20069a = null;
            return;
        }
        this.f20069a = zzb;
        this.f20070b = Status.RESULT_SUCCESS;
    }

    @NonNull
    @KeepForSdk
    public static Status initialize(@NonNull Context context, @NonNull String str, boolean z3) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (f20067e) {
            GoogleServices googleServices = f20068f;
            if (googleServices != null) {
                return googleServices.a(str);
            }
            GoogleServices googleServices2 = new GoogleServices(str, z3);
            f20068f = googleServices2;
            return googleServices2.f20070b;
        }
    }
}
