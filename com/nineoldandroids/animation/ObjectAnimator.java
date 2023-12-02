package com.nineoldandroids.animation;

import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public final class ObjectAnimator extends ValueAnimator {
    private static final Map<String, Property> H;
    private Object E;
    private String F;
    private Property G;

    static {
        HashMap hashMap = new HashMap();
        H = hashMap;
        hashMap.put("alpha", d.f36393a);
        hashMap.put("pivotX", d.f36394b);
        hashMap.put("pivotY", d.f36395c);
        hashMap.put("translationX", d.f36396d);
        hashMap.put("translationY", d.f36397e);
        hashMap.put(Key.ROTATION, d.f36398f);
        hashMap.put("rotationX", d.f36399g);
        hashMap.put("rotationY", d.f36400h);
        hashMap.put("scaleX", d.f36401i);
        hashMap.put("scaleY", d.f36402j);
        hashMap.put("scrollX", d.f36403k);
        hashMap.put("scrollY", d.f36404l);
        hashMap.put("x", d.f36405m);
        hashMap.put("y", d.f36406n);
    }

    public ObjectAnimator() {
    }

    public static ObjectAnimator ofFloat(Object obj, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofInt(Object obj, String str, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofObject(Object obj, String str, TypeEvaluator typeEvaluator, Object... objArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setObjectValues(objArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.E = obj;
        objectAnimator.setValues(propertyValuesHolderArr);
        return objectAnimator;
    }

    public String getPropertyName() {
        return this.F;
    }

    public Object getTarget() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void l(float f4) {
        super.l(f4);
        int length = this.f36377s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f36377s[i4].f(this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void p() {
        if (!this.f36370l) {
            if (this.G == null && AnimatorProxy.NEEDS_PROXY && (this.E instanceof View)) {
                Map<String, Property> map = H;
                if (map.containsKey(this.F)) {
                    setProperty(map.get(this.F));
                }
            }
            int length = this.f36377s.length;
            for (int i4 = 0; i4 < length; i4++) {
                this.f36377s[i4].j(this.E);
            }
            super.p();
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setFloatValues(float... fArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
        if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
            super.setFloatValues(fArr);
            return;
        }
        Property property = this.G;
        if (property != null) {
            setValues(PropertyValuesHolder.ofFloat(property, fArr));
        } else {
            setValues(PropertyValuesHolder.ofFloat(this.F, fArr));
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setIntValues(int... iArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
        if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
            super.setIntValues(iArr);
            return;
        }
        Property property = this.G;
        if (property != null) {
            setValues(PropertyValuesHolder.ofInt(property, iArr));
        } else {
            setValues(PropertyValuesHolder.ofInt(this.F, iArr));
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setObjectValues(Object... objArr) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
        if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
            super.setObjectValues(objArr);
            return;
        }
        Property property = this.G;
        if (property != null) {
            setValues(PropertyValuesHolder.ofObject(property, (TypeEvaluator) null, objArr));
        } else {
            setValues(PropertyValuesHolder.ofObject(this.F, (TypeEvaluator) null, objArr));
        }
    }

    public void setProperty(Property property) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
        if (propertyValuesHolderArr != null) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setProperty(property);
            this.f36378t.remove(propertyName);
            this.f36378t.put(this.F, propertyValuesHolder);
        }
        if (this.G != null) {
            this.F = property.getName();
        }
        this.G = property;
        this.f36370l = false;
    }

    public void setPropertyName(String str) {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
        if (propertyValuesHolderArr != null) {
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArr[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setPropertyName(str);
            this.f36378t.remove(propertyName);
            this.f36378t.put(str, propertyValuesHolder);
        }
        this.F = str;
        this.f36370l = false;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setTarget(Object obj) {
        Object obj2 = this.E;
        if (obj2 != obj) {
            this.E = obj;
            if (obj2 != null && obj != null && obj2.getClass() == obj.getClass()) {
                return;
            }
            this.f36370l = false;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupEndValues() {
        p();
        int length = this.f36377s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f36377s[i4].g(this.E);
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupStartValues() {
        p();
        int length = this.f36377s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f36377s[i4].l(this.E);
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator
    public void start() {
        super.start();
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.E;
        if (this.f36377s != null) {
            for (int i4 = 0; i4 < this.f36377s.length; i4++) {
                str = str + "\n    " + this.f36377s[i4].toString();
            }
        }
        return str;
    }

    private ObjectAnimator(Object obj, String str) {
        this.E = obj;
        setPropertyName(str);
    }

    public static <T> ObjectAnimator ofFloat(T t3, Property<T, Float> property, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t3, property);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static <T> ObjectAnimator ofInt(T t3, Property<T, Integer> property, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t3, property);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator
    public ObjectAnimator setDuration(long j4) {
        super.setDuration(j4);
        return this;
    }

    public static <T, V> ObjectAnimator ofObject(T t3, Property<T, V> property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t3, property);
        objectAnimator.setObjectValues(vArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator
    /* renamed from: clone */
    public ObjectAnimator mo4175clone() {
        return (ObjectAnimator) super.mo4175clone();
    }

    private <T> ObjectAnimator(T t3, Property<T, ?> property) {
        this.E = t3;
        setProperty(property);
    }
}
