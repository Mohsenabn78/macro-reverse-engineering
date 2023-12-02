package com.facebook.stetho.dumpapp;

/* loaded from: classes3.dex */
class UnexpectedFrameException extends DumpappFramingException {
    public UnexpectedFrameException(byte b4, byte b5) {
        super("Expected '" + ((int) b4) + "', got: '" + ((int) b5) + "'");
    }
}
