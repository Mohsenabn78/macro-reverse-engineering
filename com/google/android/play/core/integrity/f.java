package com.google.android.play.core.integrity;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class f extends IntegrityTokenResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f25287a;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenResponse) {
            return this.f25287a.equals(((IntegrityTokenResponse) obj).token());
        }
        return false;
    }

    public final int hashCode() {
        return this.f25287a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String str = this.f25287a;
        return "IntegrityTokenResponse{token=" + str + "}";
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenResponse
    public final String token() {
        return this.f25287a;
    }
}
