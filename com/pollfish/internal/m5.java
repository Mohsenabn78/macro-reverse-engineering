package com.pollfish.internal;

import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: P
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* loaded from: classes6.dex */
public final class m5 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f37084b = new a();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public static m5 f37085c;

    /* renamed from: d  reason: collision with root package name */
    public static n5 f37086d;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final n5 f37087a;

    /* loaded from: classes6.dex */
    public static final class a {
        public static void a(@NotNull o5 o5Var) {
            m5.f37086d = o5Var;
        }

        @NotNull
        public static m5 a() {
            m5 m5Var = m5.f37085c;
            if (m5Var == null) {
                n5 n5Var = m5.f37086d;
                if (n5Var == null) {
                    n5Var = null;
                }
                m5.f37085c = new m5(n5Var, 0);
                return m5.f37085c;
            }
            return m5Var;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes6.dex */
    public static final class b<R> extends Lambda implements Function0<l4<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s<P, R> f37088a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ P f37089b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(s<? super P, R> sVar, P p4) {
            super(0);
            this.f37088a = sVar;
            this.f37089b = p4;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f37088a.a(this.f37089b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* loaded from: classes6.dex */
    public static final class c<R> extends Lambda implements Function1<l4<? extends R>, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m5 f37090a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Function1<l4<? extends R>, Unit> f37091b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(m5 m5Var, Function1<? super l4<? extends R>, Unit> function1) {
            super(1);
            this.f37090a = m5Var;
            this.f37091b = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Object obj) {
            m5.a(this.f37090a, (l4) obj, this.f37091b);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public /* synthetic */ m5(n5 n5Var, int i4) {
        this(n5Var);
    }

    public m5(n5 n5Var) {
        this.f37087a = n5Var;
    }

    public final <P, R> void a(@NotNull s<? super P, R> sVar, P p4, @NotNull Function1<? super l4<? extends R>, Unit> function1) {
        this.f37087a.a(new f1(new b(sVar, p4), new c(this, function1)));
    }

    @NotNull
    public final <R> l4<Unit> a(@NotNull List<? extends Callable<l4<R>>> list) {
        return this.f37087a.a(list);
    }

    public static final void a(m5 m5Var, l4 l4Var, Function1 function1) {
        m5Var.f37087a.a(function1, l4Var);
    }
}
