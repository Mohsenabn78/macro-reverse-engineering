package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TextDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f1386a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final LottieAnimationView f1387b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f1388c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1389d;

    @VisibleForTesting
    TextDelegate() {
        this.f1386a = new HashMap();
        this.f1389d = true;
        this.f1387b = null;
        this.f1388c = null;
    }

    private void b() {
        LottieAnimationView lottieAnimationView = this.f1387b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        LottieDrawable lottieDrawable = this.f1388c;
        if (lottieDrawable != null) {
            lottieDrawable.invalidateSelf();
        }
    }

    public final String getTextInternal(String str) {
        if (this.f1389d && this.f1386a.containsKey(str)) {
            return this.f1386a.get(str);
        }
        String a4 = a(str);
        if (this.f1389d) {
            this.f1386a.put(str, a4);
        }
        return a4;
    }

    public void invalidateAllText() {
        this.f1386a.clear();
        b();
    }

    public void invalidateText(String str) {
        this.f1386a.remove(str);
        b();
    }

    public void setCacheText(boolean z3) {
        this.f1389d = z3;
    }

    public void setText(String str, String str2) {
        this.f1386a.put(str, str2);
        b();
    }

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        this.f1386a = new HashMap();
        this.f1389d = true;
        this.f1387b = lottieAnimationView;
        this.f1388c = null;
    }

    public TextDelegate(LottieDrawable lottieDrawable) {
        this.f1386a = new HashMap();
        this.f1389d = true;
        this.f1388c = lottieDrawable;
        this.f1387b = null;
    }

    private String a(String str) {
        return str;
    }
}
