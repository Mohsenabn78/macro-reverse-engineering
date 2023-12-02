package agency.tango.materialintroscreen.animations.wrappers;

import agency.tango.materialintroscreen.animations.ViewTranslationWrapper;
import agency.tango.materialintroscreen.animations.translations.DefaultPositionTranslation;
import agency.tango.materialintroscreen.animations.translations.ExitDefaultTranslation;
import android.view.View;

/* loaded from: classes.dex */
public class PageIndicatorTranslationWrapper extends ViewTranslationWrapper {
    public PageIndicatorTranslationWrapper(View view) {
        super(view);
        setDefaultTranslation(new DefaultPositionTranslation()).setExitTranslation(new ExitDefaultTranslation());
    }
}
