package com.nineoldandroids.util;

/* loaded from: classes6.dex */
public abstract class FloatProperty<T> extends Property<T, Float> {
    public FloatProperty(String str) {
        super(Float.class, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nineoldandroids.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f4) {
        set2((FloatProperty<T>) obj, f4);
    }

    public abstract void setValue(T t3, float f4);

    /* renamed from: set  reason: avoid collision after fix types in other method */
    public final void set2(T t3, Float f4) {
        setValue(t3, f4.floatValue());
    }
}
