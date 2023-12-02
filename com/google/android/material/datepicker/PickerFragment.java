package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class PickerFragment<S> extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    protected final LinkedHashSet<OnSelectionChangedListener<S>> f23552b = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.f23552b.add(onSelectionChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f23552b.clear();
    }
}
