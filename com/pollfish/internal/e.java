package com.pollfish.internal;

import com.pollfish.internal.l4;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class e implements d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final com.pollfish.internal.a f36776a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f36777b;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function1<Pair<? extends String, ? extends h0>, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f36778a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Pair<? extends String, ? extends h0> pair) {
            return pair.getFirst();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function1<Pair<? extends String, ? extends h0>, h0> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f36779a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final h0 invoke(Pair<? extends String, ? extends h0> pair) {
            return pair.getSecond();
        }
    }

    public e(@NotNull com.pollfish.internal.a aVar, @Nullable String str) {
        boolean isBlank;
        CharSequence trim;
        this.f36776a = aVar;
        if (str != null) {
            isBlank = kotlin.text.m.isBlank(str);
            if (!isBlank) {
                trim = StringsKt__StringsKt.trim(str);
                this.f36777b = trim.toString();
                return;
            }
        }
        this.f36777b = null;
    }

    @Override // com.pollfish.internal.d
    public final void a(@Nullable String str) {
        boolean isBlank;
        CharSequence trim;
        if (str != null) {
            isBlank = kotlin.text.m.isBlank(str);
            if (!isBlank) {
                trim = StringsKt__StringsKt.trim(str);
                this.f36777b = trim.toString();
                return;
            }
        }
        if (str == null) {
            this.f36777b = null;
        }
    }

    @Override // com.pollfish.internal.d
    @NotNull
    public final l4<h0> b() {
        if (this.f36777b != null) {
            return new l4.b(h0.USER_ID);
        }
        return n4.a(b.f36779a, this.f36776a.b());
    }

    @Override // com.pollfish.internal.d
    @NotNull
    public final l4<String> c() {
        String str = this.f36777b;
        if (str != null) {
            return new l4.b(str);
        }
        return n4.a(a.f36778a, this.f36776a.b());
    }

    @Override // com.pollfish.internal.d
    @NotNull
    public final l4<Boolean> a() {
        return this.f36776a.a();
    }
}
