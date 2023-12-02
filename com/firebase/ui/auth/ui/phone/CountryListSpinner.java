package com.firebase.ui.auth.ui.phone;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import com.firebase.ui.auth.data.model.CountryInfo;
import com.firebase.ui.auth.util.ExtraConstants;
import com.firebase.ui.auth.util.data.PhoneNumberUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class CountryListSpinner extends AppCompatEditText implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f18158a;

    /* renamed from: b  reason: collision with root package name */
    private final DialogPopup f18159b;

    /* renamed from: c  reason: collision with root package name */
    private final a f18160c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f18161d;

    /* renamed from: e  reason: collision with root package name */
    private String f18162e;

    /* renamed from: f  reason: collision with root package name */
    private CountryInfo f18163f;

    /* renamed from: g  reason: collision with root package name */
    private Set<String> f18164g;

    /* renamed from: h  reason: collision with root package name */
    private Set<String> f18165h;

    /* loaded from: classes3.dex */
    public class DialogPopup implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final com.firebase.ui.auth.ui.phone.a f18166a;

        /* renamed from: b  reason: collision with root package name */
        private AlertDialog f18167b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ListView f18169a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f18170b;

            a(ListView listView, int i4) {
                this.f18169a = listView;
                this.f18170b = i4;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18169a.setSelection(this.f18170b);
            }
        }

        DialogPopup(com.firebase.ui.auth.ui.phone.a aVar) {
            this.f18166a = aVar;
        }

        public void dismiss() {
            AlertDialog alertDialog = this.f18167b;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f18167b = null;
            }
        }

        public boolean isShowing() {
            AlertDialog alertDialog = this.f18167b;
            if (alertDialog != null && alertDialog.isShowing()) {
                return true;
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            CountryInfo countryInfo = (CountryInfo) this.f18166a.getItem(i4);
            CountryListSpinner.this.f18162e = countryInfo.getLocale().getDisplayCountry();
            CountryListSpinner.this.setSelectedForCountry(countryInfo.getCountryCode(), countryInfo.getLocale());
            dismiss();
        }

        public void show(int i4) {
            if (this.f18166a == null) {
                return;
            }
            AlertDialog create = new AlertDialog.Builder(CountryListSpinner.this.getContext()).setSingleChoiceItems(this.f18166a, 0, this).create();
            this.f18167b = create;
            create.setCanceledOnTouchOutside(true);
            ListView listView = this.f18167b.getListView();
            listView.setFastScrollEnabled(true);
            listView.setScrollbarFadingEnabled(false);
            listView.postDelayed(new a(listView, i4), 10L);
            this.f18167b.show();
        }
    }

    public CountryListSpinner(Context context) {
        this(context, null, 16842881);
    }

    private Set<String> b(@NonNull List<String> list) {
        HashSet hashSet = new HashSet();
        for (String str : list) {
            if (PhoneNumberUtils.isValid(str)) {
                hashSet.addAll(PhoneNumberUtils.getCountryIsosFromCountryCode(str));
            } else {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    private void c(View view) {
        View.OnClickListener onClickListener = this.f18161d;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private List<CountryInfo> d(Bundle bundle) {
        f(bundle);
        Map<String, Integer> immutableCountryIsoMap = PhoneNumberUtils.getImmutableCountryIsoMap();
        if (this.f18164g.isEmpty() && this.f18165h.isEmpty()) {
            this.f18164g = new HashSet(immutableCountryIsoMap.keySet());
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (!this.f18165h.isEmpty()) {
            hashSet.addAll(this.f18165h);
        } else {
            hashSet.addAll(immutableCountryIsoMap.keySet());
            hashSet.removeAll(this.f18164g);
        }
        for (String str : immutableCountryIsoMap.keySet()) {
            if (!hashSet.contains(str)) {
                arrayList.add(new CountryInfo(new Locale("", str), immutableCountryIsoMap.get(str).intValue()));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void e(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void f(@NonNull Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(ExtraConstants.ALLOWLISTED_COUNTRIES);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList(ExtraConstants.BLOCKLISTED_COUNTRIES);
        if (stringArrayList != null) {
            this.f18164g = b(stringArrayList);
        }
        if (stringArrayList2 != null) {
            this.f18165h = b(stringArrayList2);
        }
    }

    private void setDefaultCountryForSpinner(List<CountryInfo> list) {
        CountryInfo currentCountryInfo = PhoneNumberUtils.getCurrentCountryInfo(getContext());
        if (isValidIso(currentCountryInfo.getLocale().getCountry())) {
            setSelectedForCountry(currentCountryInfo.getCountryCode(), currentCountryInfo.getLocale());
        } else if (list.iterator().hasNext()) {
            CountryInfo next = list.iterator().next();
            setSelectedForCountry(next.getCountryCode(), next.getLocale());
        }
    }

    public CountryInfo getSelectedCountryInfo() {
        return this.f18163f;
    }

    public void init(Bundle bundle) {
        if (bundle != null) {
            List<CountryInfo> d4 = d(bundle);
            setCountriesToDisplay(d4);
            setDefaultCountryForSpinner(d4);
        }
    }

    public boolean isValidIso(String str) {
        boolean z3;
        String upperCase = str.toUpperCase(Locale.getDefault());
        boolean z4 = false;
        if (!this.f18164g.isEmpty() && !this.f18164g.contains(upperCase)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!this.f18165h.isEmpty()) {
            if (z3 && !this.f18165h.contains(upperCase)) {
                z4 = true;
            }
            return z4;
        }
        return z3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f18159b.show(this.f18160c.a(this.f18162e));
        e(getContext(), this);
        c(view);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f18159b.isShowing()) {
            this.f18159b.dismiss();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        Parcelable parcelable2 = bundle.getParcelable("KEY_SUPER_STATE");
        this.f18163f = (CountryInfo) bundle.getParcelable("KEY_COUNTRY_INFO");
        super.onRestoreInstanceState(parcelable2);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_SUPER_STATE", onSaveInstanceState);
        bundle.putParcelable("KEY_COUNTRY_INFO", this.f18163f);
        return bundle;
    }

    public void setCountriesToDisplay(List<CountryInfo> list) {
        this.f18160c.b(list);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f18161d = onClickListener;
    }

    public void setSelectedForCountry(int i4, Locale locale) {
        setText(String.format(this.f18158a, CountryInfo.localeToEmoji(locale), Integer.valueOf(i4)));
        this.f18163f = new CountryInfo(locale, i4);
    }

    public CountryListSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842881);
    }

    public CountryListSpinner(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f18164g = new HashSet();
        this.f18165h = new HashSet();
        super.setOnClickListener(this);
        a aVar = new a(getContext());
        this.f18160c = aVar;
        this.f18159b = new DialogPopup(aVar);
        this.f18158a = "%1$s  +%2$d";
        this.f18162e = "";
    }

    public void setSelectedForCountry(Locale locale, String str) {
        if (isValidIso(locale.getCountry())) {
            String displayName = locale.getDisplayName();
            if (TextUtils.isEmpty(displayName) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f18162e = displayName;
            setSelectedForCountry(Integer.parseInt(str), locale);
        }
    }
}
