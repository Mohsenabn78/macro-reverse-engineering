package com.arlosoft.macrodroid.wizard;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroUpdateEvent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.utils.ColorUtils;
import com.arlosoft.macrodroid.wizard.AddedItemViewHolder;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AddedItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private Activity f16502a;
    @BindView(R.id.constraint_and_or_frame)
    FrameLayout andOrLayout;

    /* renamed from: b  reason: collision with root package name */
    private Macro f16503b;

    /* renamed from: c  reason: collision with root package name */
    private int f16504c;
    @BindView(R.id.infoCardView)
    CardView cardView;
    @BindView(R.id.constraint_logic_spinner)
    Spinner constraintSpinner;
    @BindView(R.id.empty_text)
    TextView emptyText;
    @BindView(R.id.items_list)
    LinearLayout listLayout;

    public AddedItemViewHolder(Activity activity, View view, Macro macro, int i4) {
        super(view);
        ButterKnife.bind(this, view);
        this.f16502a = activity;
        this.f16503b = macro;
        this.f16504c = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(SelectableItem selectableItem, int i4, List list, View view) {
        f(selectableItem, i4, list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String[] strArr, SelectableItem selectableItem, int i4, DialogInterface dialogInterface, int i5) {
        String str = strArr[i5];
        if (str.equals(this.f16502a.getString(R.string.configure))) {
            selectableItem.setMacro(this.f16503b);
            selectableItem.setActivity(this.f16502a);
            selectableItem.onItemSelected();
        } else if (str.equals(this.f16502a.getString(R.string.delete))) {
            ((WizardActivity) this.f16502a).showDeleteUndo(this.f16503b.removeItem(selectableItem));
            EventBusUtils.getEventBus().post(new MacroUpdateEvent(1, selectableItem.getInfo().getItemType(), i4, -1));
        } else if (str.equals(this.f16502a.getString(R.string.move_up))) {
            selectableItem.moveItem(true);
            EventBusUtils.getEventBus().post(new MacroUpdateEvent(2, selectableItem.getInfo().getItemType(), i4, i4 - 1));
        } else if (str.equals(this.f16502a.getString(R.string.move_down))) {
            selectableItem.moveItem(false);
            EventBusUtils.getEventBus().post(new MacroUpdateEvent(2, selectableItem.getInfo().getItemType(), i4, i4 + 1));
        }
    }

    private void f(final SelectableItem selectableItem, final int i4, int i5) {
        ArrayList arrayList = new ArrayList();
        if (selectableItem.hasOptions()) {
            arrayList.add(this.f16502a.getString(R.string.configure));
        }
        arrayList.add(this.f16502a.getString(R.string.delete));
        if (this.f16504c == 1) {
            if (i4 < i5 - 1 && i5 > 1) {
                arrayList.add(this.f16502a.getString(R.string.move_down));
            }
            if (i4 > 0) {
                arrayList.add(this.f16502a.getString(R.string.move_up));
            }
        }
        final String[] strArr = (String[]) arrayList.toArray(new String[0]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f16502a);
        builder.setTitle(selectableItem.getEditMacroConfiguredName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: w0.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                AddedItemViewHolder.this.e(strArr, selectableItem, i4, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    public void bind(final List<? extends SelectableItem> list) {
        int color = ContextCompat.getColor(this.f16502a, ColorUtils.getSelectableItemColor(this.f16504c));
        this.cardView.setCardBackgroundColor(color);
        this.listLayout.removeAllViews();
        if (list.size() == 0) {
            this.andOrLayout.setVisibility(8);
            this.emptyText.setVisibility(0);
            TextView textView = this.emptyText;
            textView.setText("(" + this.f16502a.getString(SelectableItem.getNoItemsText(this.f16504c)) + ")");
            return;
        }
        this.emptyText.setVisibility(8);
        if (this.f16504c == 2 && list.size() > 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f16502a.getString(R.string.and));
            arrayList.add(this.f16502a.getString(R.string.or));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this.f16502a, (int) R.layout.simple_spinner_item_white_text, arrayList);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this.constraintSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
            this.andOrLayout.setVisibility(0);
            this.constraintSpinner.setSelection(this.f16503b.isConstraintOrCondition() ? 1 : 0);
            this.constraintSpinner.setOnItemSelectedListener(new a());
        } else {
            this.andOrLayout.setVisibility(8);
        }
        this.emptyText.setVisibility(8);
        LayoutInflater layoutInflater = this.f16502a.getLayoutInflater();
        final int i4 = 0;
        for (final SelectableItem selectableItem : list) {
            MaterialCardView materialCardView = (MaterialCardView) layoutInflater.inflate(R.layout.macro_edit_entry, (ViewGroup) this.listLayout, false);
            materialCardView.setCardBackgroundColor(color);
            TextView textView2 = (TextView) materialCardView.findViewById(R.id.macro_edit_entry_detail);
            ImageView imageView = (ImageView) materialCardView.findViewById(R.id.macro_edit_entry_icon);
            ((TextView) materialCardView.findViewById(R.id.macro_edit_entry_name)).setText(selectableItem.getConfiguredName());
            String extendedDetail = selectableItem.getExtendedDetail();
            if (TextUtils.isEmpty(extendedDetail)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(extendedDetail);
            }
            imageView.setImageResource(selectableItem.getIcon());
            imageView.setBackgroundResource(selectableItem.getInfo().getIconBgDrawable(true));
            this.listLayout.addView(materialCardView);
            materialCardView.setOnClickListener(new View.OnClickListener() { // from class: w0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddedItemViewHolder.this.d(selectableItem, i4, list, view);
                }
            });
            i4++;
        }
    }

    /* loaded from: classes3.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            Macro macro = AddedItemViewHolder.this.f16503b;
            boolean z3 = true;
            if (i4 != 1) {
                z3 = false;
            }
            macro.setConstraintIsOrCondition(z3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
