package com.koushikdutta.async.http.socketio;

import org.json.JSONArray;

/* loaded from: classes6.dex */
public interface EventCallback {
    void onEvent(JSONArray jSONArray, Acknowledge acknowledge);
}
