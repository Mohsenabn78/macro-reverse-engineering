package com.arlosoft.macrodroid.applications;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class ApplicationAdapter extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private final AppSelectionListener f9300a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<AppInfo> f9301b;

    /* renamed from: c  reason: collision with root package name */
    private List<AppInfo> f9302c;

    /* renamed from: d  reason: collision with root package name */
    private List<AppInfo> f9303d;

    /* renamed from: e  reason: collision with root package name */
    private Context f9304e;

    /* renamed from: f  reason: collision with root package name */
    private PackageManager f9305f;

    /* loaded from: classes3.dex */
    public interface AppSelectionListener {
        void appSelected(AppInfo appInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends ApplicationFilter {

        /* renamed from: a  reason: collision with root package name */
        boolean f9306a = false;

        a() {
        }

        @Override // com.arlosoft.macrodroid.applications.ApplicationFilter
        public final void filter(CharSequence charSequence, boolean z3) {
            this.f9306a = z3;
            filter(charSequence);
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            int size = ApplicationAdapter.this.f9302c.size();
            for (int i4 = 0; i4 < size; i4++) {
                AppInfo appInfo = (AppInfo) ApplicationAdapter.this.f9302c.get(i4);
                if ((charSequence == null || charSequence.toString().length() == 0 || appInfo.applicationName.toLowerCase().contains(charSequence.toString().toLowerCase())) && (this.f9306a || appInfo.launchable)) {
                    arrayList.add(appInfo);
                }
            }
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ApplicationAdapter.this.f9303d = (List) filterResults.values;
            ApplicationAdapter.this.notifyDataSetChanged();
        }
    }

    public ApplicationAdapter(@NonNull Activity activity, @NonNull List<AppInfo> list, @Nullable List<Boolean> list2, @Nullable AppSelectionListener appSelectionListener) {
        this.f9300a = appSelectionListener;
        this.f9304e = activity.getApplicationContext();
        if (list2 != null) {
            this.f9301b = new HashSet();
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (list2.get(i4).booleanValue()) {
                    this.f9301b.add(list.get(i4));
                }
            }
        } else {
            this.f9301b = null;
        }
        this.f9305f = this.f9304e.getPackageManager();
        this.f9302c = list;
        this.f9303d = new ArrayList(this.f9302c);
    }

    private void f(int i4, View view) {
        final AppInfo appInfo = (AppInfo) getItem(i4);
        TextView textView = (TextView) view.findViewById(R.id.app_name);
        TextView textView2 = (TextView) view.findViewById(R.id.app_package);
        ImageView imageView = (ImageView) view.findViewById(R.id.app_icon);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        if (this.f9301b == null) {
            checkBox.setVisibility(8);
            view.setOnClickListener(new View.OnClickListener() { // from class: v.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ApplicationAdapter.this.g(appInfo, view2);
                }
            });
        } else {
            checkBox.setOnCheckedChangeListener(null);
            checkBox.setChecked(this.f9301b.contains(appInfo));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: v.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    ApplicationAdapter.this.h(appInfo, compoundButton, z3);
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: v.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ApplicationAdapter.i(checkBox, view2);
                }
            });
        }
        textView.setText(appInfo.applicationName);
        textView2.setText(appInfo.packageName);
        k(imageView, appInfo.packageName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(AppInfo appInfo, View view) {
        AppSelectionListener appSelectionListener = this.f9300a;
        if (appSelectionListener != null) {
            appSelectionListener.appSelected(appInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(AppInfo appInfo, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            this.f9301b.add(appInfo);
        } else {
            this.f9301b.remove(appInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(CheckBox checkBox, View view) {
        checkBox.setChecked(!checkBox.isChecked());
    }

    private View j(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_list_item, viewGroup, false);
    }

    private void k(ImageView imageView, String str) {
        try {
            imageView.setImageDrawable(this.f9305f.getApplicationIcon(str));
        } catch (Throwable unused) {
        }
    }

    public List<AppInfo> getCheckedItems() {
        return new ArrayList(this.f9301b);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9303d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        return this.f9303d.get(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = j(viewGroup);
        }
        f(i4, view);
        return view;
    }

    @Override // android.widget.Filterable
    public ApplicationFilter getFilter() {
        return new a();
    }
}
