package com.google.firebase.functions;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class HttpsCallableOptions {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31389a;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f31390a = false;

        @NonNull
        public HttpsCallableOptions build() {
            return new HttpsCallableOptions(this.f31390a);
        }

        public boolean getLimitedUseAppCheckTokens() {
            return this.f31390a;
        }

        @NonNull
        public Builder setLimitedUseAppCheckTokens(boolean z3) {
            this.f31390a = z3;
            return this;
        }
    }

    public boolean getLimitedUseAppCheckTokens() {
        return this.f31389a;
    }

    private HttpsCallableOptions(boolean z3) {
        this.f31389a = z3;
    }
}
