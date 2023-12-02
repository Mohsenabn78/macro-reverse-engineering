package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class MoreObjects {

    /* loaded from: classes5.dex */
    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        private final String f26338a;

        /* renamed from: b  reason: collision with root package name */
        private final ValueHolder f26339b;

        /* renamed from: c  reason: collision with root package name */
        private ValueHolder f26340c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f26341d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f26342e;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
                super();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static class ValueHolder {
            @CheckForNull

            /* renamed from: a  reason: collision with root package name */
            String f26343a;
            @CheckForNull

            /* renamed from: b  reason: collision with root package name */
            Object f26344b;
            @CheckForNull

            /* renamed from: c  reason: collision with root package name */
            ValueHolder f26345c;

            private ValueHolder() {
            }
        }

        private ValueHolder a() {
            ValueHolder valueHolder = new ValueHolder();
            this.f26340c.f26345c = valueHolder;
            this.f26340c = valueHolder;
            return valueHolder;
        }

        @CanIgnoreReturnValue
        private ToStringHelper b(@CheckForNull Object obj) {
            a().f26344b = obj;
            return this;
        }

        @CanIgnoreReturnValue
        private ToStringHelper c(String str, @CheckForNull Object obj) {
            ValueHolder a4 = a();
            a4.f26344b = obj;
            a4.f26343a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        private UnconditionalValueHolder d() {
            UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
            this.f26340c.f26345c = unconditionalValueHolder;
            this.f26340c = unconditionalValueHolder;
            return unconditionalValueHolder;
        }

        @CanIgnoreReturnValue
        private ToStringHelper e(Object obj) {
            d().f26344b = obj;
            return this;
        }

        @CanIgnoreReturnValue
        private ToStringHelper f(String str, Object obj) {
            UnconditionalValueHolder d4 = d();
            d4.f26344b = obj;
            d4.f26343a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        private static boolean g(Object obj) {
            if (obj instanceof CharSequence) {
                if (((CharSequence) obj).length() == 0) {
                    return true;
                }
                return false;
            } else if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            } else {
                if (obj instanceof Map) {
                    return ((Map) obj).isEmpty();
                }
                if (obj instanceof Optional) {
                    return !((Optional) obj).isPresent();
                }
                if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
                    return true;
                }
                return false;
            }
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, @CheckForNull Object obj) {
            return c(str, obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(@CheckForNull Object obj) {
            return b(obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper omitNullValues() {
            this.f26341d = true;
            return this;
        }

        public String toString() {
            boolean z3 = this.f26341d;
            boolean z4 = this.f26342e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f26338a);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.f26339b.f26345c; valueHolder != null; valueHolder = valueHolder.f26345c) {
                Object obj = valueHolder.f26344b;
                if (!(valueHolder instanceof UnconditionalValueHolder)) {
                    if (obj == null) {
                        if (z3) {
                        }
                    } else if (z4 && g(obj)) {
                    }
                }
                sb.append(str);
                String str2 = valueHolder.f26343a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append(SignatureVisitor.INSTANCEOF);
                }
                if (obj != null && obj.getClass().isArray()) {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                } else {
                    sb.append(obj);
                }
                str = ", ";
            }
            sb.append('}');
            return sb.toString();
        }

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f26339b = valueHolder;
            this.f26340c = valueHolder;
            this.f26341d = false;
            this.f26342e = false;
            this.f26338a = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, boolean z3) {
            return f(str, String.valueOf(z3));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(boolean z3) {
            return e(String.valueOf(z3));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, char c4) {
            return f(str, String.valueOf(c4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(char c4) {
            return e(String.valueOf(c4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, double d4) {
            return f(str, String.valueOf(d4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(double d4) {
            return e(String.valueOf(d4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, float f4) {
            return f(str, String.valueOf(f4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(float f4) {
            return e(String.valueOf(f4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, int i4) {
            return f(str, String.valueOf(i4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(int i4) {
            return e(String.valueOf(i4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, long j4) {
            return f(str, String.valueOf(j4));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(long j4) {
            return e(String.valueOf(j4));
        }
    }

    private MoreObjects() {
    }

    public static <T> T firstNonNull(@CheckForNull T t3, @CheckForNull T t4) {
        if (t3 != null) {
            return t3;
        }
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
