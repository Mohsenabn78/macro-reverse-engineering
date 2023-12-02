package com.pollfish.internal;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.pollfish.R;
import com.pollfish.builder.Position;
import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import com.pollfish.internal.n2;
import com.pollfish.internal.u1;
import com.pollfish.internal.y5;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class n2 extends RelativeLayout implements u1.a<Boolean> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u3 f37122a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final x0 f37123b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final m1 f37124c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37125d;

    /* renamed from: e  reason: collision with root package name */
    public int f37126e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37127f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final c f37128g;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37129a;

        static {
            int[] iArr = new int[Position.values().length];
            try {
                iArr[Position.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Position.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Position.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Position.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f37129a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function0<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f37130a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(0);
            this.f37130a = imageView;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.f37130a.setImageResource(R.drawable.pollfish_indicator);
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements u1.a<w0> {
        public c() {
        }

        @Override // com.pollfish.internal.u1.a
        public final void a(w0 w0Var) {
            boolean areEqual;
            w0 w0Var2 = w0Var;
            if (w0Var2 instanceof y5.c) {
                areEqual = true;
            } else {
                areEqual = Intrinsics.areEqual(w0Var2, y5.d.f37368a);
            }
            if (areEqual) {
                n2.this.a(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends Lambda implements Function0<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f37132a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n2 f37133b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(boolean z3, n2 n2Var) {
            super(0);
            this.f37132a = z3;
            this.f37133b = n2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            try {
                if (this.f37132a) {
                    n2 n2Var = this.f37133b;
                    n2Var.a(new p2(n2Var));
                } else {
                    n2.e(this.f37133b);
                }
            } catch (Exception e4) {
                this.f37133b.f37122a.a(new l4.a.d0(e4));
            }
            return Unit.INSTANCE;
        }
    }

    public n2(@NotNull Context context, @NotNull u3 u3Var, @NotNull x0 x0Var, @NotNull m1 m1Var) {
        super(context);
        this.f37122a = u3Var;
        this.f37123b = x0Var;
        this.f37124c = m1Var;
        c cVar = new c();
        this.f37128g = cVar;
        setId(View.generateViewId());
        setLayoutTransition(new LayoutTransition());
        this.f37126e = s5.a((View) this);
        setClipToPadding(false);
        setClipChildren(false);
        u3Var.m().b(this);
        x0Var.a(cVar);
    }

    public static final void e(n2 n2Var) {
        n2Var.f37127f = false;
        n2Var.f37122a.m().c(n2Var);
        n2Var.f37123b.b(n2Var.f37128g);
        ViewParent parent = n2Var.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(n2Var);
            parent.requestLayout();
        }
    }

    public static final void f(n2 n2Var) {
        if (n2Var.f37127f && n2Var.f37126e != s5.a((View) n2Var)) {
            n2Var.f37122a.t();
        } else if (!n2Var.f37127f && n2Var.f37126e == s5.a((View) n2Var)) {
            n2Var.f37127f = true;
            n2Var.getLayoutTransition().enableTransitionType(4);
            ImageView imageView = n2Var.f37125d;
            if (imageView != null) {
                RelativeLayout.LayoutParams imageViewLayoutParams = n2Var.getImageViewLayoutParams();
                Pair<Integer, Integer> padding = n2Var.getPadding();
                imageViewLayoutParams.setMargins(0, padding.getSecond().intValue(), 0, padding.getFirst().intValue());
                if (z1.a(n2Var.f37124c.b()) == 1) {
                    imageViewLayoutParams.addRule(20);
                } else {
                    imageViewLayoutParams.addRule(21);
                }
                imageView.setLayoutParams(imageViewLayoutParams);
            }
        }
    }

    private final int getHideEndHorizontalPosition() {
        Position position = this.f37124c.f37079a;
        if (position != Position.TOP_LEFT && position != Position.MIDDLE_LEFT && position != Position.BOTTOM_LEFT) {
            return getWidth();
        }
        return -s5.a(this, 64);
    }

    private final RelativeLayout.LayoutParams getImageViewLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(s5.a(this, 64), s5.a(this, 64));
        Position position = this.f37124c.f37079a;
        if (position != Position.BOTTOM_RIGHT && position != Position.BOTTOM_LEFT) {
            if (position != Position.MIDDLE_RIGHT && position != Position.MIDDLE_LEFT) {
                if (position == Position.TOP_LEFT || position == Position.TOP_RIGHT) {
                    layoutParams.addRule(10);
                }
            } else {
                layoutParams.addRule(15);
            }
        } else {
            layoutParams.addRule(12);
        }
        return layoutParams;
    }

    private final Pair<Integer, Integer> getPadding() {
        int i4 = a.f37129a[this.f37124c.b().ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3 && i4 != 4) {
                return new Pair<>(0, 0);
            }
            return new Pair<>(Integer.valueOf(s5.a(this, this.f37124c.a())), 0);
        }
        return new Pair<>(0, Integer.valueOf(s5.a(this, this.f37124c.a())));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        post(new Runnable() { // from class: k1.s
            @Override // java.lang.Runnable
            public final void run() {
                n2.f(n2.this);
            }
        });
    }

    @Override // com.pollfish.internal.u1.a
    public final void a(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                s5.a(this, new q2(this));
            } else {
                a(true);
            }
        }
    }

    public final void a() {
        Unit unit;
        ImageView imageView = new ImageView(getContext());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: k1.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n2.a(n2.this, view);
            }
        });
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Pair<Integer, Integer> padding = getPadding();
        RelativeLayout.LayoutParams imageViewLayoutParams = getImageViewLayoutParams();
        if (z1.a(this.f37124c.b()) == 1) {
            imageViewLayoutParams.addRule(20);
            imageViewLayoutParams.setMargins(-s5.a(imageView, 64), padding.getSecond().intValue(), 0, padding.getFirst().intValue());
        } else {
            imageViewLayoutParams.addRule(21);
            imageViewLayoutParams.setMargins(0, padding.getSecond().intValue(), -s5.a(imageView, 64), padding.getFirst().intValue());
        }
        imageView.setLayoutParams(imageViewLayoutParams);
        g2 d4 = this.f37122a.d();
        if (d4 != null) {
            s5.a(imageView, d4.g(), new b(imageView));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            u3 u3Var = this.f37122a;
            u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
        }
        this.f37125d = imageView;
        addView(imageView);
    }

    public static final void a(n2 n2Var, View view) {
        n2Var.f37122a.s();
    }

    public final void a(boolean z3) {
        s5.a(this, new d(z3, this));
    }

    public final void a(final p2 p2Var) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator x3;
        ViewPropertyAnimator withEndAction;
        try {
            ImageView imageView = this.f37125d;
            if (imageView == null || (animate = imageView.animate()) == null || (x3 = animate.x(getHideEndHorizontalPosition())) == null || (withEndAction = x3.withEndAction(new Runnable() { // from class: k1.r
                @Override // java.lang.Runnable
                public final void run() {
                    n2.a(n2.this, p2Var);
                }
            })) == null) {
                return;
            }
            withEndAction.start();
        } catch (Exception e4) {
            this.f37122a.a(f4.a.ERROR, new l4.a.c(e4));
            p2Var.invoke();
        }
    }

    public static final void a(n2 n2Var, Function0 function0) {
        s5.a(n2Var, new o2(function0));
    }
}
