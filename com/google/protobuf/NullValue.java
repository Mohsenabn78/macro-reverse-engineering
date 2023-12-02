package com.google.protobuf;

import com.google.protobuf.Internal;

/* loaded from: classes6.dex */
public enum NullValue implements Internal.EnumLite {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    public static final int NULL_VALUE_VALUE = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final Internal.EnumLiteMap<NullValue> f33507a = new Internal.EnumLiteMap<NullValue>() { // from class: com.google.protobuf.NullValue.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public NullValue findValueByNumber(int i4) {
            return NullValue.forNumber(i4);
        }
    };
    private final int value;

    /* loaded from: classes6.dex */
    private static final class NullValueVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f33509a = new NullValueVerifier();

        private NullValueVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i4) {
            if (NullValue.forNumber(i4) != null) {
                return true;
            }
            return false;
        }
    }

    NullValue(int i4) {
        this.value = i4;
    }

    public static NullValue forNumber(int i4) {
        if (i4 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static Internal.EnumLiteMap<NullValue> internalGetValueMap() {
        return f33507a;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return NullValueVerifier.f33509a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static NullValue valueOf(int i4) {
        return forNumber(i4);
    }
}
