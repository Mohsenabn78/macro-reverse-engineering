package com.koushikdutta.async.http.socketio;

import com.koushikdutta.async.http.AsyncHttpPost;

/* loaded from: classes6.dex */
public class SocketIORequest extends AsyncHttpPost {

    /* renamed from: l  reason: collision with root package name */
    Config f35388l;

    /* renamed from: m  reason: collision with root package name */
    String f35389m;

    /* renamed from: n  reason: collision with root package name */
    String f35390n;

    /* loaded from: classes6.dex */
    public static class Config {

        /* renamed from: a  reason: collision with root package name */
        boolean f35391a = false;

        /* renamed from: b  reason: collision with root package name */
        long f35392b = 1000;

        /* renamed from: c  reason: collision with root package name */
        long f35393c = 0;

        public long getReconnectDelay() {
            return this.f35392b;
        }

        public long getReconnectDelayMax() {
            return this.f35393c;
        }

        public boolean isRandomizeReconnectDelay() {
            return this.f35391a;
        }

        public void setRandomizeReconnectDelay(boolean z3) {
            this.f35391a = z3;
        }

        public void setReconnectDelay(long j4) {
            if (j4 >= 0) {
                this.f35392b = j4;
                return;
            }
            throw new IllegalArgumentException("reconnectDelay must be >= 0");
        }

        public void setReconnectDelayMax(long j4) {
            if (this.f35392b >= 0) {
                this.f35393c = j4;
                return;
            }
            throw new IllegalArgumentException("reconnectDelayMax must be >= 0");
        }
    }

    public SocketIORequest(String str) {
        this(str, "");
    }

    public Config getConfig() {
        return this.f35388l;
    }

    public String getEndpoint() {
        return this.f35389m;
    }

    public String getQuery() {
        return this.f35390n;
    }

    public SocketIORequest(String str, String str2) {
        this(str, str2, null);
    }

    public SocketIORequest(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SocketIORequest(java.lang.String r3, java.lang.String r4, java.lang.String r5, com.koushikdutta.async.http.socketio.SocketIORequest.Config r6) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            if (r5 != 0) goto Ld
            java.lang.String r3 = ""
            goto L1e
        Ld:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "?"
            r3.append(r1)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
        L1e:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            android.net.Uri$Builder r3 = r3.buildUpon()
            java.lang.String r0 = "/socket.io/1/"
            android.net.Uri$Builder r3 = r3.encodedPath(r0)
            android.net.Uri r3 = r3.build()
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            if (r6 == 0) goto L41
            goto L46
        L41:
            com.koushikdutta.async.http.socketio.SocketIORequest$Config r6 = new com.koushikdutta.async.http.socketio.SocketIORequest$Config
            r6.<init>()
        L46:
            r2.f35388l = r6
            r2.f35389m = r4
            r2.f35390n = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.socketio.SocketIORequest.<init>(java.lang.String, java.lang.String, java.lang.String, com.koushikdutta.async.http.socketio.SocketIORequest$Config):void");
    }
}
