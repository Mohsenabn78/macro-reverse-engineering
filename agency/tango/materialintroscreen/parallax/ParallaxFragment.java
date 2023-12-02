package agency.tango.materialintroscreen.parallax;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class ParallaxFragment extends Fragment implements Parallaxable {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Parallaxable f126b;

    public Parallaxable findParallaxLayout(View view) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        while (!linkedList.isEmpty()) {
            View view2 = (View) linkedList.remove();
            if (view2 instanceof Parallaxable) {
                return (Parallaxable) view2;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    linkedList.add(viewGroup.getChildAt(childCount));
                }
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        this.f126b = findParallaxLayout(view);
    }

    @Override // agency.tango.materialintroscreen.parallax.Parallaxable
    public void setOffset(@FloatRange(from = -1.0d, to = 1.0d) float f4) {
        Parallaxable parallaxable = this.f126b;
        if (parallaxable != null) {
            parallaxable.setOffset(f4);
        }
    }
}
