package com.arlosoft.macrodroid.geofences.ui;

/* loaded from: classes3.dex */
public interface ConfigureZoneView {
    void closeView(boolean z3);

    void promptSaveOnExit();

    void saveImageOfMapAndClose();

    void setAreaRadius(int i4);

    void setRadiusBarValue(int i4);

    void setRadiusText(int i4);

    void setSaveEnabled(boolean z3);

    void showAlreadyExistsWarning();

    void showConfirmDelete();

    void showNameWarning();

    void showRadiusValueDialog(int i4);
}
