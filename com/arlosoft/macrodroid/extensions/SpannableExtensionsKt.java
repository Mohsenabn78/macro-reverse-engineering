package com.arlosoft.macrodroid.extensions;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: SpannableExtensions.kt */
@SourceDebugExtension({"SMAP\nSpannableExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableExtensions.kt\ncom/arlosoft/macrodroid/extensions/SpannableExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
/* loaded from: classes3.dex */
public final class SpannableExtensionsKt {
    private static final SpannableString a(CharSequence charSequence, Object obj) {
        SpannableString spannableString;
        SpannableString spannableString2;
        if (charSequence instanceof String) {
            spannableString2 = new SpannableString(charSequence);
        } else {
            if (charSequence instanceof SpannableString) {
                spannableString = (SpannableString) charSequence;
            } else {
                spannableString = null;
            }
            spannableString2 = spannableString;
            if (spannableString2 == null) {
                spannableString2 = new SpannableString("");
            }
        }
        spannableString2.setSpan(obj, 0, spannableString2.length(), 33);
        return spannableString2;
    }

    @NotNull
    public static final SpannableString background(int i4, @NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new BackgroundColorSpan(i4));
    }

    @NotNull
    public static final SpannableString bold(@NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new StyleSpan(1));
    }

    @NotNull
    public static final SpannableString color(int i4, @NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new ForegroundColorSpan(i4));
    }

    @NotNull
    public static final SpannableString italic(@NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new StyleSpan(2));
    }

    @NotNull
    public static final SpannableString plus(@NotNull SpannableString spannableString, @NotNull SpannableString s3) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Intrinsics.checkNotNullParameter(s3, "s");
        return new SpannableString(TextUtils.concat(spannableString, s3));
    }

    @NotNull
    public static final SpannableString size(float f4, @NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new RelativeSizeSpan(f4));
    }

    @NotNull
    public static final SpannableString spannable(@NotNull Function0<? extends SpannableString> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        return func.invoke();
    }

    @NotNull
    public static final SpannableString strike(@NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new StrikethroughSpan());
    }

    @NotNull
    public static final SpannableString sub(@NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new SubscriptSpan());
    }

    @NotNull
    public static final SpannableString sup(@NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new SuperscriptSpan());
    }

    @NotNull
    public static final SpannableString underline(@NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new UnderlineSpan());
    }

    @NotNull
    public static final SpannableString url(@NotNull String url, @NotNull CharSequence s3) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(s3, "s");
        return a(s3, new URLSpan(url));
    }

    @NotNull
    public static final SpannableString plus(@NotNull SpannableString spannableString, @NotNull String s3) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Intrinsics.checkNotNullParameter(s3, "s");
        return new SpannableString(TextUtils.concat(spannableString, s3));
    }
}
