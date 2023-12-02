package com.google.api.client.googleapis.notifications.json;

import com.google.api.client.googleapis.notifications.TypedNotificationCallback;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public abstract class JsonNotificationCallback<T> extends TypedNotificationCallback<T> {
    private static final long serialVersionUID = 1;

    protected abstract JsonFactory e() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.googleapis.notifications.TypedNotificationCallback
    /* renamed from: f */
    public final JsonObjectParser b() throws IOException {
        return new JsonObjectParser(e());
    }
}
