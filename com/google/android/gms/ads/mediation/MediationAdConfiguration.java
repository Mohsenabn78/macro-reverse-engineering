package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;

    /* renamed from: a  reason: collision with root package name */
    private final String f19440a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f19441b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f19442c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f19443d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f19444e;

    /* renamed from: f  reason: collision with root package name */
    private final int f19445f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19446g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final String f19447h;

    /* renamed from: i  reason: collision with root package name */
    private final String f19448i;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(@NonNull Context context, @NonNull String str, @NonNull Bundle bundle, @NonNull Bundle bundle2, boolean z3, @Nullable Location location, int i4, int i5, @Nullable String str2, @NonNull String str3) {
        this.f19440a = str;
        this.f19441b = bundle;
        this.f19442c = bundle2;
        this.f19443d = context;
        this.f19444e = z3;
        this.f19445f = i4;
        this.f19446g = i5;
        this.f19447h = str2;
        this.f19448i = str3;
    }

    @NonNull
    public String getBidResponse() {
        return this.f19440a;
    }

    @NonNull
    public Context getContext() {
        return this.f19443d;
    }

    @Nullable
    public String getMaxAdContentRating() {
        return this.f19447h;
    }

    @NonNull
    public Bundle getMediationExtras() {
        return this.f19442c;
    }

    @NonNull
    public Bundle getServerParameters() {
        return this.f19441b;
    }

    @NonNull
    public String getWatermark() {
        return this.f19448i;
    }

    public boolean isTestRequest() {
        return this.f19444e;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f19445f;
    }

    public int taggedForUnderAgeTreatment() {
        return this.f19446g;
    }
}
