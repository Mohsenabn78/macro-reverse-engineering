package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes2.dex */
abstract class a<V, O> implements AnimatableValue<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<Keyframe<V>> f1621a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(V v3) {
        this(Collections.singletonList(new Keyframe(v3)));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<V>> getKeyframes() {
        return this.f1621a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.f1621a.isEmpty()) {
            return true;
        }
        if (this.f1621a.size() == 1 && this.f1621a.get(0).isStatic()) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f1621a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f1621a.toArray()));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<Keyframe<V>> list) {
        this.f1621a = list;
    }
}
