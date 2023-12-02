package agency.tango.materialintroscreen.animations.translations;

import agency.tango.materialintroscreen.R;
import agency.tango.materialintroscreen.animations.IViewTranslation;
import android.view.View;
import androidx.annotation.FloatRange;

/* loaded from: classes.dex */
public class EnterDefaultTranslation implements IViewTranslation {
    @Override // agency.tango.materialintroscreen.animations.IViewTranslation
    public void translate(View view, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        view.setTranslationY((1.0f - f4) * view.getResources().getDimensionPixelOffset(R.dimen.y_offset));
    }
}
