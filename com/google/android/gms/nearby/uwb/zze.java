package com.google.android.gms.nearby.uwb;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@ShowFirstParty
/* loaded from: classes4.dex */
public final class zze implements Api.ApiOptions.HasOptions {

    /* renamed from: b  reason: collision with root package name */
    private final int f22557b;

    /* renamed from: d  reason: collision with root package name */
    private final int f22559d;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22558c = false;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f22556a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zze(int i4, boolean z3, String str, int i5, zzd zzdVar) {
        this.f22557b = i4;
        this.f22559d = i5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        boolean z3 = zzeVar.f22558c;
        if (Objects.equal(Integer.valueOf(this.f22557b), Integer.valueOf(zzeVar.f22557b)) && Objects.equal(null, null) && Objects.equal(Integer.valueOf(this.f22559d), Integer.valueOf(zzeVar.f22559d))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22557b), Boolean.FALSE, null, Integer.valueOf(this.f22559d));
    }

    public final int zza() {
        return this.f22557b;
    }
}
