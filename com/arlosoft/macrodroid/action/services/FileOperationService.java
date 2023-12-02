package com.arlosoft.macrodroid.action.services;

import android.app.IntentService;

/* loaded from: classes2.dex */
public class FileOperationService extends IntentService {
    public static final String EXTRA_FILE_EXTENSIONS = "FileExtensions";
    public static final String EXTRA_FILE_OPTION = "FileOption";
    public static final String EXTRA_FILE_OPTION_FIXED = "FileOptionFixed";
    public static final String EXTRA_FILE_PATTERN = "FilePattern";
    public static final String EXTRA_FROM_PATH = "FromPath";
    public static final String EXTRA_TO_PATH = "ToPath";

    public FileOperationService() {
        super("FileOperationService");
        setIntentRedelivery(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011f  */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onHandleIntent(android.content.Intent r20) {
        /*
            Method dump skipped, instructions count: 901
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.services.FileOperationService.onHandleIntent(android.content.Intent):void");
    }
}
