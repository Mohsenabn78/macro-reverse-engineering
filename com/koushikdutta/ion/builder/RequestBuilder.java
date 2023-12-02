package com.koushikdutta.ion.builder;

import android.app.ProgressDialog;
import android.os.Handler;
import android.widget.ProgressBar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.http.NameValuePair;
import com.koushikdutta.ion.HeadersCallback;
import com.koushikdutta.ion.ProgressCallback;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.builder.MultipartBodyBuilder;
import com.koushikdutta.ion.builder.RequestBuilder;
import com.koushikdutta.ion.builder.UrlEncodedBuilder;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;

/* loaded from: classes6.dex */
public interface RequestBuilder<F, R extends RequestBuilder, M extends MultipartBodyBuilder, U extends UrlEncodedBuilder> extends MultipartBodyBuilder<M>, UrlEncodedBuilder<U> {
    R addHeader(String str, String str2);

    R addHeaders(Map<String, List<String>> map);

    R addQueries(Map<String, List<String>> map);

    R addQuery(String str, String str2);

    R basicAuthentication(String str, String str2);

    R followRedirect(boolean z3);

    R noCache();

    R onHeaders(HeadersCallback headersCallback);

    R progress(ProgressCallback progressCallback);

    R progressBar(ProgressBar progressBar);

    R progressDialog(ProgressDialog progressDialog);

    R progressHandler(ProgressCallback progressCallback);

    R proxy(String str, int i4);

    F setByteArrayBody(byte[] bArr);

    F setDocumentBody(Document document);

    F setFileBody(File file);

    R setHandler(Handler handler);

    R setHeader(String str, String str2);

    R setHeader(NameValuePair... nameValuePairArr);

    F setJsonArrayBody(JsonArray jsonArray);

    F setJsonObjectBody(JsonObject jsonObject);

    <T> F setJsonPojoBody(T t3);

    <T> F setJsonPojoBody(T t3, TypeToken<T> typeToken);

    R setLogging(String str, int i4);

    Builders.Any.F setStreamBody(InputStream inputStream);

    Builders.Any.F setStreamBody(InputStream inputStream, int i4);

    F setStringBody(String str);

    R setTimeout(int i4);

    R uploadProgress(ProgressCallback progressCallback);

    R uploadProgressBar(ProgressBar progressBar);

    R uploadProgressDialog(ProgressDialog progressDialog);

    R uploadProgressHandler(ProgressCallback progressCallback);

    R userAgent(String str);
}
