package com.pollfish.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class q2 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n2 f37162a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q2(n2 n2Var) {
        super(0);
        this.f37162a = n2Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
        if (r4.b() == com.pollfish.builder.Position.MIDDLE_LEFT) goto L19;
     */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Unit invoke() {
        /*
            r6 = this;
            com.pollfish.internal.n2 r0 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            android.view.ViewParent r0 = r0.getParent()     // Catch: java.lang.Exception -> L8a
            if (r0 == 0) goto L15
            com.pollfish.internal.n2 r0 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            android.view.ViewParent r0 = r0.getParent()     // Catch: java.lang.Exception -> L8a
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.n2 r1 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            r0.removeView(r1)     // Catch: java.lang.Exception -> L8a
        L15:
            com.pollfish.internal.n2 r0 = r6.f37162a     // Catch: java.lang.Exception -> L23
            android.widget.ImageView r0 = com.pollfish.internal.n2.c(r0)     // Catch: java.lang.Exception -> L23
            if (r0 == 0) goto L34
            com.pollfish.internal.n2 r1 = r6.f37162a     // Catch: java.lang.Exception -> L23
            r1.removeView(r0)     // Catch: java.lang.Exception -> L23
            goto L34
        L23:
            r0 = move-exception
            com.pollfish.internal.n2 r1 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.u3 r1 = com.pollfish.internal.n2.d(r1)     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.f4$a r2 = com.pollfish.internal.f4.a.WARNING     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.l4$a$y r3 = new com.pollfish.internal.l4$a$y     // Catch: java.lang.Exception -> L8a
            r3.<init>(r0)     // Catch: java.lang.Exception -> L8a
            r1.a(r2, r3)     // Catch: java.lang.Exception -> L8a
        L34:
            com.pollfish.internal.n2 r0 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.n2.a(r0)     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.n2 r0 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Exception -> L8a
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.n2 r1 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams     // Catch: java.lang.Exception -> L8a
            r3 = -1
            r2.<init>(r3, r3)     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.n2 r3 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.m1 r4 = com.pollfish.internal.n2.b(r3)     // Catch: java.lang.Exception -> L8a
            com.pollfish.builder.Position r4 = r4.b()     // Catch: java.lang.Exception -> L8a
            com.pollfish.builder.Position r5 = com.pollfish.builder.Position.MIDDLE_RIGHT     // Catch: java.lang.Exception -> L8a
            if (r4 == r5) goto L63
            com.pollfish.internal.m1 r4 = com.pollfish.internal.n2.b(r3)     // Catch: java.lang.Exception -> L8a
            com.pollfish.builder.Position r4 = r4.b()     // Catch: java.lang.Exception -> L8a
            com.pollfish.builder.Position r5 = com.pollfish.builder.Position.MIDDLE_LEFT     // Catch: java.lang.Exception -> L8a
            if (r4 != r5) goto L75
        L63:
            com.pollfish.internal.m1 r4 = com.pollfish.internal.n2.b(r3)     // Catch: java.lang.Exception -> L8a
            int r4 = r4.a()     // Catch: java.lang.Exception -> L8a
            int r4 = r4 * 2
            int r3 = com.pollfish.internal.s5.a(r3, r4)     // Catch: java.lang.Exception -> L8a
            r4 = 0
            r2.setMargins(r4, r3, r4, r4)     // Catch: java.lang.Exception -> L8a
        L75:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L8a
            r0.addContentView(r1, r2)     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.n2 r0 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            r0.requestFocus()     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.n2 r0 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            r0.requestLayout()     // Catch: java.lang.Exception -> L8a
            com.pollfish.internal.n2 r0 = r6.f37162a     // Catch: java.lang.Exception -> L8a
            r0.bringToFront()     // Catch: java.lang.Exception -> L8a
            goto L99
        L8a:
            r0 = move-exception
            com.pollfish.internal.n2 r1 = r6.f37162a
            com.pollfish.internal.u3 r1 = com.pollfish.internal.n2.d(r1)
            com.pollfish.internal.l4$a$d0 r2 = new com.pollfish.internal.l4$a$d0
            r2.<init>(r0)
            r1.a(r2)
        L99:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.q2.invoke():java.lang.Object");
    }
}
