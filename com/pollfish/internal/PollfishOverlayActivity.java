package com.pollfish.internal;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.pollfish.Pollfish;
import com.pollfish.internal.PollfishOverlayActivity;
import com.pollfish.internal.k3;
import com.pollfish.internal.l4;
import com.pollfish.internal.u1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/pollfish/internal/PollfishOverlayActivity;", "Landroid/app/Activity;", "Lcom/pollfish/internal/k3$a;", "Lcom/pollfish/internal/u1$a;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class PollfishOverlayActivity extends Activity implements k3.a, u1.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public k3 f36680a;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            k3 k3Var = PollfishOverlayActivity.this.f36680a;
            if (k3Var == null) {
                k3Var = null;
            }
            k3Var.n();
            return Unit.INSTANCE;
        }
    }

    public static final void b(PollfishOverlayActivity pollfishOverlayActivity) {
        y compositionRoot$pollfish_googleplayRelease;
        u3 k4;
        try {
            k3 k3Var = pollfishOverlayActivity.f36680a;
            k3 k3Var2 = null;
            if (k3Var == null) {
                k3Var = null;
            }
            k3Var.setVisibility(0);
            k3 k3Var3 = pollfishOverlayActivity.f36680a;
            if (k3Var3 == null) {
                k3Var3 = null;
            }
            k3Var3.k();
            k3 k3Var4 = pollfishOverlayActivity.f36680a;
            if (k3Var4 != null) {
                k3Var2 = k3Var4;
            }
            k3Var2.a(new a());
        } catch (Exception e4) {
            Pollfish instance$pollfish_googleplayRelease = Pollfish.Companion.getInstance$pollfish_googleplayRelease();
            if (instance$pollfish_googleplayRelease != null && (compositionRoot$pollfish_googleplayRelease = instance$pollfish_googleplayRelease.getCompositionRoot$pollfish_googleplayRelease()) != null && (k4 = compositionRoot$pollfish_googleplayRelease.k()) != null) {
                k4.a(new l4.a.d0(e4));
            }
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            Result.Companion companion = Result.Companion;
            k3 k3Var = this.f36680a;
            if (k3Var == null) {
                k3Var = null;
            }
            k3Var.m();
            Result.m4188constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m4188constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // android.app.Activity
    public final void onCreate(@Nullable Bundle bundle) {
        y compositionRoot$pollfish_googleplayRelease;
        u3 k4;
        y compositionRoot$pollfish_googleplayRelease2;
        u3 k5;
        u1<Boolean> q4;
        Bundle extras;
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        if (getIntent().hasExtra("ui_visibility") && Build.VERSION.SDK_INT < 30 && (extras = getIntent().getExtras()) != null) {
            getWindow().getDecorView().setSystemUiVisibility(extras.getInt("ui_visibility"));
        }
        try {
            this.f36680a = t5.b(this);
            Pollfish instance$pollfish_googleplayRelease = Pollfish.Companion.getInstance$pollfish_googleplayRelease();
            if (instance$pollfish_googleplayRelease != null && (compositionRoot$pollfish_googleplayRelease2 = instance$pollfish_googleplayRelease.getCompositionRoot$pollfish_googleplayRelease()) != null && (k5 = compositionRoot$pollfish_googleplayRelease2.k()) != null && (q4 = k5.q()) != null) {
                q4.b(this);
            }
            k3 k3Var = this.f36680a;
            k3 k3Var2 = null;
            if (k3Var == null) {
                k3Var = null;
            }
            k3Var.setLifecycleCallback(this);
            k3 k3Var3 = this.f36680a;
            if (k3Var3 == null) {
                k3Var3 = null;
            }
            k3Var3.i();
            k3 k3Var4 = this.f36680a;
            if (k3Var4 == null) {
                k3Var4 = null;
            }
            if (k3Var4.getParent() != null) {
                k3 k3Var5 = this.f36680a;
                if (k3Var5 == null) {
                    k3Var5 = null;
                }
                ViewGroup viewGroup = (ViewGroup) k3Var5.getParent();
                k3 k3Var6 = this.f36680a;
                if (k3Var6 == null) {
                    k3Var6 = null;
                }
                viewGroup.removeView(k3Var6);
            }
            k3 k3Var7 = this.f36680a;
            if (k3Var7 == null) {
                k3Var7 = null;
            }
            addContentView(k3Var7, new RelativeLayout.LayoutParams(-1, -1));
            k3 k3Var8 = this.f36680a;
            if (k3Var8 != null) {
                k3Var2 = k3Var8;
            }
            k3Var2.post(new Runnable() { // from class: k1.a
                @Override // java.lang.Runnable
                public final void run() {
                    PollfishOverlayActivity.b(PollfishOverlayActivity.this);
                }
            });
        } catch (Exception e4) {
            Pollfish instance$pollfish_googleplayRelease2 = Pollfish.Companion.getInstance$pollfish_googleplayRelease();
            if (instance$pollfish_googleplayRelease2 != null && (compositionRoot$pollfish_googleplayRelease = instance$pollfish_googleplayRelease2.getCompositionRoot$pollfish_googleplayRelease()) != null && (k4 = compositionRoot$pollfish_googleplayRelease.k()) != null) {
                k4.a(new l4.a.d0(e4));
            }
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        y compositionRoot$pollfish_googleplayRelease;
        u3 k4;
        u1<Boolean> q4;
        Pollfish instance$pollfish_googleplayRelease = Pollfish.Companion.getInstance$pollfish_googleplayRelease();
        if (instance$pollfish_googleplayRelease != null && (compositionRoot$pollfish_googleplayRelease = instance$pollfish_googleplayRelease.getCompositionRoot$pollfish_googleplayRelease()) != null && (k4 = compositionRoot$pollfish_googleplayRelease.k()) != null && (q4 = k4.q()) != null) {
            q4.c(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.pollfish.internal.u1.a
    public final void a(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            bool2.booleanValue();
            k3 k3Var = this.f36680a;
            if (k3Var == null) {
                k3Var = null;
            }
            k3Var.a(true, false);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.pollfish.internal.k3.a
    public final void a() {
        finish();
    }
}
