package com.koushikdutta.async.http.socketio;

import android.text.TextUtils;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.socketio.transport.SocketIOTransport;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes6.dex */
public class SocketIOClient extends EventEmitter {

    /* renamed from: b  reason: collision with root package name */
    boolean f35372b;

    /* renamed from: c  reason: collision with root package name */
    boolean f35373c;

    /* renamed from: d  reason: collision with root package name */
    ConnectCallback f35374d;

    /* renamed from: e  reason: collision with root package name */
    ExceptionCallback f35375e;

    /* renamed from: f  reason: collision with root package name */
    ErrorCallback f35376f;

    /* renamed from: g  reason: collision with root package name */
    DisconnectCallback f35377g;

    /* renamed from: h  reason: collision with root package name */
    ReconnectCallback f35378h;

    /* renamed from: i  reason: collision with root package name */
    JSONCallback f35379i;

    /* renamed from: j  reason: collision with root package name */
    StringCallback f35380j;

    /* renamed from: k  reason: collision with root package name */
    com.koushikdutta.async.http.socketio.a f35381k;

    /* renamed from: l  reason: collision with root package name */
    String f35382l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements ConnectCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SocketIORequest f35383a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ConnectCallback f35384b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f35385c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.koushikdutta.async.http.socketio.a f35386d;

        /* renamed from: com.koushikdutta.async.http.socketio.SocketIOClient$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0195a implements ConnectCallback {
            C0195a() {
            }

            @Override // com.koushikdutta.async.http.socketio.ConnectCallback
            public void onConnectCompleted(Exception exc, SocketIOClient socketIOClient) {
                ConnectCallback connectCallback = a.this.f35384b;
                if (connectCallback != null) {
                    connectCallback.onConnectCompleted(exc, socketIOClient);
                }
                a.this.f35385c.setComplete(exc, socketIOClient);
            }
        }

        a(SocketIORequest socketIORequest, ConnectCallback connectCallback, SimpleFuture simpleFuture, com.koushikdutta.async.http.socketio.a aVar) {
            this.f35383a = socketIORequest;
            this.f35384b = connectCallback;
            this.f35385c = simpleFuture;
            this.f35386d = aVar;
        }

        @Override // com.koushikdutta.async.http.socketio.ConnectCallback
        public void onConnectCompleted(Exception exc, SocketIOClient socketIOClient) {
            if (exc == null && !TextUtils.isEmpty(this.f35383a.getEndpoint())) {
                this.f35386d.f35397d.remove(socketIOClient);
                socketIOClient.of(this.f35383a.getEndpoint(), new C0195a());
                return;
            }
            ConnectCallback connectCallback = this.f35384b;
            if (connectCallback != null) {
                connectCallback.onConnectCompleted(exc, socketIOClient);
            }
            this.f35385c.setComplete(exc, socketIOClient);
        }
    }

    private SocketIOClient(com.koushikdutta.async.http.socketio.a aVar, String str, ConnectCallback connectCallback) {
        this.f35382l = str;
        this.f35381k = aVar;
        this.f35374d = connectCallback;
    }

    private void b(int i4, String str, Acknowledge acknowledge) {
        this.f35381k.o(i4, this, str, acknowledge);
    }

    public static Future<SocketIOClient> connect(AsyncHttpClient asyncHttpClient, String str, ConnectCallback connectCallback) {
        return connect(asyncHttpClient, new SocketIORequest(str), connectCallback);
    }

    public void disconnect() {
        this.f35381k.n(this);
        DisconnectCallback disconnectCallback = this.f35377g;
        if (disconnectCallback != null) {
            disconnectCallback.onDisconnect(null);
        }
    }

    public void emit(String str, JSONArray jSONArray) {
        emit(str, jSONArray, null);
    }

    public void emitEvent(String str) {
        emitEvent(str, null);
    }

    public DisconnectCallback getDisconnectCallback() {
        return this.f35377g;
    }

    public ErrorCallback getErrorCallback() {
        return this.f35376f;
    }

    public ExceptionCallback getExceptionCallback() {
        return this.f35375e;
    }

    public JSONCallback getJSONCallback() {
        return this.f35379i;
    }

    public ReconnectCallback getReconnectCallback() {
        return this.f35378h;
    }

    public StringCallback getStringCallback() {
        return this.f35380j;
    }

    public SocketIOTransport getTransport() {
        return this.f35381k.f35398e;
    }

    public boolean isConnected() {
        if (this.f35372b && !this.f35373c && this.f35381k.p()) {
            return true;
        }
        return false;
    }

    public void of(String str, ConnectCallback connectCallback) {
        com.koushikdutta.async.http.socketio.a aVar = this.f35381k;
        aVar.l(new SocketIOClient(aVar, str, connectCallback));
    }

    public void reconnect() {
        this.f35381k.r(null);
    }

    public void setDisconnectCallback(DisconnectCallback disconnectCallback) {
        this.f35377g = disconnectCallback;
    }

    public void setErrorCallback(ErrorCallback errorCallback) {
        this.f35376f = errorCallback;
    }

    public void setExceptionCallback(ExceptionCallback exceptionCallback) {
        this.f35375e = exceptionCallback;
    }

    public void setJSONCallback(JSONCallback jSONCallback) {
        this.f35379i = jSONCallback;
    }

    public void setReconnectCallback(ReconnectCallback reconnectCallback) {
        this.f35378h = reconnectCallback;
    }

    public void setStringCallback(StringCallback stringCallback) {
        this.f35380j = stringCallback;
    }

    public static Future<SocketIOClient> connect(AsyncHttpClient asyncHttpClient, SocketIORequest socketIORequest, ConnectCallback connectCallback) {
        SimpleFuture simpleFuture = new SimpleFuture();
        com.koushikdutta.async.http.socketio.a aVar = new com.koushikdutta.async.http.socketio.a(asyncHttpClient, socketIORequest);
        aVar.f35397d.add(new SocketIOClient(aVar, "", new a(socketIORequest, connectCallback, simpleFuture, aVar)));
        aVar.r(simpleFuture);
        return simpleFuture;
    }

    public void emit(String str) {
        emit(str, (Acknowledge) null);
    }

    public void emitEvent(String str, Acknowledge acknowledge) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            b(5, jSONObject.toString(), acknowledge);
        } catch (Exception unused) {
        }
    }

    public void emit(JSONObject jSONObject) {
        emit(jSONObject, (Acknowledge) null);
    }

    public void emit(String str, JSONArray jSONArray, Acknowledge acknowledge) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("args", jSONArray);
            b(5, jSONObject.toString(), acknowledge);
        } catch (Exception unused) {
        }
    }

    public void emit(String str, Acknowledge acknowledge) {
        b(3, str, acknowledge);
    }

    public void emit(JSONObject jSONObject, Acknowledge acknowledge) {
        b(4, jSONObject.toString(), acknowledge);
    }
}
