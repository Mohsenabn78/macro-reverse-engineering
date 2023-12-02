package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Feature[] f20104a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20105b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20106c;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @KeepForSdk
    /* loaded from: classes4.dex */
    public static class Builder<A extends Api.AnyClient, ResultT> {

        /* renamed from: a  reason: collision with root package name */
        private RemoteCall f20107a;

        /* renamed from: c  reason: collision with root package name */
        private Feature[] f20109c;

        /* renamed from: b  reason: collision with root package name */
        private boolean f20108b = true;

        /* renamed from: d  reason: collision with root package name */
        private int f20110d = 0;

        private Builder() {
        }

        @NonNull
        @KeepForSdk
        public TaskApiCall<A, ResultT> build() {
            boolean z3;
            if (this.f20107a != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "execute parameter required");
            return new zacv(this, this.f20109c, this.f20108b, this.f20110d);
        }

        @NonNull
        @Deprecated
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> execute(@NonNull final BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.f20107a = new RemoteCall() { // from class: com.google.android.gms.common.api.internal.zacu
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    BiConsumer.this.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
                }
            };
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> run(@NonNull RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.f20107a = remoteCall;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z3) {
            this.f20108b = z3;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> setFeatures(@NonNull Feature... featureArr) {
            this.f20109c = featureArr;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder<A, ResultT> setMethodKey(int i4) {
            this.f20110d = i4;
            return this;
        }

        /* synthetic */ Builder(zacw zacwVar) {
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.f20104a = null;
        this.f20105b = false;
        this.f20106c = 0;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public abstract void a(@NonNull A a4, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.f20105b;
    }

    public final int zaa() {
        return this.f20106c;
    }

    @Nullable
    public final Feature[] zab() {
        return this.f20104a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public TaskApiCall(@Nullable Feature[] featureArr, boolean z3, int i4) {
        this.f20104a = featureArr;
        boolean z4 = false;
        if (featureArr != null && z3) {
            z4 = true;
        }
        this.f20105b = z4;
        this.f20106c = i4;
    }
}
