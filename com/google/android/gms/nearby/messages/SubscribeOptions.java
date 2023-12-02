package com.google.android.gms.nearby.messages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class SubscribeOptions {
    @NonNull
    public static final SubscribeOptions DEFAULT = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final Strategy f22407a;

    /* renamed from: b  reason: collision with root package name */
    private final MessageFilter f22408b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final SubscribeCallback f22409c;
    public final boolean zza = false;
    public final int zzb = 0;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Strategy f22410a = Strategy.DEFAULT;

        /* renamed from: b  reason: collision with root package name */
        private MessageFilter f22411b = MessageFilter.INCLUDE_ALL_MY_TYPES;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private SubscribeCallback f22412c;

        @NonNull
        public SubscribeOptions build() {
            return new SubscribeOptions(this.f22410a, this.f22411b, this.f22412c, false, 0, null);
        }

        @NonNull
        public Builder setCallback(@NonNull SubscribeCallback subscribeCallback) {
            this.f22412c = (SubscribeCallback) Preconditions.checkNotNull(subscribeCallback);
            return this;
        }

        @NonNull
        public Builder setFilter(@NonNull MessageFilter messageFilter) {
            this.f22411b = messageFilter;
            return this;
        }

        @NonNull
        public Builder setStrategy(@NonNull Strategy strategy) {
            this.f22410a = strategy;
            return this;
        }
    }

    /* synthetic */ SubscribeOptions(Strategy strategy, MessageFilter messageFilter, SubscribeCallback subscribeCallback, boolean z3, int i4, zzg zzgVar) {
        this.f22407a = strategy;
        this.f22408b = messageFilter;
        this.f22409c = subscribeCallback;
    }

    @Nullable
    public SubscribeCallback getCallback() {
        return this.f22409c;
    }

    @NonNull
    public MessageFilter getFilter() {
        return this.f22408b;
    }

    @NonNull
    public Strategy getStrategy() {
        return this.f22407a;
    }

    @NonNull
    public String toString() {
        String valueOf = String.valueOf(this.f22407a);
        String valueOf2 = String.valueOf(this.f22408b);
        return "SubscribeOptions{strategy=" + valueOf + ", filter=" + valueOf2 + "}";
    }
}
