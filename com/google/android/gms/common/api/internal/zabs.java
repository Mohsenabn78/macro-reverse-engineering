package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabs {

    /* renamed from: a  reason: collision with root package name */
    private final ApiKey f20253a;

    /* renamed from: b  reason: collision with root package name */
    private final Feature f20254b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zabs(ApiKey apiKey, Feature feature, zabr zabrVar) {
        this.f20253a = apiKey;
        this.f20254b = feature;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabsVar = (zabs) obj;
            if (Objects.equal(this.f20253a, zabsVar.f20253a) && Objects.equal(this.f20254b, zabsVar.f20254b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f20253a, this.f20254b);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("key", this.f20253a).add("feature", this.f20254b).toString();
    }
}
