package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.Serializable;

@Beta
/* loaded from: classes5.dex */
public interface UnparsedNotificationCallback extends Serializable {
    void onNotification(StoredChannel storedChannel, UnparsedNotification unparsedNotification) throws IOException;
}
