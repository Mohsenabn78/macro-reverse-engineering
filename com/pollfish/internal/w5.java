package com.pollfish.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.pollfish.internal.u1;
import com.pollfish.internal.u3;
import com.pollfish.internal.y5;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class w5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u3 f37284a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final x0 f37285b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<c4> f37286c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Context> f37287d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<ViewGroup> f37288e;

    /* renamed from: f  reason: collision with root package name */
    public int f37289f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final c f37290g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final b f37291h;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c4 f37292a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c4 c4Var) {
            super(0);
            this.f37292a = c4Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.f37292a.destroy();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements u1.a<w0> {
        public b() {
        }

        @Override // com.pollfish.internal.u1.a
        public final void a(w0 w0Var) {
            y5 y5Var;
            w0 w0Var2 = w0Var;
            if (w0Var2 instanceof y5) {
                y5Var = (y5) w0Var2;
            } else {
                y5Var = null;
            }
            if (y5Var != null) {
                w5.a(w5.this, y5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements u1.a<Boolean> {
        public c() {
        }

        @Override // com.pollfish.internal.u1.a
        public final void a(Boolean bool) {
            if (Intrinsics.areEqual(bool, Boolean.TRUE) && (w5.this.f37284a.a() instanceof u3.a.e)) {
                int i4 = w5.this.f37289f;
                if (i4 == 0) {
                    i4 = 0;
                }
                int a4 = v0.a(i4);
                if (a4 == 0) {
                    w5.this.a();
                    w5.a(w5.this);
                } else if (a4 == 1) {
                    w5.e(w5.this);
                }
            }
        }
    }

    public w5(u3 u3Var, x0 x0Var) {
        this.f37284a = u3Var;
        this.f37285b = x0Var;
        this.f37290g = new c();
        this.f37291h = new b();
        b();
    }

    public static final void a(w5 w5Var, y5 y5Var) {
        Context context;
        ViewGroup viewGroup;
        WeakReference<Context> weakReference;
        Context context2;
        w5Var.getClass();
        if (Intrinsics.areEqual(y5Var, y5.b.f37366a)) {
            w5Var.a();
            int i4 = w5Var.f37289f;
            if (i4 == 0) {
                i4 = 0;
            }
            int a4 = v0.a(i4);
            if (a4 != 0) {
                if (a4 != 1 || (weakReference = w5Var.f37287d) == null || (context2 = weakReference.get()) == null) {
                    return;
                }
                c0.a(context2, new u5(w5Var, context2));
                return;
            }
            WeakReference<ViewGroup> weakReference2 = w5Var.f37288e;
            if (weakReference2 == null || (viewGroup = weakReference2.get()) == null) {
                return;
            }
            s5.a(viewGroup, new v5(w5Var, viewGroup));
        } else if (Intrinsics.areEqual(y5Var, y5.a.f37365a)) {
            WeakReference<Context> weakReference3 = w5Var.f37287d;
            if (weakReference3 == null || (context = weakReference3.get()) == null) {
                return;
            }
            t5.a(context);
        } else if (Intrinsics.areEqual(y5Var, y5.c.f37367a)) {
            w5Var.a();
        } else if (Intrinsics.areEqual(y5Var, y5.d.f37368a)) {
            w5Var.a();
        }
    }

    public static final void e(w5 w5Var) {
        Context context;
        Activity activity;
        Window window;
        View decorView;
        WeakReference<Context> weakReference = w5Var.f37287d;
        if (weakReference != null && (context = weakReference.get()) != null) {
            Intent intent = new Intent(context, PollfishOverlayActivity.class);
            if (Build.VERSION.SDK_INT < 30) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                    intent.putExtra("ui_visibility", decorView.getSystemUiVisibility());
                }
            }
            context.startActivity(intent);
            w5Var.a();
        }
    }

    public static final void f(w5 w5Var) {
        WeakReference<Context> weakReference = w5Var.f37287d;
        if (weakReference != null && weakReference.get() != null && !w5Var.f37284a.q().a(w5Var.f37290g)) {
            w5Var.f37284a.q().b(w5Var.f37290g);
        }
    }

    public final void b() {
        this.f37284a.q().b(this.f37290g);
        Unit unit = Unit.INSTANCE;
        this.f37284a.q().a(this.f37290g);
        this.f37285b.a((u1.a<w0>) this.f37291h);
        this.f37285b.a(this.f37291h);
    }

    public w5(@NotNull u3 u3Var, @NotNull x0 x0Var, @NotNull Context context) {
        this(u3Var, x0Var);
        this.f37287d = new WeakReference<>(context);
        this.f37289f = 2;
    }

    public w5(@NotNull u3 u3Var, @NotNull x0 x0Var, @NotNull ViewGroup viewGroup) {
        this(u3Var, x0Var);
        this.f37288e = new WeakReference<>(viewGroup);
        this.f37289f = 1;
    }

    public final void a(@NotNull Context context) {
        this.f37287d = new WeakReference<>(context);
    }

    public static final void a(w5 w5Var) {
        WeakReference<ViewGroup> weakReference;
        ViewGroup viewGroup;
        int i4 = w5Var.f37289f;
        if (i4 == 0) {
            i4 = 0;
        }
        if (i4 != 1 || (weakReference = w5Var.f37288e) == null || (viewGroup = weakReference.get()) == null) {
            return;
        }
        t5.a(viewGroup);
        w5Var.f37287d = new WeakReference<>(viewGroup.getContext());
    }

    public final void a() {
        c4 c4Var;
        WeakReference<c4> weakReference = this.f37286c;
        if (weakReference == null || (c4Var = weakReference.get()) == null) {
            return;
        }
        s5.a(c4Var, new a(c4Var));
        this.f37286c = null;
    }
}
