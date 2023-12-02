package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class Layer {

    /* renamed from: a  reason: collision with root package name */
    private final List<ContentModel> f1751a;

    /* renamed from: b  reason: collision with root package name */
    private final LottieComposition f1752b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1753c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1754d;

    /* renamed from: e  reason: collision with root package name */
    private final LayerType f1755e;

    /* renamed from: f  reason: collision with root package name */
    private final long f1756f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f1757g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Mask> f1758h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableTransform f1759i;

    /* renamed from: j  reason: collision with root package name */
    private final int f1760j;

    /* renamed from: k  reason: collision with root package name */
    private final int f1761k;

    /* renamed from: l  reason: collision with root package name */
    private final int f1762l;

    /* renamed from: m  reason: collision with root package name */
    private final float f1763m;

    /* renamed from: n  reason: collision with root package name */
    private final float f1764n;

    /* renamed from: o  reason: collision with root package name */
    private final int f1765o;

    /* renamed from: p  reason: collision with root package name */
    private final int f1766p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private final AnimatableTextFrame f1767q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private final AnimatableTextProperties f1768r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private final AnimatableFloatValue f1769s;

    /* renamed from: t  reason: collision with root package name */
    private final List<Keyframe<Float>> f1770t;

    /* renamed from: u  reason: collision with root package name */
    private final MatteType f1771u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f1772v;

    /* loaded from: classes2.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes2.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j4, LayerType layerType, long j5, @Nullable String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i4, int i5, int i6, float f4, float f5, int i7, int i8, @Nullable AnimatableTextFrame animatableTextFrame, @Nullable AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, @Nullable AnimatableFloatValue animatableFloatValue, boolean z3) {
        this.f1751a = list;
        this.f1752b = lottieComposition;
        this.f1753c = str;
        this.f1754d = j4;
        this.f1755e = layerType;
        this.f1756f = j5;
        this.f1757g = str2;
        this.f1758h = list2;
        this.f1759i = animatableTransform;
        this.f1760j = i4;
        this.f1761k = i5;
        this.f1762l = i6;
        this.f1763m = f4;
        this.f1764n = f5;
        this.f1765o = i7;
        this.f1766p = i8;
        this.f1767q = animatableTextFrame;
        this.f1768r = animatableTextProperties;
        this.f1770t = list3;
        this.f1771u = matteType;
        this.f1769s = animatableFloatValue;
        this.f1772v = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieComposition a() {
        return this.f1752b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Keyframe<Float>> b() {
        return this.f1770t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> c() {
        return this.f1758h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType d() {
        return this.f1771u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.f1753c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long f() {
        return this.f1756f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1766p;
    }

    public long getId() {
        return this.f1754d;
    }

    public LayerType getLayerType() {
        return this.f1755e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f1765o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String i() {
        return this.f1757g;
    }

    public boolean isHidden() {
        return this.f1772v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ContentModel> j() {
        return this.f1751a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f1762l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f1761k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f1760j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        return this.f1764n / this.f1752b.getDurationFrames();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AnimatableTextFrame o() {
        return this.f1767q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AnimatableTextProperties p() {
        return this.f1768r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AnimatableFloatValue q() {
        return this.f1769s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float r() {
        return this.f1763m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatableTransform s() {
        return this.f1759i;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(e());
        sb.append("\n");
        Layer layerModelForId = this.f1752b.layerModelForId(f());
        if (layerModelForId != null) {
            sb.append("\t\tParents: ");
            sb.append(layerModelForId.e());
            Layer layerModelForId2 = this.f1752b.layerModelForId(layerModelForId.f());
            while (layerModelForId2 != null) {
                sb.append("->");
                sb.append(layerModelForId2.e());
                layerModelForId2 = this.f1752b.layerModelForId(layerModelForId2.f());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!c().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(c().size());
            sb.append("\n");
        }
        if (m() != 0 && l() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(m()), Integer.valueOf(l()), Integer.valueOf(k())));
        }
        if (!this.f1751a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel contentModel : this.f1751a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(contentModel);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
