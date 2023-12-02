package agency.tango.materialintroscreen.animations;

import agency.tango.materialintroscreen.animations.translations.NoTranslation;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.AnimRes;

/* loaded from: classes.dex */
public class ViewTranslationWrapper {

    /* renamed from: a  reason: collision with root package name */
    private View f107a;

    /* renamed from: b  reason: collision with root package name */
    private IViewTranslation f108b = new NoTranslation();

    /* renamed from: c  reason: collision with root package name */
    private IViewTranslation f109c = new NoTranslation();

    /* renamed from: d  reason: collision with root package name */
    private IViewTranslation f110d;

    /* renamed from: e  reason: collision with root package name */
    private Animation f111e;

    public ViewTranslationWrapper(View view) {
        this.f107a = view;
        setErrorAnimation(0);
    }

    public void defaultTranslate(float f4) {
        this.f110d.translate(this.f107a, f4);
    }

    public void enterTranslate(float f4) {
        this.f108b.translate(this.f107a, f4);
    }

    public void error() {
        Animation animation = this.f111e;
        if (animation != null) {
            this.f107a.startAnimation(animation);
        }
    }

    public void exitTranslate(float f4) {
        this.f109c.translate(this.f107a, f4);
    }

    public ViewTranslationWrapper setDefaultTranslation(IViewTranslation iViewTranslation) {
        this.f110d = iViewTranslation;
        return this;
    }

    public ViewTranslationWrapper setEnterTranslation(IViewTranslation iViewTranslation) {
        this.f108b = iViewTranslation;
        return this;
    }

    public ViewTranslationWrapper setErrorAnimation(@AnimRes int i4) {
        if (i4 != 0) {
            this.f111e = AnimationUtils.loadAnimation(this.f107a.getContext(), i4);
        }
        return this;
    }

    public ViewTranslationWrapper setExitTranslation(IViewTranslation iViewTranslation) {
        this.f109c = iViewTranslation;
        return this;
    }
}
