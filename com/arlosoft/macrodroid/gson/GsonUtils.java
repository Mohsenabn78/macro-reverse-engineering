package com.arlosoft.macrodroid.gson;

import android.util.SparseArray;
import com.arlosoft.macrodroid.action.UiInteractionConfiguration;
import com.arlosoft.macrodroid.action.textmanipulation.TextManipulationAdapterFactory;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.serialization.AnnotationExclusionStrategy;
import com.arlosoft.macrodroid.data.BasicTile;
import com.arlosoft.macrodroid.data.CustomTile;
import com.arlosoft.macrodroid.data.HomeTile;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemActionBlock;
import com.arlosoft.macrodroid.drawer.model.DrawerItemAppShortcut;
import com.arlosoft.macrodroid.drawer.model.DrawerItemLog;
import com.arlosoft.macrodroid.drawer.model.DrawerItemMacro;
import com.arlosoft.macrodroid.drawer.model.DrawerItemOpenShortcut;
import com.arlosoft.macrodroid.drawer.model.DrawerItemSeparator;
import com.arlosoft.macrodroid.drawer.model.DrawerItemStopwatch;
import com.arlosoft.macrodroid.drawer.model.DrawerItemText;
import com.arlosoft.macrodroid.drawer.model.DrawerItemVariable;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroDeserializer;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* loaded from: classes3.dex */
public class GsonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final GsonBuilder f12271a = new GsonBuilder().setPrettyPrinting();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends TypeToken<SparseArray<VariableValue>> {
        a() {
        }
    }

    public static Gson getDrawerItemGson() {
        return f12271a.registerTypeAdapterFactory(getDrawerItemTypeAdapterFactory()).create();
    }

    public static RuntimeTypeAdapterFactory<DrawerItem> getDrawerItemTypeAdapterFactory() {
        return RuntimeTypeAdapterFactory.of(DrawerItem.class, "type").registerSubtype(DrawerItemLog.class, DrawerItemLog.ITEM_TYPE).registerSubtype(DrawerItemMacro.class, "Macro").registerSubtype(DrawerItemActionBlock.class, DrawerItemActionBlock.ITEM_TYPE).registerSubtype(DrawerItemStopwatch.class, DrawerItemStopwatch.ITEM_TYPE).registerSubtype(DrawerItemVariable.class, "Variable").registerSubtype(DrawerItemAppShortcut.class, DrawerItemAppShortcut.ITEM_TYPE).registerSubtype(DrawerItemText.class, DrawerItemText.ITEM_TYPE).registerSubtype(DrawerItemOpenShortcut.class, DrawerItemOpenShortcut.ITEM_TYPE).registerSubtype(DrawerItemSeparator.class, DrawerItemSeparator.ITEM_TYPE);
    }

    public static GsonBuilder getGsonBuilder() {
        return getGsonBuilder(true, true);
    }

    public static Gson getHomeTileGson() {
        return f12271a.registerTypeAdapterFactory(getHomeTileTypeAdapterFactory()).create();
    }

    public static RuntimeTypeAdapterFactory<HomeTile> getHomeTileTypeAdapterFactory() {
        return RuntimeTypeAdapterFactory.of(HomeTile.class, "tileType").registerSubtype(BasicTile.class, HomeTile.TILE_TYPE_BASIC).registerSubtype(CustomTile.class, "custom");
    }

    public static Gson getMacroGson() {
        return getGsonBuilder().registerTypeAdapter(ActionBlock.class, new MacroDeserializer(MacroDroidApplication.getInstance(), true, true, true)).registerTypeAdapter(Macro.class, new MacroDeserializer(MacroDroidApplication.getInstance(), true, true, true)).create();
    }

    public static void registerType(RuntimeTypeAdapterFactory<?> runtimeTypeAdapterFactory) {
        f12271a.registerTypeAdapterFactory(runtimeTypeAdapterFactory);
    }

    public static GsonBuilder getGsonBuilder(boolean z3, boolean z4) {
        new a().getType();
        GsonBuilder lenient = new GsonBuilder().excludeFieldsWithModifiers(128, 8).registerTypeAdapterFactory(TextManipulationAdapterFactory.create()).registerTypeAdapter(UiInteractionConfiguration.class, new UIInteractionConfigurationDeserializer()).registerTypeAdapter(VariableValue.class, new DictionaryValueDeserializer()).registerTypeAdapter(VariableValue.class, new ArrayValueDeserializer()).registerTypeAdapterFactory(SparseArrayTypeAdapterFactory.INSTANCE).serializeSpecialFloatingPointValues().addSerializationExclusionStrategy(new AnnotationExclusionStrategy()).setLenient();
        if (z3) {
            lenient.registerTypeAdapterFactory(getDrawerItemTypeAdapterFactory());
        }
        if (z4) {
            lenient.registerTypeAdapterFactory(getHomeTileTypeAdapterFactory());
        }
        return lenient;
    }
}
