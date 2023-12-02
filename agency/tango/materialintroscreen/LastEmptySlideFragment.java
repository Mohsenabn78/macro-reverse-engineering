package agency.tango.materialintroscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class LastEmptySlideFragment extends SlideFragment {
    @Override // agency.tango.materialintroscreen.SlideFragment
    public int backgroundColor() {
        return R.color.transparent;
    }

    @Override // agency.tango.materialintroscreen.SlideFragment
    public int buttonsColor() {
        return R.color.transparent;
    }

    @Override // agency.tango.materialintroscreen.SlideFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.empty_fragment_slide, viewGroup, false);
    }
}
