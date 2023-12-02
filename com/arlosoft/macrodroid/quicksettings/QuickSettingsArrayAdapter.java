package com.arlosoft.macrodroid.quicksettings;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class QuickSettingsArrayAdapter extends ArrayAdapter<String> {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f13279a;

    public QuickSettingsArrayAdapter(@NonNull Context context, @NonNull String[] strArr, boolean[] zArr) {
        super(context, (int) R.layout.single_choice_list_item, strArr);
        this.f13279a = zArr;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i4, view, viewGroup);
        TextView textView = (TextView) view2.findViewById(16908308);
        if (!this.f13279a[i4]) {
            textView.setText(Html.fromHtml(((Object) textView.getText()) + "<br/><small>" + getContext().getString(R.string.disabled) + "</small></br>"));
        }
        return view2;
    }
}
