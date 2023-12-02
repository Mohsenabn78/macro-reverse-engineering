package agency.tango.materialintroscreen.widgets;

import agency.tango.materialintroscreen.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.viewpager.widget.ViewPager;
import java.util.Arrays;

/* loaded from: classes.dex */
public class InkPageIndicator extends View implements ViewPager.OnPageChangeListener, View.OnAttachStateChangeListener {
    private int A;
    private int B;
    private float C;
    private boolean D;
    private float[] E;
    private float[] F;
    private float G;
    private float H;
    private float[] I;
    private boolean J;
    private boolean K;
    private Paint L;
    private Path M;
    private ValueAnimator N;
    private PendingRetreatAnimator O;
    private PendingRevealAnimator[] P;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f129a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f130b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f131c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f132d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f133e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator f134f;

    /* renamed from: g  reason: collision with root package name */
    float f135g;

    /* renamed from: h  reason: collision with root package name */
    float f136h;

    /* renamed from: i  reason: collision with root package name */
    float f137i;

    /* renamed from: j  reason: collision with root package name */
    float f138j;

    /* renamed from: k  reason: collision with root package name */
    float f139k;

    /* renamed from: l  reason: collision with root package name */
    float f140l;

    /* renamed from: m  reason: collision with root package name */
    float f141m;

    /* renamed from: n  reason: collision with root package name */
    float f142n;

    /* renamed from: o  reason: collision with root package name */
    private int f143o;

    /* renamed from: p  reason: collision with root package name */
    private int f144p;

    /* renamed from: q  reason: collision with root package name */
    private long f145q;

    /* renamed from: r  reason: collision with root package name */
    private int f146r;

    /* renamed from: s  reason: collision with root package name */
    private float f147s;

    /* renamed from: t  reason: collision with root package name */
    private float f148t;

    /* renamed from: u  reason: collision with root package name */
    private long f149u;

    /* renamed from: v  reason: collision with root package name */
    private float f150v;

    /* renamed from: w  reason: collision with root package name */
    private float f151w;

    /* renamed from: x  reason: collision with root package name */
    private float f152x;

    /* renamed from: y  reason: collision with root package name */
    private SwipeableViewPager f153y;

    /* renamed from: z  reason: collision with root package name */
    private int f154z;

    /* loaded from: classes.dex */
    public class LeftwardStartPredicate extends StartPredicate {
        LeftwardStartPredicate(float f4) {
            super(f4);
        }

        @Override // agency.tango.materialintroscreen.widgets.InkPageIndicator.StartPredicate
        boolean a(float f4) {
            if (f4 < this.f177a) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class PendingRetreatAnimator extends PendingStartAnimator {

        /* loaded from: classes.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InkPageIndicator f157a;

            a(InkPageIndicator inkPageIndicator) {
                this.f157a = inkPageIndicator;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InkPageIndicator.this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewCompat.postInvalidateOnAnimation(InkPageIndicator.this);
                for (PendingRevealAnimator pendingRevealAnimator : InkPageIndicator.this.P) {
                    pendingRevealAnimator.a(InkPageIndicator.this.G);
                }
            }
        }

        /* loaded from: classes.dex */
        class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InkPageIndicator f159a;

            b(InkPageIndicator inkPageIndicator) {
                this.f159a = inkPageIndicator;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                InkPageIndicator.this.H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewCompat.postInvalidateOnAnimation(InkPageIndicator.this);
                for (PendingRevealAnimator pendingRevealAnimator : InkPageIndicator.this.P) {
                    pendingRevealAnimator.a(InkPageIndicator.this.H);
                }
            }
        }

        /* loaded from: classes.dex */
        class c extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InkPageIndicator f161a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int[] f162b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ float f163c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ float f164d;

            c(InkPageIndicator inkPageIndicator, int[] iArr, float f4, float f5) {
                this.f161a = inkPageIndicator;
                this.f162b = iArr;
                this.f163c = f4;
                this.f164d = f5;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                InkPageIndicator.this.G = -1.0f;
                InkPageIndicator.this.H = -1.0f;
                ViewCompat.postInvalidateOnAnimation(InkPageIndicator.this);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                InkPageIndicator.this.clearJoiningFractions();
                for (int i4 : this.f162b) {
                    InkPageIndicator.this.D(i4, 1.0E-5f);
                }
                InkPageIndicator.this.G = this.f163c;
                InkPageIndicator.this.H = this.f164d;
                ViewCompat.postInvalidateOnAnimation(InkPageIndicator.this);
            }
        }

        PendingRetreatAnimator(int i4, int i5, int i6, StartPredicate startPredicate) {
            super(startPredicate);
            float f4;
            float f5;
            float f6;
            float f7;
            float max;
            float f8;
            float f9;
            float f10;
            setDuration(InkPageIndicator.this.f149u);
            setInterpolator(InkPageIndicator.this.f134f);
            if (i5 > i4) {
                f4 = Math.min(InkPageIndicator.this.E[i4], InkPageIndicator.this.C);
                f5 = InkPageIndicator.this.f147s;
            } else {
                f4 = InkPageIndicator.this.E[i5];
                f5 = InkPageIndicator.this.f147s;
            }
            float f11 = f4 - f5;
            if (i5 > i4) {
                f6 = InkPageIndicator.this.E[i5];
                f7 = InkPageIndicator.this.f147s;
            } else {
                f6 = InkPageIndicator.this.E[i5];
                f7 = InkPageIndicator.this.f147s;
            }
            float f12 = f6 - f7;
            if (i5 > i4) {
                max = InkPageIndicator.this.E[i5];
                f8 = InkPageIndicator.this.f147s;
            } else {
                max = Math.max(InkPageIndicator.this.E[i4], InkPageIndicator.this.C);
                f8 = InkPageIndicator.this.f147s;
            }
            float f13 = max + f8;
            if (i5 > i4) {
                f9 = InkPageIndicator.this.E[i5];
                f10 = InkPageIndicator.this.f147s;
            } else {
                f9 = InkPageIndicator.this.E[i5];
                f10 = InkPageIndicator.this.f147s;
            }
            float f14 = f9 + f10;
            InkPageIndicator.this.P = new PendingRevealAnimator[i6];
            int[] iArr = new int[i6];
            int i7 = 0;
            if (f11 != f12) {
                setFloatValues(f11, f12);
                while (i7 < i6) {
                    int i8 = i4 + i7;
                    InkPageIndicator.this.P[i7] = new PendingRevealAnimator(i8, new RightwardStartPredicate(InkPageIndicator.this.E[i8]));
                    iArr[i7] = i8;
                    i7++;
                }
                addUpdateListener(new a(InkPageIndicator.this));
            } else {
                setFloatValues(f13, f14);
                while (i7 < i6) {
                    int i9 = i4 - i7;
                    InkPageIndicator.this.P[i7] = new PendingRevealAnimator(i9, new LeftwardStartPredicate(InkPageIndicator.this.E[i9]));
                    iArr[i7] = i9;
                    i7++;
                }
                addUpdateListener(new b(InkPageIndicator.this));
            }
            addListener(new c(InkPageIndicator.this, iArr, f11, f13));
        }
    }

    /* loaded from: classes.dex */
    public class PendingRevealAnimator extends PendingStartAnimator {

        /* renamed from: d  reason: collision with root package name */
        private int f166d;

        /* loaded from: classes.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InkPageIndicator f168a;

            a(InkPageIndicator inkPageIndicator) {
                this.f168a = inkPageIndicator;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PendingRevealAnimator pendingRevealAnimator = PendingRevealAnimator.this;
                InkPageIndicator.this.D(pendingRevealAnimator.f166d, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        /* loaded from: classes.dex */
        class b extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InkPageIndicator f170a;

            b(InkPageIndicator inkPageIndicator) {
                this.f170a = inkPageIndicator;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PendingRevealAnimator pendingRevealAnimator = PendingRevealAnimator.this;
                InkPageIndicator.this.D(pendingRevealAnimator.f166d, 0.0f);
                ViewCompat.postInvalidateOnAnimation(InkPageIndicator.this);
            }
        }

        PendingRevealAnimator(int i4, StartPredicate startPredicate) {
            super(startPredicate);
            setFloatValues(1.0E-5f, 1.0f);
            this.f166d = i4;
            setDuration(InkPageIndicator.this.f149u);
            setInterpolator(InkPageIndicator.this.f134f);
            addUpdateListener(new a(InkPageIndicator.this));
            addListener(new b(InkPageIndicator.this));
        }
    }

    /* loaded from: classes.dex */
    public abstract class PendingStartAnimator extends ValueAnimator {

        /* renamed from: a  reason: collision with root package name */
        boolean f172a = false;

        /* renamed from: b  reason: collision with root package name */
        StartPredicate f173b;

        PendingStartAnimator(StartPredicate startPredicate) {
            this.f173b = startPredicate;
        }

        void a(float f4) {
            if (!this.f172a && this.f173b.a(f4)) {
                start();
                this.f172a = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class RightwardStartPredicate extends StartPredicate {
        RightwardStartPredicate(float f4) {
            super(f4);
        }

        @Override // agency.tango.materialintroscreen.widgets.InkPageIndicator.StartPredicate
        boolean a(float f4) {
            if (f4 > this.f177a) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f176a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f176a);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f176a = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public abstract class StartPredicate {

        /* renamed from: a  reason: collision with root package name */
        float f177a;

        StartPredicate(float f4) {
            this.f177a = f4;
        }

        abstract boolean a(float f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            InkPageIndicator inkPageIndicator = InkPageIndicator.this;
            inkPageIndicator.setPageCount(inkPageIndicator.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InkPageIndicator.this.B();
            InkPageIndicator.this.K = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            InkPageIndicator.this.C = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            InkPageIndicator.this.O.a(InkPageIndicator.this.C);
            ViewCompat.postInvalidateOnAnimation(InkPageIndicator.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            InkPageIndicator.this.D = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            InkPageIndicator.this.D = false;
        }
    }

    public InkPageIndicator(Context context) {
        this(context, null, 0);
    }

    private boolean A(int i4, float f4, float f5) {
        if ((f4 == 0.0f || f4 == -1.0f) && f5 == 0.0f && (i4 != this.A || !this.D)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        float[] fArr = new float[this.f154z - 1];
        this.F = fArr;
        Arrays.fill(fArr, 0.0f);
        float[] fArr2 = new float[this.f154z];
        this.I = fArr2;
        Arrays.fill(fArr2, 0.0f);
        this.G = -1.0f;
        this.H = -1.0f;
        this.D = true;
    }

    private void C() {
        SwipeableViewPager swipeableViewPager = this.f153y;
        if (swipeableViewPager != null) {
            this.A = swipeableViewPager.getCurrentItem();
        } else {
            this.A = 0;
        }
        if (y()) {
            this.C = this.E[this.A];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i4, float f4) {
        float[] fArr = this.I;
        if (i4 < fArr.length) {
            fArr[i4] = f4;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void E(int i4, float f4) {
        float[] fArr = this.F;
        if (fArr != null && i4 < fArr.length) {
            fArr[i4] = f4;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCount() {
        return this.f153y.getAdapter().slidesCount();
    }

    private int getDesiredHeight() {
        return getPaddingTop() + this.f143o + getPaddingBottom();
    }

    private int getDesiredWidth() {
        return getPaddingLeft() + getRequiredWidth() + getPaddingRight();
    }

    private int getRequiredWidth() {
        int i4 = this.f154z;
        return (this.f143o * i4) + ((i4 - 1) * this.f144p);
    }

    private Path getRetreatingJoinPath() {
        this.f130b.rewind();
        this.f133e.set(this.G, this.f150v, this.H, this.f152x);
        Path path = this.f130b;
        RectF rectF = this.f133e;
        float f4 = this.f147s;
        path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        return this.f130b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageCount(int i4) {
        if (i4 > 0) {
            this.f154z = i4;
            B();
            requestLayout();
        }
    }

    private void setSelectedPage(int i4) {
        int i5 = this.A;
        if (i4 == i5) {
            return;
        }
        this.K = true;
        this.B = i5;
        this.A = i4;
        int abs = Math.abs(i4 - i5);
        if (abs > 1) {
            if (i4 > this.B) {
                for (int i6 = 0; i6 < abs; i6++) {
                    E(this.B + i6, 1.0f);
                }
            } else {
                for (int i7 = -1; i7 > (-abs); i7--) {
                    E(this.B + i7, 1.0f);
                }
            }
        }
        float[] fArr = this.E;
        if (fArr != null) {
            ValueAnimator u3 = u(fArr[i4], this.B, i4, abs);
            this.N = u3;
            u3.start();
        }
    }

    private void t(int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        float paddingRight = paddingLeft + ((((i4 - getPaddingRight()) - paddingLeft) - getRequiredWidth()) / 2) + this.f147s;
        this.E = new float[this.f154z];
        for (int i5 = 0; i5 < this.f154z; i5++) {
            this.E[i5] = ((this.f143o + this.f144p) * i5) + paddingRight;
        }
        float f4 = paddingTop;
        this.f150v = f4;
        this.f151w = f4 + this.f147s;
        this.f152x = paddingTop + this.f143o;
        C();
    }

    private ValueAnimator u(float f4, int i4, int i5, int i6) {
        StartPredicate leftwardStartPredicate;
        long j4;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.C, f4);
        if (i5 > i4) {
            leftwardStartPredicate = new RightwardStartPredicate(f4 - ((f4 - this.C) * 0.25f));
        } else {
            leftwardStartPredicate = new LeftwardStartPredicate(f4 + ((this.C - f4) * 0.25f));
        }
        PendingRetreatAnimator pendingRetreatAnimator = new PendingRetreatAnimator(i4, i5, i6, leftwardStartPredicate);
        this.O = pendingRetreatAnimator;
        pendingRetreatAnimator.addListener(new b());
        ofFloat.addUpdateListener(new c());
        ofFloat.addListener(new d());
        if (this.D) {
            j4 = this.f145q / 4;
        } else {
            j4 = 0;
        }
        ofFloat.setStartDelay(j4);
        ofFloat.setDuration((this.f145q * 3) / 4);
        ofFloat.setInterpolator(this.f134f);
        return ofFloat;
    }

    private void v(Canvas canvas) {
        canvas.drawCircle(this.C, this.f151w, this.f147s, this.f129a);
    }

    private void w(Canvas canvas) {
        int i4;
        float f4;
        this.M.rewind();
        int i5 = 0;
        while (true) {
            int i6 = this.f154z;
            if (i5 >= i6) {
                break;
            }
            if (i5 == i6 - 1) {
                i4 = i5;
            } else {
                i4 = i5 + 1;
            }
            float[] fArr = this.E;
            float f5 = fArr[i5];
            float f6 = fArr[i4];
            if (i5 == i6 - 1) {
                f4 = -1.0f;
            } else {
                f4 = this.F[i5];
            }
            Path x3 = x(i5, f5, f6, f4, this.I[i5]);
            x3.addPath(this.M);
            this.M.addPath(x3);
            i5++;
        }
        if (this.G != -1.0f) {
            this.M.addPath(getRetreatingJoinPath());
        }
        canvas.drawPath(this.M, this.L);
    }

    private Path x(int i4, float f4, float f5, float f6, float f7) {
        this.f130b.rewind();
        if (A(i4, f6, f7)) {
            this.f130b.addCircle(this.E[i4], this.f151w, this.f147s, Path.Direction.CW);
        }
        if (z(f6)) {
            this.f131c.rewind();
            this.f131c.moveTo(f4, this.f152x);
            RectF rectF = this.f133e;
            float f8 = this.f147s;
            rectF.set(f4 - f8, this.f150v, f8 + f4, this.f152x);
            this.f131c.arcTo(this.f133e, 90.0f, 180.0f, true);
            float f9 = this.f147s + f4 + (this.f144p * f6);
            this.f135g = f9;
            float f10 = this.f151w;
            this.f136h = f10;
            float f11 = this.f148t;
            float f12 = f4 + f11;
            this.f139k = f12;
            float f13 = this.f150v;
            this.f140l = f13;
            this.f141m = f9;
            float f14 = f10 - f11;
            this.f142n = f14;
            this.f131c.cubicTo(f12, f13, f9, f14, f9, f10);
            this.f137i = f4;
            float f15 = this.f152x;
            this.f138j = f15;
            float f16 = this.f135g;
            this.f139k = f16;
            float f17 = this.f136h;
            float f18 = this.f148t;
            float f19 = f17 + f18;
            this.f140l = f19;
            float f20 = f4 + f18;
            this.f141m = f20;
            this.f142n = f15;
            this.f131c.cubicTo(f16, f19, f20, f15, f4, f15);
            this.f130b.addPath(this.f131c);
            this.f132d.rewind();
            this.f132d.moveTo(f5, this.f152x);
            RectF rectF2 = this.f133e;
            float f21 = this.f147s;
            rectF2.set(f5 - f21, this.f150v, f21 + f5, this.f152x);
            this.f132d.arcTo(this.f133e, 90.0f, -180.0f, true);
            float f22 = (f5 - this.f147s) - (this.f144p * f6);
            this.f135g = f22;
            float f23 = this.f151w;
            this.f136h = f23;
            float f24 = this.f148t;
            float f25 = f5 - f24;
            this.f139k = f25;
            float f26 = this.f150v;
            this.f140l = f26;
            this.f141m = f22;
            float f27 = f23 - f24;
            this.f142n = f27;
            this.f132d.cubicTo(f25, f26, f22, f27, f22, f23);
            this.f137i = f5;
            float f28 = this.f152x;
            this.f138j = f28;
            float f29 = this.f135g;
            this.f139k = f29;
            float f30 = this.f136h;
            float f31 = this.f148t;
            float f32 = f30 + f31;
            this.f140l = f32;
            float f33 = f5 - f31;
            this.f141m = f33;
            this.f142n = f28;
            this.f132d.cubicTo(f29, f32, f33, f28, f5, f28);
            this.f130b.addPath(this.f132d);
        }
        if (f6 > 0.5f && f6 < 1.0f && this.G == -1.0f) {
            float f34 = (f6 - 0.2f) * 1.25f;
            this.f130b.moveTo(f4, this.f152x);
            RectF rectF3 = this.f133e;
            float f35 = this.f147s;
            rectF3.set(f4 - f35, this.f150v, f35 + f4, this.f152x);
            this.f130b.arcTo(this.f133e, 90.0f, 180.0f, true);
            float f36 = this.f147s;
            float f37 = f4 + f36 + (this.f144p / 2);
            this.f135g = f37;
            float f38 = this.f151w - (f34 * f36);
            this.f136h = f38;
            float f39 = f37 - (f34 * f36);
            this.f139k = f39;
            float f40 = this.f150v;
            this.f140l = f40;
            float f41 = 1.0f - f34;
            float f42 = f37 - (f36 * f41);
            this.f141m = f42;
            this.f142n = f38;
            this.f130b.cubicTo(f39, f40, f42, f38, f37, f38);
            this.f137i = f5;
            float f43 = this.f150v;
            this.f138j = f43;
            float f44 = this.f135g;
            float f45 = this.f147s;
            float f46 = (f41 * f45) + f44;
            this.f139k = f46;
            float f47 = this.f136h;
            this.f140l = f47;
            float f48 = f44 + (f45 * f34);
            this.f141m = f48;
            this.f142n = f43;
            this.f130b.cubicTo(f46, f47, f48, f43, f5, f43);
            RectF rectF4 = this.f133e;
            float f49 = this.f147s;
            rectF4.set(f5 - f49, this.f150v, f49 + f5, this.f152x);
            this.f130b.arcTo(this.f133e, 270.0f, 180.0f, true);
            float f50 = this.f151w;
            float f51 = this.f147s;
            float f52 = f50 + (f34 * f51);
            this.f136h = f52;
            float f53 = this.f135g;
            float f54 = (f34 * f51) + f53;
            this.f139k = f54;
            float f55 = this.f152x;
            this.f140l = f55;
            float f56 = (f51 * f41) + f53;
            this.f141m = f56;
            this.f142n = f52;
            this.f130b.cubicTo(f54, f55, f56, f52, f53, f52);
            this.f137i = f4;
            float f57 = this.f152x;
            this.f138j = f57;
            float f58 = this.f135g;
            float f59 = this.f147s;
            float f60 = f58 - (f41 * f59);
            this.f139k = f60;
            float f61 = this.f136h;
            this.f140l = f61;
            float f62 = f58 - (f34 * f59);
            this.f141m = f62;
            this.f142n = f57;
            this.f130b.cubicTo(f60, f61, f62, f57, f4, f57);
        }
        if (f6 == 1.0f && this.G == -1.0f) {
            RectF rectF5 = this.f133e;
            float f63 = this.f147s;
            rectF5.set(f4 - f63, this.f150v, f63 + f5, this.f152x);
            Path path = this.f130b;
            RectF rectF6 = this.f133e;
            float f64 = this.f147s;
            path.addRoundRect(rectF6, f64, f64, Path.Direction.CW);
        }
        if (f7 > 1.0E-5f) {
            this.f130b.addCircle(f4, this.f151w, this.f147s * f7, Path.Direction.CW);
        }
        return this.f130b;
    }

    private boolean y() {
        ValueAnimator valueAnimator;
        float[] fArr = this.E;
        if (fArr != null && fArr.length > 0 && ((valueAnimator = this.N) == null || !valueAnimator.isStarted())) {
            return true;
        }
        return false;
    }

    private boolean z(float f4) {
        if (f4 > 0.0f && f4 <= 0.5f && this.G == -1.0f) {
            return true;
        }
        return false;
    }

    public void clearJoiningFractions() {
        Arrays.fill(this.F, 0.0f);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f153y != null && this.f154z != 0) {
            w(canvas);
            v(canvas);
        }
    }

    @Override // android.view.View
    @SuppressLint({"SwitchIntDef"})
    protected void onMeasure(int i4, int i5) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                desiredHeight = View.MeasureSpec.getSize(i5);
            }
        } else {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i5));
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 1073741824) {
                desiredWidth = View.MeasureSpec.getSize(i4);
            }
        } else {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i4));
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
        t(desiredWidth);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i4, float f4, int i5) {
        int i6;
        if (this.J) {
            if (this.K) {
                i6 = this.B;
            } else {
                i6 = this.A;
            }
            if (i6 != i4) {
                f4 = 1.0f - f4;
                if (f4 == 1.0f) {
                    i4 = Math.min(i6, i4);
                }
            }
            E(i4, f4);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i4) {
        if (i4 < this.f154z) {
            if (this.J) {
                setSelectedPage(i4);
            } else {
                C();
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.A = savedState.f176a;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f176a = this.A;
        return savedState;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.J = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.J = false;
    }

    public void setPageIndicatorColor(int i4) {
        this.f146r = i4;
        Paint paint = new Paint(1);
        this.L = paint;
        paint.setColor(this.f146r);
    }

    public void setViewPager(SwipeableViewPager swipeableViewPager) {
        this.f153y = swipeableViewPager;
        swipeableViewPager.addOnPageChangeListener(this);
        setPageCount(getCount());
        swipeableViewPager.getAdapter().registerDataSetObserver(new a());
        C();
    }

    public InkPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InkPageIndicator(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        int i5 = (int) context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.InkPageIndicator, i4, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InkPageIndicator_dotDiameter, i5 * 8);
        this.f143o = dimensionPixelSize;
        float f4 = dimensionPixelSize / 2;
        this.f147s = f4;
        this.f148t = f4 / 2.0f;
        this.f144p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InkPageIndicator_dotGap, i5 * 12);
        long integer = obtainStyledAttributes.getInteger(R.styleable.InkPageIndicator_animationDuration, 400);
        this.f145q = integer;
        this.f149u = integer / 2;
        this.f146r = obtainStyledAttributes.getColor(R.styleable.InkPageIndicator_pageIndicatorColor, -2130706433);
        int color = obtainStyledAttributes.getColor(R.styleable.InkPageIndicator_currentPageIndicatorColor, -1);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.L = paint;
        paint.setColor(this.f146r);
        Paint paint2 = new Paint(1);
        this.f129a = paint2;
        paint2.setColor(color);
        this.f134f = new FastOutSlowInInterpolator();
        this.M = new Path();
        this.f130b = new Path();
        this.f131c = new Path();
        this.f132d = new Path();
        this.f133e = new RectF();
        addOnAttachStateChangeListener(this);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i4) {
    }
}
