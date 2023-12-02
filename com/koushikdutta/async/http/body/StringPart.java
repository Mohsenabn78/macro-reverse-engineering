package com.koushikdutta.async.http.body;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class StringPart extends StreamPart {

    /* renamed from: d  reason: collision with root package name */
    String f35150d;

    public StringPart(String str, String str2) {
        super(str, str2.getBytes().length, null);
        this.f35150d = str2;
    }

    @Override // com.koushikdutta.async.http.body.StreamPart
    protected InputStream a() throws IOException {
        return new ByteArrayInputStream(this.f35150d.getBytes());
    }
}
