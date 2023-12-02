package com.google.android.gms.common.moduleinstall;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class ModuleInstallRequest {

    /* renamed from: a  reason: collision with root package name */
    private final List f20602a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final InstallStatusListener f20603b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Executor f20604c;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List f20605a = new ArrayList();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private InstallStatusListener f20606b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Executor f20607c;

        @NonNull
        @CanIgnoreReturnValue
        public Builder addApi(@NonNull OptionalModuleApi optionalModuleApi) {
            this.f20605a.add(optionalModuleApi);
            return this;
        }

        @NonNull
        public ModuleInstallRequest build() {
            return new ModuleInstallRequest(this.f20605a, this.f20606b, this.f20607c, true, null);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setListener(@NonNull InstallStatusListener installStatusListener, @Nullable Executor executor) {
            this.f20606b = installStatusListener;
            this.f20607c = executor;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setListener(@NonNull InstallStatusListener installStatusListener) {
            return setListener(installStatusListener, null);
        }
    }

    /* synthetic */ ModuleInstallRequest(List list, InstallStatusListener installStatusListener, Executor executor, boolean z3, zac zacVar) {
        Preconditions.checkNotNull(list, "APIs must not be null.");
        Preconditions.checkArgument(!list.isEmpty(), "APIs must not be empty.");
        if (executor != null) {
            Preconditions.checkNotNull(installStatusListener, "Listener must not be null when listener executor is set.");
        }
        this.f20602a = list;
        this.f20603b = installStatusListener;
        this.f20604c = executor;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @NonNull
    public List<OptionalModuleApi> getApis() {
        return this.f20602a;
    }

    @Nullable
    public InstallStatusListener getListener() {
        return this.f20603b;
    }

    @Nullable
    public Executor getListenerExecutor() {
        return this.f20604c;
    }
}
