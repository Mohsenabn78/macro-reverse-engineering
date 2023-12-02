package com.hippo.quickjs.android;

import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.hippo.quickjs.android.m;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class Method {

    /* renamed from: a  reason: collision with root package name */
    final Type f34066a;

    /* renamed from: b  reason: collision with root package name */
    final String f34067b;

    /* renamed from: c  reason: collision with root package name */
    final Type[] f34068c;

    public Method(Type type, String str, Type[] typeArr) {
        this.f34066a = a(type);
        this.f34067b = str;
        this.f34068c = new Type[typeArr.length];
        for (int i4 = 0; i4 < typeArr.length; i4++) {
            this.f34068c[i4] = a(typeArr[i4]);
        }
    }

    private static Type a(Type type) {
        return m.o(m.g(type));
    }

    private static String c(Type type) {
        if (type instanceof m.a) {
            return "[" + c(((m.a) type).getGenericComponentType());
        }
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (type == Void.TYPE) {
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            }
            if (type == Boolean.TYPE) {
                return "Z";
            }
            if (type == Byte.TYPE) {
                return "B";
            }
            if (type == Character.TYPE) {
                return "C";
            }
            if (type == Short.TYPE) {
                return ExifInterface.LATITUDE_SOUTH;
            }
            if (type == Integer.TYPE) {
                return "I";
            }
            if (type == Long.TYPE) {
                return "J";
            }
            if (type == Float.TYPE) {
                return "F";
            }
            if (type == Double.TYPE) {
                return "D";
            }
        }
        String name = m.l(type).getName();
        StringBuilder sb = new StringBuilder(name.length() + 2);
        sb.append("L");
        for (int i4 = 0; i4 < name.length(); i4++) {
            char charAt = name.charAt(i4);
            if (charAt == '.') {
                charAt = '/';
            }
            sb.append(charAt);
        }
        sb.append(";");
        return sb.toString();
    }

    @Nullable
    public static Method create(Type type, java.lang.reflect.Method method) {
        Class<?> l4 = m.l(type);
        Type p4 = m.p(type, l4, method.getGenericReturnType());
        if (p4 instanceof TypeVariable) {
            return null;
        }
        String name = method.getName();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        int length = genericParameterTypes.length;
        Type[] typeArr = new Type[length];
        for (int i4 = 0; i4 < length; i4++) {
            Type p5 = m.p(type, l4, genericParameterTypes[i4]);
            typeArr[i4] = p5;
            if (p5 instanceof TypeVariable) {
                return null;
            }
        }
        return new Method(p4, name, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (Type type : this.f34068c) {
            sb.append(c(type));
        }
        sb.append(")");
        sb.append(c(this.f34066a));
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Method)) {
            return false;
        }
        Method method = (Method) obj;
        if (!this.f34066a.equals(method.f34066a) || !this.f34067b.equals(method.f34067b) || !Arrays.equals(this.f34068c, method.f34068c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f34066a.hashCode() + 31) * 31) + this.f34067b.hashCode()) * 31) + Arrays.hashCode(this.f34068c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f34066a);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(this.f34067b);
        sb.append("(");
        for (int i4 = 0; i4 < this.f34068c.length; i4++) {
            if (i4 != 0) {
                sb.append(", ");
            }
            sb.append(this.f34068c[i4]);
        }
        sb.append(")");
        return sb.toString();
    }
}
