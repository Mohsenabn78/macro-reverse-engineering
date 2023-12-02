package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;

/* loaded from: classes.dex */
final class AutoValue_BackendRequest extends BackendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<EventInternal> f18696a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f18697b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends BackendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Iterable<EventInternal> f18698a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f18699b;

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest build() {
            String str = "";
            if (this.f18698a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new AutoValue_BackendRequest(this.f18698a, this.f18699b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder setEvents(Iterable<EventInternal> iterable) {
            if (iterable != null) {
                this.f18698a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        @Override // com.google.android.datatransport.runtime.backends.BackendRequest.Builder
        public BackendRequest.Builder setExtras(@Nullable byte[] bArr) {
            this.f18699b = bArr;
            return this;
        }
    }

    public boolean equals(Object obj) {
        byte[] extras;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f18696a.equals(backendRequest.getEvents())) {
            byte[] bArr = this.f18697b;
            if (backendRequest instanceof AutoValue_BackendRequest) {
                extras = ((AutoValue_BackendRequest) backendRequest).f18697b;
            } else {
                extras = backendRequest.getExtras();
            }
            if (Arrays.equals(bArr, extras)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    public Iterable<EventInternal> getEvents() {
        return this.f18696a;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRequest
    @Nullable
    public byte[] getExtras() {
        return this.f18697b;
    }

    public int hashCode() {
        return ((this.f18696a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f18697b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f18696a + ", extras=" + Arrays.toString(this.f18697b) + "}";
    }

    private AutoValue_BackendRequest(Iterable<EventInternal> iterable, @Nullable byte[] bArr) {
        this.f18696a = iterable;
        this.f18697b = bArr;
    }
}
