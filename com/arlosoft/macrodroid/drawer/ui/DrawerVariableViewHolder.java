package com.arlosoft.macrodroid.drawer.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemVariable;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;

/* loaded from: classes3.dex */
public class DrawerVariableViewHolder extends DrawerItemViewHolder {
    @BindView(R.id.drag_handle)
    ImageView dragHandle;

    /* renamed from: e  reason: collision with root package name */
    private MacroDroidVariable f11545e;

    /* renamed from: f  reason: collision with root package name */
    private VariableValue f11546f;

    /* renamed from: g  reason: collision with root package name */
    private DictionaryKeys f11547g;

    /* renamed from: h  reason: collision with root package name */
    private DrawerItemVariable f11548h;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.var_name)
    TextView varName;
    @BindView(R.id.var_value)
    TextView varValue;

    public DrawerVariableViewHolder(@NonNull View view, DrawItemListener drawItemListener, int i4) {
        super(view, drawItemListener);
        ButterKnife.bind(this, view);
        float f4 = i4;
        this.varName.setTextSize(2, f4);
        this.varValue.setTextSize(2, f4);
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    protected ImageView[] e() {
        return new ImageView[]{this.icon};
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    @Nullable
    protected TextView[] f() {
        return new TextView[]{this.varName, this.varValue};
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        int i4;
        int i5;
        int i6;
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemVariable) {
            ImageView imageView = this.icon;
            int i7 = 8;
            if (drawerItem.hideIcon()) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            DrawerItemVariable drawerItemVariable = (DrawerItemVariable) drawerItem;
            MacroDroidVariable variableByName = MacroDroidVariableStore.getInstance().getVariableByName(drawerItemVariable.getVariableName());
            this.f11545e = variableByName;
            if (variableByName != null) {
                this.f11546f = variableByName.getVariableValue();
                DictionaryKeys dictionaryKeys = drawerItemVariable.getDictionaryKeys();
                this.f11547g = dictionaryKeys;
                if (dictionaryKeys != null) {
                    VariableValue.DictionaryEntry dictionaryEntryFromKeyList = this.f11545e.getDictionaryEntryFromKeyList(VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.f11547g.getKeys(), null, null));
                    if (dictionaryEntryFromKeyList != null) {
                        this.f11546f = dictionaryEntryFromKeyList.getVariable();
                    }
                }
            }
            this.f11548h = drawerItemVariable;
            setIcon(this.icon, drawerItem, R.drawable.ic_help_white_24dp);
            setColor(this.f11548h.getColor());
            this.varName.setText(drawerItem.getName());
            TextView textView = this.varName;
            if (this.f11548h.getHideName()) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            textView.setVisibility(i5);
            refresh();
            if (z3) {
                this.dragHandle.setVisibility(0);
                i(this.dragHandle);
            } else {
                this.dragHandle.setVisibility(8);
            }
            boolean isValid = drawerItem.isValid();
            TextView textView2 = this.varValue;
            if (isValid) {
                i7 = 0;
            }
            textView2.setVisibility(i7);
            TextView textView3 = this.varName;
            if (isValid) {
                i6 = MacroDroidApplication.getInstance().getResources().getDimensionPixelSize(R.dimen.max_var_name_width);
            } else {
                i6 = 9999;
            }
            textView3.setMaxWidth(i6);
            return;
        }
        throw new IllegalArgumentException("DrawerItemVariable required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.variable_container})
    public void onClicked() {
        if (this.f11548h.isValid()) {
            DrawerUpdateVariableActivity.displayDialog(this.itemView.getContext(), this.f11545e.getName(), this.f11547g);
            d();
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void refresh() {
        MacroDroidVariable macroDroidVariable = this.f11545e;
        if (macroDroidVariable != null) {
            this.f11546f = macroDroidVariable.getVariableValue();
            if (this.f11547g != null) {
                VariableValue.DictionaryEntry dictionaryEntryFromKeyList = this.f11545e.getDictionaryEntryFromKeyList(VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.f11547g.getKeys(), null, null));
                if (dictionaryEntryFromKeyList != null) {
                    this.f11546f = dictionaryEntryFromKeyList.getVariable();
                }
            }
            VariableValue variableValue = this.f11546f;
            if (variableValue != null) {
                String valueAsText = variableValue.getValueAsText();
                if (TextUtils.isEmpty(valueAsText)) {
                    TextView textView = this.varValue;
                    textView.setText("<" + this.itemView.getContext().getString(R.string.empty) + ">");
                    return;
                }
                this.varValue.setText(valueAsText);
            }
        }
    }
}
