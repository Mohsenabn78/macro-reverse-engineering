package com.pollfish.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pollfish.internal.d2;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class d2 implements c2 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f36758a;

    /* renamed from: b  reason: collision with root package name */
    public AlertDialog f36759b;

    public d2(@NotNull Context context) {
        this.f36758a = new WeakReference<>(context);
    }

    public static final void b(d2 d2Var, Function0 function0, View view) {
        AlertDialog alertDialog = d2Var.f36759b;
        if (alertDialog == null) {
            alertDialog = null;
        }
        alertDialog.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.pollfish.internal.c2
    public final void a(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable final Function0<Unit> function0, @Nullable final Function0<Unit> function02) {
        Context context = this.f36758a.get();
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, 16974373);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackgroundColor(-1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setPadding(s5.a(linearLayout, 8), s5.a(linearLayout, 8), s5.a(linearLayout, 8), s5.a(linearLayout, 8));
            TextView textView = new TextView(context);
            textView.setTextSize(1, 15.0f);
            textView.setTextColor(-16777216);
            textView.setTypeface(textView.getTypeface(), 1);
            textView.setPadding(s5.a(textView, 14), s5.a(textView, 14), s5.a(textView, 14), s5.a(textView, 4));
            textView.setText(str);
            linearLayout.addView(textView);
            View view = new View(context);
            view.setBackgroundColor(Color.parseColor("#ffe6e9ee"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, s5.a(view, 1));
            layoutParams.setMargins(s5.a(view, 14), s5.a(view, 4), s5.a(view, 14), s5.a(view, 4));
            view.setLayoutParams(layoutParams);
            linearLayout.addView(view);
            TextView textView2 = new TextView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(s5.a(textView2, 8), s5.a(textView2, 14), s5.a(textView2, 8), s5.a(textView2, 14));
            textView2.setLayoutParams(layoutParams2);
            textView2.setText(str2);
            textView2.setTextSize(1, 15.0f);
            textView2.setPadding(s5.a(textView2, 14), s5.a(textView2, 8), s5.a(textView2, 14), s5.a(textView2, 4));
            textView2.setTextColor(-16777216);
            textView2.setGravity(1);
            linearLayout.addView(textView2);
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setWeightSum(2.0f);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.setMargins(s5.a(linearLayout2, 8), s5.a(linearLayout2, 16), s5.a(linearLayout2, 8), s5.a(linearLayout2, 16));
            linearLayout2.setLayoutParams(layoutParams3);
            linearLayout2.setOrientation(0);
            linearLayout2.setBackgroundColor(-1);
            TextView textView3 = new TextView(context);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
            layoutParams4.weight = 1.0f;
            layoutParams4.setMargins(s5.a(textView3, 8), s5.a(textView3, 0), s5.a(textView3, 0), s5.a(textView3, 16));
            textView3.setLayoutParams(layoutParams4);
            textView3.setPadding(s5.a(textView3, 0), s5.a(textView3, 8), s5.a(textView3, 0), s5.a(textView3, 8));
            textView3.setText(str4);
            textView3.setBackgroundColor(Color.parseColor("#ff246df0"));
            textView3.setTextColor(-1);
            textView3.setTextAlignment(4);
            textView3.setGravity(17);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: k1.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d2.b(d2.this, function02, view2);
                }
            });
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor("#ff246df0"));
            gradientDrawable.setCornerRadius(80.0f);
            gradientDrawable.setStroke(2, -1);
            textView3.setBackground(gradientDrawable);
            linearLayout2.addView(textView3);
            TextView textView4 = new TextView(context);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2);
            layoutParams5.weight = 1.0f;
            layoutParams5.setMargins(s5.a(textView4, 8), s5.a(textView4, 0), s5.a(textView4, 8), s5.a(textView4, 0));
            textView4.setLayoutParams(layoutParams5);
            textView4.setPadding(s5.a(textView4, 0), s5.a(textView4, 8), s5.a(textView4, 0), s5.a(textView4, 8));
            textView4.setText(str3);
            textView4.setBackgroundColor(Color.parseColor("#ff246df0"));
            textView4.setTextColor(-16777216);
            textView4.setTextAlignment(4);
            textView4.setGravity(17);
            textView4.setOnClickListener(new View.OnClickListener() { // from class: k1.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d2.a(d2.this, function0, view2);
                }
            });
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(-1);
            gradientDrawable2.setStroke(2, Color.parseColor("#ffe6e9ee"));
            gradientDrawable2.setCornerRadius(80.0f);
            textView4.setBackground(gradientDrawable2);
            linearLayout2.addView(textView4);
            linearLayout.addView(linearLayout2);
            builder.setView(linearLayout);
            AlertDialog create = builder.create();
            this.f36759b = create;
            if (create == null) {
                create = null;
            }
            create.show();
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void a(d2 d2Var, Function0 function0, View view) {
        AlertDialog alertDialog = d2Var.f36759b;
        if (alertDialog == null) {
            alertDialog = null;
        }
        alertDialog.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
    }
}
