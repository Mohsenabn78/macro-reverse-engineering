package agency.tango.materialintroscreen.listeners.clickListeners;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.animations.ViewTranslationWrapper;
import android.view.View;

/* loaded from: classes.dex */
public class PermissionNotGrantedClickListener implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final MaterialIntroActivity f123a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewTranslationWrapper f124b;

    public PermissionNotGrantedClickListener(MaterialIntroActivity materialIntroActivity, ViewTranslationWrapper viewTranslationWrapper) {
        this.f123a = materialIntroActivity;
        this.f124b = viewTranslationWrapper;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f124b.error();
        this.f123a.showPermissionsNotGrantedError();
    }
}
