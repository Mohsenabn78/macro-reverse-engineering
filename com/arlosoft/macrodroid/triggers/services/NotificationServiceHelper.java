package com.arlosoft.macrodroid.triggers.services;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: NotificationServiceHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NotificationServiceHelper {
    public static final int $stable;
    @NotNull
    public static final NotificationServiceHelper INSTANCE = new NotificationServiceHelper();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final MutableSharedFlow<Boolean> f15516a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final SharedFlow<Boolean> f15517b;

    static {
        MutableSharedFlow<Boolean> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);
        f15516a = MutableSharedFlow$default;
        f15517b = MutableSharedFlow$default;
        $stable = 8;
    }

    private NotificationServiceHelper() {
    }

    @NotNull
    public final SharedFlow<Boolean> getGetActiveNotifications() {
        return f15517b;
    }

    public final void reqeustNotifications() {
        f15516a.tryEmit(Boolean.TRUE);
    }
}
