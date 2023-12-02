package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Strings;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public abstract class AbstractGoogleClient {

    /* renamed from: j  reason: collision with root package name */
    static final Logger f25694j = Logger.getLogger(AbstractGoogleClient.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final HttpRequestFactory f25695a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleClientRequestInitializer f25696b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25697c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25698d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25699e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25700f;

    /* renamed from: g  reason: collision with root package name */
    private final ObjectParser f25701g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f25702h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f25703i;

    /* loaded from: classes5.dex */
    public static abstract class Builder {

        /* renamed from: a  reason: collision with root package name */
        final HttpTransport f25704a;

        /* renamed from: b  reason: collision with root package name */
        GoogleClientRequestInitializer f25705b;

        /* renamed from: c  reason: collision with root package name */
        HttpRequestInitializer f25706c;

        /* renamed from: d  reason: collision with root package name */
        final ObjectParser f25707d;

        /* renamed from: e  reason: collision with root package name */
        String f25708e;

        /* renamed from: f  reason: collision with root package name */
        String f25709f;

        /* renamed from: g  reason: collision with root package name */
        String f25710g;

        /* renamed from: h  reason: collision with root package name */
        String f25711h;

        /* renamed from: i  reason: collision with root package name */
        boolean f25712i;

        /* renamed from: j  reason: collision with root package name */
        boolean f25713j;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(HttpTransport httpTransport, String str, String str2, ObjectParser objectParser, HttpRequestInitializer httpRequestInitializer) {
            this.f25704a = (HttpTransport) Preconditions.checkNotNull(httpTransport);
            this.f25707d = objectParser;
            setRootUrl(str);
            setServicePath(str2);
            this.f25706c = httpRequestInitializer;
        }

        public abstract AbstractGoogleClient build();

        public final String getApplicationName() {
            return this.f25711h;
        }

        public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
            return this.f25705b;
        }

        public final HttpRequestInitializer getHttpRequestInitializer() {
            return this.f25706c;
        }

        public ObjectParser getObjectParser() {
            return this.f25707d;
        }

        public final String getRootUrl() {
            return this.f25708e;
        }

        public final String getServicePath() {
            return this.f25709f;
        }

        public final boolean getSuppressPatternChecks() {
            return this.f25712i;
        }

        public final boolean getSuppressRequiredParameterChecks() {
            return this.f25713j;
        }

        public final HttpTransport getTransport() {
            return this.f25704a;
        }

        public Builder setApplicationName(String str) {
            this.f25711h = str;
            return this;
        }

        public Builder setBatchPath(String str) {
            this.f25710g = str;
            return this;
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            this.f25705b = googleClientRequestInitializer;
            return this;
        }

        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            this.f25706c = httpRequestInitializer;
            return this;
        }

        public Builder setRootUrl(String str) {
            this.f25708e = AbstractGoogleClient.b(str);
            return this;
        }

        public Builder setServicePath(String str) {
            this.f25709f = AbstractGoogleClient.c(str);
            return this;
        }

        public Builder setSuppressAllChecks(boolean z3) {
            return setSuppressPatternChecks(true).setSuppressRequiredParameterChecks(true);
        }

        public Builder setSuppressPatternChecks(boolean z3) {
            this.f25712i = z3;
            return this;
        }

        public Builder setSuppressRequiredParameterChecks(boolean z3) {
            this.f25713j = z3;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractGoogleClient(Builder builder) {
        HttpRequestFactory createRequestFactory;
        this.f25696b = builder.f25705b;
        this.f25697c = b(builder.f25708e);
        this.f25698d = c(builder.f25709f);
        this.f25699e = builder.f25710g;
        if (Strings.isNullOrEmpty(builder.f25711h)) {
            f25694j.warning("Application name is not set. Call Builder#setApplicationName.");
        }
        this.f25700f = builder.f25711h;
        HttpRequestInitializer httpRequestInitializer = builder.f25706c;
        if (httpRequestInitializer == null) {
            createRequestFactory = builder.f25704a.createRequestFactory();
        } else {
            createRequestFactory = builder.f25704a.createRequestFactory(httpRequestInitializer);
        }
        this.f25695a = createRequestFactory;
        this.f25701g = builder.f25707d;
        this.f25702h = builder.f25712i;
        this.f25703i = builder.f25713j;
    }

    static String b(String str) {
        Preconditions.checkNotNull(str, "root URL cannot be null.");
        if (!str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return str.concat(RemoteSettings.FORWARD_SLASH_STRING);
        }
        return str;
    }

    static String c(String str) {
        Preconditions.checkNotNull(str, "service path cannot be null");
        if (str.length() == 1) {
            Preconditions.checkArgument(RemoteSettings.FORWARD_SLASH_STRING.equals(str), "service path must equal \"/\" if it is of length 1.");
            return "";
        } else if (str.length() > 0) {
            if (!str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                str = str.concat(RemoteSettings.FORWARD_SLASH_STRING);
            }
            if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                return str.substring(1);
            }
            return str;
        } else {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        if (getGoogleClientRequestInitializer() != null) {
            getGoogleClientRequestInitializer().initialize(abstractGoogleClientRequest);
        }
    }

    public final BatchRequest batch() {
        return batch(null);
    }

    public final String getApplicationName() {
        return this.f25700f;
    }

    public final String getBaseUrl() {
        String valueOf = String.valueOf(this.f25697c);
        String valueOf2 = String.valueOf(this.f25698d);
        if (valueOf2.length() != 0) {
            return valueOf.concat(valueOf2);
        }
        return new String(valueOf);
    }

    public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
        return this.f25696b;
    }

    public ObjectParser getObjectParser() {
        return this.f25701g;
    }

    public final HttpRequestFactory getRequestFactory() {
        return this.f25695a;
    }

    public final String getRootUrl() {
        return this.f25697c;
    }

    public final String getServicePath() {
        return this.f25698d;
    }

    public final boolean getSuppressPatternChecks() {
        return this.f25702h;
    }

    public final boolean getSuppressRequiredParameterChecks() {
        return this.f25703i;
    }

    public final BatchRequest batch(HttpRequestInitializer httpRequestInitializer) {
        BatchRequest batchRequest = new BatchRequest(getRequestFactory().getTransport(), httpRequestInitializer);
        String valueOf = String.valueOf(getRootUrl());
        String valueOf2 = String.valueOf(this.f25699e);
        batchRequest.setBatchUrl(new GenericUrl(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
        return batchRequest;
    }
}
