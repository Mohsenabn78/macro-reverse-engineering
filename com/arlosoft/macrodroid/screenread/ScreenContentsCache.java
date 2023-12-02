package com.arlosoft.macrodroid.screenread;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScreenContentsCache.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class ScreenContentsCache {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MutableSharedFlow<Map<String, String>> f13306a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SharedFlow<Map<String, String>> f13307b;

    @Inject
    public ScreenContentsCache() {
        MutableSharedFlow<Map<String, String>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.f13306a = MutableSharedFlow$default;
        this.f13307b = MutableSharedFlow$default;
    }

    @NotNull
    public final SharedFlow<Map<String, String>> getScreenDataFlow() {
        return this.f13307b;
    }

    public final void setScreenData(@NotNull Map<String, String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f13306a.tryEmit(data);
    }
}
