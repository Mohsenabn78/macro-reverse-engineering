package com.arlosoft.macrodroid.events;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RefreshStopClubEvent.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class RefreshStopClubEvent {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11984a;

    public RefreshStopClubEvent() {
        this(false, 1, null);
    }

    public final boolean getForceActivate() {
        return this.f11984a;
    }

    public RefreshStopClubEvent(boolean z3) {
        this.f11984a = z3;
    }

    public /* synthetic */ RefreshStopClubEvent(boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z3);
    }
}
