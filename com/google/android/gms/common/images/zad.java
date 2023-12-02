package com.google.android.gms.common.images;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zad {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f20416a;

    public zad(Uri uri) {
        this.f20416a = uri;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zad)) {
            return false;
        }
        return Objects.equal(((zad) obj).f20416a, this.f20416a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f20416a);
    }
}
