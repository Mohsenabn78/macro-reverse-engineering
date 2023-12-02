package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class RegistrationMethods<A extends Api.AnyClient, L> {
    @NonNull
    @KeepForSdk
    public final RegisterListenerMethod<A, L> register;
    @NonNull
    public final UnregisterListenerMethod zaa;
    @NonNull
    public final Runnable zab;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static class Builder<A extends Api.AnyClient, L> {

        /* renamed from: a  reason: collision with root package name */
        private RemoteCall f20096a;

        /* renamed from: b  reason: collision with root package name */
        private RemoteCall f20097b;

        /* renamed from: d  reason: collision with root package name */
        private ListenerHolder f20099d;

        /* renamed from: e  reason: collision with root package name */
        private Feature[] f20100e;

        /* renamed from: g  reason: collision with root package name */
        private int f20102g;

        /* renamed from: c  reason: collision with root package name */
        private Runnable f20098c = zacj.zaa;

        /* renamed from: f  reason: collision with root package name */
        private boolean f20101f = true;

        private Builder() {
        }

        @NonNull
        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            boolean z3;
            boolean z4;
            boolean z5 = true;
            if (this.f20096a != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Must set register function");
            if (this.f20097b != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Must set unregister function");
            if (this.f20099d == null) {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "Must set holder");
            return new RegistrationMethods<>(new zack(this, this.f20099d, this.f20100e, this.f20101f, this.f20102g), new zacl(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.f20099d.getListenerKey(), "Key must not be null")), this.f20098c, null);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> onConnectionSuspended(@NonNull Runnable runnable) {
            this.f20098c = runnable;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> register(@NonNull RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.f20096a = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> setAutoResolveMissingFeatures(boolean z3) {
            this.f20101f = z3;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> setFeatures(@NonNull Feature... featureArr) {
            this.f20100e = featureArr;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> setMethodKey(int i4) {
            this.f20102g = i4;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> unregister(@NonNull RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.f20097b = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, L> withHolder(@NonNull ListenerHolder<L> listenerHolder) {
            this.f20099d = listenerHolder;
            return this;
        }

        /* synthetic */ Builder(zacm zacmVar) {
        }
    }

    /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, zacn zacnVar) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>(null);
    }
}
