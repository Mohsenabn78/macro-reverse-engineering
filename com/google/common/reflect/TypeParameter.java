package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class TypeParameter<T> extends TypeCapture<T> {

    /* renamed from: a  reason: collision with root package name */
    final TypeVariable<?> f28223a;

    protected TypeParameter() {
        Type a4 = a();
        Preconditions.checkArgument(a4 instanceof TypeVariable, "%s should be a type variable.", a4);
        this.f28223a = (TypeVariable) a4;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeParameter) {
            return this.f28223a.equals(((TypeParameter) obj).f28223a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f28223a.hashCode();
    }

    public String toString() {
        return this.f28223a.toString();
    }
}
