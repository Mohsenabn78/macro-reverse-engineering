package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import com.arlosoft.macrodroid.common.Util;

/* loaded from: classes2.dex */
public abstract class FileSelectionAction extends Action {
    protected static final int FILE_PICKER_ID = 9876;
    protected String m_filePath;

    public FileSelectionAction() {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i5 == -1) {
            this.m_filePath = intent.getExtras().getString(Util.FILE_SELECTION_EXTRA);
            itemComplete();
        }
    }

    public FileSelectionAction(Parcel parcel) {
        super(parcel);
    }
}
