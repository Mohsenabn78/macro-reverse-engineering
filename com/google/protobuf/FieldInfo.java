package com.google.protobuf;

import com.google.protobuf.Internal;

@CheckReturnValue
/* loaded from: classes6.dex */
final class FieldInfo implements Comparable<FieldInfo> {

    /* renamed from: a  reason: collision with root package name */
    private final java.lang.reflect.Field f33346a;

    /* renamed from: b  reason: collision with root package name */
    private final FieldType f33347b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f33348c;

    /* renamed from: d  reason: collision with root package name */
    private final int f33349d;

    /* renamed from: e  reason: collision with root package name */
    private final java.lang.reflect.Field f33350e;

    /* renamed from: f  reason: collision with root package name */
    private final int f33351f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f33352g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f33353h;

    /* renamed from: i  reason: collision with root package name */
    private final OneofInfo f33354i;

    /* renamed from: j  reason: collision with root package name */
    private final java.lang.reflect.Field f33355j;

    /* renamed from: k  reason: collision with root package name */
    private final Class<?> f33356k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f33357l;

    /* renamed from: m  reason: collision with root package name */
    private final Internal.EnumVerifier f33358m;

    /* renamed from: com.google.protobuf.FieldInfo$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33359a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f33359a = iArr;
            try {
                iArr[FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33359a[FieldType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33359a[FieldType.MESSAGE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33359a[FieldType.GROUP_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private java.lang.reflect.Field f33360a;

        /* renamed from: b  reason: collision with root package name */
        private FieldType f33361b;

        /* renamed from: c  reason: collision with root package name */
        private int f33362c;

        /* renamed from: d  reason: collision with root package name */
        private java.lang.reflect.Field f33363d;

        /* renamed from: e  reason: collision with root package name */
        private int f33364e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f33365f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f33366g;

        /* renamed from: h  reason: collision with root package name */
        private OneofInfo f33367h;

        /* renamed from: i  reason: collision with root package name */
        private Class<?> f33368i;

        /* renamed from: j  reason: collision with root package name */
        private Object f33369j;

        /* renamed from: k  reason: collision with root package name */
        private Internal.EnumVerifier f33370k;

        /* renamed from: l  reason: collision with root package name */
        private java.lang.reflect.Field f33371l;

        private Builder() {
        }

        public FieldInfo build() {
            OneofInfo oneofInfo = this.f33367h;
            if (oneofInfo != null) {
                return FieldInfo.f(this.f33362c, this.f33361b, oneofInfo, this.f33368i, this.f33366g, this.f33370k);
            }
            Object obj = this.f33369j;
            if (obj != null) {
                return FieldInfo.e(this.f33360a, this.f33362c, obj, this.f33370k);
            }
            java.lang.reflect.Field field = this.f33363d;
            if (field != null) {
                if (this.f33365f) {
                    return FieldInfo.j(this.f33360a, this.f33362c, this.f33361b, field, this.f33364e, this.f33366g, this.f33370k);
                }
                return FieldInfo.i(this.f33360a, this.f33362c, this.f33361b, field, this.f33364e, this.f33366g, this.f33370k);
            }
            Internal.EnumVerifier enumVerifier = this.f33370k;
            if (enumVerifier != null) {
                java.lang.reflect.Field field2 = this.f33371l;
                if (field2 == null) {
                    return FieldInfo.d(this.f33360a, this.f33362c, this.f33361b, enumVerifier);
                }
                return FieldInfo.h(this.f33360a, this.f33362c, this.f33361b, enumVerifier, field2);
            }
            java.lang.reflect.Field field3 = this.f33371l;
            if (field3 == null) {
                return FieldInfo.c(this.f33360a, this.f33362c, this.f33361b, this.f33366g);
            }
            return FieldInfo.g(this.f33360a, this.f33362c, this.f33361b, field3);
        }

        public Builder withCachedSizeField(java.lang.reflect.Field field) {
            this.f33371l = field;
            return this;
        }

        public Builder withEnforceUtf8(boolean z3) {
            this.f33366g = z3;
            return this;
        }

        public Builder withEnumVerifier(Internal.EnumVerifier enumVerifier) {
            this.f33370k = enumVerifier;
            return this;
        }

        public Builder withField(java.lang.reflect.Field field) {
            if (this.f33367h == null) {
                this.f33360a = field;
                return this;
            }
            throw new IllegalStateException("Cannot set field when building a oneof.");
        }

        public Builder withFieldNumber(int i4) {
            this.f33362c = i4;
            return this;
        }

        public Builder withMapDefaultEntry(Object obj) {
            this.f33369j = obj;
            return this;
        }

        public Builder withOneof(OneofInfo oneofInfo, Class<?> cls) {
            if (this.f33360a == null && this.f33363d == null) {
                this.f33367h = oneofInfo;
                this.f33368i = cls;
                return this;
            }
            throw new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        }

        public Builder withPresence(java.lang.reflect.Field field, int i4) {
            this.f33363d = (java.lang.reflect.Field) Internal.b(field, "presenceField");
            this.f33364e = i4;
            return this;
        }

        public Builder withRequired(boolean z3) {
            this.f33365f = z3;
            return this;
        }

        public Builder withType(FieldType fieldType) {
            this.f33361b = fieldType;
            return this;
        }
    }

    private FieldInfo(java.lang.reflect.Field field, int i4, FieldType fieldType, Class<?> cls, java.lang.reflect.Field field2, int i5, boolean z3, boolean z4, OneofInfo oneofInfo, Class<?> cls2, Object obj, Internal.EnumVerifier enumVerifier, java.lang.reflect.Field field3) {
        this.f33346a = field;
        this.f33347b = fieldType;
        this.f33348c = cls;
        this.f33349d = i4;
        this.f33350e = field2;
        this.f33351f = i5;
        this.f33352g = z3;
        this.f33353h = z4;
        this.f33354i = oneofInfo;
        this.f33356k = cls2;
        this.f33357l = obj;
        this.f33358m = enumVerifier;
        this.f33355j = field3;
    }

    private static void a(int i4) {
        if (i4 > 0) {
            return;
        }
        throw new IllegalArgumentException("fieldNumber must be positive: " + i4);
    }

    public static FieldInfo c(java.lang.reflect.Field field, int i4, FieldType fieldType, boolean z3) {
        a(i4);
        Internal.b(field, "field");
        Internal.b(fieldType, "fieldType");
        if (fieldType != FieldType.MESSAGE_LIST && fieldType != FieldType.GROUP_LIST) {
            return new FieldInfo(field, i4, fieldType, null, null, 0, false, z3, null, null, null, null, null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo d(java.lang.reflect.Field field, int i4, FieldType fieldType, Internal.EnumVerifier enumVerifier) {
        a(i4);
        Internal.b(field, "field");
        return new FieldInfo(field, i4, fieldType, null, null, 0, false, false, null, null, null, enumVerifier, null);
    }

    public static FieldInfo e(java.lang.reflect.Field field, int i4, Object obj, Internal.EnumVerifier enumVerifier) {
        Internal.b(obj, "mapDefaultEntry");
        a(i4);
        Internal.b(field, "field");
        return new FieldInfo(field, i4, FieldType.MAP, null, null, 0, false, true, null, null, obj, enumVerifier, null);
    }

    public static FieldInfo f(int i4, FieldType fieldType, OneofInfo oneofInfo, Class<?> cls, boolean z3, Internal.EnumVerifier enumVerifier) {
        a(i4);
        Internal.b(fieldType, "fieldType");
        Internal.b(oneofInfo, "oneof");
        Internal.b(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new FieldInfo(null, i4, fieldType, null, null, 0, false, z3, oneofInfo, cls, null, enumVerifier, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i4 + " is of type " + fieldType);
    }

    public static FieldInfo g(java.lang.reflect.Field field, int i4, FieldType fieldType, java.lang.reflect.Field field2) {
        a(i4);
        Internal.b(field, "field");
        Internal.b(fieldType, "fieldType");
        if (fieldType != FieldType.MESSAGE_LIST && fieldType != FieldType.GROUP_LIST) {
            return new FieldInfo(field, i4, fieldType, null, null, 0, false, false, null, null, null, null, field2);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static FieldInfo h(java.lang.reflect.Field field, int i4, FieldType fieldType, Internal.EnumVerifier enumVerifier, java.lang.reflect.Field field2) {
        a(i4);
        Internal.b(field, "field");
        return new FieldInfo(field, i4, fieldType, null, null, 0, false, false, null, null, null, enumVerifier, field2);
    }

    public static FieldInfo i(java.lang.reflect.Field field, int i4, FieldType fieldType, java.lang.reflect.Field field2, int i5, boolean z3, Internal.EnumVerifier enumVerifier) {
        a(i4);
        Internal.b(field, "field");
        Internal.b(fieldType, "fieldType");
        Internal.b(field2, "presenceField");
        if (field2 != null && !v(i5)) {
            throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i5);
        }
        return new FieldInfo(field, i4, fieldType, null, field2, i5, false, z3, null, null, null, enumVerifier, null);
    }

    public static FieldInfo j(java.lang.reflect.Field field, int i4, FieldType fieldType, java.lang.reflect.Field field2, int i5, boolean z3, Internal.EnumVerifier enumVerifier) {
        a(i4);
        Internal.b(field, "field");
        Internal.b(fieldType, "fieldType");
        Internal.b(field2, "presenceField");
        if (field2 != null && !v(i5)) {
            throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i5);
        }
        return new FieldInfo(field, i4, fieldType, null, field2, i5, true, z3, null, null, null, enumVerifier, null);
    }

    private static boolean v(int i4) {
        if (i4 != 0 && (i4 & (i4 - 1)) == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(FieldInfo fieldInfo) {
        return this.f33349d - fieldInfo.f33349d;
    }

    public java.lang.reflect.Field k() {
        return this.f33355j;
    }

    public Internal.EnumVerifier l() {
        return this.f33358m;
    }

    public java.lang.reflect.Field m() {
        return this.f33346a;
    }

    public int n() {
        return this.f33349d;
    }

    public Object o() {
        return this.f33357l;
    }

    public Class<?> p() {
        int i4 = AnonymousClass1.f33359a[this.f33347b.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3 && i4 != 4) {
                return null;
            }
            return this.f33348c;
        }
        java.lang.reflect.Field field = this.f33346a;
        if (field != null) {
            return field.getType();
        }
        return this.f33356k;
    }

    public OneofInfo q() {
        return this.f33354i;
    }

    public java.lang.reflect.Field r() {
        return this.f33350e;
    }

    public int s() {
        return this.f33351f;
    }

    public FieldType t() {
        return this.f33347b;
    }

    public boolean u() {
        return this.f33353h;
    }

    public boolean w() {
        return this.f33352g;
    }
}
