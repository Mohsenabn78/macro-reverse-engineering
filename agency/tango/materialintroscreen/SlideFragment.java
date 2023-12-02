package agency.tango.materialintroscreen;

import agency.tango.materialintroscreen.parallax.ParallaxFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class SlideFragment extends ParallaxFragment {

    /* renamed from: c  reason: collision with root package name */
    private int f86c;

    /* renamed from: d  reason: collision with root package name */
    private int f87d;

    /* renamed from: e  reason: collision with root package name */
    private int f88e;

    /* renamed from: f  reason: collision with root package name */
    private String f89f;

    /* renamed from: g  reason: collision with root package name */
    private String f90g;

    /* renamed from: h  reason: collision with root package name */
    private String f91h;

    /* renamed from: i  reason: collision with root package name */
    private String[] f92i;

    /* renamed from: j  reason: collision with root package name */
    private String[] f93j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f94k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f95l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f96m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f97n;

    private boolean b(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (isNotNullOrEmpty(str) && ContextCompat.checkSelfPermission(getContext(), str) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private String[] c(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList2.removeAll(Collections.singleton(null));
        return (String[]) arrayList2.toArray(new String[0]);
    }

    public static SlideFragment createInstance(SlideFragmentBuilder slideFragmentBuilder) {
        SlideFragment slideFragment = new SlideFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("background_color", slideFragmentBuilder.f98a);
        bundle.putInt("buttons_color", slideFragmentBuilder.f99b);
        bundle.putInt("image", slideFragmentBuilder.f105h);
        bundle.putString("caption", slideFragmentBuilder.f100c);
        bundle.putString("title", slideFragmentBuilder.f101d);
        bundle.putString("description", slideFragmentBuilder.f102e);
        bundle.putStringArray("needed_permission", slideFragmentBuilder.f103f);
        bundle.putStringArray("possible_permission", slideFragmentBuilder.f104g);
        slideFragment.setArguments(bundle);
        return slideFragment;
    }

    private void d() {
        this.f96m.setText(this.f89f);
        this.f94k.setText(this.f90g);
        this.f95l.setText(this.f91h);
        if (this.f88e != 0) {
            this.f97n.setImageDrawable(ContextCompat.getDrawable(getActivity(), this.f88e));
            this.f97n.setVisibility(0);
        }
    }

    public static boolean isNotNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    public void askForPermissions() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = this.f92i;
        if (strArr != null) {
            for (String str : strArr) {
                if (isNotNullOrEmpty(str) && ContextCompat.checkSelfPermission(getContext(), str) != 0) {
                    arrayList.add(str);
                }
            }
        }
        String[] strArr2 = this.f93j;
        if (strArr2 != null) {
            for (String str2 : strArr2) {
                if (isNotNullOrEmpty(str2) && ContextCompat.checkSelfPermission(getContext(), str2) != 0) {
                    arrayList.add(str2);
                }
            }
        }
        ActivityCompat.requestPermissions(getActivity(), c(arrayList), 15621);
    }

    public int backgroundColor() {
        return this.f86c;
    }

    public int buttonsColor() {
        return this.f87d;
    }

    public boolean canMoveFurther() {
        return true;
    }

    public String cantMoveFurtherErrorMessage() {
        return getString(R.string.impassable_slide);
    }

    public int dotsOffColor() {
        return buttonsColor();
    }

    public boolean hasAnyPermissionsToGrant() {
        boolean b4 = b(this.f92i);
        if (!b4) {
            return b(this.f93j);
        }
        return b4;
    }

    public boolean hasNeededPermissionsToGrant() {
        return b(this.f92i);
    }

    public void initializeView() {
        Bundle arguments = getArguments();
        this.f86c = arguments.getInt("background_color");
        this.f87d = arguments.getInt("buttons_color");
        this.f88e = arguments.getInt("image", 0);
        this.f89f = arguments.getString("caption");
        this.f90g = arguments.getString("title");
        this.f91h = arguments.getString("description");
        this.f92i = arguments.getStringArray("needed_permission");
        this.f93j = arguments.getStringArray("possible_permission");
        d();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        View inflate = layoutInflater.inflate(R.layout.fragment_slide, viewGroup, false);
        this.f94k = (TextView) inflate.findViewById(R.id.txt_title_slide);
        this.f95l = (TextView) inflate.findViewById(R.id.txt_description_slide);
        this.f97n = (ImageView) inflate.findViewById(R.id.image_slide);
        this.f96m = (TextView) inflate.findViewById(R.id.txt_image_caption);
        initializeView();
        return inflate;
    }
}
