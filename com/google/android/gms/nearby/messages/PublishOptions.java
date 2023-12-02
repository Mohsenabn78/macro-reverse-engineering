package com.google.android.gms.nearby.messages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class PublishOptions {
    @NonNull
    public static final PublishOptions DEFAULT = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final Strategy f22391a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final PublishCallback f22392b;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Strategy f22393a = Strategy.DEFAULT;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private PublishCallback f22394b;

        @NonNull
        public PublishOptions build() {
            return new PublishOptions(this.f22393a, this.f22394b, null);
        }

        @NonNull
        public Builder setCallback(@NonNull PublishCallback publishCallback) {
            this.f22394b = (PublishCallback) Preconditions.checkNotNull(publishCallback);
            return this;
        }

        @NonNull
        public Builder setStrategy(@NonNull Strategy strategy) {
            this.f22393a = (Strategy) Preconditions.checkNotNull(strategy);
            return this;
        }
    }

    /* synthetic */ PublishOptions(Strategy strategy, PublishCallback publishCallback, zze zzeVar) {
        this.f22391a = strategy;
        this.f22392b = publishCallback;
    }

    @Nullable
    public PublishCallback getCallback() {
        return this.f22392b;
    }

    @NonNull
    public Strategy getStrategy() {
        return this.f22391a;
    }
}
