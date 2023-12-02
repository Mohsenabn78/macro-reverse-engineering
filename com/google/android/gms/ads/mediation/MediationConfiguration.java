package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdFormat;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class MediationConfiguration {
    @NonNull
    public static final String CUSTOM_EVENT_SERVER_PARAMETER_FIELD = "parameter";

    /* renamed from: a  reason: collision with root package name */
    private final AdFormat f19450a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f19451b;

    public MediationConfiguration(@NonNull AdFormat adFormat, @NonNull Bundle bundle) {
        this.f19450a = adFormat;
        this.f19451b = bundle;
    }

    @NonNull
    public AdFormat getFormat() {
        return this.f19450a;
    }

    @NonNull
    public Bundle getServerParameters() {
        return this.f19451b;
    }
}
