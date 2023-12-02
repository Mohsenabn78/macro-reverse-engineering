package com.arlosoft.macrodroid.calendar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.arlosoft.macrodroid.R;
import java.util.List;

/* loaded from: classes3.dex */
public class CalendarArrayAdapter extends ArrayAdapter<CalendarInfo> {

    /* renamed from: a  reason: collision with root package name */
    private List<CalendarInfo> f9602a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f9603b;

    public CalendarArrayAdapter(Activity activity, List<CalendarInfo> list) {
        super(activity, 17367043, list);
        this.f9602a = list;
        this.f9603b = activity;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        return getView(i4, view, viewGroup);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f9603b.getLayoutInflater().inflate(R.layout.list_item_calendar_entry, viewGroup, false);
        }
        CalendarInfo item = getItem(i4);
        ((TextView) view.findViewById(R.id.calendar_account)).setText(item.ownerAccount);
        ((TextView) view.findViewById(R.id.calendar_name)).setText(item.name);
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public CalendarInfo getItem(int i4) {
        return this.f9602a.get(i4);
    }
}
