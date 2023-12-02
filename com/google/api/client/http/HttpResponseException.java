package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;

/* loaded from: classes5.dex */
public class HttpResponseException extends IOException {
    private static final long serialVersionUID = -1875819453475890043L;

    /* renamed from: a  reason: collision with root package name */
    private final transient HttpHeaders f25827a;
    private final String content;
    private final int statusCode;
    private final String statusMessage;

    public HttpResponseException(HttpResponse httpResponse) {
        this(new Builder(httpResponse));
    }

    public static StringBuilder computeMessageBuffer(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder();
        int statusCode = httpResponse.getStatusCode();
        if (statusCode != 0) {
            sb.append(statusCode);
        }
        String statusMessage = httpResponse.getStatusMessage();
        if (statusMessage != null) {
            if (statusCode != 0) {
                sb.append(' ');
            }
            sb.append(statusMessage);
        }
        return sb;
    }

    public final String getContent() {
        return this.content;
    }

    public HttpHeaders getHeaders() {
        return this.f25827a;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final boolean isSuccessStatusCode() {
        return HttpStatusCodes.isSuccess(this.statusCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpResponseException(Builder builder) {
        super(builder.f25832e);
        this.statusCode = builder.f25828a;
        this.statusMessage = builder.f25829b;
        this.f25827a = builder.f25830c;
        this.content = builder.f25831d;
    }

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        int f25828a;

        /* renamed from: b  reason: collision with root package name */
        String f25829b;

        /* renamed from: c  reason: collision with root package name */
        HttpHeaders f25830c;

        /* renamed from: d  reason: collision with root package name */
        String f25831d;

        /* renamed from: e  reason: collision with root package name */
        String f25832e;

        public Builder(int i4, String str, HttpHeaders httpHeaders) {
            setStatusCode(i4);
            setStatusMessage(str);
            setHeaders(httpHeaders);
        }

        public HttpResponseException build() {
            return new HttpResponseException(this);
        }

        public final String getContent() {
            return this.f25831d;
        }

        public HttpHeaders getHeaders() {
            return this.f25830c;
        }

        public final String getMessage() {
            return this.f25832e;
        }

        public final int getStatusCode() {
            return this.f25828a;
        }

        public final String getStatusMessage() {
            return this.f25829b;
        }

        public Builder setContent(String str) {
            this.f25831d = str;
            return this;
        }

        public Builder setHeaders(HttpHeaders httpHeaders) {
            this.f25830c = (HttpHeaders) Preconditions.checkNotNull(httpHeaders);
            return this;
        }

        public Builder setMessage(String str) {
            this.f25832e = str;
            return this;
        }

        public Builder setStatusCode(int i4) {
            boolean z3;
            if (i4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f25828a = i4;
            return this;
        }

        public Builder setStatusMessage(String str) {
            this.f25829b = str;
            return this;
        }

        public Builder(HttpResponse httpResponse) {
            this(httpResponse.getStatusCode(), httpResponse.getStatusMessage(), httpResponse.getHeaders());
            try {
                String parseAsString = httpResponse.parseAsString();
                this.f25831d = parseAsString;
                if (parseAsString.length() == 0) {
                    this.f25831d = null;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            StringBuilder computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
            if (this.f25831d != null) {
                computeMessageBuffer.append(StringUtils.LINE_SEPARATOR);
                computeMessageBuffer.append(this.f25831d);
            }
            this.f25832e = computeMessageBuffer.toString();
        }
    }
}
