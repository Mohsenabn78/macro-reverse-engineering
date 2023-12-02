package agency.tango.materialintroscreen;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

/* loaded from: classes.dex */
public class SlideFragmentBuilder {

    /* renamed from: a  reason: collision with root package name */
    int f98a;

    /* renamed from: b  reason: collision with root package name */
    int f99b;

    /* renamed from: c  reason: collision with root package name */
    String f100c;

    /* renamed from: d  reason: collision with root package name */
    String f101d;

    /* renamed from: e  reason: collision with root package name */
    String f102e;

    /* renamed from: f  reason: collision with root package name */
    String[] f103f;

    /* renamed from: g  reason: collision with root package name */
    String[] f104g;

    /* renamed from: h  reason: collision with root package name */
    int f105h;

    public SlideFragmentBuilder backgroundColor(@ColorRes int i4) {
        this.f98a = i4;
        return this;
    }

    public SlideFragment build() {
        return SlideFragment.createInstance(this);
    }

    public SlideFragmentBuilder buttonsColor(@ColorRes int i4) {
        this.f99b = i4;
        return this;
    }

    public SlideFragmentBuilder caption(String str) {
        this.f100c = str;
        return this;
    }

    public SlideFragmentBuilder description(String str) {
        this.f102e = str;
        return this;
    }

    public SlideFragmentBuilder image(@DrawableRes int i4) {
        this.f105h = i4;
        return this;
    }

    public SlideFragmentBuilder neededPermissions(String[] strArr) {
        this.f103f = strArr;
        return this;
    }

    public SlideFragmentBuilder possiblePermissions(String[] strArr) {
        this.f104g = strArr;
        return this;
    }

    public SlideFragmentBuilder title(String str) {
        this.f101d = str;
        return this;
    }
}
