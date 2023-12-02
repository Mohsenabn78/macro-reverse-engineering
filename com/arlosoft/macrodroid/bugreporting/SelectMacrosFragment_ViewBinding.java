package com.arlosoft.macrodroid.bugreporting;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.SearchView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class SelectMacrosFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SelectMacrosFragment f9576a;

    /* renamed from: b  reason: collision with root package name */
    private View f9577b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SelectMacrosFragment f9578a;

        a(SelectMacrosFragment selectMacrosFragment) {
            this.f9578a = selectMacrosFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f9578a.onFabClicked();
        }
    }

    @UiThread
    public SelectMacrosFragment_ViewBinding(SelectMacrosFragment selectMacrosFragment, View view) {
        this.f9576a = selectMacrosFragment;
        selectMacrosFragment.macroListView = (ListView) Utils.findRequiredViewAsType(view, R.id.macro_list, "field 'macroListView'", ListView.class);
        selectMacrosFragment.searchView = (SearchView) Utils.findRequiredViewAsType(view, R.id.searchView, "field 'searchView'", SearchView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.continueButton, "method 'onFabClicked'");
        this.f9577b = findRequiredView;
        findRequiredView.setOnClickListener(new a(selectMacrosFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SelectMacrosFragment selectMacrosFragment = this.f9576a;
        if (selectMacrosFragment != null) {
            this.f9576a = null;
            selectMacrosFragment.macroListView = null;
            selectMacrosFragment.searchView = null;
            this.f9577b.setOnClickListener(null);
            this.f9577b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
