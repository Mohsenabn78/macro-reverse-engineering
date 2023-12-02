package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.MergedStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class DataFormatMatcher {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f17703a;

    /* renamed from: b  reason: collision with root package name */
    protected final byte[] f17704b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f17705c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f17706d;

    /* renamed from: e  reason: collision with root package name */
    protected final JsonFactory f17707e;

    /* renamed from: f  reason: collision with root package name */
    protected final MatchStrength f17708f;

    /* JADX INFO: Access modifiers changed from: protected */
    public DataFormatMatcher(InputStream inputStream, byte[] bArr, int i4, int i5, JsonFactory jsonFactory, MatchStrength matchStrength) {
        this.f17703a = inputStream;
        this.f17704b = bArr;
        this.f17705c = i4;
        this.f17706d = i5;
        this.f17707e = jsonFactory;
        this.f17708f = matchStrength;
    }

    public JsonParser createParserWithMatch() throws IOException {
        JsonFactory jsonFactory = this.f17707e;
        if (jsonFactory == null) {
            return null;
        }
        if (this.f17703a == null) {
            return jsonFactory.createJsonParser(this.f17704b, this.f17705c, this.f17706d);
        }
        return jsonFactory.createJsonParser(getDataStream());
    }

    public InputStream getDataStream() {
        if (this.f17703a == null) {
            return new ByteArrayInputStream(this.f17704b, this.f17705c, this.f17706d);
        }
        return new MergedStream(null, this.f17703a, this.f17704b, this.f17705c, this.f17706d);
    }

    public JsonFactory getMatch() {
        return this.f17707e;
    }

    public MatchStrength getMatchStrength() {
        MatchStrength matchStrength = this.f17708f;
        if (matchStrength == null) {
            return MatchStrength.INCONCLUSIVE;
        }
        return matchStrength;
    }

    public String getMatchedFormatName() {
        return this.f17707e.getFormatName();
    }

    public boolean hasMatch() {
        if (this.f17707e != null) {
            return true;
        }
        return false;
    }
}
