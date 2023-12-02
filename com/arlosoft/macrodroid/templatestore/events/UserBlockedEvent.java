package com.arlosoft.macrodroid.templatestore.events;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserBlockedEvent.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserBlockedEvent {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f13648a;

    public UserBlockedEvent(int i4) {
        this.f13648a = i4;
    }

    public static /* synthetic */ UserBlockedEvent copy$default(UserBlockedEvent userBlockedEvent, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = userBlockedEvent.f13648a;
        }
        return userBlockedEvent.copy(i4);
    }

    public final int component1() {
        return this.f13648a;
    }

    @NotNull
    public final UserBlockedEvent copy(int i4) {
        return new UserBlockedEvent(i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UserBlockedEvent) && this.f13648a == ((UserBlockedEvent) obj).f13648a) {
            return true;
        }
        return false;
    }

    public final int getUserId() {
        return this.f13648a;
    }

    public int hashCode() {
        return this.f13648a;
    }

    @NotNull
    public String toString() {
        int i4 = this.f13648a;
        return "UserBlockedEvent(userId=" + i4 + ")";
    }
}
