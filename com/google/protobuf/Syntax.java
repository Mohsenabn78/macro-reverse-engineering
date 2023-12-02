package com.google.protobuf;

import com.google.protobuf.Internal;

/* loaded from: classes6.dex */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;

    /* renamed from: a  reason: collision with root package name */
    private static final Internal.EnumLiteMap<Syntax> f33578a = new Internal.EnumLiteMap<Syntax>() { // from class: com.google.protobuf.Syntax.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public Syntax findValueByNumber(int i4) {
            return Syntax.forNumber(i4);
        }
    };
    private final int value;

    /* loaded from: classes6.dex */
    private static final class SyntaxVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f33580a = new SyntaxVerifier();

        private SyntaxVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i4) {
            if (Syntax.forNumber(i4) != null) {
                return true;
            }
            return false;
        }
    }

    Syntax(int i4) {
        this.value = i4;
    }

    public static Syntax forNumber(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                return null;
            }
            return SYNTAX_PROTO3;
        }
        return SYNTAX_PROTO2;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return f33578a;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SyntaxVerifier.f33580a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static Syntax valueOf(int i4) {
        return forNumber(i4);
    }
}
