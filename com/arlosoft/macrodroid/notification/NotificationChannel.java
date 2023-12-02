package com.arlosoft.macrodroid.notification;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: NotificationChannel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NotificationChannel {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f13011a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13012b;

    public NotificationChannel(@NotNull String channelName, int i4) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        this.f13011a = channelName;
        this.f13012b = i4;
    }

    @NotNull
    public final String getChannelName() {
        return this.f13011a;
    }

    public final int getPriority() {
        return this.f13012b;
    }
}
