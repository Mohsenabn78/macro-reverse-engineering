package com.arlosoft.macrodroid.settings;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public class EditCategoriesActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private EditCategoriesActivity f13413a;

    /* renamed from: b  reason: collision with root package name */
    private View f13414b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditCategoriesActivity f13415a;

        a(EditCategoriesActivity editCategoriesActivity) {
            this.f13415a = editCategoriesActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f13415a.onPlusButtonClicked();
        }
    }

    @UiThread
    public EditCategoriesActivity_ViewBinding(EditCategoriesActivity editCategoriesActivity) {
        this(editCategoriesActivity, editCategoriesActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditCategoriesActivity editCategoriesActivity = this.f13413a;
        if (editCategoriesActivity != null) {
            this.f13413a = null;
            editCategoriesActivity.infoCardView = null;
            editCategoriesActivity.infoCardTitle = null;
            editCategoriesActivity.infoCardDetail = null;
            editCategoriesActivity.infoCardGotIt = null;
            editCategoriesActivity.plusButton = null;
            this.f13414b.setOnClickListener(null);
            this.f13414b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public EditCategoriesActivity_ViewBinding(EditCategoriesActivity editCategoriesActivity, View view) {
        this.f13413a = editCategoriesActivity;
        editCategoriesActivity.infoCardView = (CardView) Utils.findRequiredViewAsType(view, R.id.infoCardView, "field 'infoCardView'", CardView.class);
        editCategoriesActivity.infoCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'infoCardTitle'", TextView.class);
        editCategoriesActivity.infoCardDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'infoCardDetail'", TextView.class);
        editCategoriesActivity.infoCardGotIt = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'infoCardGotIt'", Button.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.fab, "field 'plusButton' and method 'onPlusButtonClicked'");
        editCategoriesActivity.plusButton = (FloatingActionButton) Utils.castView(findRequiredView, R.id.fab, "field 'plusButton'", FloatingActionButton.class);
        this.f13414b = findRequiredView;
        findRequiredView.setOnClickListener(new a(editCategoriesActivity));
    }
}
