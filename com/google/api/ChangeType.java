package com.google.api;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum ChangeType implements Internal.EnumLite {
    CHANGE_TYPE_UNSPECIFIED(0),
    ADDED(1),
    REMOVED(2),
    MODIFIED(3),
    UNRECOGNIZED(-1);
    
    public static final int ADDED_VALUE = 1;
    public static final int CHANGE_TYPE_UNSPECIFIED_VALUE = 0;
    public static final int MODIFIED_VALUE = 3;
    public static final int REMOVED_VALUE = 2;

    /* renamed from: a  reason: collision with root package name */
    private static final Internal.EnumLiteMap<ChangeType> f25394a = new Internal.EnumLiteMap<ChangeType>() { // from class: com.google.api.ChangeType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public ChangeType findValueByNumber(int i4) {
            return ChangeType.forNumber(i4);
        }
    };
    private final int value;

    /* loaded from: classes5.dex */
    private static final class ChangeTypeVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f25396a = new ChangeTypeVerifier();

        private ChangeTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i4) {
            if (ChangeType.forNumber(i4) != null) {
                return true;
            }
            return false;
        }
    }

    ChangeType(int i4) {
        this.value = i4;
    }

    public static ChangeType forNumber(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return MODIFIED;
                }
                return REMOVED;
            }
            return ADDED;
        }
        return CHANGE_TYPE_UNSPECIFIED;
    }

    public static Internal.EnumLiteMap<ChangeType> internalGetValueMap() {
        return f25394a;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ChangeTypeVerifier.f25396a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static ChangeType valueOf(int i4) {
        return forNumber(i4);
    }
}
