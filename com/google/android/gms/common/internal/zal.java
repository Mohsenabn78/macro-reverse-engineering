package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zal {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f20526a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleApiAvailabilityLight f20527b;

    public zal() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, int i4) {
        return this.f20526a.get(i4, -1);
    }

    @ResultIgnorabilityUnspecified
    public final int zab(@NonNull Context context, @NonNull Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i4 = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zaa = zaa(context, minApkVersion);
        if (zaa == -1) {
            int i5 = 0;
            while (true) {
                if (i5 < this.f20526a.size()) {
                    int keyAt = this.f20526a.keyAt(i5);
                    if (keyAt > minApkVersion && this.f20526a.get(keyAt) == 0) {
                        break;
                    }
                    i5++;
                } else {
                    i4 = -1;
                    break;
                }
            }
            if (i4 == -1) {
                zaa = this.f20527b.isGooglePlayServicesAvailable(context, minApkVersion);
            } else {
                zaa = i4;
            }
            this.f20526a.put(minApkVersion, zaa);
        }
        return zaa;
    }

    public final void zac() {
        this.f20526a.clear();
    }

    public zal(@NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.f20526a = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.f20527b = googleApiAvailabilityLight;
    }
}
