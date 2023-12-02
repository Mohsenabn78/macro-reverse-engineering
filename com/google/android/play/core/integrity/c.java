package com.google.android.play.core.integrity;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class c extends IntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f25284a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f25285b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(String str, Long l4, b bVar) {
        this.f25284a = str;
        this.f25285b = l4;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    @Nullable
    public final Long cloudProjectNumber() {
        return this.f25285b;
    }

    public final boolean equals(Object obj) {
        Long l4;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (this.f25284a.equals(integrityTokenRequest.nonce()) && ((l4 = this.f25285b) != null ? l4.equals(integrityTokenRequest.cloudProjectNumber()) : integrityTokenRequest.cloudProjectNumber() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.f25284a.hashCode() ^ 1000003;
        Long l4 = this.f25285b;
        if (l4 == null) {
            hashCode = 0;
        } else {
            hashCode = l4.hashCode();
        }
        return (hashCode2 * 1000003) ^ hashCode;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final String nonce() {
        return this.f25284a;
    }

    public final String toString() {
        String str = this.f25284a;
        Long l4 = this.f25285b;
        return "IntegrityTokenRequest{nonce=" + str + ", cloudProjectNumber=" + l4 + "}";
    }
}
