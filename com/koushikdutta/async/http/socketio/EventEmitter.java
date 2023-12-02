package com.koushikdutta.async.http.socketio;

import com.koushikdutta.async.util.HashList;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: classes6.dex */
public class EventEmitter {

    /* renamed from: a  reason: collision with root package name */
    HashList<EventCallback> f35369a = new HashList<>();

    /* loaded from: classes6.dex */
    class a implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EventCallback f35370a;

        a(EventCallback eventCallback) {
            this.f35370a = eventCallback;
        }

        @Override // com.koushikdutta.async.http.socketio.EventCallback
        public void onEvent(JSONArray jSONArray, Acknowledge acknowledge) {
            this.f35370a.onEvent(jSONArray, acknowledge);
        }
    }

    /* loaded from: classes6.dex */
    interface b extends EventCallback {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONArray jSONArray, Acknowledge acknowledge) {
        ArrayList<EventCallback> arrayList = this.f35369a.get(str);
        if (arrayList == null) {
            return;
        }
        Iterator<EventCallback> it = arrayList.iterator();
        while (it.hasNext()) {
            EventCallback next = it.next();
            next.onEvent(jSONArray, acknowledge);
            if (next instanceof b) {
                it.remove();
            }
        }
    }

    public void addListener(String str, EventCallback eventCallback) {
        on(str, eventCallback);
    }

    public void on(String str, EventCallback eventCallback) {
        this.f35369a.add(str, eventCallback);
    }

    public void once(String str, EventCallback eventCallback) {
        on(str, new a(eventCallback));
    }

    public void removeListener(String str, EventCallback eventCallback) {
        ArrayList<EventCallback> arrayList = this.f35369a.get(str);
        if (arrayList == null) {
            return;
        }
        arrayList.remove(eventCallback);
    }
}
