package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.internal.ads.zzbef;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public class MediationNativeAdConfiguration extends MediationAdConfiguration {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final zzbef f19452j;

    public MediationNativeAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z3, @Nullable Location location, int i4, int i5, @Nullable String str2, String str3, @Nullable zzbef zzbefVar) {
        super(context, str, bundle, bundle2, z3, location, i4, i5, str2, str3);
        this.f19452j = zzbefVar;
    }

    @NonNull
    public NativeAdOptions getNativeAdOptions() {
        return zzbef.zza(this.f19452j);
    }
}
