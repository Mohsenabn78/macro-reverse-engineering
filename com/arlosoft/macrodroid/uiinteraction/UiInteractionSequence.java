package com.arlosoft.macrodroid.uiinteraction;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UiInteractionSequence.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class UiInteractionSequence {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<UiInteraction> f15869a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f15870b;

    public final void addEvent(@NotNull UiInteraction event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f15869a.add(event);
    }

    public final void clearAllEvents() {
        this.f15869a.clear();
    }

    @NotNull
    public final List<UiInteraction> getAllEvents() {
        return this.f15869a;
    }

    public final boolean isEventRecordingEnabled() {
        return this.f15870b;
    }

    public final void setEventRecordingEnabled(boolean z3) {
        this.f15870b = z3;
    }
}
