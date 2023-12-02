package com.arlosoft.macrodroid.notification;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: NotificationChannelList.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NotificationChannelList {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<NotificationChannel> f13013a;

    public NotificationChannelList(@NotNull List<NotificationChannel> notificationChannels) {
        Intrinsics.checkNotNullParameter(notificationChannels, "notificationChannels");
        this.f13013a = notificationChannels;
    }

    @NotNull
    public final List<NotificationChannel> getNotificationChannels() {
        return this.f13013a;
    }
}
