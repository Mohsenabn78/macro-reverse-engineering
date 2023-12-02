package com.google.api.client.util;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes5.dex */
public final class Objects {

    /* loaded from: classes5.dex */
    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final String f26140a;

        /* renamed from: b  reason: collision with root package name */
        private ValueHolder f26141b;

        /* renamed from: c  reason: collision with root package name */
        private ValueHolder f26142c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f26143d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class ValueHolder {

            /* renamed from: a  reason: collision with root package name */
            String f26144a;

            /* renamed from: b  reason: collision with root package name */
            Object f26145b;

            /* renamed from: c  reason: collision with root package name */
            ValueHolder f26146c;

            private ValueHolder() {
            }
        }

        ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f26141b = valueHolder;
            this.f26142c = valueHolder;
            this.f26140a = str;
        }

        private ValueHolder a() {
            ValueHolder valueHolder = new ValueHolder();
            this.f26142c.f26146c = valueHolder;
            this.f26142c = valueHolder;
            return valueHolder;
        }

        private ToStringHelper b(String str, Object obj) {
            ValueHolder a4 = a();
            a4.f26145b = obj;
            a4.f26144a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public ToStringHelper add(String str, Object obj) {
            return b(str, obj);
        }

        public ToStringHelper omitNullValues() {
            this.f26143d = true;
            return this;
        }

        public String toString() {
            boolean z3 = this.f26143d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f26140a);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.f26141b.f26146c; valueHolder != null; valueHolder = valueHolder.f26146c) {
                if (!z3 || valueHolder.f26145b != null) {
                    sb.append(str);
                    String str2 = valueHolder.f26144a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append(SignatureVisitor.INSTANCEOF);
                    }
                    sb.append(valueHolder.f26145b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private Objects() {
    }

    public static boolean equal(Object obj, Object obj2) {
        return com.google.api.client.repackaged.com.google.common.base.Objects.equal(obj, obj2);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
