package com.fasterxml.jackson.core;

/* loaded from: classes3.dex */
public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;

    public JsonGenerationException(Throwable th) {
        super(th);
    }

    public JsonGenerationException(String str) {
        super(str, null);
    }

    public JsonGenerationException(String str, Throwable th) {
        super(str, null, th);
    }
}
