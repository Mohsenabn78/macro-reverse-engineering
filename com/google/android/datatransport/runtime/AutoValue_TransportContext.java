package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

/* loaded from: classes.dex */
final class AutoValue_TransportContext extends TransportContext {

    /* renamed from: a  reason: collision with root package name */
    private final String f18652a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f18653b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f18654c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends TransportContext.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f18655a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f18656b;

        /* renamed from: c  reason: collision with root package name */
        private Priority f18657c;

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext build() {
            String str = "";
            if (this.f18655a == null) {
                str = " backendName";
            }
            if (this.f18657c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new AutoValue_TransportContext(this.f18655a, this.f18656b, this.f18657c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder setBackendName(String str) {
            if (str != null) {
                this.f18655a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder setExtras(@Nullable byte[] bArr) {
            this.f18656b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.Builder
        public TransportContext.Builder setPriority(Priority priority) {
            if (priority != null) {
                this.f18657c = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public boolean equals(Object obj) {
        byte[] extras;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f18652a.equals(transportContext.getBackendName())) {
            byte[] bArr = this.f18653b;
            if (transportContext instanceof AutoValue_TransportContext) {
                extras = ((AutoValue_TransportContext) transportContext).f18653b;
            } else {
                extras = transportContext.getExtras();
            }
            if (Arrays.equals(bArr, extras) && this.f18654c.equals(transportContext.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public String getBackendName() {
        return this.f18652a;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    @Nullable
    public byte[] getExtras() {
        return this.f18653b;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority getPriority() {
        return this.f18654c;
    }

    public int hashCode() {
        return ((((this.f18652a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f18653b)) * 1000003) ^ this.f18654c.hashCode();
    }

    private AutoValue_TransportContext(String str, @Nullable byte[] bArr, Priority priority) {
        this.f18652a = str;
        this.f18653b = bArr;
        this.f18654c = priority;
    }
}
