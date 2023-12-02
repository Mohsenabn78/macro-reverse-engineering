package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public class MediationBannerAdConfiguration extends MediationAdConfiguration {

    /* renamed from: j  reason: collision with root package name */
    private final AdSize f19449j;

    public MediationBannerAdConfiguration(@NonNull Context context, @NonNull String str, @NonNull Bundle bundle, @NonNull Bundle bundle2, boolean z3, @Nullable Location location, int i4, int i5, @NonNull String str2, @NonNull AdSize adSize, @NonNull String str3) {
        super(context, str, bundle, bundle2, z3, location, i4, i5, str2, str3);
        this.f19449j = adSize;
    }

    @NonNull
    public AdSize getAdSize() {
        return this.f19449j;
    }
}
