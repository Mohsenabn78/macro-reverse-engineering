package com.google.android.gms.location.places;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import java.util.Locale;

@Deprecated
/* loaded from: classes4.dex */
public final class PlacesOptions implements Api.ApiOptions.Optional {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Locale f21050a;
    @Nullable
    public final String zzas;
    @Nullable
    public final String zzat;
    public final int zzau;
    @Nullable
    public final String zzav;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f21051a = 0;

        public PlacesOptions build() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.zzas = null;
        this.zzat = null;
        this.zzau = 0;
        this.zzav = null;
        this.f21050a = null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlacesOptions) || !Objects.equal(null, null) || !Objects.equal(null, null) || !Objects.equal(0, 0) || !Objects.equal(null, null) || !Objects.equal(null, null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(null, null, 0, null, null);
    }
}
