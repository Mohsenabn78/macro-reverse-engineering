package com.facebook.stetho.server.http;

/* loaded from: classes3.dex */
public class LightHttpResponse extends LightHttpMessage {
    public LightHttpBody body;
    public int code;
    public String reasonPhrase;

    public void prepare() {
        LightHttpBody lightHttpBody = this.body;
        if (lightHttpBody != null) {
            addHeader("Content-Type", lightHttpBody.contentType());
            addHeader("Content-Length", String.valueOf(this.body.contentLength()));
        }
    }

    @Override // com.facebook.stetho.server.http.LightHttpMessage
    public void reset() {
        super.reset();
        this.code = -1;
        this.reasonPhrase = null;
        this.body = null;
    }
}
