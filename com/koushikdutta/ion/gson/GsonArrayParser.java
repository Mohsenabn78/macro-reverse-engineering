package com.koushikdutta.ion.gson;

import com.google.gson.JsonArray;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public class GsonArrayParser extends GsonParser<JsonArray> {
    public GsonArrayParser() {
        super(JsonArray.class);
    }

    public GsonArrayParser(Charset charset) {
        super(JsonArray.class, charset);
    }
}
