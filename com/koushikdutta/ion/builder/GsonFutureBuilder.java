package com.koushikdutta.ion.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.future.ResponseFuture;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public interface GsonFutureBuilder {
    <T> ResponseFuture<T> as(TypeToken<T> typeToken);

    <T> ResponseFuture<T> as(Class<T> cls);

    ResponseFuture<JsonArray> asJsonArray();

    ResponseFuture<JsonArray> asJsonArray(Charset charset);

    ResponseFuture<JsonObject> asJsonObject();

    ResponseFuture<JsonObject> asJsonObject(Charset charset);
}
