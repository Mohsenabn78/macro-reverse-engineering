package com.fasterxml.jackson.core;

/* loaded from: classes3.dex */
public enum JsonToken {
    NOT_AVAILABLE(null),
    START_OBJECT("{"),
    END_OBJECT("}"),
    START_ARRAY("["),
    END_ARRAY("]"),
    FIELD_NAME(null),
    VALUE_EMBEDDED_OBJECT(null),
    VALUE_STRING(null),
    VALUE_NUMBER_INT(null),
    VALUE_NUMBER_FLOAT(null),
    VALUE_TRUE("true"),
    VALUE_FALSE("false"),
    VALUE_NULL("null");
    
    final String _serialized;
    final byte[] _serializedBytes;
    final char[] _serializedChars;

    JsonToken(String str) {
        if (str == null) {
            this._serialized = null;
            this._serializedChars = null;
            this._serializedBytes = null;
            return;
        }
        this._serialized = str;
        char[] charArray = str.toCharArray();
        this._serializedChars = charArray;
        int length = charArray.length;
        this._serializedBytes = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            this._serializedBytes[i4] = (byte) this._serializedChars[i4];
        }
    }

    public byte[] asByteArray() {
        return this._serializedBytes;
    }

    public char[] asCharArray() {
        return this._serializedChars;
    }

    public String asString() {
        return this._serialized;
    }

    public boolean isNumeric() {
        if (this != VALUE_NUMBER_INT && this != VALUE_NUMBER_FLOAT) {
            return false;
        }
        return true;
    }

    public boolean isScalarValue() {
        if (ordinal() >= VALUE_EMBEDDED_OBJECT.ordinal()) {
            return true;
        }
        return false;
    }
}
