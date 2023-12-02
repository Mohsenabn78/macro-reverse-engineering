package com.arlosoft.macrodroid.uiinteraction;

import androidx.compose.runtime.internal.StabilityInferred;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: UIInteractionResultCache.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class UIInteractionResultCache {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MutableSharedFlow<UIInteractionResult> f15861a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SharedFlow<UIInteractionResult> f15862b;

    @Inject
    public UIInteractionResultCache() {
        MutableSharedFlow<UIInteractionResult> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.f15861a = MutableSharedFlow$default;
        this.f15862b = MutableSharedFlow$default;
    }

    @NotNull
    public final SharedFlow<UIInteractionResult> getResultDataFlow() {
        return this.f15862b;
    }

    public final void setResultData(int i4, boolean z3, long j4) {
        this.f15861a.tryEmit(new UIInteractionResult(i4, z3, j4));
    }
}
