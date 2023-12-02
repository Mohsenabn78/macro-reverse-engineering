package com.koushikdutta.async.http.body;

import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.NameValuePair;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* loaded from: classes6.dex */
public class Part {
    public static final String CONTENT_DISPOSITION = "Content-Disposition";

    /* renamed from: a  reason: collision with root package name */
    Headers f35140a;

    /* renamed from: b  reason: collision with root package name */
    Multimap f35141b;

    /* renamed from: c  reason: collision with root package name */
    private long f35142c;

    public Part(Headers headers) {
        this.f35142c = -1L;
        this.f35140a = headers;
        this.f35141b = Multimap.parseSemicolonDelimited(headers.get("Content-Disposition"));
    }

    public String getContentType() {
        return this.f35140a.get("Content-Type");
    }

    public String getFilename() {
        String string = this.f35141b.getString("filename");
        if (string == null) {
            return null;
        }
        return new File(string).getName();
    }

    public String getName() {
        return this.f35141b.getString("name");
    }

    public Headers getRawHeaders() {
        return this.f35140a;
    }

    public boolean isFile() {
        return this.f35141b.containsKey("filename");
    }

    public long length() {
        return this.f35142c;
    }

    public void setContentType(String str) {
        this.f35140a.set("Content-Type", str);
    }

    public Part(String str, long j4, List<NameValuePair> list) {
        this.f35142c = j4;
        this.f35140a = new Headers();
        StringBuilder sb = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", str));
        if (list != null) {
            for (NameValuePair nameValuePair : list) {
                sb.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", nameValuePair.getName(), nameValuePair.getValue()));
            }
        }
        this.f35140a.set("Content-Disposition", sb.toString());
        this.f35141b = Multimap.parseSemicolonDelimited(this.f35140a.get("Content-Disposition"));
    }

    public void write(DataSink dataSink, CompletedCallback completedCallback) {
    }
}
