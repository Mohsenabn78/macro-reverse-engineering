package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@GwtCompatible
/* loaded from: classes5.dex */
public final class Objects {

    /* loaded from: classes5.dex */
    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final String f25957a;

        /* renamed from: b  reason: collision with root package name */
        private ValueHolder f25958b;

        /* renamed from: c  reason: collision with root package name */
        private ValueHolder f25959c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f25960d;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class ValueHolder {

            /* renamed from: a  reason: collision with root package name */
            String f25961a;

            /* renamed from: b  reason: collision with root package name */
            Object f25962b;

            /* renamed from: c  reason: collision with root package name */
            ValueHolder f25963c;

            private ValueHolder() {
            }
        }

        private ValueHolder a() {
            ValueHolder valueHolder = new ValueHolder();
            this.f25959c.f25963c = valueHolder;
            this.f25959c = valueHolder;
            return valueHolder;
        }

        private ToStringHelper b(@Nullable Object obj) {
            a().f25962b = obj;
            return this;
        }

        private ToStringHelper c(String str, @Nullable Object obj) {
            ValueHolder a4 = a();
            a4.f25962b = obj;
            a4.f25961a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public ToStringHelper add(String str, @Nullable Object obj) {
            return c(str, obj);
        }

        public ToStringHelper addValue(@Nullable Object obj) {
            return b(obj);
        }

        public ToStringHelper omitNullValues() {
            this.f25960d = true;
            return this;
        }

        public String toString() {
            boolean z3 = this.f25960d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f25957a);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.f25958b.f25963c; valueHolder != null; valueHolder = valueHolder.f25963c) {
                if (!z3 || valueHolder.f25962b != null) {
                    sb.append(str);
                    String str2 = valueHolder.f25961a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append(SignatureVisitor.INSTANCEOF);
                    }
                    sb.append(valueHolder.f25962b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f25958b = valueHolder;
            this.f25959c = valueHolder;
            this.f25960d = false;
            this.f25957a = (String) Preconditions.checkNotNull(str);
        }

        public ToStringHelper add(String str, boolean z3) {
            return c(str, String.valueOf(z3));
        }

        public ToStringHelper addValue(boolean z3) {
            return b(String.valueOf(z3));
        }

        public ToStringHelper add(String str, char c4) {
            return c(str, String.valueOf(c4));
        }

        public ToStringHelper addValue(char c4) {
            return b(String.valueOf(c4));
        }

        public ToStringHelper add(String str, double d4) {
            return c(str, String.valueOf(d4));
        }

        public ToStringHelper addValue(double d4) {
            return b(String.valueOf(d4));
        }

        public ToStringHelper add(String str, float f4) {
            return c(str, String.valueOf(f4));
        }

        public ToStringHelper addValue(float f4) {
            return b(String.valueOf(f4));
        }

        public ToStringHelper add(String str, int i4) {
            return c(str, String.valueOf(i4));
        }

        public ToStringHelper addValue(int i4) {
            return b(String.valueOf(i4));
        }

        public ToStringHelper add(String str, long j4) {
            return c(str, String.valueOf(j4));
        }

        public ToStringHelper addValue(long j4) {
            return b(String.valueOf(j4));
        }
    }

    private Objects() {
    }

    private static String a(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static <T> T firstNonNull(@Nullable T t3, @Nullable T t4) {
        if (t3 == null) {
            return (T) Preconditions.checkNotNull(t4);
        }
        return t3;
    }

    public static int hashCode(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(a(obj.getClass()));
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(a(cls));
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
