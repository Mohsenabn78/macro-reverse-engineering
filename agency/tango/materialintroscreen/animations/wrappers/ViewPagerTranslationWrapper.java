package agency.tango.materialintroscreen.animations.wrappers;

import agency.tango.materialintroscreen.animations.ViewTranslationWrapper;
import agency.tango.materialintroscreen.animations.translations.AlphaTranslation;
import agency.tango.materialintroscreen.animations.translations.DefaultAlphaTranslation;
import android.view.View;

/* loaded from: classes.dex */
public class ViewPagerTranslationWrapper extends ViewTranslationWrapper {
    public ViewPagerTranslationWrapper(View view) {
        super(view);
        setDefaultTranslation(new DefaultAlphaTranslation()).setExitTranslation(new AlphaTranslation());
    }
}
