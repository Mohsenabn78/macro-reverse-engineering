package com.arlosoft.macrodroid.gson;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.UiInteractionConfiguration;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIInteractionConfigurationDeserializer.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UIInteractionConfigurationDeserializer implements JsonDeserializer<UiInteractionConfiguration>, JsonSerializer<UiInteractionConfiguration> {
    public static final int $stable = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public UiInteractionConfiguration deserialize(@Nullable JsonElement jsonElement, @Nullable Type type, @Nullable JsonDeserializationContext jsonDeserializationContext) {
        JsonElement jsonElement2;
        JsonObject asJsonObject = jsonElement != null ? jsonElement.getAsJsonObject() : null;
        String asString = (asJsonObject == null || (jsonElement2 = asJsonObject.get("type")) == null) ? null : jsonElement2.getAsString();
        if (jsonDeserializationContext != null) {
            String qualifiedName = Reflection.getOrCreateKotlinClass(UiInteractionConfiguration.class).getQualifiedName();
            return (UiInteractionConfiguration) jsonDeserializationContext.deserialize(jsonElement, Class.forName(qualifiedName + "$" + asString));
        }
        return null;
    }

    @Override // com.google.gson.JsonSerializer
    @NotNull
    public JsonElement serialize(@Nullable UiInteractionConfiguration uiInteractionConfiguration, @Nullable Type type, @Nullable JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = null;
        if (jsonSerializationContext != null) {
            String qualifiedName = Reflection.getOrCreateKotlinClass(UiInteractionConfiguration.class).getQualifiedName();
            String type2 = uiInteractionConfiguration != null ? uiInteractionConfiguration.getType() : null;
            jsonElement = jsonSerializationContext.serialize(uiInteractionConfiguration, Class.forName(qualifiedName + "$" + type2));
        }
        Intrinsics.checkNotNull(jsonElement);
        return jsonElement;
    }
}
