package com.facebook.stetho.inspector.database;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class DefaultDatabaseFilesProvider implements DatabaseFilesProvider {
    private final Context mContext;

    public DefaultDatabaseFilesProvider(Context context) {
        this.mContext = context;
    }

    @Override // com.facebook.stetho.inspector.database.DatabaseFilesProvider
    public List<File> getDatabaseFiles() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.mContext.databaseList()) {
            arrayList.add(this.mContext.getDatabasePath(str));
        }
        return arrayList;
    }
}
