package com.firebase.ui.auth.ui.phone;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.CountryInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: CountryListAdapter.java */
/* loaded from: classes3.dex */
final class a extends ArrayAdapter<CountryInfo> implements SectionIndexer {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, Integer> f18203a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f18204b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f18205c;

    public a(Context context) {
        super(context, R.layout.fui_dgts_country_row, 16908308);
        this.f18203a = new LinkedHashMap();
        this.f18204b = new LinkedHashMap();
    }

    public int a(String str) {
        Integer num = this.f18204b.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void b(List<CountryInfo> list) {
        int i4 = 0;
        for (CountryInfo countryInfo : list) {
            String upperCase = countryInfo.getLocale().getDisplayCountry().substring(0, 1).toUpperCase(Locale.getDefault());
            if (!this.f18203a.containsKey(upperCase)) {
                this.f18203a.put(upperCase, Integer.valueOf(i4));
            }
            this.f18204b.put(countryInfo.getLocale().getDisplayCountry(), Integer.valueOf(i4));
            i4++;
            add(countryInfo);
        }
        this.f18205c = new String[this.f18203a.size()];
        this.f18203a.keySet().toArray(this.f18205c);
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f18204b.size();
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i4) {
        String[] strArr = this.f18205c;
        if (strArr == null || i4 <= 0) {
            return 0;
        }
        if (i4 >= strArr.length) {
            i4 = strArr.length - 1;
        }
        return this.f18203a.get(strArr[i4]).intValue();
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i4) {
        if (this.f18205c == null) {
            return 0;
        }
        for (int i5 = 0; i5 < this.f18205c.length; i5++) {
            if (getPositionForSection(i5) > i4) {
                return i5 - 1;
            }
        }
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f18205c;
    }
}
