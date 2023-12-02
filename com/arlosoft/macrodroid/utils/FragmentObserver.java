package com.arlosoft.macrodroid.utils;

import java.util.Observable;

/* loaded from: classes3.dex */
public class FragmentObserver extends Observable {
    @Override // java.util.Observable
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }
}
