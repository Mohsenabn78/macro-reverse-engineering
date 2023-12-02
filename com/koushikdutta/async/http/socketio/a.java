package com.koushikdutta.async.http.socketio;

import android.net.Uri;
import android.text.TextUtils;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.DependentCancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.socketio.transport.SocketIOTransport;
import com.koushikdutta.async.http.socketio.transport.WebSocketTransport;
import com.koushikdutta.async.http.socketio.transport.XHRPollingTransport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import kotlin.time.DurationKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SocketIOConnection.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    AsyncHttpClient f35394a;

    /* renamed from: b  reason: collision with root package name */
    int f35395b;

    /* renamed from: c  reason: collision with root package name */
    long f35396c;

    /* renamed from: e  reason: collision with root package name */
    SocketIOTransport f35398e;

    /* renamed from: f  reason: collision with root package name */
    SocketIORequest f35399f;

    /* renamed from: h  reason: collision with root package name */
    int f35401h;

    /* renamed from: i  reason: collision with root package name */
    Cancellable f35402i;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<SocketIOClient> f35397d = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    Hashtable<String, Acknowledge> f35400g = new Hashtable<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* renamed from: com.koushikdutta.async.http.socketio.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0196a implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f35403a;

        C0196a(String str) {
            this.f35403a = str;
        }

        @Override // com.koushikdutta.async.http.socketio.a.o
        public void a(SocketIOClient socketIOClient) {
            ErrorCallback errorCallback = socketIOClient.f35376f;
            if (errorCallback != null) {
                errorCallback.onError(this.f35403a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class b implements Acknowledge {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f35405a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35406b;

        /* compiled from: SocketIOConnection.java */
        /* renamed from: com.koushikdutta.async.http.socketio.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0197a implements o {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Exception f35408a;

            C0197a(Exception exc) {
                this.f35408a = exc;
            }

            @Override // com.koushikdutta.async.http.socketio.a.o
            public void a(SocketIOClient socketIOClient) {
                ExceptionCallback exceptionCallback = socketIOClient.f35375e;
                if (exceptionCallback != null) {
                    exceptionCallback.onException(this.f35408a);
                }
            }
        }

        b(String str, String str2) {
            this.f35405a = str;
            this.f35406b = str2;
        }

        @Override // com.koushikdutta.async.http.socketio.Acknowledge
        public void acknowledge(JSONArray jSONArray) {
            String str = "";
            if (jSONArray != null) {
                str = "" + Marker.ANY_NON_NULL_MARKER + jSONArray.toString();
            }
            SocketIOTransport socketIOTransport = a.this.f35398e;
            if (socketIOTransport == null) {
                a.this.y(this.f35405a, new C0197a(new SocketIOException("not connected to server")));
            } else {
                socketIOTransport.send(String.format(Locale.ENGLISH, "6:::%s%s", this.f35406b, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class c implements CompletedCallback {
        c() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            a aVar = a.this;
            aVar.f35398e = null;
            aVar.t(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class d implements SocketIOTransport.StringCallback {
        d() {
        }

        @Override // com.koushikdutta.async.http.socketio.transport.SocketIOTransport.StringCallback
        public void onStringAvailable(String str) {
            JSONArray jSONArray;
            try {
                String[] split = str.split(":", 4);
                switch (Integer.parseInt(split[0])) {
                    case 0:
                        a.this.f35398e.disconnect();
                        a.this.t(null);
                        return;
                    case 1:
                        a.this.s(split[2]);
                        return;
                    case 2:
                        a.this.f35398e.send("2::");
                        return;
                    case 3:
                        a aVar = a.this;
                        String str2 = split[2];
                        aVar.x(str2, split[3], aVar.j(split[1], str2));
                        return;
                    case 4:
                        JSONObject jSONObject = new JSONObject(split[3]);
                        a aVar2 = a.this;
                        String str3 = split[2];
                        aVar2.w(str3, jSONObject, aVar2.j(split[1], str3));
                        return;
                    case 5:
                        JSONObject jSONObject2 = new JSONObject(split[3]);
                        String string = jSONObject2.getString("name");
                        JSONArray optJSONArray = jSONObject2.optJSONArray("args");
                        a aVar3 = a.this;
                        String str4 = split[2];
                        aVar3.v(str4, string, optJSONArray, aVar3.j(split[1], str4));
                        return;
                    case 6:
                        String[] split2 = split[3].split("\\+", 2);
                        Acknowledge remove = a.this.f35400g.remove(split2[0]);
                        if (remove == null) {
                            return;
                        }
                        if (split2.length == 2) {
                            jSONArray = new JSONArray(split2[1]);
                        } else {
                            jSONArray = null;
                        }
                        remove.acknowledge(jSONArray);
                        return;
                    case 7:
                        a.this.u(split[2], split[3]);
                        return;
                    case 8:
                        return;
                    default:
                        throw new SocketIOException("unknown code");
                }
            } catch (Exception e4) {
                a.this.f35398e.setClosedCallback(null);
                a.this.f35398e.disconnect();
                a aVar4 = a.this;
                aVar4.f35398e = null;
                aVar4.t(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class e implements o {
        e() {
        }

        @Override // com.koushikdutta.async.http.socketio.a.o
        public void a(SocketIOClient socketIOClient) {
            if (TextUtils.isEmpty(socketIOClient.f35382l)) {
                return;
            }
            a.this.l(socketIOClient);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class f implements FutureCallback<SocketIOTransport> {
        f() {
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, SocketIOTransport socketIOTransport) {
            if (exc != null) {
                a.this.t(exc);
                return;
            }
            a aVar = a.this;
            aVar.f35396c = aVar.f35399f.f35388l.f35392b;
            aVar.f35398e = socketIOTransport;
            aVar.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class g extends TransformFuture<SocketIOTransport, String> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SocketIOConnection.java */
        /* renamed from: com.koushikdutta.async.http.socketio.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0198a implements FutureCallback<WebSocket> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SimpleFuture f35415a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f35416b;

            C0198a(SimpleFuture simpleFuture, String str) {
                this.f35415a = simpleFuture;
                this.f35416b = str;
            }

            @Override // com.koushikdutta.async.future.FutureCallback
            /* renamed from: a */
            public void onCompleted(Exception exc, WebSocket webSocket) {
                if (exc != null) {
                    this.f35415a.setComplete(exc);
                } else {
                    this.f35415a.setComplete((SimpleFuture) new WebSocketTransport(webSocket, this.f35416b));
                }
            }
        }

        g() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(String str) throws Exception {
            String[] split = str.split(":");
            String str2 = split[0];
            if (!"".equals(split[1])) {
                a.this.f35395b = (Integer.parseInt(split[1]) / 2) * 1000;
            } else {
                a.this.f35395b = 0;
            }
            HashSet hashSet = new HashSet(Arrays.asList(split[3].split(",")));
            SimpleFuture simpleFuture = new SimpleFuture();
            if (hashSet.contains("websocket")) {
                a.this.f35394a.websocket(Uri.parse(a.this.f35399f.getUri().toString()).buildUpon().appendPath("websocket").appendPath(str2).build().toString(), (String) null, (AsyncHttpClient.WebSocketConnectCallback) null).setCallback(new C0198a(simpleFuture, str2));
            } else if (hashSet.contains("xhr-polling")) {
                simpleFuture.setComplete((SimpleFuture) new XHRPollingTransport(a.this.f35394a, Uri.parse(a.this.f35399f.getUri().toString()).buildUpon().appendPath("xhr-polling").appendPath(str2).build().toString(), str2));
            } else {
                throw new SocketIOException("transport not supported");
            }
            setComplete((Future) simpleFuture);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            SocketIOTransport socketIOTransport = aVar.f35398e;
            if (aVar.f35395b > 0 && socketIOTransport != null && socketIOTransport.isConnected()) {
                socketIOTransport.send("2:::");
                socketIOTransport.getServer().postDelayed(this, a.this.f35395b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.r(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class j implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Exception f35420a;

        j(Exception exc) {
            this.f35420a = exc;
        }

        @Override // com.koushikdutta.async.http.socketio.a.o
        public void a(SocketIOClient socketIOClient) {
            if (socketIOClient.f35372b) {
                socketIOClient.f35373c = true;
                DisconnectCallback disconnectCallback = socketIOClient.getDisconnectCallback();
                if (disconnectCallback != null) {
                    disconnectCallback.onDisconnect(this.f35420a);
                    return;
                }
                return;
            }
            ConnectCallback connectCallback = socketIOClient.f35374d;
            if (connectCallback != null) {
                connectCallback.onConnectCompleted(this.f35420a, socketIOClient);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class k implements o {
        k() {
        }

        @Override // com.koushikdutta.async.http.socketio.a.o
        public void a(SocketIOClient socketIOClient) {
            if (socketIOClient.isConnected()) {
                return;
            }
            if (!socketIOClient.f35372b) {
                socketIOClient.f35372b = true;
                ConnectCallback connectCallback = socketIOClient.f35374d;
                if (connectCallback != null) {
                    connectCallback.onConnectCompleted(null, socketIOClient);
                }
            } else if (socketIOClient.f35373c) {
                socketIOClient.f35373c = false;
                ReconnectCallback reconnectCallback = socketIOClient.f35378h;
                if (reconnectCallback != null) {
                    reconnectCallback.onReconnect();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class l implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f35423a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Acknowledge f35424b;

        l(JSONObject jSONObject, Acknowledge acknowledge) {
            this.f35423a = jSONObject;
            this.f35424b = acknowledge;
        }

        @Override // com.koushikdutta.async.http.socketio.a.o
        public void a(SocketIOClient socketIOClient) {
            JSONCallback jSONCallback = socketIOClient.f35379i;
            if (jSONCallback != null) {
                jSONCallback.onJSON(this.f35423a, this.f35424b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class m implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f35426a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Acknowledge f35427b;

        m(String str, Acknowledge acknowledge) {
            this.f35426a = str;
            this.f35427b = acknowledge;
        }

        @Override // com.koushikdutta.async.http.socketio.a.o
        public void a(SocketIOClient socketIOClient) {
            StringCallback stringCallback = socketIOClient.f35380j;
            if (stringCallback != null) {
                stringCallback.onString(this.f35426a, this.f35427b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public class n implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f35429a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f35430b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Acknowledge f35431c;

        n(String str, JSONArray jSONArray, Acknowledge acknowledge) {
            this.f35429a = str;
            this.f35430b = jSONArray;
            this.f35431c = acknowledge;
        }

        @Override // com.koushikdutta.async.http.socketio.a.o
        public void a(SocketIOClient socketIOClient) {
            socketIOClient.a(this.f35429a, this.f35430b, this.f35431c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SocketIOConnection.java */
    /* loaded from: classes6.dex */
    public interface o {
        void a(SocketIOClient socketIOClient);
    }

    public a(AsyncHttpClient asyncHttpClient, SocketIORequest socketIORequest) {
        this.f35394a = asyncHttpClient;
        this.f35399f = socketIORequest;
        this.f35396c = socketIORequest.f35388l.f35392b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Acknowledge j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new b(str2, str.replaceAll("\\+$", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f35398e.heartbeats()) {
            z();
        }
        this.f35398e.setClosedCallback(new c());
        this.f35398e.setStringCallback(new d());
        y(null, new e());
    }

    private void m() {
        boolean z3;
        if (this.f35398e == null && this.f35397d.size() != 0) {
            Iterator<SocketIOClient> it = this.f35397d.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f35373c) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3) {
                return;
            }
            this.f35394a.getServer().postDelayed(new i(), q(this.f35396c));
            long j4 = this.f35396c * 2;
            this.f35396c = j4;
            long j5 = this.f35399f.f35388l.f35393c;
            if (j5 > 0) {
                this.f35396c = Math.min(j4, j5);
            }
        }
    }

    private long q(long j4) {
        if (j4 >= 2 && j4 <= DurationKt.MAX_MILLIS && this.f35399f.f35388l.f35391a) {
            return (j4 >> 1) + ((long) (j4 * Math.random()));
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        y(str, new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        if (exc != null) {
            this.f35399f.loge("socket.io disconnected", exc);
        } else {
            this.f35399f.logi("socket.io disconnected");
        }
        y(null, new j(exc));
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2) {
        y(str, new C0196a(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, String str2, JSONArray jSONArray, Acknowledge acknowledge) {
        y(str, new n(str2, jSONArray, acknowledge));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, JSONObject jSONObject, Acknowledge acknowledge) {
        y(str, new l(jSONObject, acknowledge));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, String str2, Acknowledge acknowledge) {
        y(str, new m(str2, acknowledge));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, o oVar) {
        Iterator<SocketIOClient> it = this.f35397d.iterator();
        while (it.hasNext()) {
            SocketIOClient next = it.next();
            if (str == null || TextUtils.equals(next.f35382l, str)) {
                oVar.a(next);
            }
        }
    }

    public void l(SocketIOClient socketIOClient) {
        if (!this.f35397d.contains(socketIOClient)) {
            this.f35397d.add(socketIOClient);
        }
        this.f35398e.send(String.format(Locale.ENGLISH, "1::%s", socketIOClient.f35382l));
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(com.koushikdutta.async.http.socketio.SocketIOClient r6) {
        /*
            r5 = this;
            java.util.ArrayList<com.koushikdutta.async.http.socketio.SocketIOClient> r0 = r5.f35397d
            r0.remove(r6)
            java.util.ArrayList<com.koushikdutta.async.http.socketio.SocketIOClient> r0 = r5.f35397d
            java.util.Iterator r0 = r0.iterator()
        Lb:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2d
            java.lang.Object r1 = r0.next()
            com.koushikdutta.async.http.socketio.SocketIOClient r1 = (com.koushikdutta.async.http.socketio.SocketIOClient) r1
            java.lang.String r1 = r1.f35382l
            java.lang.String r4 = r6.f35382l
            boolean r1 = android.text.TextUtils.equals(r1, r4)
            if (r1 != 0) goto L2b
            java.lang.String r1 = r6.f35382l
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto Lb
        L2b:
            r0 = 0
            goto L2e
        L2d:
            r0 = 1
        L2e:
            com.koushikdutta.async.http.socketio.transport.SocketIOTransport r1 = r5.f35398e
            if (r0 == 0) goto L45
            if (r1 == 0) goto L45
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = r6.f35382l
            r3[r2] = r6
            java.lang.String r6 = "0::%s"
            java.lang.String r6 = java.lang.String.format(r0, r6, r3)
            r1.send(r6)
        L45:
            java.util.ArrayList<com.koushikdutta.async.http.socketio.SocketIOClient> r6 = r5.f35397d
            int r6 = r6.size()
            if (r6 > 0) goto L5c
            if (r1 != 0) goto L50
            goto L5c
        L50:
            r6 = 0
            r1.setStringCallback(r6)
            r1.setClosedCallback(r6)
            r1.disconnect()
            r5.f35398e = r6
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.socketio.a.n(com.koushikdutta.async.http.socketio.SocketIOClient):void");
    }

    public void o(int i4, SocketIOClient socketIOClient, String str, Acknowledge acknowledge) {
        String str2 = "";
        if (acknowledge != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            int i5 = this.f35401h;
            this.f35401h = i5 + 1;
            sb.append(i5);
            String sb2 = sb.toString();
            this.f35400g.put(sb2, acknowledge);
            str2 = sb2 + Marker.ANY_NON_NULL_MARKER;
        }
        this.f35398e.send(String.format(Locale.ENGLISH, "%d:%s:%s:%s", Integer.valueOf(i4), str2, socketIOClient.f35382l, str));
    }

    public boolean p() {
        SocketIOTransport socketIOTransport = this.f35398e;
        if (socketIOTransport != null && socketIOTransport.isConnected()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(DependentCancellable dependentCancellable) {
        if (p()) {
            return;
        }
        Cancellable cancellable = this.f35402i;
        if (cancellable != null && !cancellable.isDone() && !this.f35402i.isCancelled()) {
            if (dependentCancellable != null) {
                dependentCancellable.setParent(this.f35402i);
                return;
            }
            return;
        }
        this.f35399f.logi("Reconnecting socket.io");
        SimpleFuture<SocketIOTransport> callback = ((g) this.f35394a.executeString(this.f35399f, null).then(new g())).setCallback((FutureCallback) new f());
        this.f35402i = callback;
        if (dependentCancellable != null) {
            dependentCancellable.setParent(callback);
        }
    }

    void z() {
        new h().run();
    }
}
