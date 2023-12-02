package com.arlosoft.macrodroid.celltowers;

import android.text.TextUtils;
import android.util.Log;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.CellTowerGroup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CellTowerGroupStore {

    /* renamed from: b  reason: collision with root package name */
    private static CellTowerGroupStore f9644b;

    /* renamed from: a  reason: collision with root package name */
    private List<CellTowerGroup> f9645a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends TypeToken<List<CellTowerGroup>> {
        a() {
        }
    }

    private CellTowerGroupStore() {
        a();
    }

    private void a() {
        FileInputStream fileInputStream;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    fileInputStream = MacroDroidApplication.getInstance().openFileInput("cellTowerGroups.json");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
                        try {
                            char[] cArr = new char[1024];
                            for (int read = bufferedReader2.read(cArr, 0, 1024); read > 0; read = bufferedReader2.read(cArr, 0, 1024)) {
                                sb.append(cArr, 0, read);
                            }
                            bufferedReader2.close();
                            importJSONFromString(sb.toString());
                            bufferedReader2.close();
                        } catch (FileNotFoundException unused) {
                            bufferedReader = bufferedReader2;
                            Log.w("CellTowerGroupStore", "No Cell Tower data file found");
                            bufferedReader.close();
                            fileInputStream.close();
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = bufferedReader2;
                            String stackTraceToString = Util.stackTraceToString(e);
                            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import CellTowerGroup from JSON: " + e.getMessage() + stackTraceToString.substring(0, Math.max(200, stackTraceToString.length()))));
                            bufferedReader.close();
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            try {
                                bufferedReader.close();
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused3) {
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (FileNotFoundException unused4) {
                    fileInputStream = null;
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
                fileInputStream.close();
            } catch (Exception unused5) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static CellTowerGroupStore getInstance() {
        if (f9644b == null) {
            f9644b = new CellTowerGroupStore();
        }
        return f9644b;
    }

    public void addGroup(CellTowerGroup cellTowerGroup) {
        this.f9645a.add(cellTowerGroup);
    }

    public List<CellTowerGroup> getCellTowerGroups() {
        return this.f9645a;
    }

    public List<CellTowerGroup> getCellTowerGroupsSorted() {
        Collections.sort(this.f9645a);
        return this.f9645a;
    }

    public CellTowerGroup getGroupByName(String str) {
        for (CellTowerGroup cellTowerGroup : this.f9645a) {
            if (str != null && str.equals(cellTowerGroup.getName())) {
                return cellTowerGroup;
            }
        }
        return null;
    }

    public void importJSONFromString(String str) {
        List<CellTowerGroup> list = (List) new GsonBuilder().create().fromJson(str, new a().getType());
        this.f9645a = list;
        if (list == null) {
            this.f9645a = new ArrayList();
        }
        for (CellTowerGroup cellTowerGroup : this.f9645a) {
            for (int i4 = 0; i4 < cellTowerGroup.getCellTowerIds().size(); i4++) {
                cellTowerGroup.getCellTowerIds().set(i4, CellTowerGroup.convertLegacyCellTowerId(cellTowerGroup.getCellTowerIds().get(i4)));
            }
        }
        Iterator<CellTowerGroup> it = this.f9645a.iterator();
        while (it.hasNext()) {
            CellTowerGroup next = it.next();
            if (TextUtils.isEmpty(next.getName()) || next.getCellTowerIds() == null) {
                it.remove();
            }
        }
    }

    public void persistData() {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        Gson gson = new Gson();
        OutputStreamWriter outputStreamWriter2 = null;
        outputStreamWriter2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = MacroDroidApplication.getInstance().openFileOutput("cellTowerGroups.json", 0);
                try {
                    outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                } catch (Exception e4) {
                    e = e4;
                    outputStreamWriter = null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        outputStreamWriter2.close();
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                outputStreamWriter = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                outputStreamWriter.write(gson.toJson(this.f9645a));
                outputStreamWriter.close();
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (Exception e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                try {
                    FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ERROR - Serializing the macro list: " + e.getMessage()));
                    outputStreamWriter.close();
                    fileOutputStream2.close();
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    outputStreamWriter2 = outputStreamWriter;
                    outputStreamWriter2.close();
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                outputStreamWriter2 = outputStreamWriter;
                outputStreamWriter2.close();
                fileOutputStream.close();
                throw th;
            }
        } catch (Exception unused2) {
        }
    }

    public void removeGroup(CellTowerGroup cellTowerGroup) {
        this.f9645a.remove(cellTowerGroup);
    }

    public void setCellTowerGroups(List<CellTowerGroup> list) {
        this.f9645a = list;
    }
}
