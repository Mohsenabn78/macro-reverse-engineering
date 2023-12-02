package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ValueAnimator extends Animator {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;

    /* renamed from: b  reason: collision with root package name */
    long f36360b;

    /* renamed from: h  reason: collision with root package name */
    private long f36366h;

    /* renamed from: s  reason: collision with root package name */
    PropertyValuesHolder[] f36377s;

    /* renamed from: t  reason: collision with root package name */
    HashMap<String, PropertyValuesHolder> f36378t;

    /* renamed from: u  reason: collision with root package name */
    private static ThreadLocal<f> f36354u = new ThreadLocal<>();

    /* renamed from: v  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<ValueAnimator>> f36355v = new a();

    /* renamed from: w  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<ValueAnimator>> f36356w = new b();

    /* renamed from: x  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<ValueAnimator>> f36357x = new c();

    /* renamed from: y  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<ValueAnimator>> f36358y = new d();

    /* renamed from: z  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<ValueAnimator>> f36359z = new e();
    private static final Interpolator A = new AccelerateDecelerateInterpolator();
    private static final TypeEvaluator B = new IntEvaluator();
    private static final TypeEvaluator C = new FloatEvaluator();
    private static long D = 10;

    /* renamed from: c  reason: collision with root package name */
    long f36361c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36362d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f36363e = 0;

    /* renamed from: f  reason: collision with root package name */
    private float f36364f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36365g = false;

    /* renamed from: i  reason: collision with root package name */
    int f36367i = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f36368j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f36369k = false;

    /* renamed from: l  reason: collision with root package name */
    boolean f36370l = false;

    /* renamed from: m  reason: collision with root package name */
    private long f36371m = 300;

    /* renamed from: n  reason: collision with root package name */
    private long f36372n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f36373o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f36374p = 1;

    /* renamed from: q  reason: collision with root package name */
    private Interpolator f36375q = A;

    /* renamed from: r  reason: collision with root package name */
    private ArrayList<AnimatorUpdateListener> f36376r = null;

    /* loaded from: classes6.dex */
    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends ThreadLocal<ArrayList<ValueAnimator>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: classes6.dex */
    static class b extends ThreadLocal<ArrayList<ValueAnimator>> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: classes6.dex */
    static class c extends ThreadLocal<ArrayList<ValueAnimator>> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: classes6.dex */
    static class d extends ThreadLocal<ArrayList<ValueAnimator>> {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    /* loaded from: classes6.dex */
    static class e extends ThreadLocal<ArrayList<ValueAnimator>> {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class f extends Handler {
        private f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z3;
            ArrayList arrayList = (ArrayList) ValueAnimator.f36355v.get();
            ArrayList arrayList2 = (ArrayList) ValueAnimator.f36357x.get();
            int i4 = message.what;
            if (i4 != 0) {
                if (i4 == 1) {
                    z3 = true;
                } else {
                    return;
                }
            } else {
                ArrayList arrayList3 = (ArrayList) ValueAnimator.f36356w.get();
                if (arrayList.size() <= 0 && arrayList2.size() <= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ValueAnimator valueAnimator = (ValueAnimator) arrayList4.get(i5);
                        if (valueAnimator.f36372n == 0) {
                            valueAnimator.r();
                        } else {
                            arrayList2.add(valueAnimator);
                        }
                    }
                }
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) ValueAnimator.f36359z.get();
            ArrayList arrayList6 = (ArrayList) ValueAnimator.f36358y.get();
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                ValueAnimator valueAnimator2 = (ValueAnimator) arrayList2.get(i6);
                if (valueAnimator2.n(currentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i7 = 0; i7 < size3; i7++) {
                    ValueAnimator valueAnimator3 = (ValueAnimator) arrayList5.get(i7);
                    valueAnimator3.r();
                    valueAnimator3.f36368j = true;
                    arrayList2.remove(valueAnimator3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i8 = 0;
            while (i8 < size4) {
                ValueAnimator valueAnimator4 = (ValueAnimator) arrayList.get(i8);
                if (valueAnimator4.m(currentAnimationTimeMillis)) {
                    arrayList6.add(valueAnimator4);
                }
                if (arrayList.size() == size4) {
                    i8++;
                } else {
                    size4--;
                    arrayList6.remove(valueAnimator4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i9 = 0; i9 < arrayList6.size(); i9++) {
                    ((ValueAnimator) arrayList6.get(i9)).o();
                }
                arrayList6.clear();
            }
            if (z3) {
                if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.D - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
                }
            }
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    public static void clearAllAnimations() {
        f36355v.get().clear();
        f36356w.get().clear();
        f36357x.get().clear();
    }

    public static int getCurrentAnimationsCount() {
        return f36355v.get().size();
    }

    public static long getFrameDelay() {
        return D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(long j4) {
        if (!this.f36365g) {
            this.f36365g = true;
            this.f36366h = j4;
            return false;
        }
        long j5 = j4 - this.f36366h;
        long j6 = this.f36372n;
        if (j5 > j6) {
            this.f36360b = j4 - (j5 - j6);
            this.f36367i = 1;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ArrayList<Animator.AnimatorListener> arrayList;
        f36355v.get().remove(this);
        f36356w.get().remove(this);
        f36357x.get().remove(this);
        this.f36367i = 0;
        if (this.f36368j && (arrayList = this.f36291a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((Animator.AnimatorListener) arrayList2.get(i4)).onAnimationEnd(this);
            }
        }
        this.f36368j = false;
        this.f36369k = false;
    }

    public static ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static ValueAnimator ofInt(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static ValueAnimator ofObject(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    private void q(boolean z3) {
        if (Looper.myLooper() != null) {
            this.f36362d = z3;
            this.f36363e = 0;
            this.f36367i = 0;
            this.f36369k = true;
            this.f36365g = false;
            f36356w.get().add(this);
            if (this.f36372n == 0) {
                setCurrentPlayTime(getCurrentPlayTime());
                this.f36367i = 0;
                this.f36368j = true;
                ArrayList<Animator.AnimatorListener> arrayList = this.f36291a;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((Animator.AnimatorListener) arrayList2.get(i4)).onAnimationStart(this);
                    }
                }
            }
            f fVar = f36354u.get();
            if (fVar == null) {
                fVar = new f(null);
                f36354u.set(fVar);
            }
            fVar.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ArrayList<Animator.AnimatorListener> arrayList;
        p();
        f36355v.get().add(this);
        if (this.f36372n > 0 && (arrayList = this.f36291a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((Animator.AnimatorListener) arrayList2.get(i4)).onAnimationStart(this);
            }
        }
    }

    public static void setFrameDelay(long j4) {
        D = j4;
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.f36376r == null) {
            this.f36376r = new ArrayList<>();
        }
        this.f36376r.add(animatorUpdateListener);
    }

    @Override // com.nineoldandroids.animation.Animator
    public void cancel() {
        ArrayList<Animator.AnimatorListener> arrayList;
        if (this.f36367i != 0 || f36356w.get().contains(this) || f36357x.get().contains(this)) {
            if (this.f36368j && (arrayList = this.f36291a) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            o();
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void end() {
        if (!f36355v.get().contains(this) && !f36356w.get().contains(this)) {
            this.f36365g = false;
            r();
        } else if (!this.f36370l) {
            p();
        }
        int i4 = this.f36373o;
        if (i4 > 0 && (i4 & 1) == 1) {
            l(0.0f);
        } else {
            l(1.0f);
        }
        o();
    }

    public float getAnimatedFraction() {
        return this.f36364f;
    }

    public Object getAnimatedValue() {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length <= 0) {
            return null;
        }
        return propertyValuesHolderArr[0].b();
    }

    public long getCurrentPlayTime() {
        if (this.f36370l && this.f36367i != 0) {
            return AnimationUtils.currentAnimationTimeMillis() - this.f36360b;
        }
        return 0L;
    }

    @Override // com.nineoldandroids.animation.Animator
    public long getDuration() {
        return this.f36371m;
    }

    public Interpolator getInterpolator() {
        return this.f36375q;
    }

    public int getRepeatCount() {
        return this.f36373o;
    }

    public int getRepeatMode() {
        return this.f36374p;
    }

    @Override // com.nineoldandroids.animation.Animator
    public long getStartDelay() {
        return this.f36372n;
    }

    public PropertyValuesHolder[] getValues() {
        return this.f36377s;
    }

    @Override // com.nineoldandroids.animation.Animator
    public boolean isRunning() {
        if (this.f36367i == 1 || this.f36368j) {
            return true;
        }
        return false;
    }

    @Override // com.nineoldandroids.animation.Animator
    public boolean isStarted() {
        return this.f36369k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f4) {
        float interpolation = this.f36375q.getInterpolation(f4);
        this.f36364f = interpolation;
        int length = this.f36377s.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f36377s[i4].a(interpolation);
        }
        ArrayList<AnimatorUpdateListener> arrayList = this.f36376r;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f36376r.get(i5).onAnimationUpdate(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean m(long r10) {
        /*
            r9 = this;
            int r0 = r9.f36367i
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L1a
            r9.f36367i = r3
            long r4 = r9.f36361c
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L12
            r9.f36360b = r10
            goto L1a
        L12:
            long r4 = r10 - r4
            r9.f36360b = r4
            r4 = -1
            r9.f36361c = r4
        L1a:
            int r0 = r9.f36367i
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L23
            if (r0 == r4) goto L23
            goto L82
        L23:
            long r6 = r9.f36371m
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L32
            long r1 = r9.f36360b
            long r10 = r10 - r1
            float r10 = (float) r10
            float r11 = (float) r6
            float r10 = r10 / r11
            goto L34
        L32:
            r10 = 1065353216(0x3f800000, float:1.0)
        L34:
            int r11 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r11 < 0) goto L77
            int r11 = r9.f36363e
            int r1 = r9.f36373o
            if (r11 < r1) goto L47
            r11 = -1
            if (r1 != r11) goto L42
            goto L47
        L42:
            float r10 = java.lang.Math.min(r10, r0)
            goto L78
        L47:
            java.util.ArrayList<com.nineoldandroids.animation.Animator$AnimatorListener> r11 = r9.f36291a
            if (r11 == 0) goto L60
            int r11 = r11.size()
            r1 = 0
        L50:
            if (r1 >= r11) goto L60
            java.util.ArrayList<com.nineoldandroids.animation.Animator$AnimatorListener> r2 = r9.f36291a
            java.lang.Object r2 = r2.get(r1)
            com.nineoldandroids.animation.Animator$AnimatorListener r2 = (com.nineoldandroids.animation.Animator.AnimatorListener) r2
            r2.onAnimationRepeat(r9)
            int r1 = r1 + 1
            goto L50
        L60:
            int r11 = r9.f36374p
            if (r11 != r4) goto L69
            boolean r11 = r9.f36362d
            r11 = r11 ^ r3
            r9.f36362d = r11
        L69:
            int r11 = r9.f36363e
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.f36363e = r11
            float r10 = r10 % r0
            long r1 = r9.f36360b
            long r3 = r9.f36371m
            long r1 = r1 + r3
            r9.f36360b = r1
        L77:
            r3 = 0
        L78:
            boolean r11 = r9.f36362d
            if (r11 == 0) goto L7e
            float r10 = r0 - r10
        L7e:
            r9.l(r10)
            r5 = r3
        L82:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.ValueAnimator.m(long):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        if (!this.f36370l) {
            int length = this.f36377s.length;
            for (int i4 = 0; i4 < length; i4++) {
                this.f36377s[i4].e();
            }
            this.f36370l = true;
        }
    }

    public void removeAllUpdateListeners() {
        ArrayList<AnimatorUpdateListener> arrayList = this.f36376r;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.f36376r = null;
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        ArrayList<AnimatorUpdateListener> arrayList = this.f36376r;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorUpdateListener);
        if (this.f36376r.size() == 0) {
            this.f36376r = null;
        }
    }

    public void reverse() {
        this.f36362d = !this.f36362d;
        if (this.f36367i == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f36360b = currentAnimationTimeMillis - (this.f36371m - (currentAnimationTimeMillis - this.f36360b));
            return;
        }
        q(true);
    }

    public void setCurrentPlayTime(long j4) {
        p();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f36367i != 1) {
            this.f36361c = j4;
            this.f36367i = 2;
        }
        this.f36360b = currentAnimationTimeMillis - j4;
        m(currentAnimationTimeMillis);
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        if (typeEvaluator != null && (propertyValuesHolderArr = this.f36377s) != null && propertyValuesHolderArr.length > 0) {
            propertyValuesHolderArr[0].setEvaluator(typeEvaluator);
        }
    }

    public void setFloatValues(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
            if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
                propertyValuesHolderArr[0].setFloatValues(fArr);
            } else {
                setValues(PropertyValuesHolder.ofFloat("", fArr));
            }
            this.f36370l = false;
        }
    }

    public void setIntValues(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
            if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
                propertyValuesHolderArr[0].setIntValues(iArr);
            } else {
                setValues(PropertyValuesHolder.ofInt("", iArr));
            }
            this.f36370l = false;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.f36375q = interpolator;
        } else {
            this.f36375q = new LinearInterpolator();
        }
    }

    public void setObjectValues(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
            if (propertyValuesHolderArr != null && propertyValuesHolderArr.length != 0) {
                propertyValuesHolderArr[0].setObjectValues(objArr);
            } else {
                setValues(PropertyValuesHolder.ofObject("", (TypeEvaluator) null, objArr));
            }
            this.f36370l = false;
        }
    }

    public void setRepeatCount(int i4) {
        this.f36373o = i4;
    }

    public void setRepeatMode(int i4) {
        this.f36374p = i4;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setStartDelay(long j4) {
        this.f36372n = j4;
    }

    public void setValues(PropertyValuesHolder... propertyValuesHolderArr) {
        int length = propertyValuesHolderArr.length;
        this.f36377s = propertyValuesHolderArr;
        this.f36378t = new HashMap<>(length);
        for (PropertyValuesHolder propertyValuesHolder : propertyValuesHolderArr) {
            this.f36378t.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
        }
        this.f36370l = false;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void start() {
        q(false);
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f36377s != null) {
            for (int i4 = 0; i4 < this.f36377s.length; i4++) {
                str = str + "\n    " + this.f36377s[i4].toString();
            }
        }
        return str;
    }

    @Override // com.nineoldandroids.animation.Animator
    public ValueAnimator setDuration(long j4) {
        if (j4 >= 0) {
            this.f36371m = j4;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j4);
    }

    @Override // com.nineoldandroids.animation.Animator
    /* renamed from: clone */
    public ValueAnimator mo4175clone() {
        ValueAnimator valueAnimator = (ValueAnimator) super.mo4175clone();
        ArrayList<AnimatorUpdateListener> arrayList = this.f36376r;
        if (arrayList != null) {
            valueAnimator.f36376r = new ArrayList<>();
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                valueAnimator.f36376r.add(arrayList.get(i4));
            }
        }
        valueAnimator.f36361c = -1L;
        valueAnimator.f36362d = false;
        valueAnimator.f36363e = 0;
        valueAnimator.f36370l = false;
        valueAnimator.f36367i = 0;
        valueAnimator.f36365g = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.f36377s;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.f36377s = new PropertyValuesHolder[length];
            valueAnimator.f36378t = new HashMap<>(length);
            for (int i5 = 0; i5 < length; i5++) {
                PropertyValuesHolder mo4177clone = propertyValuesHolderArr[i5].mo4177clone();
                valueAnimator.f36377s[i5] = mo4177clone;
                valueAnimator.f36378t.put(mo4177clone.getPropertyName(), mo4177clone);
            }
        }
        return valueAnimator;
    }

    public Object getAnimatedValue(String str) {
        PropertyValuesHolder propertyValuesHolder = this.f36378t.get(str);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.b();
        }
        return null;
    }
}
