package com.pollfish.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import com.pollfish.internal.u1;
import com.pollfish.internal.y5;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class t3 extends FrameLayout {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final View f37232a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final u3 f37233b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final x0 f37234c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final d f37235d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final a f37236e;

    /* renamed from: f  reason: collision with root package name */
    public int f37237f;

    /* loaded from: classes6.dex */
    public static final class a implements u1.a<w0> {
        public a() {
        }

        @Override // com.pollfish.internal.u1.a
        public final void a(w0 w0Var) {
            boolean z3;
            w0 w0Var2 = w0Var;
            if (w0Var2 instanceof y5.d) {
                z3 = true;
            } else {
                z3 = w0Var2 instanceof y5.c;
            }
            if (z3) {
                t3.this.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            t3 t3Var = t3.this;
            t3Var.removeView(t3Var.f37232a);
            ViewParent parent = t3.this.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(t3.this);
            }
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends Lambda implements Function0<Unit> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            try {
                if (t3.this.f37232a.getParent() != null) {
                    t3 t3Var = t3.this;
                    t3Var.removeView(t3Var.f37232a);
                }
                t3 t3Var2 = t3.this;
                t3Var2.addView(t3Var2.f37232a);
                if (t3.this.getParent() != null) {
                    ((ViewGroup) t3.this.getParent()).removeView(t3.this);
                }
                ((Activity) t3.this.getContext()).addContentView(t3.this, new RelativeLayout.LayoutParams(-1, -1));
            } catch (Exception e4) {
                t3.this.f37233b.a(new l4.a.d0(e4));
                t3.c(t3.this);
            }
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements u1.a<Boolean> {
        public d() {
        }

        @Override // com.pollfish.internal.u1.a
        public final void a(Boolean bool) {
            Boolean bool2 = bool;
            if (bool2 != null) {
                t3 t3Var = t3.this;
                bool2.booleanValue();
                if (bool2.booleanValue()) {
                    t3Var.c();
                } else {
                    t3Var.a();
                }
            }
        }
    }

    public t3(@NotNull Context context, @NotNull View view, @NotNull u3 u3Var, @NotNull x0 x0Var) {
        super(context);
        Unit unit;
        this.f37232a = view;
        this.f37233b = u3Var;
        this.f37234c = x0Var;
        this.f37235d = new d();
        this.f37236e = new a();
        g2 d4 = u3Var.d();
        if (d4 != null) {
            setBackgroundColor(Color.parseColor(d4.p()));
            view.setBackgroundColor(Color.parseColor(d4.p()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            u3Var.a(f4.a.ERROR, new l4.a.u(u3Var.toString()));
        }
        b();
    }

    public final void c() {
        this.f37237f = ((Activity) getContext()).getRequestedOrientation();
        ((Activity) getContext()).setRequestedOrientation(14);
        s5.a(this, new c());
    }

    @NotNull
    public final View getVideoView() {
        return this.f37232a;
    }

    public final void a() {
        ((Activity) getContext()).setRequestedOrientation(this.f37237f);
        this.f37233b.e().c(this.f37235d);
        this.f37234c.b(this.f37236e);
        s5.a(this, new b());
    }

    public final void b() {
        this.f37233b.e().b(this.f37235d);
        this.f37234c.a(this.f37236e);
    }

    public static final void c(t3 t3Var) {
        ((Activity) t3Var.getContext()).setRequestedOrientation(t3Var.f37237f);
    }
}
