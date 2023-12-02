package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: c  reason: collision with root package name */
    private final c<K> f1528c;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    protected LottieValueCallback<A> f1530e;

    /* renamed from: a  reason: collision with root package name */
    final List<AnimationListener> f1526a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f1527b = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f1529d = 0.0f;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private A f1531f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f1532g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f1533h = -1.0f;

    /* loaded from: classes2.dex */
    public interface AnimationListener {
        void onValueChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b<T> implements c<T> {
        private b() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public Keyframe<T> a() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public float b() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean c(float f4) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean d(float f4) {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public float e() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface c<T> {
        Keyframe<T> a();

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
        float b();

        boolean c(float f4);

        boolean d(float f4);

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<? extends Keyframe<T>> f1534a;

        /* renamed from: c  reason: collision with root package name */
        private Keyframe<T> f1536c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f1537d = -1.0f;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private Keyframe<T> f1535b = f(0.0f);

        d(List<? extends Keyframe<T>> list) {
            this.f1534a = list;
        }

        private Keyframe<T> f(float f4) {
            List<? extends Keyframe<T>> list = this.f1534a;
            Keyframe<T> keyframe = list.get(list.size() - 1);
            if (f4 >= keyframe.getStartProgress()) {
                return keyframe;
            }
            for (int size = this.f1534a.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = this.f1534a.get(size);
                if (this.f1535b != keyframe2 && keyframe2.containsProgress(f4)) {
                    return keyframe2;
                }
            }
            return this.f1534a.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        @NonNull
        public Keyframe<T> a() {
            return this.f1535b;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public float b() {
            return this.f1534a.get(0).getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean c(float f4) {
            Keyframe<T> keyframe = this.f1536c;
            Keyframe<T> keyframe2 = this.f1535b;
            if (keyframe == keyframe2 && this.f1537d == f4) {
                return true;
            }
            this.f1536c = keyframe2;
            this.f1537d = f4;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean d(float f4) {
            if (this.f1535b.containsProgress(f4)) {
                return !this.f1535b.isStatic();
            }
            this.f1535b = f(f4);
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public float e() {
            List<? extends Keyframe<T>> list = this.f1534a;
            return list.get(list.size() - 1).getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class e<T> implements c<T> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Keyframe<T> f1538a;

        /* renamed from: b  reason: collision with root package name */
        private float f1539b = -1.0f;

        e(List<? extends Keyframe<T>> list) {
            this.f1538a = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public Keyframe<T> a() {
            return this.f1538a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public float b() {
            return this.f1538a.getStartProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean c(float f4) {
            if (this.f1539b == f4) {
                return true;
            }
            this.f1539b = f4;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean d(float f4) {
            return !this.f1538a.isStatic();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public float e() {
            return this.f1538a.getEndProgress();
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.c
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.f1528c = g(list);
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    private float e() {
        if (this.f1532g == -1.0f) {
            this.f1532g = this.f1528c.b();
        }
        return this.f1532g;
    }

    private static <T> c<T> g(List<? extends Keyframe<T>> list) {
        if (list.isEmpty()) {
            return new b();
        }
        if (list.size() == 1) {
            return new e(list);
        }
        return new d(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Keyframe<K> a() {
        L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> a4 = this.f1528c.a();
        L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return a4;
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.f1526a.add(animationListener);
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    float b() {
        if (this.f1533h == -1.0f) {
            this.f1533h = this.f1528c.e();
        }
        return this.f1533h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float c() {
        Keyframe<K> a4 = a();
        if (a4.isStatic()) {
            return 0.0f;
        }
        return a4.interpolator.getInterpolation(d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        if (this.f1527b) {
            return 0.0f;
        }
        Keyframe<K> a4 = a();
        if (a4.isStatic()) {
            return 0.0f;
        }
        return (this.f1529d - a4.getStartProgress()) / (a4.getEndProgress() - a4.getStartProgress());
    }

    protected A f(Keyframe<K> keyframe, float f4, float f5, float f6) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public float getProgress() {
        return this.f1529d;
    }

    public A getValue() {
        A value;
        float d4 = d();
        if (this.f1530e == null && this.f1528c.c(d4)) {
            return this.f1531f;
        }
        Keyframe<K> a4 = a();
        Interpolator interpolator = a4.xInterpolator;
        if (interpolator != null && a4.yInterpolator != null) {
            value = f(a4, d4, interpolator.getInterpolation(d4), a4.yInterpolator.getInterpolation(d4));
        } else {
            value = getValue(a4, c());
        }
        this.f1531f = value;
        return value;
    }

    abstract A getValue(Keyframe<K> keyframe, float f4);

    public void notifyListeners() {
        for (int i4 = 0; i4 < this.f1526a.size(); i4++) {
            this.f1526a.get(i4).onValueChanged();
        }
    }

    public void setIsDiscrete() {
        this.f1527b = true;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.f1528c.isEmpty()) {
            return;
        }
        if (f4 < e()) {
            f4 = e();
        } else if (f4 > b()) {
            f4 = b();
        }
        if (f4 == this.f1529d) {
            return;
        }
        this.f1529d = f4;
        if (this.f1528c.d(f4)) {
            notifyListeners();
        }
    }

    public void setValueCallback(@Nullable LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.f1530e;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation(null);
        }
        this.f1530e = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }
}
