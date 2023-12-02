package com.arlosoft.macrodroid.variables;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class MacroDroidVariablesActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MacroDroidVariablesActivity f16181a;

    /* renamed from: b  reason: collision with root package name */
    private View f16182b;

    /* renamed from: c  reason: collision with root package name */
    private View f16183c;

    /* loaded from: classes3.dex */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariablesActivity f16184a;

        a(MacroDroidVariablesActivity macroDroidVariablesActivity) {
            this.f16184a = macroDroidVariablesActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            this.f16184a.onLocalVariableCheckboxChanged(z3);
        }
    }

    /* loaded from: classes3.dex */
    class b extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariablesActivity f16186a;

        b(MacroDroidVariablesActivity macroDroidVariablesActivity) {
            this.f16186a = macroDroidVariablesActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f16186a.onPlusButtonClicked();
        }
    }

    @UiThread
    public MacroDroidVariablesActivity_ViewBinding(MacroDroidVariablesActivity macroDroidVariablesActivity) {
        this(macroDroidVariablesActivity, macroDroidVariablesActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MacroDroidVariablesActivity macroDroidVariablesActivity = this.f16181a;
        if (macroDroidVariablesActivity != null) {
            this.f16181a = null;
            macroDroidVariablesActivity.localVariableOptionLayout = null;
            macroDroidVariablesActivity.localVariableCheckbox = null;
            macroDroidVariablesActivity.m_list = null;
            macroDroidVariablesActivity.toolbar = null;
            macroDroidVariablesActivity.filterPanel = null;
            macroDroidVariablesActivity.rootContainer = null;
            macroDroidVariablesActivity.variableTypeSpinner = null;
            ((CompoundButton) this.f16182b).setOnCheckedChangeListener(null);
            this.f16182b = null;
            this.f16183c.setOnClickListener(null);
            this.f16183c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public MacroDroidVariablesActivity_ViewBinding(MacroDroidVariablesActivity macroDroidVariablesActivity, View view) {
        this.f16181a = macroDroidVariablesActivity;
        macroDroidVariablesActivity.localVariableOptionLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.local_variable_option_layout, "field 'localVariableOptionLayout'", ViewGroup.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.local_variable_checkbox, "field 'localVariableCheckbox' and method 'onLocalVariableCheckboxChanged'");
        macroDroidVariablesActivity.localVariableCheckbox = (CheckBox) Utils.castView(findRequiredView, R.id.local_variable_checkbox, "field 'localVariableCheckbox'", CheckBox.class);
        this.f16182b = findRequiredView;
        ((CompoundButton) findRequiredView).setOnCheckedChangeListener(new a(macroDroidVariablesActivity));
        macroDroidVariablesActivity.m_list = (ListView) Utils.findRequiredViewAsType(view, R.id.variables_activity_list, "field 'm_list'", ListView.class);
        macroDroidVariablesActivity.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        macroDroidVariablesActivity.filterPanel = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.filterPanel, "field 'filterPanel'", ViewGroup.class);
        macroDroidVariablesActivity.rootContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rootContainer, "field 'rootContainer'", LinearLayout.class);
        macroDroidVariablesActivity.variableTypeSpinner = (Spinner) Utils.findRequiredViewAsType(view, R.id.variableTypeSpinner, "field 'variableTypeSpinner'", Spinner.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.fab, "method 'onPlusButtonClicked'");
        this.f16183c = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(macroDroidVariablesActivity));
    }
}
