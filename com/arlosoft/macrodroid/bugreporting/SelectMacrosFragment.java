package com.arlosoft.macrodroid.bugreporting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SelectMacrosFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private List<Macro> f9573b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayAdapter<String> f9574c;
    @BindView(R.id.macro_list)
    ListView macroListView;
    @BindView(R.id.searchView)
    SearchView searchView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SearchView.OnQueryTextListener {
        a() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            SelectMacrosFragment.this.f9574c.getFilter().filter(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    private void d() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getContext().getString(R.string.no_macros_selected));
        builder.setMessage(R.string.confirm_no_macros);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.bugreporting.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SelectMacrosFragment.this.f(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getContext().getString(R.string.error));
        builder.setMessage(R.string.too_many_macros);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(DialogInterface dialogInterface, int i4) {
        ((ReportBugActivity) getActivity()).macrosSelected(new ArrayList());
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : this.f9573b) {
            arrayList.add(macro.getName());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), (int) R.layout.multi_choice_list_item, arrayList);
        this.f9574c = arrayAdapter;
        this.macroListView.setAdapter((ListAdapter) arrayAdapter);
        this.searchView.setOnQueryTextListener(new a());
    }

    public static SelectMacrosFragment newInstance() {
        SelectMacrosFragment selectMacrosFragment = new SelectMacrosFragment();
        selectMacrosFragment.setArguments(new Bundle());
        return selectMacrosFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bug_macro_select, viewGroup, false);
        ButterKnife.bind(this, inflate);
        this.f9573b = MacroStore.getInstance().getAllCompletedMacrosWithActionBlocksSortedMacrosFirst(true);
        g();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.continueButton})
    public void onFabClicked() {
        SparseBooleanArray checkedItemPositions = this.macroListView.getCheckedItemPositions();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.macroListView.getCount(); i4++) {
            if (checkedItemPositions.get(i4)) {
                String item = this.f9574c.getItem(i4);
                Iterator<Macro> it = this.f9573b.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Macro next = it.next();
                        if (next.getName().equals(item)) {
                            arrayList.add(next);
                            break;
                        }
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            d();
        } else if (arrayList.size() <= 4) {
            ((ReportBugActivity) getActivity()).macrosSelected(arrayList);
        } else {
            e();
        }
    }
}
