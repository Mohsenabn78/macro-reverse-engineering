package com.arlosoft.macrodroid.common;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.arlosoft.macrodroid.R;
import java.util.List;

/* loaded from: classes3.dex */
public class AppListAdapter extends ArrayAdapter<ResolveInfo> {

    /* renamed from: a  reason: collision with root package name */
    private RadioButton f9842a;

    /* renamed from: b  reason: collision with root package name */
    private int f9843b;

    /* renamed from: c  reason: collision with root package name */
    private final DialogInterface.OnClickListener f9844c;

    public AppListAdapter(Context context, int i4, List<ResolveInfo> list, DialogInterface.OnClickListener onClickListener) {
        super(context, i4, list);
        this.f9842a = null;
        this.f9843b = -1;
        this.f9844c = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i4, RadioButton radioButton, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            RadioButton radioButton2 = this.f9842a;
            if (radioButton2 != null) {
                radioButton2.setChecked(false);
            }
            this.f9843b = i4;
            this.f9842a = radioButton;
            DialogInterface.OnClickListener onClickListener = this.f9844c;
            if (onClickListener != null) {
                onClickListener.onClick(null, i4);
            }
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i4, View view, ViewGroup viewGroup) {
        PackageManager packageManager = getContext().getPackageManager();
        ResolveInfo resolveInfo = (ResolveInfo) getItem(i4);
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.application_item, (ViewGroup) null);
        }
        ((ImageView) view.findViewById(R.id.application_item_icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
        TextView textView = (TextView) view.findViewById(R.id.application_item_name);
        Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        textView.setText(resolveInfo.loadLabel(packageManager).toString());
        final RadioButton radioButton = (RadioButton) view.findViewById(R.id.application_item_radio_button);
        if (this.f9843b == i4) {
            radioButton.setChecked(true);
        } else {
            radioButton.setChecked(false);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.common.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                radioButton.setChecked(true);
            }
        });
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.common.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                AppListAdapter.this.d(i4, radioButton, compoundButton, z3);
            }
        });
        return view;
    }
}
