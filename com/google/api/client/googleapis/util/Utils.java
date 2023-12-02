package com.google.api.client.googleapis.util;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes5.dex */
public final class Utils {

    /* loaded from: classes5.dex */
    private static class JsonFactoryInstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        static final JsonFactory f25746a = new JacksonFactory();

        private JsonFactoryInstanceHolder() {
        }
    }

    /* loaded from: classes5.dex */
    private static class TransportInstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        static final HttpTransport f25747a = new NetHttpTransport();

        private TransportInstanceHolder() {
        }
    }

    private Utils() {
    }

    public static JsonFactory getDefaultJsonFactory() {
        return JsonFactoryInstanceHolder.f25746a;
    }

    public static HttpTransport getDefaultTransport() {
        return TransportInstanceHolder.f25747a;
    }
}
