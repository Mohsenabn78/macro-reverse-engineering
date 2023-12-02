package com.arlosoft.macrodroid.app;

import androidx.compose.runtime.internal.StabilityInferred;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ServiceInitialisation.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ServiceInitialisation {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<Boolean> f5694a;

    public ServiceInitialisation() {
        PublishSubject<Boolean> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.f5694a = create;
    }

    @NotNull
    public final Flowable<Boolean> awaitInitFlowable() {
        Flowable<Boolean> flowable = this.f5694a.toFlowable(BackpressureStrategy.BUFFER);
        Intrinsics.checkNotNullExpressionValue(flowable, "serviceInitSubject.toFlo…kpressureStrategy.BUFFER)");
        return flowable;
    }

    public final void notifyServiceInitialised() {
        this.f5694a.onNext(Boolean.TRUE);
    }
}
