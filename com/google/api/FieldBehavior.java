package com.google.api;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum FieldBehavior implements Internal.EnumLite {
    FIELD_BEHAVIOR_UNSPECIFIED(0),
    OPTIONAL(1),
    REQUIRED(2),
    OUTPUT_ONLY(3),
    INPUT_ONLY(4),
    IMMUTABLE(5),
    UNRECOGNIZED(-1);
    
    public static final int FIELD_BEHAVIOR_UNSPECIFIED_VALUE = 0;
    public static final int IMMUTABLE_VALUE = 5;
    public static final int INPUT_ONLY_VALUE = 4;
    public static final int OPTIONAL_VALUE = 1;
    public static final int OUTPUT_ONLY_VALUE = 3;
    public static final int REQUIRED_VALUE = 2;

    /* renamed from: a  reason: collision with root package name */
    private static final Internal.EnumLiteMap<FieldBehavior> f25407a = new Internal.EnumLiteMap<FieldBehavior>() { // from class: com.google.api.FieldBehavior.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public FieldBehavior findValueByNumber(int i4) {
            return FieldBehavior.forNumber(i4);
        }
    };
    private final int value;

    /* loaded from: classes5.dex */
    private static final class FieldBehaviorVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f25409a = new FieldBehaviorVerifier();

        private FieldBehaviorVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i4) {
            if (FieldBehavior.forNumber(i4) != null) {
                return true;
            }
            return false;
        }
    }

    FieldBehavior(int i4) {
        this.value = i4;
    }

    public static FieldBehavior forNumber(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                return null;
                            }
                            return IMMUTABLE;
                        }
                        return INPUT_ONLY;
                    }
                    return OUTPUT_ONLY;
                }
                return REQUIRED;
            }
            return OPTIONAL;
        }
        return FIELD_BEHAVIOR_UNSPECIFIED;
    }

    public static Internal.EnumLiteMap<FieldBehavior> internalGetValueMap() {
        return f25407a;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return FieldBehaviorVerifier.f25409a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static FieldBehavior valueOf(int i4) {
        return forNumber(i4);
    }
}
