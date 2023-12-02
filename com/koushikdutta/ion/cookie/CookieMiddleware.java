package com.koushikdutta.ion.cookie;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.SimpleMiddleware;
import com.koushikdutta.ion.Ion;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.SM;

/* loaded from: classes6.dex */
public class CookieMiddleware extends SimpleMiddleware {

    /* renamed from: a  reason: collision with root package name */
    CookieManager f35829a;

    /* renamed from: b  reason: collision with root package name */
    SharedPreferences f35830b;

    /* renamed from: c  reason: collision with root package name */
    Ion f35831c;

    public CookieMiddleware(Ion ion) {
        this.f35831c = ion;
    }

    private void a() {
        if (this.f35829a == null) {
            reinit();
        }
    }

    public static void addCookies(Map<String, List<String>> map, Headers headers) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if ("Cookie".equalsIgnoreCase(key) || SM.COOKIE2.equalsIgnoreCase(key)) {
                headers.addAll(key, entry.getValue());
            }
        }
    }

    public void clear() {
        a();
        getCookieStore().removeAll();
        this.f35830b.edit().clear().apply();
    }

    public CookieManager getCookieManager() {
        a();
        return this.f35829a;
    }

    public CookieStore getCookieStore() {
        return this.f35829a.getCookieStore();
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onHeadersReceived(AsyncHttpClientMiddleware.OnHeadersReceivedDataOnRequestSentData onHeadersReceivedDataOnRequestSentData) {
        a();
        try {
            put(URI.create(onHeadersReceivedDataOnRequestSentData.request.getUri().toString()), onHeadersReceivedDataOnRequestSentData.response.headers());
        } catch (Exception unused) {
        }
    }

    @Override // com.koushikdutta.async.http.SimpleMiddleware, com.koushikdutta.async.http.AsyncHttpClientMiddleware
    public void onRequest(AsyncHttpClientMiddleware.OnRequestData onRequestData) {
        a();
        try {
            addCookies(this.f35829a.get(URI.create(onRequestData.request.getUri().toString()), onRequestData.request.getHeaders().getMultiMap()), onRequestData.request.getHeaders());
        } catch (Exception unused) {
        }
    }

    public void put(URI uri, Headers headers) {
        a();
        try {
            this.f35829a.put(uri, headers.getMultiMap());
            if (headers.get("Set-Cookie") == null) {
                return;
            }
            List<HttpCookie> list = this.f35829a.getCookieStore().get(uri);
            Headers headers2 = new Headers();
            for (HttpCookie httpCookie : list) {
                headers2.add("Set-Cookie", httpCookie.getName() + "=" + httpCookie.getValue() + "; path=" + httpCookie.getPath());
            }
            this.f35830b.edit().putString(uri.getScheme() + "://" + uri.getAuthority(), headers2.toPrefixString("HTTP/1.1 200 OK")).commit();
        } catch (Exception unused) {
        }
    }

    public void reinit() {
        String[] split;
        this.f35829a = new CookieManager(null, null);
        SharedPreferences sharedPreferences = this.f35831c.getContext().getSharedPreferences(this.f35831c.getName() + "-cookies", 0);
        this.f35830b = sharedPreferences;
        for (String str : sharedPreferences.getAll().keySet()) {
            try {
                String string = this.f35830b.getString(str, null);
                Headers headers = new Headers();
                boolean z3 = true;
                for (String str2 : string.split("\n")) {
                    if (z3) {
                        z3 = false;
                    } else if (!TextUtils.isEmpty(str2)) {
                        headers.addLine(str2);
                    }
                }
                this.f35829a.put(URI.create(str), headers.getMultiMap());
            } catch (Exception e4) {
                Log.e("Ion", "unable to load cookies", e4);
            }
        }
    }
}
