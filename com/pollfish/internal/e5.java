package com.pollfish.internal;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class e5 {
    @NotNull
    public static final Spanned a() {
        Spanned fromHtml;
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml("&#x21bb;", 0);
            return fromHtml;
        }
        return Html.fromHtml("&#x21bb;");
    }
}
