package com.pollfish.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class s5 {

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f37208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f37209b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f37210c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView, k kVar, Function0<Unit> function0) {
            super(0);
            this.f37208a = imageView;
            this.f37209b = kVar;
            this.f37210c = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            try {
                Uri parse = Uri.parse(this.f37208a.getContext().getCacheDir().toString() + "/pollfish" + this.f37209b.a());
                if (new File(parse.toString()).exists()) {
                    this.f37208a.setImageURI(parse);
                } else {
                    Function0<Unit> function0 = this.f37210c;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            } catch (Exception unused) {
                Function0<Unit> function02 = this.f37210c;
                if (function02 != null) {
                    function02.invoke();
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final int a(@NotNull View view, int i4) {
        int roundToInt;
        roundToInt = kotlin.math.c.roundToInt(TypedValue.applyDimension(1, i4, view.getContext().getResources().getDisplayMetrics()));
        return roundToInt;
    }

    public static final void a(@NotNull View view, @NotNull Function0<Unit> function0) {
        c0.a(view.getContext(), function0);
    }

    public static final boolean a(@Nullable ViewGroup viewGroup) {
        return (viewGroup != null ? viewGroup.getContext() : null) instanceof Activity;
    }

    public static final void a(@NotNull ImageView imageView, @Nullable k kVar, @Nullable Function0<Unit> function0) {
        if (kVar != null && kVar.b() == r.IMAGE && !Intrinsics.areEqual(kVar.a(), "")) {
            c0.a(imageView.getContext(), new a(imageView, kVar, function0));
            return;
        }
        function0.invoke();
    }

    public static final void a(@NotNull View view, @NotNull String str) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Context context = view.getContext();
        startsWith$default = kotlin.text.m.startsWith$default(str, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = kotlin.text.m.startsWith$default(str, "https://", false, 2, null);
            if (!startsWith$default2) {
                str = "http://" + str;
            }
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static final int a(@NotNull View view) {
        return view.getContext().getResources().getConfiguration().orientation;
    }
}
