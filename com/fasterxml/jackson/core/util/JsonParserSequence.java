package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class JsonParserSequence extends JsonParserDelegate {

    /* renamed from: c  reason: collision with root package name */
    protected final JsonParser[] f17893c;

    /* renamed from: d  reason: collision with root package name */
    protected int f17894d;

    protected JsonParserSequence(JsonParser[] jsonParserArr) {
        super(jsonParserArr[0]);
        this.f17893c = jsonParserArr;
        this.f17894d = 1;
    }

    public static JsonParserSequence createFlattened(JsonParser jsonParser, JsonParser jsonParser2) {
        boolean z3 = jsonParser instanceof JsonParserSequence;
        if (!z3 && !(jsonParser2 instanceof JsonParserSequence)) {
            return new JsonParserSequence(new JsonParser[]{jsonParser, jsonParser2});
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            ((JsonParserSequence) jsonParser).d(arrayList);
        } else {
            arrayList.add(jsonParser);
        }
        if (jsonParser2 instanceof JsonParserSequence) {
            ((JsonParserSequence) jsonParser2).d(arrayList);
        } else {
            arrayList.add(jsonParser2);
        }
        return new JsonParserSequence((JsonParser[]) arrayList.toArray(new JsonParser[arrayList.size()]));
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        do {
            this.f17892b.close();
        } while (e());
    }

    public int containedParsersCount() {
        return this.f17893c.length;
    }

    protected void d(List<JsonParser> list) {
        int length = this.f17893c.length;
        for (int i4 = this.f17894d - 1; i4 < length; i4++) {
            JsonParser jsonParser = this.f17893c[i4];
            if (jsonParser instanceof JsonParserSequence) {
                ((JsonParserSequence) jsonParser).d(list);
            } else {
                list.add(jsonParser);
            }
        }
    }

    protected boolean e() {
        int i4 = this.f17894d;
        JsonParser[] jsonParserArr = this.f17893c;
        if (i4 >= jsonParserArr.length) {
            return false;
        }
        this.f17894d = i4 + 1;
        this.f17892b = jsonParserArr[i4];
        return true;
    }

    @Override // com.fasterxml.jackson.core.util.JsonParserDelegate, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException, JsonParseException {
        JsonToken nextToken = this.f17892b.nextToken();
        if (nextToken != null) {
            return nextToken;
        }
        while (e()) {
            JsonToken nextToken2 = this.f17892b.nextToken();
            if (nextToken2 != null) {
                return nextToken2;
            }
        }
        return null;
    }
}
