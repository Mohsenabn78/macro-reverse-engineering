package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EncodedPayload {

    /* renamed from: a  reason: collision with root package name */
    private final Encoding f18672a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f18673b;

    public EncodedPayload(@NonNull Encoding encoding, @NonNull byte[] bArr) {
        if (encoding != null) {
            if (bArr != null) {
                this.f18672a = encoding;
                this.f18673b = bArr;
                return;
            }
            throw new NullPointerException("bytes is null");
        }
        throw new NullPointerException("encoding is null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.f18672a.equals(encodedPayload.f18672a)) {
            return false;
        }
        return Arrays.equals(this.f18673b, encodedPayload.f18673b);
    }

    public byte[] getBytes() {
        return this.f18673b;
    }

    public Encoding getEncoding() {
        return this.f18672a;
    }

    public int hashCode() {
        return ((this.f18672a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f18673b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f18672a + ", bytes=[...]}";
    }
}
