package com.arlosoft.macrodroid.helper;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.helper.data.HelperResult;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: HelperResultHandler.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class HelperResultHandler {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MutableSharedFlow<HelperResult> f12286a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Flow<HelperResult> f12287b;

    @Inject
    public HelperResultHandler() {
        MutableSharedFlow<HelperResult> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.f12286a = MutableSharedFlow$default;
        this.f12287b = MutableSharedFlow$default;
    }

    @NotNull
    public final Flow<HelperResult> getResultsFlow() {
        return this.f12287b;
    }

    @NotNull
    public final MutableSharedFlow<HelperResult> get_resultsFlow() {
        return this.f12286a;
    }

    public final void newResultAvailable(@NotNull HelperResult helperResult) {
        Intrinsics.checkNotNullParameter(helperResult, "helperResult");
        this.f12286a.tryEmit(helperResult);
    }
}
