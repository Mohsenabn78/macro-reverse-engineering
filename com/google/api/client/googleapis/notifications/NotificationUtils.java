package com.google.api.client.googleapis.notifications;

import java.util.UUID;

/* loaded from: classes5.dex */
public final class NotificationUtils {
    private NotificationUtils() {
    }

    public static String randomUuidString() {
        return UUID.randomUUID().toString();
    }
}
