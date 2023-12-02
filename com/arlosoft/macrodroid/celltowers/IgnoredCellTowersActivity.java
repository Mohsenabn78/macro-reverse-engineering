package com.arlosoft.macrodroid.celltowers;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.celltowers.IgnoredCellTowersActivity;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.LogUpdateEvent;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.List;

/* loaded from: classes3.dex */
public class IgnoredCellTowersActivity extends MacroDroidBaseActivity {
    @BindView(R.id.emptyView)
    ViewGroup emptyView;

    /* renamed from: f  reason: collision with root package name */
    private Database f9666f;

    /* renamed from: g  reason: collision with root package name */
    private IgnoredTowersAdapter f9667g;
    @BindView(R.id.infoCard)
    CardView infoCard;
    @BindView(R.id.infoCardDetail)
    TextView infoCardDetail;
    @BindView(R.id.infoCardGotIt)
    Button infoCardGotit;
    @BindView(R.id.infoCardTitle)
    TextView infoCardTitle;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    /* loaded from: classes3.dex */
    public static class IgnoredTowersAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

        /* renamed from: a  reason: collision with root package name */
        private final IgnoredCellTowersActivity f9668a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f9669b;

        /* renamed from: c  reason: collision with root package name */
        private final Database f9670c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.cellid_name)
            TextView cellId;
            @BindView(R.id.cell_tower_list_row_item_count)
            TextView cellTowerCount;
            @BindView(R.id.cell_tower_row)
            ViewGroup cellTowerRow;
            @BindView(R.id.cell_tower_list_row_checkbox)
            CheckBox checkBox;

            public ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        /* loaded from: classes3.dex */
        public class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: a  reason: collision with root package name */
            private ViewHolder f9672a;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f9672a = viewHolder;
                viewHolder.cellTowerCount = (TextView) Utils.findRequiredViewAsType(view, R.id.cell_tower_list_row_item_count, "field 'cellTowerCount'", TextView.class);
                viewHolder.checkBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cell_tower_list_row_checkbox, "field 'checkBox'", CheckBox.class);
                viewHolder.cellId = (TextView) Utils.findRequiredViewAsType(view, R.id.cellid_name, "field 'cellId'", TextView.class);
                viewHolder.cellTowerRow = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.cell_tower_row, "field 'cellTowerRow'", ViewGroup.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                ViewHolder viewHolder = this.f9672a;
                if (viewHolder != null) {
                    this.f9672a = null;
                    viewHolder.cellTowerCount = null;
                    viewHolder.checkBox = null;
                    viewHolder.cellId = null;
                    viewHolder.cellTowerRow = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public IgnoredTowersAdapter(IgnoredCellTowersActivity ignoredCellTowersActivity, Database database, List<String> list) {
            this.f9668a = ignoredCellTowersActivity;
            this.f9670c = database;
            setHasStableIds(true);
            this.f9669b = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, View view) {
            e(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, DialogInterface dialogInterface, int i4) {
            if (i4 == 0) {
                this.f9670c.setIgnoreCellTowerState(str, false);
                this.f9668a.refresh();
            }
        }

        private void e(final String str) {
            String[] strArr = {this.f9668a.getString(R.string.remove_from_global_ignore)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f9668a);
            builder.setTitle(str).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.b0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    IgnoredCellTowersActivity.IgnoredTowersAdapter.this.d(str, dialogInterface, i4);
                }
            });
            builder.create().show();
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f9669b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        public void setCellTowerRecordList(List<String> list) {
            this.f9669b = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i4) {
            final String str = this.f9669b.get(i4);
            viewHolder.cellId.setText(str);
            viewHolder.cellTowerCount.setText(String.valueOf(i4 + 1));
            viewHolder.cellTowerRow.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IgnoredCellTowersActivity.IgnoredTowersAdapter.this.c(str, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
            ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_tower_list_row, viewGroup, false));
            viewHolder.checkBox.setVisibility(8);
            return viewHolder;
        }
    }

    private void p() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Settings);
        builder.setTitle(R.string.trigger_cell_tower_add_tower_id);
        final EditText editText = new EditText(this);
        editText.setInputType(524289);
        editText.setHint(R.string.trigger_cell_tower_enter_group_name_hint);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.margin_medium);
        builder.setView(editText, dimensionPixelOffset, getResources().getDimensionPixelSize(R.dimen.input_text_dialog_top_margin), dimensionPixelOffset, 0);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                IgnoredCellTowersActivity.this.s(editText, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        AlertDialog show = builder.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(show.getWindow().getAttributes());
        layoutParams.width = -1;
        show.getWindow().setAttributes(layoutParams);
        Button button = show.getButton(-1);
        button.setEnabled(false);
        editText.addTextChangedListener(new a(button));
    }

    private void q(boolean z3) {
        if (z3) {
            this.emptyView.setVisibility(0);
            this.recyclerView.setVisibility(8);
            return;
        }
        this.emptyView.setVisibility(8);
        this.recyclerView.setVisibility(0);
    }

    private void r() {
        if (Settings.shouldHideIgnoredTowersInfoCard(this)) {
            this.infoCard.setVisibility(8);
            return;
        }
        this.infoCard.setCardBackgroundColor(ContextCompat.getColor(this, R.color.cell_towers_primary));
        this.infoCardTitle.setText(R.string.ignored_towers);
        this.infoCardDetail.setText(R.string.ignored_towers_info);
        this.infoCardGotit.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IgnoredCellTowersActivity.this.t(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        List<String> ignoreCellTowers = this.f9666f.getIgnoreCellTowers();
        this.f9667g.setCellTowerRecordList(ignoreCellTowers);
        this.f9667g.notifyDataSetChanged();
        q(ignoreCellTowers.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(EditText editText, DialogInterface dialogInterface, int i4) {
        this.f9666f.setIgnoreCellTowerState(editText.getText().toString(), true);
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        Settings.hideIgnoredTowersInfoCard(this);
        this.infoCard.setVisibility(8);
    }

    @OnClick({R.id.addTowerButton})
    public void onAddTowerButtonClick() {
        p();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ignored_cell_towers);
        ButterKnife.bind(this);
        Database database = Database.getInstance();
        this.f9666f = database;
        List<String> ignoreCellTowers = database.getIgnoreCellTowers();
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        IgnoredTowersAdapter ignoredTowersAdapter = new IgnoredTowersAdapter(this, this.f9666f, ignoreCellTowers);
        this.f9667g = ignoredTowersAdapter;
        this.recyclerView.setAdapter(ignoredTowersAdapter);
        EventBusUtils.getEventBus().register(this);
        q(ignoreCellTowers.isEmpty());
        r();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBusUtils.getEventBus().unregister(this);
        super.onDestroy();
    }

    public void onEventMainThread(LogUpdateEvent logUpdateEvent) {
        refresh();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f9673a;

        a(Button button) {
            this.f9673a = button;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f9673a;
            if (i6 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
