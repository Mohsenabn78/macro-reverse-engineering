package com.koushikdutta.ion.gson;

import com.google.gson.JsonObject;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public class GsonObjectParser extends GsonParser<JsonObject> {
    public GsonObjectParser() {
        super(JsonObject.class);
    }

    public GsonObjectParser(Charset charset) {
        super(JsonObject.class, charset);
    }
}
