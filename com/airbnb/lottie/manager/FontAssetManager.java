package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FontAssetManager {

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f1579d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private FontAssetDelegate f1580e;

    /* renamed from: a  reason: collision with root package name */
    private final MutablePair<String> f1576a = new MutablePair<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<MutablePair<String>, Typeface> f1577b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f1578c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f1581f = ".ttf";

    public FontAssetManager(Drawable.Callback callback, @Nullable FontAssetDelegate fontAssetDelegate) {
        this.f1580e = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.f1579d = null;
            return;
        }
        this.f1579d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(String str) {
        Typeface typeface;
        String fontPath;
        Typeface typeface2 = this.f1578c.get(str);
        if (typeface2 != null) {
            return typeface2;
        }
        FontAssetDelegate fontAssetDelegate = this.f1580e;
        if (fontAssetDelegate != null) {
            typeface = fontAssetDelegate.fetchFont(str);
        } else {
            typeface = null;
        }
        FontAssetDelegate fontAssetDelegate2 = this.f1580e;
        if (fontAssetDelegate2 != null && typeface == null && (fontPath = fontAssetDelegate2.getFontPath(str)) != null) {
            typeface = Typeface.createFromAsset(this.f1579d, fontPath);
        }
        if (typeface == null) {
            typeface = Typeface.createFromAsset(this.f1579d, "fonts/" + str + this.f1581f);
        }
        this.f1578c.put(str, typeface);
        return typeface;
    }

    private Typeface b(Typeface typeface, String str) {
        int i4;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i4 = 3;
        } else if (contains) {
            i4 = 2;
        } else if (contains2) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (typeface.getStyle() == i4) {
            return typeface;
        }
        return Typeface.create(typeface, i4);
    }

    public Typeface getTypeface(String str, String str2) {
        this.f1576a.set(str, str2);
        Typeface typeface = this.f1577b.get(this.f1576a);
        if (typeface != null) {
            return typeface;
        }
        Typeface b4 = b(a(str), str2);
        this.f1577b.put(this.f1576a, b4);
        return b4;
    }

    public void setDefaultFontFileExtension(String str) {
        this.f1581f = str;
    }

    public void setDelegate(@Nullable FontAssetDelegate fontAssetDelegate) {
        this.f1580e = fontAssetDelegate;
    }
}
