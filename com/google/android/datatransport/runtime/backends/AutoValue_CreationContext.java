package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes.dex */
final class AutoValue_CreationContext extends CreationContext {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18702a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f18703b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f18704c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18705d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.f18702a = context;
            if (clock != null) {
                this.f18703b = clock;
                if (clock2 != null) {
                    this.f18704c = clock2;
                    if (str != null) {
                        this.f18705d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        if (this.f18702a.equals(creationContext.getApplicationContext()) && this.f18703b.equals(creationContext.getWallClock()) && this.f18704c.equals(creationContext.getMonotonicClock()) && this.f18705d.equals(creationContext.getBackendName())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Context getApplicationContext() {
        return this.f18702a;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    @NonNull
    public String getBackendName() {
        return this.f18705d;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock getMonotonicClock() {
        return this.f18704c;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock getWallClock() {
        return this.f18703b;
    }

    public int hashCode() {
        return ((((((this.f18702a.hashCode() ^ 1000003) * 1000003) ^ this.f18703b.hashCode()) * 1000003) ^ this.f18704c.hashCode()) * 1000003) ^ this.f18705d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f18702a + ", wallClock=" + this.f18703b + ", monotonicClock=" + this.f18704c + ", backendName=" + this.f18705d + "}";
    }
}
