package agency.tango.materialintroscreen.listeners;

import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.R;
import agency.tango.materialintroscreen.SlideFragment;
import agency.tango.materialintroscreen.adapter.SlidesAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/* loaded from: classes.dex */
public class MessageButtonBehaviourOnPageSelected implements IPageSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    private Button f112a;

    /* renamed from: b  reason: collision with root package name */
    private SlidesAdapter f113b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArray<MessageButtonBehaviour> f114c;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlideFragment f115a;

        a(SlideFragment slideFragment) {
            this.f115a = slideFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f115a.askForPermissions();
        }
    }

    public MessageButtonBehaviourOnPageSelected(Button button, SlidesAdapter slidesAdapter, SparseArray<MessageButtonBehaviour> sparseArray) {
        this.f112a = button;
        this.f113b = slidesAdapter;
        this.f114c = sparseArray;
    }

    private boolean a(int i4) {
        if (this.f114c.get(i4) != null && SlideFragment.isNotNullOrEmpty(this.f114c.get(i4).getMessageButtonText())) {
            return true;
        }
        return false;
    }

    @Override // agency.tango.materialintroscreen.listeners.IPageSelectedListener
    public void pageSelected(int i4) {
        SlideFragment item = this.f113b.getItem(i4);
        if (item.hasAnyPermissionsToGrant()) {
            b(item);
            this.f112a.setText(item.getActivity().getString(R.string.grant_permissions));
            this.f112a.setOnClickListener(new a(item));
        } else if (a(i4)) {
            b(item);
            this.f112a.setText(this.f114c.get(i4).getMessageButtonText());
            this.f112a.setOnClickListener(this.f114c.get(i4).getClickListener());
        } else if (this.f112a.getVisibility() != 4) {
            this.f112a.startAnimation(AnimationUtils.loadAnimation(item.getContext(), R.anim.fade_out));
            this.f112a.setVisibility(4);
        }
    }

    private void b(SlideFragment slideFragment) {
    }
}
