package com.google.firebase.firestore;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public final class TransactionOptions {

    /* renamed from: b  reason: collision with root package name */
    static final TransactionOptions f30238b = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final int f30239a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TransactionOptions.class == obj.getClass() && this.f30239a == ((TransactionOptions) obj).f30239a) {
            return true;
        }
        return false;
    }

    public int getMaxAttempts() {
        return this.f30239a;
    }

    public int hashCode() {
        return this.f30239a;
    }

    public String toString() {
        return "TransactionOptions{maxAttempts=" + this.f30239a + '}';
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f30240a;

        public Builder() {
            this.f30240a = 5;
        }

        @NonNull
        public TransactionOptions build() {
            return new TransactionOptions(this.f30240a);
        }

        @NonNull
        public Builder setMaxAttempts(int i4) {
            if (i4 >= 1) {
                this.f30240a = i4;
                return this;
            }
            throw new IllegalArgumentException("Max attempts must be at least 1");
        }

        public Builder(@NonNull TransactionOptions transactionOptions) {
            this.f30240a = 5;
            this.f30240a = transactionOptions.f30239a;
        }
    }

    private TransactionOptions(int i4) {
        this.f30239a = i4;
    }
}
