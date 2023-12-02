package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class FontCharacter {

    /* renamed from: a  reason: collision with root package name */
    private final List<ShapeGroup> f1595a;

    /* renamed from: b  reason: collision with root package name */
    private final char f1596b;

    /* renamed from: c  reason: collision with root package name */
    private final double f1597c;

    /* renamed from: d  reason: collision with root package name */
    private final double f1598d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1599e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1600f;

    public FontCharacter(List<ShapeGroup> list, char c4, double d4, double d5, String str, String str2) {
        this.f1595a = list;
        this.f1596b = c4;
        this.f1597c = d4;
        this.f1598d = d5;
        this.f1599e = str;
        this.f1600f = str2;
    }

    public static int hashFor(char c4, String str, String str2) {
        return ((((0 + c4) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<ShapeGroup> getShapes() {
        return this.f1595a;
    }

    public double getWidth() {
        return this.f1598d;
    }

    public int hashCode() {
        return hashFor(this.f1596b, this.f1600f, this.f1599e);
    }
}
