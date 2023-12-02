package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class RtbSignalData {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19466a;

    /* renamed from: b  reason: collision with root package name */
    private final List f19467b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f19468c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AdSize f19469d;

    public RtbSignalData(@NonNull Context context, @NonNull List<MediationConfiguration> list, @NonNull Bundle bundle, @Nullable AdSize adSize) {
        this.f19466a = context;
        this.f19467b = list;
        this.f19468c = bundle;
        this.f19469d = adSize;
    }

    @Nullable
    public AdSize getAdSize() {
        return this.f19469d;
    }

    @Nullable
    @Deprecated
    public MediationConfiguration getConfiguration() {
        List list = this.f19467b;
        if (list != null && list.size() > 0) {
            return (MediationConfiguration) this.f19467b.get(0);
        }
        return null;
    }

    @NonNull
    public List<MediationConfiguration> getConfigurations() {
        return this.f19467b;
    }

    @NonNull
    public Context getContext() {
        return this.f19466a;
    }

    @NonNull
    public Bundle getNetworkExtras() {
        return this.f19468c;
    }
}
