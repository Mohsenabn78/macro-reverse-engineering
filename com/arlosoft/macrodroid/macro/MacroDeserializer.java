package com.arlosoft.macrodroid.macro;

import android.content.Context;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.CellTowerConstraint;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.CellTowerTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.util.Set;

/* loaded from: classes3.dex */
public class MacroDeserializer implements JsonDeserializer<Macro> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f12812a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f12813b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f12814c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12815d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<String> f12816e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Action f12817a;

        a(Action action) {
            this.f12817a = action;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f12817a.checkOnImport();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constraint f12819a;

        b(Constraint constraint) {
            this.f12819a = constraint;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f12819a.checkOnImport();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Trigger f12821a;

        c(Trigger trigger) {
            this.f12821a = trigger;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f12821a.checkOnImport();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Trigger f12823a;

        d(Trigger trigger) {
            this.f12823a = trigger;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f12823a.checkOnImport();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Trigger f12825a;

        e(Trigger trigger) {
            this.f12825a = trigger;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f12825a.checkOnImport();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constraint f12827a;

        f(Constraint constraint) {
            this.f12827a = constraint;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f12827a.checkOnImport();
        }
    }

    public MacroDeserializer(Context context, boolean z3, boolean z4, boolean z5) {
        this.f12812a = z3;
        this.f12813b = context;
        this.f12814c = z4;
        this.f12815d = z5;
        this.f12816e = Settings.getDisabledCategories(context);
    }

    private static void a(JsonDeserializationContext jsonDeserializationContext, SelectableItem selectableItem, JsonArray jsonArray, boolean z3, Macro macro) {
        for (int i4 = 0; i4 < jsonArray.size(); i4++) {
            JsonElement jsonElement = jsonArray.get(i4);
            String asString = jsonElement.getAsJsonObject().get("m_classType").getAsString();
            try {
                Class<?> cls = Class.forName("com.arlosoft.macrodroid.constraint." + asString);
                JsonArray jsonArray2 = (JsonArray) jsonElement.getAsJsonObject().get("m_childConstraints");
                jsonElement.getAsJsonObject().remove("m_childConstraints");
                Constraint constraint = (Constraint) jsonDeserializationContext.deserialize(jsonElement, cls);
                constraint.setMacro(macro);
                constraint.configureOnImport();
                selectableItem.addConstraint(constraint);
                constraint.setParentGUID(selectableItem.getSIGUID());
                if (z3) {
                    new f(constraint).start();
                }
                if (constraint instanceof CellTowerConstraint) {
                    ((CellTowerConstraint) constraint).replaceLegacyIds();
                }
                if (jsonArray2 != null && jsonArray2.size() > 0) {
                    a(jsonDeserializationContext, constraint, jsonArray2, z3, macro);
                }
            } catch (Throwable th) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to restore constraint: " + th.toString()));
            }
        }
    }

    private Trigger b(JsonElement jsonElement, JsonDeserializationContext jsonDeserializationContext) {
        String asString;
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("m_secondaryClassType");
        if (jsonElement2 != null) {
            asString = jsonElement2.getAsString();
        } else {
            asString = jsonElement.getAsJsonObject().get("m_classType").getAsString();
        }
        try {
            Class<?> cls = Class.forName("com.arlosoft.macrodroid.triggers." + asString);
            JsonArray jsonArray = (JsonArray) jsonElement.getAsJsonObject().get("m_constraintList");
            jsonElement.getAsJsonObject().remove("m_constraintList");
            Trigger trigger = (Trigger) jsonDeserializationContext.deserialize(jsonElement, cls);
            if (this.f12812a) {
                new e(trigger).start();
            }
            if (trigger instanceof CellTowerTrigger) {
                ((CellTowerTrigger) trigger).replaceLegacyIds();
            }
            return trigger;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Can't wrap try/catch for region: R(21:91|(1:93)(1:179)|(5:94|95|(1:97)|98|99)|(3:158|159|(19:161|162|163|(1:165)|102|103|104|105|106|107|108|109|110|111|112|(1:114)|(1:118)|(3:124|(4:127|(3:129|130|131)(1:133)|132|125)|134)|135))|101|102|103|104|105|106|107|108|109|110|111|112|(0)|(2:116|118)|(1:138)(5:120|122|124|(1:125)|134)|135|89) */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0583, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0585, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0586, code lost:
        r21 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0589, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x058b, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x058c, code lost:
        r18 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x058e, code lost:
        r20 = r5;
        r21 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x059c, code lost:
        r5 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x059e, code lost:
        r3 = r20;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0254 A[Catch: all -> 0x0263, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0346 A[Catch: all -> 0x0469, TryCatch #9 {all -> 0x0469, blocks: (B:140:0x0325, B:139:0x0304, B:150:0x0346, B:152:0x0360, B:153:0x0365, B:160:0x03bf, B:161:0x03d4, B:163:0x03da, B:154:0x0371, B:156:0x0397), top: B:302:0x0304 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03bf A[Catch: all -> 0x0469, TryCatch #9 {all -> 0x0469, blocks: (B:140:0x0325, B:139:0x0304, B:150:0x0346, B:152:0x0360, B:153:0x0365, B:160:0x03bf, B:161:0x03d4, B:163:0x03da, B:154:0x0371, B:156:0x0397), top: B:302:0x0304 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0545 A[Catch: all -> 0x0583, TryCatch #2 {all -> 0x0583, blocks: (B:218:0x0524, B:220:0x0545, B:222:0x054f, B:224:0x0555, B:226:0x055c, B:228:0x0562, B:230:0x0566, B:231:0x056a, B:233:0x0570, B:235:0x057c), top: B:290:0x0524 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0570 A[Catch: all -> 0x0583, TryCatch #2 {all -> 0x0583, blocks: (B:218:0x0524, B:220:0x0545, B:222:0x054f, B:224:0x0555, B:226:0x055c, B:228:0x0562, B:230:0x0566, B:231:0x056a, B:233:0x0570, B:235:0x057c), top: B:290:0x0524 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0623  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0151 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017d A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a4 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b5 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c7 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d6 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e5 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f4 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0203 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0212 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0221 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0230 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x023f A[Catch: all -> 0x0263, TRY_LEAVE, TryCatch #3 {all -> 0x0263, blocks: (B:78:0x0143, B:79:0x0151, B:80:0x0161, B:82:0x0167, B:83:0x0179, B:84:0x017d, B:85:0x0188, B:87:0x018e, B:88:0x01a4, B:89:0x01b5, B:90:0x01c7, B:91:0x01d6, B:92:0x01e5, B:93:0x01f4, B:94:0x0203, B:95:0x0212, B:96:0x0221, B:97:0x0230, B:98:0x023f, B:101:0x0254), top: B:292:0x0143 }] */
    @Override // com.google.gson.JsonDeserializer
    @android.annotation.SuppressLint({"UseValueOf"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.arlosoft.macrodroid.macro.Macro deserialize(com.google.gson.JsonElement r23, java.lang.reflect.Type r24, com.google.gson.JsonDeserializationContext r25) throws com.google.gson.JsonParseException {
        /*
            Method dump skipped, instructions count: 1806
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.macro.MacroDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.arlosoft.macrodroid.macro.Macro");
    }
}
