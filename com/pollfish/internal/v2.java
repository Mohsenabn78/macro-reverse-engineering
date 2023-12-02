package com.pollfish.internal;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class v2 extends View implements u2 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u3 f37273a;

    public v2(@NotNull Context context, @NotNull u3 u3Var) {
        super(context);
        this.f37273a = u3Var;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        c();
    }

    @Override // com.pollfish.internal.u2
    public final void a() {
        setVisibility(0);
    }

    @Override // com.pollfish.internal.u2
    public final void b() {
        setVisibility(8);
    }

    public final void c() {
        Unit unit;
        g2 d4 = this.f37273a.d();
        if (d4 != null) {
            try {
                setBackgroundColor(Color.parseColor(d4.p()));
            } catch (IllegalArgumentException unused) {
                setBackgroundColor(-1);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            setBackgroundColor(-1);
        }
    }
}
