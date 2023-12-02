package com.arlosoft.macrodroid.templatestore.ui.upload;

import androidx.compose.runtime.internal.StabilityInferred;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TemplateRefreshNotifier.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class TemplateRefreshNotifier {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<Boolean> f14132a;

    @Inject
    public TemplateRefreshNotifier() {
        PublishSubject<Boolean> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.f14132a = create;
    }

    public final void notifyRefreshRequired() {
        this.f14132a.onNext(Boolean.TRUE);
    }

    @NotNull
    public final Flowable<Boolean> requiresRefreshFlowable() {
        Flowable<Boolean> flowable = this.f14132a.toFlowable(BackpressureStrategy.LATEST);
        Intrinsics.checkNotNullExpressionValue(flowable, "templateRefreshSubject.t…kpressureStrategy.LATEST)");
        return flowable;
    }
}
