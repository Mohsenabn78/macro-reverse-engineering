package com.arlosoft.macrodroid.utils.gradients;

import android.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Gradients.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class Gradients {
    @NotNull
    public static final Gradients INSTANCE = new Gradients();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final MacroDroidApplication f16111a = MacroDroidApplication.Companion.getInstance();
    public static final int $stable = 8;

    private Gradients() {
    }

    private final WebGradientDrawable a(String str, double d4, int[] iArr, float[] fArr) {
        return new WebGradientDrawable(str, new LinearGradientShaderFactory(d4, iArr, fArr));
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable aboveTheSky() {
        return INSTANCE.a("Above The Sky", -90.0d, new int[]{Color.parseColor("lightgrey"), Color.parseColor("lightgrey"), Color.parseColor("#e0e0e0"), Color.parseColor("#efefef"), Color.parseColor("#d9d9d9"), Color.parseColor("#bcbcbc")}, new float[]{0.0f, 0.01f, 0.26f, 0.48f, 0.75f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable addButton() {
        Gradients gradients = INSTANCE;
        MacroDroidApplication macroDroidApplication = f16111a;
        return gradients.a("Add Button", -90.0d, new int[]{ContextCompat.getColor(macroDroidApplication, R.color.home_add_gradient_1), ContextCompat.getColor(macroDroidApplication, R.color.home_add_gradient_2)}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable africanField() {
        return INSTANCE.a("African Field", -90.0d, new int[]{Color.parseColor("#65bd60"), Color.parseColor("#5ac1a8"), Color.parseColor("#3ec6ed"), Color.parseColor("#b7ddb7"), Color.parseColor("#fef381")}, new float[]{0.0f, 0.25f, 0.5f, 0.75f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable alchemistLab() {
        return INSTANCE.a("Alchemist Lab", -110.0d, new int[]{Color.parseColor("#d558c8"), Color.parseColor("#24d292")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable amourAmour() {
        return INSTANCE.a("Amour Amour", -90.0d, new int[]{Color.parseColor("#f77062"), Color.parseColor("#fe5196")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable amyCrisp() {
        return INSTANCE.a("Amy Crisp", 30.0d, new int[]{Color.parseColor("#a6c0fe"), Color.parseColor("#f68084")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable angelCare() {
        return INSTANCE.a("Angel Care", -315.0d, new int[]{Color.parseColor("#FFE29F"), Color.parseColor("#FFA99F"), Color.parseColor("#FF719A")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable aquaGuidance() {
        return INSTANCE.a("Aqua Guidance", -90.0d, new int[]{Color.parseColor("#007adf"), Color.parseColor("#00ecbc")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable aquaSplash() {
        return INSTANCE.a("Aqua Splash", -75.0d, new int[]{Color.parseColor("#13547a"), Color.parseColor("#80d0c7")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable awesomePine() {
        return INSTANCE.a("Awesome Pine", -90.0d, new int[]{Color.parseColor("#ebbba7"), Color.parseColor("#cfc7f8")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable bigMango() {
        return INSTANCE.a("Big Mango", -90.0d, new int[]{Color.parseColor("#c71d6f"), Color.parseColor("#d09693")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable blackSea() {
        return INSTANCE.a("Black Sea", -315.0d, new int[]{Color.parseColor("#2CD8D5"), Color.parseColor("#6B8DD6"), Color.parseColor("#8E37D7")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable blessing() {
        return INSTANCE.a("Blessing", -90.0d, new int[]{Color.parseColor("#fddb92"), Color.parseColor("#d1fdff")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable burningSpring() {
        return INSTANCE.a("Burning Spring", -90.0d, new int[]{Color.parseColor("#4fb576"), Color.parseColor("#44c489"), Color.parseColor("#28a9ae"), Color.parseColor("#28a2b7"), Color.parseColor("#4c7788"), Color.parseColor("#6c4f63"), Color.parseColor("#432c39")}, new float[]{0.0f, 0.3f, 0.46f, 0.59f, 0.71f, 0.86f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable cheerfulCaramel() {
        return INSTANCE.a("Cheerful Caramel", -90.0d, new int[]{Color.parseColor("#e6b980"), Color.parseColor("#eacda3")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable childCare() {
        return INSTANCE.a("Child Care", -110.0d, new int[]{Color.parseColor("#f794a4"), Color.parseColor("#fdd6bd")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable cleanMirror() {
        return INSTANCE.a("Clean Mirror", -45.0d, new int[]{Color.parseColor("#93a5cf"), Color.parseColor("#e4efe9")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable cloudyApple() {
        return INSTANCE.a("Cloudy Apple", -90.0d, new int[]{Color.parseColor("#f3e7e9"), Color.parseColor("#e3eeff"), Color.parseColor("#e3eeff")}, new float[]{0.0f, 0.99f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable cloudyKnoxville() {
        return INSTANCE.a("Cloudy Knoxville", 30.0d, new int[]{Color.parseColor("#fdfbfb"), Color.parseColor("#ebedee")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable cochitiLake() {
        return INSTANCE.a("Cochiti Lake", -45.0d, new int[]{Color.parseColor("#93a5cf"), Color.parseColor("#e4efe9")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable coldEvening() {
        return INSTANCE.a("Cold Evening", -90.0d, new int[]{Color.parseColor("#0c3483"), Color.parseColor("#a2b6df"), Color.parseColor("#6b8cce"), Color.parseColor("#a2b6df")}, new float[]{0.0f, 1.0f, 1.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable colorfulPeach() {
        return INSTANCE.a("Colorful Peach", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#ed6ea0"), Color.parseColor("#ec8c69")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable confidentCloud() {
        return INSTANCE.a("Confident Cloud", -90.0d, new int[]{Color.parseColor("#dad4ec"), Color.parseColor("#dad4ec"), Color.parseColor("#f3e7e9")}, new float[]{0.0f, 0.01f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable crystalRiver() {
        return INSTANCE.a("Crystal River", -315.0d, new int[]{Color.parseColor("#22E1FF"), Color.parseColor("#1D8FE1"), Color.parseColor("#625EB1")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable crystalline() {
        return INSTANCE.a("Crystalline", -110.0d, new int[]{Color.parseColor("#00cdac"), Color.parseColor("#8ddad5")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable deepBlue() {
        return INSTANCE.a("Deep Blue", 30.0d, new int[]{Color.parseColor("#e0c3fc"), Color.parseColor("#8ec5fc")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable deepBlue2() {
        return INSTANCE.a("Deep Blue", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#6a11cb"), Color.parseColor("#2575fc")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable deepRelief() {
        return INSTANCE.a("Deep Relief", -315.0d, new int[]{Color.parseColor("#7085B6"), Color.parseColor("#87A7D9"), Color.parseColor("#DEF3F8")}, new float[]{0.0f, 0.5f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable denseWater() {
        return INSTANCE.a("Dense Water", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#3ab5b0"), Color.parseColor("#3d99be"), Color.parseColor("#56317a")}, new float[]{0.0f, 0.31f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable desertHump() {
        return INSTANCE.a("Desert Hump", -90.0d, new int[]{Color.parseColor("#c79081"), Color.parseColor("#dfa579")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable dirtyBeauty() {
        return INSTANCE.a("Dirty Beauty", -90.0d, new int[]{Color.parseColor("#6a85b6"), Color.parseColor("#bac8e0")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable dustyGrass() {
        return INSTANCE.a("Dusty Grass", 30.0d, new int[]{Color.parseColor("#d4fc79"), Color.parseColor("#96e6a1")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable eternalConstance() {
        return INSTANCE.a("Eternal Constance", -90.0d, new int[]{Color.parseColor("#09203f"), Color.parseColor("#537895")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable everlastingSky() {
        return INSTANCE.a("Everlasting Sky", 45.0d, new int[]{Color.parseColor("#fdfcfb"), Color.parseColor("#e2d1c3")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable exportImportButton() {
        Gradients gradients = INSTANCE;
        MacroDroidApplication macroDroidApplication = f16111a;
        return gradients.a("Export/Import Button", -90.0d, new int[]{ContextCompat.getColor(macroDroidApplication, R.color.home_export_gradient_1), ContextCompat.getColor(macroDroidApplication, R.color.home_export_gradient_2)}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable fabledSunset() {
        return INSTANCE.a("Fabled Sunset", -315.0d, new int[]{Color.parseColor("#231557"), Color.parseColor("#44107A"), Color.parseColor("#FF1361"), Color.parseColor("#FFF800")}, new float[]{0.0f, 0.29f, 0.67f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable farawayRiver() {
        return INSTANCE.a("Faraway River", -110.0d, new int[]{Color.parseColor("#6e45e2"), Color.parseColor("#88d3ce")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable februaryInk() {
        return INSTANCE.a("February Ink", -90.0d, new int[]{Color.parseColor("#accbee"), Color.parseColor("#e7f0fd")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @Nullable
    public static final WebGradientDrawable find(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        switch (name.hashCode()) {
            case -2109445576:
                if (name.equals("Shady Water")) {
                    return shadyWater();
                }
                break;
            case -2079154063:
                if (name.equals("Faraway River")) {
                    return farawayRiver();
                }
                break;
            case -2041142651:
                if (name.equals("Happy Fisher")) {
                    return happyFisher();
                }
                break;
            case -2040041197:
                if (name.equals("Soft Lipstick")) {
                    return softLipstick();
                }
                break;
            case -2011103877:
                if (name.equals("Sunny Morning")) {
                    return sunnyMorning();
                }
                break;
            case -2007375014:
                if (name.equals("Burning Spring")) {
                    return burningSpring();
                }
                break;
            case -1995249297:
                if (name.equals("Fly High")) {
                    return flyHigh();
                }
                break;
            case -1940343932:
                if (name.equals("Wild Apple")) {
                    return wildApple();
                }
                break;
            case -1885490974:
                if (name.equals("Cochiti Lake")) {
                    return cochitiLake();
                }
                break;
            case -1813342872:
                if (name.equals("True Sunset")) {
                    return trueSunset();
                }
                break;
            case -1801238721:
                if (name.equals("River City")) {
                    return riverCity();
                }
                break;
            case -1773561355:
                if (name.equals("Sugar Lollipop")) {
                    return sugarLollipop();
                }
                break;
            case -1732447890:
                if (name.equals("Young Grass")) {
                    return youngGrass();
                }
                break;
            case -1727180256:
                if (name.equals("Teen Party")) {
                    return teenParty();
                }
                break;
            case -1724929618:
                if (name.equals("Royal Garden")) {
                    return royalGarden();
                }
                break;
            case -1716442292:
                if (name.equals("Cold Evening")) {
                    return coldEvening();
                }
                break;
            case -1715951021:
                if (name.equals("Spiky Naga")) {
                    return spikyNaga();
                }
                break;
            case -1703097176:
                if (name.equals("Space Shift")) {
                    return spaceShift();
                }
                break;
            case -1661165186:
                if (name.equals("Grown Early")) {
                    return grownEarly();
                }
                break;
            case -1638672226:
                if (name.equals("Night Party")) {
                    return nightParty();
                }
                break;
            case -1567133026:
                if (name.equals("Mole Hall")) {
                    return moleHall();
                }
                break;
            case -1551056886:
                if (name.equals("Cloudy Knoxville")) {
                    return cloudyKnoxville();
                }
                break;
            case -1436424550:
                if (name.equals("Supreme Sky")) {
                    return supremeSky();
                }
                break;
            case -1427330737:
                if (name.equals("Smiling Rain")) {
                    return smilingRain();
                }
                break;
            case -1411076791:
                if (name.equals("Smart Indigo")) {
                    return smartIndigo();
                }
                break;
            case -1351562281:
                if (name.equals("New Retrowave")) {
                    return newRetrowave();
                }
                break;
            case -1340187506:
                if (name.equals("Red Salvation")) {
                    return redSalvation();
                }
                break;
            case -1312051608:
                if (name.equals("February Ink")) {
                    return februaryInk();
                }
                break;
            case -1244185289:
                if (name.equals("Rainy Ashville")) {
                    return rainyAshville();
                }
                break;
            case -1231415151:
                if (name.equals("Purple Division")) {
                    return purpleDivision();
                }
                break;
            case -1229183102:
                if (name.equals("Gagarin View")) {
                    return gagarinView();
                }
                break;
            case -1141884961:
                if (name.equals("Premium Dark")) {
                    return premiumDark();
                }
                break;
            case -1114599781:
                if (name.equals("Risky Concrete")) {
                    return riskyConcrete();
                }
                break;
            case -1074196703:
                if (name.equals("October Silence")) {
                    return octoberSilence();
                }
                break;
            case -1048180692:
                if (name.equals("Heaven Peach")) {
                    return heavenPeach();
                }
                break;
            case -1037976238:
                if (name.equals("Palo Alto")) {
                    return paloAlto();
                }
                break;
            case -1031995507:
                if (name.equals("Heavy Rain")) {
                    return heavyRain();
                }
                break;
            case -1020948256:
                if (name.equals("Premium White")) {
                    return premiumWhite();
                }
                break;
            case -1006004267:
                if (name.equals("Child Care")) {
                    return childCare();
                }
                break;
            case -985745789:
                if (name.equals("Snow Again")) {
                    return snowAgain();
                }
                break;
            case -973307801:
                if (name.equals("Malibu Beach")) {
                    return malibuBeach();
                }
                break;
            case -960272274:
                if (name.equals("Black Sea")) {
                    return blackSea();
                }
                break;
            case -933186866:
                if (name.equals("African Field")) {
                    return africanField();
                }
                break;
            case -926840615:
                if (name.equals("Night Sky")) {
                    return nightSky();
                }
                break;
            case -913338330:
                if (name.equals("Japan Blush")) {
                    return japanBlush();
                }
                break;
            case -871205593:
                if (name.equals("Blessing")) {
                    return blessing();
                }
                break;
            case -820091844:
                if (name.equals("Aqua Guidance")) {
                    return aquaGuidance();
                }
                break;
            case -820017729:
                if (name.equals("Sun Veggie")) {
                    return sunVeggie();
                }
                break;
            case -790418334:
                if (name.equals("Magic Lake")) {
                    return magicLake();
                }
                break;
            case -782662951:
                if (name.equals("Mind Crawl")) {
                    return mindCrawl();
                }
                break;
            case -772193999:
                if (name.equals("Sweet Period")) {
                    return sweetPeriod();
                }
                break;
            case -742696415:
                if (name.equals("Confident Cloud")) {
                    return confidentCloud();
                }
                break;
            case -679780545:
                if (name.equals("Alchemist Lab")) {
                    return alchemistLab();
                }
                break;
            case -668944816:
                if (name.equals("Frozen Dreams")) {
                    return frozenDreams();
                }
                break;
            case -668720722:
                if (name.equals("Wide Matrix")) {
                    return wideMatrix();
                }
                break;
            case -667400978:
                if (name.equals("Orange Juice")) {
                    return orangeJuice();
                }
                break;
            case -626284389:
                if (name.equals("Desert Hump")) {
                    return desertHump();
                }
                break;
            case -621571626:
                if (name.equals("Lady Lips")) {
                    return ladyLips();
                }
                break;
            case -605750250:
                if (name.equals("North Miracle")) {
                    return northMiracle();
                }
                break;
            case -553782822:
                if (name.equals("Witch Dance")) {
                    return witchDance();
                }
                break;
            case -436727951:
                if (name.equals("Ladoga Bottom")) {
                    return ladogaBottom();
                }
                break;
            case -425170064:
                if (name.equals("Frozen Heat")) {
                    return frozenHeat();
                }
                break;
            case -405401467:
                if (name.equals("Juicy Peach")) {
                    return juicyPeach();
                }
                break;
            case -387453477:
                if (name.equals("Mars Party")) {
                    return marsParty();
                }
                break;
            case -382642008:
                if (name.equals("Sleepless Night")) {
                    return sleeplessNight();
                }
                break;
            case -374796737:
                if (name.equals("Kind Steel")) {
                    return kindSteel();
                }
                break;
            case -369844948:
                if (name.equals("Spring Warmth")) {
                    return springWarmth();
                }
                break;
            case -364628309:
                if (name.equals("Sharpeye Eagle")) {
                    return sharpeyeEagle();
                }
                break;
            case -331821333:
                if (name.equals("Le Cocktail")) {
                    return leCocktail();
                }
                break;
            case -326473631:
                if (name.equals("Teen Notebook")) {
                    return teenNotebook();
                }
                break;
            case -317001192:
                if (name.equals("Lemon Gate")) {
                    return lemonGate();
                }
                break;
            case -300894826:
                if (name.equals("Frozen Berry")) {
                    return frozenBerry();
                }
                break;
            case -246275503:
                if (name.equals("Phoenix Start")) {
                    return phoenixStart();
                }
                break;
            case -227107402:
                if (name.equals("Sweet Dessert")) {
                    return sweetDessert();
                }
                break;
            case -220492725:
                if (name.equals("Aqua Splash")) {
                    return aquaSplash();
                }
                break;
            case -202813161:
                if (name.equals("Star Wine")) {
                    return starWine();
                }
                break;
            case -197394749:
                if (name.equals("Rich Metal")) {
                    return richMetal();
                }
                break;
            case -164038921:
                if (name.equals("Magic Ray")) {
                    return magicRay();
                }
                break;
            case -147293169:
                if (name.equals("Itmeo Branding")) {
                    return itmeoBranding();
                }
                break;
            case -140236530:
                if (name.equals("Saint Petersburg")) {
                    return saintPetersburg();
                }
                break;
            case -128118791:
                if (name.equals("Near Moon")) {
                    return nearMoon();
                }
                break;
            case -35984626:
                if (name.equals("Deep Blue")) {
                    return deepBlue2();
                }
                break;
            case -16661325:
                if (name.equals("Midnight Bloom")) {
                    return midnightBloom();
                }
                break;
            case 2424049:
                if (name.equals("Nega")) {
                    return nega();
                }
                break;
            case 131229870:
                if (name.equals("High Flight")) {
                    return highFlight();
                }
                break;
            case 164548025:
                if (name.equals("Jungle Day")) {
                    return jungleDay();
                }
                break;
            case 183754559:
                if (name.equals("Landing Aircraft")) {
                    return landingAircraft();
                }
                break;
            case 212619433:
                if (name.equals("Strict November")) {
                    return strictNovember();
                }
                break;
            case 229853509:
                if (name.equals("Deep Relief")) {
                    return deepRelief();
                }
                break;
            case 239210594:
                if (name.equals("Crystal River")) {
                    return crystalRiver();
                }
                break;
            case 279052549:
                if (name.equals("Fruit Blend")) {
                    return fruitBlend();
                }
                break;
            case 283672802:
                if (name.equals("Old Hat")) {
                    return oldHat();
                }
                break;
            case 293427711:
                if (name.equals("Plum Bath")) {
                    return plumBath();
                }
                break;
            case 317032728:
                if (name.equals("Mountain Rock")) {
                    return mountainRock();
                }
                break;
            case 337633814:
                if (name.equals("Perfect White")) {
                    return perfectWhite();
                }
                break;
            case 339701312:
                if (name.equals("Soft Grass")) {
                    return softGrass();
                }
                break;
            case 353583756:
                if (name.equals("Hidden Jaguar")) {
                    return hiddenJaguar();
                }
                break;
            case 386497734:
                if (name.equals("Rare Wind")) {
                    return rareWind();
                }
                break;
            case 446777373:
                if (name.equals("Dusty Grass")) {
                    return dustyGrass();
                }
                break;
            case 448971919:
                if (name.equals("Eternal Constance")) {
                    return eternalConstance();
                }
                break;
            case 462614884:
                if (name.equals("Amy Crisp")) {
                    return amyCrisp();
                }
                break;
            case 492408847:
                if (name.equals("Young Passion")) {
                    return youngPassion();
                }
                break;
            case 497765750:
                if (name.equals("Soft Cherish")) {
                    return softCherish();
                }
                break;
            case 519563658:
                if (name.equals("Plum Plate")) {
                    return plumPlate();
                }
                break;
            case 525520940:
                if (name.equals("Love Kiss")) {
                    return loveKiss();
                }
                break;
            case 548019216:
                if (name.equals("Angel Care")) {
                    return angelCare();
                }
                break;
            case 582002893:
                if (name.equals("Marble Wall")) {
                    return marbleWall();
                }
                break;
            case 588009482:
                if (name.equals("Crystalline")) {
                    return crystalline();
                }
                break;
            case 592177408:
                if (name.equals("Over Sun")) {
                    return overSun();
                }
                break;
            case 593258902:
                if (name.equals("Great Whale")) {
                    return greatWhale();
                }
                break;
            case 734816694:
                if (name.equals("Clean Mirror")) {
                    return cleanMirror();
                }
                break;
            case 778899766:
                if (name.equals("Strong Bliss")) {
                    return strongBliss();
                }
                break;
            case 794837447:
                if (name.equals("Strong Stick")) {
                    return strongStick();
                }
                break;
            case 799200453:
                if (name.equals("Grass Shampoo")) {
                    return grassShampoo();
                }
                break;
            case 804626092:
                if (name.equals("Forest Inei")) {
                    return forestInei();
                }
                break;
            case 830343987:
                if (name.equals("Glass Water")) {
                    return glassWater();
                }
                break;
            case 834285082:
                if (name.equals("Shy Rainbow")) {
                    return shyRainbow();
                }
                break;
            case 842724345:
                if (name.equals("Lily Meadow")) {
                    return lilyMeadow();
                }
                break;
            case 864953495:
                if (name.equals("Cheerful Caramel")) {
                    return cheerfulCaramel();
                }
                break;
            case 876883046:
                if (name.equals("Sea Lord")) {
                    return seaLord();
                }
                break;
            case 903399896:
                if (name.equals("Warm Flame")) {
                    return warmFlame();
                }
                break;
            case 913635476:
                if (name.equals("Healthy Water")) {
                    return healthyWater();
                }
                break;
            case 915272477:
                if (name.equals("Winter Neva")) {
                    return winterNeva();
                }
                break;
            case 940673807:
                if (name.equals("Above The Sky")) {
                    return aboveTheSky();
                }
                break;
            case 942392843:
                if (name.equals("Colorful Peach")) {
                    return colorfulPeach();
                }
                break;
            case 954369438:
                if (name.equals("Seashore")) {
                    return seashore();
                }
                break;
            case 980101325:
                if (name.equals("Perfect Blue")) {
                    return perfectBlue();
                }
                break;
            case 1002786937:
                if (name.equals("Polite Rumors")) {
                    return politeRumors();
                }
                break;
            case 1066040944:
                if (name.equals("Solid Stone")) {
                    return solidStone();
                }
                break;
            case 1076047075:
                if (name.equals("Sea Strike")) {
                    return seaStrike();
                }
                break;
            case 1094910372:
                if (name.equals("Juicy Cake")) {
                    return juicyCake();
                }
                break;
            case 1095140554:
                if (name.equals("Dirty Beauty")) {
                    return dirtyBeauty();
                }
                break;
            case 1104695228:
                if (name.equals("Passionate Bed")) {
                    return passionateBed();
                }
                break;
            case 1156761311:
                if (name.equals("Happy Memories")) {
                    return happyMemories();
                }
                break;
            case 1160853517:
                if (name.equals("Fresh Milk")) {
                    return freshMilk();
                }
                break;
            case 1167380247:
                if (name.equals("Salt Mountain")) {
                    return saltMountain();
                }
                break;
            case 1213040049:
                if (name.equals("Tempting Azure")) {
                    return temptingAzure();
                }
                break;
            case 1241491132:
                if (name.equals("Vicious Stance")) {
                    return viciousStance();
                }
                break;
            case 1244646973:
                if (name.equals("Happy Acid")) {
                    return happyAcid();
                }
                break;
            case 1258381305:
                if (name.equals("Mean Fruit")) {
                    return meanFruit();
                }
                break;
            case 1332225446:
                if (name.equals("Night Call")) {
                    return nightCall();
                }
                break;
            case 1332314564:
                if (name.equals("Night Fade")) {
                    return nightFade();
                }
                break;
            case 1336209637:
                if (name.equals("Morning Salad")) {
                    return morningSalad();
                }
                break;
            case 1347993294:
                if (name.equals("Sand Strike")) {
                    return sandStrike();
                }
                break;
            case 1375965786:
                if (name.equals("Zeus Miracle")) {
                    return zeusMiracle();
                }
                break;
            case 1380165918:
                if (name.equals("Cloudy Apple")) {
                    return cloudyApple();
                }
                break;
            case 1382601148:
                if (name.equals("New Life")) {
                    return newLife();
                }
                break;
            case 1382994575:
                if (name.equals("New York")) {
                    return newYork();
                }
                break;
            case 1398398819:
                if (name.equals("Sharp Blues")) {
                    return sharpBlues();
                }
                break;
            case 1479761442:
                if (name.equals("Flying Lemon")) {
                    return flyingLemon();
                }
                break;
            case 1487389794:
                if (name.equals("Big Mango")) {
                    return bigMango();
                }
                break;
            case 1505180313:
                if (name.equals("Norse Beauty")) {
                    return norseBeauty();
                }
                break;
            case 1535697426:
                if (name.equals("Mixed Hopes")) {
                    return mixedHopes();
                }
                break;
            case 1545594991:
                if (name.equals("Everlasting Sky")) {
                    return everlastingSky();
                }
                break;
            case 1574230752:
                if (name.equals("Amour Amour")) {
                    return amourAmour();
                }
                break;
            case 1628336153:
                if (name.equals("Fresh Oasis")) {
                    return freshOasis();
                }
                break;
            case 1642786188:
                if (name.equals("Sky Glider")) {
                    return skyGlider();
                }
                break;
            case 1695391565:
                if (name.equals("Awesome Pine")) {
                    return awesomePine();
                }
                break;
            case 1710511896:
                if (name.equals("Happy Unicorn")) {
                    return happyUnicorn();
                }
                break;
            case 1721233960:
                if (name.equals("Morpheus Den")) {
                    return morpheusDen();
                }
                break;
            case 1725233508:
                if (name.equals("Light Blue")) {
                    return lightBlue();
                }
                break;
            case 1739604118:
                if (name.equals("Dense Water")) {
                    return denseWater();
                }
                break;
            case 1796166149:
                if (name.equals("Party Bliss")) {
                    return partyBliss();
                }
                break;
            case 1932825012:
                if (name.equals("Gentle Care")) {
                    return gentleCare();
                }
                break;
            case 1955932944:
                if (name.equals("Summer Games")) {
                    return summerGames();
                }
                break;
            case 1957628050:
                if (name.equals("Fabled Sunset")) {
                    return fabledSunset();
                }
                break;
            case 2027789240:
                if (name.equals("Millennium Pine")) {
                    return millenniumPine();
                }
                break;
            case 2028233951:
                if (name.equals("Ripe Malinka")) {
                    return ripeMalinka();
                }
                break;
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable flyHigh() {
        return INSTANCE.a("Fly High", -90.0d, new int[]{Color.parseColor("#48c6ef"), Color.parseColor("#6f86d6")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable flyingLemon() {
        return INSTANCE.a("Flying Lemon", -30.0d, new int[]{Color.parseColor("#64b3f4"), Color.parseColor("#c2e59c")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable forestInei() {
        return INSTANCE.a("Forest Inei", -90.0d, new int[]{Color.parseColor("#df89b5"), Color.parseColor("#bfd9fe")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable forumButton() {
        Gradients gradients = INSTANCE;
        MacroDroidApplication macroDroidApplication = f16111a;
        return gradients.a("Forum Button", -90.0d, new int[]{ContextCompat.getColor(macroDroidApplication, R.color.home_forum_gradient_1), ContextCompat.getColor(macroDroidApplication, R.color.home_forum_gradient_2)}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable freshMilk() {
        return INSTANCE.a("Fresh Milk", -90.0d, new int[]{Color.parseColor("#feada6"), Color.parseColor("#f5efef")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable freshOasis() {
        return INSTANCE.a("Fresh Oasis", -315.0d, new int[]{Color.parseColor("#7DE2FC"), Color.parseColor("#B9B6E5")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable frozenBerry() {
        return INSTANCE.a("Frozen Berry", -90.0d, new int[]{Color.parseColor("#e8198b"), Color.parseColor("#c7eafd")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable frozenDreams() {
        return INSTANCE.a("Frozen Dreams", -90.0d, new int[]{Color.parseColor("#fdcbf1"), Color.parseColor("#fdcbf1"), Color.parseColor("#e6dee9")}, new float[]{0.0f, 0.01f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable frozenHeat() {
        return INSTANCE.a("Frozen Heat", -315.0d, new int[]{Color.parseColor("#FF057C"), Color.parseColor("#7C64D5"), Color.parseColor("#4CC3FF")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable fruitBlend() {
        return INSTANCE.a("Fruit Blend", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#f9d423"), Color.parseColor("#ff4e50")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable gagarinView() {
        return INSTANCE.a("Gagarin View", -315.0d, new int[]{Color.parseColor("#69EACB"), Color.parseColor("#EACCF8"), Color.parseColor("#6654F1")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable gentleCare() {
        return INSTANCE.a("Gentle Care", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#ffc3a0"), Color.parseColor("#ffafbd")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable glassWater() {
        return INSTANCE.a("Glass Water", -90.0d, new int[]{Color.parseColor("#dfe9f3"), Color.parseColor("white")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable grassShampoo() {
        return INSTANCE.a("Grass Shampoo", -315.0d, new int[]{Color.parseColor("#DFFFCD"), Color.parseColor("#90F9C4"), Color.parseColor("#39F3BB")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable greatWhale() {
        return INSTANCE.a("Great Whale", -90.0d, new int[]{Color.parseColor("#a3bded"), Color.parseColor("#6991c7")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable grownEarly() {
        return INSTANCE.a("Grown Early", -90.0d, new int[]{Color.parseColor("#0ba360"), Color.parseColor("#3cba92")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable happyAcid() {
        return INSTANCE.a("Happy Acid", -90.0d, new int[]{Color.parseColor("#37ecba"), Color.parseColor("#72afd3")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable happyFisher() {
        return INSTANCE.a("Happy Fisher", 30.0d, new int[]{Color.parseColor("#89f7fe"), Color.parseColor("#66a6ff")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable happyMemories() {
        return INSTANCE.a("Happy Memories", -150.0d, new int[]{Color.parseColor("#ff5858"), Color.parseColor("#f09819")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable happyUnicorn() {
        return INSTANCE.a("Happy Unicorn", -90.0d, new int[]{Color.parseColor("#b3ffab"), Color.parseColor("#12fff7")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable healthyWater() {
        return INSTANCE.a("Healthy Water", -30.0d, new int[]{Color.parseColor("#96deda"), Color.parseColor("#50c9c3")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable heavenPeach() {
        return INSTANCE.a("Heaven Peach", -90.0d, new int[]{Color.parseColor("#d9afd9"), Color.parseColor("#97d9e1")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable heavyRain() {
        return INSTANCE.a("Heavy Rain", -90.0d, new int[]{Color.parseColor("#cfd9df"), Color.parseColor("#e2ebf0")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable hiddenJaguar() {
        return INSTANCE.a("Hidden Jaguar", -90.0d, new int[]{Color.parseColor("#0fd850"), Color.parseColor("#f9f047")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable highFlight() {
        return INSTANCE.a("High Flight", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#0acffe"), Color.parseColor("#495aff")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable itmeoBranding() {
        return INSTANCE.a("Itmeo Branding", 90.0d, new int[]{Color.parseColor("#2af598"), Color.parseColor("#009efd")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable japanBlush() {
        return INSTANCE.a("Japan Blush", -110.0d, new int[]{Color.parseColor("#ddd6f3"), Color.parseColor("#faaca8"), Color.parseColor("#faaca8")}, new float[]{0.0f, 1.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable juicyCake() {
        return INSTANCE.a("Juicy Cake", -90.0d, new int[]{Color.parseColor("#e14fad"), Color.parseColor("#f9d423")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable juicyPeach() {
        return INSTANCE.a("Juicy Peach", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#ffecd2"), Color.parseColor("#fcb69f")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable jungleDay() {
        return INSTANCE.a("Jungle Day", -45.0d, new int[]{Color.parseColor("#8baaaa"), Color.parseColor("#ae8b9c")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable kindSteel() {
        return INSTANCE.a("Kind Steel", -110.0d, new int[]{Color.parseColor("#e9defa"), Color.parseColor("#fbfcdb")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable ladogaBottom() {
        return INSTANCE.a("Ladoga Bottom", -90.0d, new int[]{Color.parseColor("#ebc0fd"), Color.parseColor("#d9ded8")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable ladyLips() {
        return INSTANCE.a("Lady Lips", -90.0d, new int[]{Color.parseColor("#ff9a9e"), Color.parseColor("#fecfef"), Color.parseColor("#fecfef")}, new float[]{0.0f, 0.99f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable landingAircraft() {
        return INSTANCE.a("Landing Aircraft", -315.0d, new int[]{Color.parseColor("#5D9FFF"), Color.parseColor("#B8DCFF"), Color.parseColor("#6BBBFF")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable leCocktail() {
        return INSTANCE.a("Le Cocktail", -45.0d, new int[]{Color.parseColor("#874da2"), Color.parseColor("#c43a30")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable lemonGate() {
        return INSTANCE.a("Lemon Gate", -90.0d, new int[]{Color.parseColor("#96fbc4"), Color.parseColor("#f9f586")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable lightBlue() {
        return INSTANCE.a("Light Blue", -315.0d, new int[]{Color.parseColor("#9EFBD3"), Color.parseColor("#57E9F2"), Color.parseColor("#45D4FB")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable lilyMeadow() {
        return INSTANCE.a("Lily Meadow", -315.0d, new int[]{Color.parseColor("#65379B"), Color.parseColor("#886AEA"), Color.parseColor("#6457C6")}, new float[]{0.0f, 0.53f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable listButton() {
        Gradients gradients = INSTANCE;
        MacroDroidApplication macroDroidApplication = f16111a;
        return gradients.a("List Button", -90.0d, new int[]{ContextCompat.getColor(macroDroidApplication, R.color.home_macros_gradient_1), ContextCompat.getColor(macroDroidApplication, R.color.home_macros_gradient_2)}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable loveKiss() {
        return INSTANCE.a("Love Kiss", -90.0d, new int[]{Color.parseColor("#ff0844"), Color.parseColor("#ffb199")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable magicLake() {
        return INSTANCE.a("Magic Lake", -90.0d, new int[]{Color.parseColor("#d5dee7"), Color.parseColor("#ffafbd"), Color.parseColor("#c9ffbf")}, new float[]{0.0f, 0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable magicRay() {
        return INSTANCE.a("Magic Ray", -315.0d, new int[]{Color.parseColor("#FF3CAC"), Color.parseColor("#562B7C"), Color.parseColor("#2B86C5")}, new float[]{0.0f, 0.52f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable malibuBeach() {
        return INSTANCE.a("Malibu Beach", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#4facfe"), Color.parseColor("#00f2fe")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable marbleWall() {
        return INSTANCE.a("Marble Wall", -90.0d, new int[]{Color.parseColor("#bdc2e8"), Color.parseColor("#bdc2e8"), Color.parseColor("#e6dee9")}, new float[]{0.0f, 0.01f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable marsParty() {
        return INSTANCE.a("Mars Party", -90.0d, new int[]{Color.parseColor("#5f72bd"), Color.parseColor("#9b23ea")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable meanFruit() {
        return INSTANCE.a("Mean Fruit", 30.0d, new int[]{Color.parseColor("#fccb90"), Color.parseColor("#d57eeb")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable midnightBloom() {
        return INSTANCE.a("Midnight Bloom", -110.0d, new int[]{Color.parseColor("#2b5876"), Color.parseColor("#4e4376")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable millenniumPine() {
        return INSTANCE.a("Millennium Pine", -90.0d, new int[]{Color.parseColor("#50cc7f"), Color.parseColor("#f5d100")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable mindCrawl() {
        return INSTANCE.a("Mind Crawl", -315.0d, new int[]{Color.parseColor("#473B7B"), Color.parseColor("#3584A7"), Color.parseColor("#30D2BE")}, new float[]{0.0f, 0.51f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable mixedHopes() {
        return INSTANCE.a("Mixed Hopes", -90.0d, new int[]{Color.parseColor("#c471f5"), Color.parseColor("#fa71cd")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable moleHall() {
        return INSTANCE.a("Mole Hall", -110.0d, new int[]{Color.parseColor("#616161"), Color.parseColor("#9bc5c3")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable morningSalad() {
        return INSTANCE.a("Morning Salad", -315.0d, new int[]{Color.parseColor("#B7F8DB"), Color.parseColor("#50A7C2")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable morpheusDen() {
        return INSTANCE.a("Morpheus Den", -90.0d, new int[]{Color.parseColor("#30cfd0"), Color.parseColor("#330867")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable mountainRock() {
        return INSTANCE.a("Mountain Rock", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#868f96"), Color.parseColor("#596164")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final List<String> names() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Warm Flame", "Night Fade", "Spring Warmth", "Juicy Peach", "Young Passion", "Lady Lips", "Sunny Morning", "Rainy Ashville", "Frozen Dreams", "Winter Neva", "Dusty Grass", "Tempting Azure", "Heavy Rain", "Amy Crisp", "Mean Fruit", "Deep Blue", "Ripe Malinka", "Cloudy Knoxville", "Malibu Beach", "New Life", "True Sunset", "Morpheus Den", "Rare Wind", "Near Moon", "Wild Apple", "Saint Petersburg", "Plum Plate", "Everlasting Sky", "Happy Fisher", "Blessing", "Sharpeye Eagle", "Ladoga Bottom", "Lemon Gate", "Itmeo Branding", "Zeus Miracle", "Old Hat", "Star Wine", "Happy Acid", "Awesome Pine", "New York", "Shy Rainbow", "Mixed Hopes", "Fly High", "Strong Bliss", "Fresh Milk", "Snow Again", "February Ink", "Kind Steel", "Soft Grass", "Grown Early", "Sharp Blues", "Shady Water", "Dirty Beauty", "Great Whale", "Teen Notebook", "Polite Rumors", "Sweet Period", "Wide Matrix", "Soft Cherish", "Red Salvation", "Burning Spring", "Night Party", "Sky Glider", "Heaven Peach", "Purple Division", "Aqua Splash", "Spiky Naga", "Love Kiss", "Clean Mirror", "Premium Dark", "Cold Evening", "Cochiti Lake", "Summer Games", "Passionate Bed", "Mountain Rock", "Desert Hump", "Jungle Day", "Phoenix Start", "October Silence", "Faraway River", "Alchemist Lab", "Over Sun", "Premium White", "Mars Party", "Eternal Constance", "Japan Blush", "Smiling Rain", "Cloudy Apple", "Big Mango", "Healthy Water", "Amour Amour", "Risky Concrete", "Strong Stick", "Vicious Stance", "Palo Alto", "Happy Memories", "Midnight Bloom", "Crystalline", "Party Bliss", "Confident Cloud", "Le Cocktail", "River City", "Frozen Berry", "Child Care", "Flying Lemon", "New Retrowave", "Hidden Jaguar", "Above The Sky", "Nega", "Dense Water", "Seashore", "Marble Wall", "Cheerful Caramel", "Night Sky", "Magic Lake", "Young Grass", "Colorful Peach", "Gentle Care", "Plum Bath", "Happy Unicorn", "African Field", "Solid Stone", "Orange Juice", "Glass Water", "North Miracle", "Fruit Blend", "Millennium Pine", "High Flight", "Mole Hall", "Space Shift", "Forest Inei", "Royal Garden", "Rich Metal", "Juicy Cake", "Smart Indigo", "Sand Strike", "Norse Beauty", "Aqua Guidance", "Sun Veggie", "Sea Lord", "Black Sea", "Grass Shampoo", "Landing Aircraft", "Witch Dance", "Sleepless Night", "Angel Care", "Crystal River", "Soft Lipstick", "Salt Mountain", "Perfect White", "Fresh Oasis", "Strict November", "Morning Salad", "Deep Relief", "Sea Strike", "Night Call", "Supreme Sky", "Light Blue", "Mind Crawl", "Lily Meadow", "Sugar Lollipop", "Sweet Dessert", "Magic Ray", "Teen Party", "Frozen Heat", "Gagarin View", "Fabled Sunset", "Perfect Blue"});
        return listOf;
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable nearMoon() {
        return INSTANCE.a("Near Moon", -90.0d, new int[]{Color.parseColor("#5ee7df"), Color.parseColor("#b490ca")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable nega() {
        return INSTANCE.a("Nega", -45.0d, new int[]{Color.parseColor("#ee9ca7"), Color.parseColor("#ffdde1")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable newLife() {
        return INSTANCE.a("New Life", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#43e97b"), Color.parseColor("#38f9d7")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable newRetrowave() {
        return INSTANCE.a("New Retrowave", -90.0d, new int[]{Color.parseColor("#3b41c5"), Color.parseColor("#a981bb"), Color.parseColor("#ffc8a9")}, new float[]{0.0f, 0.49f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable newYork() {
        return INSTANCE.a("New York", -90.0d, new int[]{Color.parseColor("#fff1eb"), Color.parseColor("#ace0f9")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable nightCall() {
        return INSTANCE.a("Night Call", -315.0d, new int[]{Color.parseColor("#AC32E4"), Color.parseColor("#7918F2"), Color.parseColor("#4801FF")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable nightFade() {
        return INSTANCE.a("Night Fade", -90.0d, new int[]{Color.parseColor("#a18cd1"), Color.parseColor("#fbc2eb")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable nightParty() {
        return INSTANCE.a("Night Party", -90.0d, new int[]{Color.parseColor("#0250c5"), Color.parseColor("#d43f8d")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable nightSky() {
        return INSTANCE.a("Night Sky", -90.0d, new int[]{Color.parseColor("#1e3c72"), Color.parseColor("#1e3c72"), Color.parseColor("#2a5298")}, new float[]{0.0f, 0.01f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable norseBeauty() {
        return INSTANCE.a("Norse Beauty", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#ec77ab"), Color.parseColor("#7873f5")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable northMiracle() {
        return INSTANCE.a("North Miracle", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#00dbde"), Color.parseColor("#fc00ff")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable octoberSilence() {
        return INSTANCE.a("October Silence", -110.0d, new int[]{Color.parseColor("#b721ff"), Color.parseColor("#21d4fd")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable oldHat() {
        return INSTANCE.a("Old Hat", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#e4afcb"), Color.parseColor("#b8cbb8"), Color.parseColor("#b8cbb8"), Color.parseColor("#e2c58b"), Color.parseColor("#c2ce9c"), Color.parseColor("#7edbdc")}, new float[]{0.0f, 0.0f, 0.0f, 0.3f, 0.64f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable orangeJuice() {
        return INSTANCE.a("Orange Juice", -110.0d, new int[]{Color.parseColor("#fc6076"), Color.parseColor("#ff9a44")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable overSun() {
        return INSTANCE.a("Over Sun", -30.0d, new int[]{Color.parseColor("#abecd6"), Color.parseColor("#fbed96")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable paloAlto() {
        return INSTANCE.a("Palo Alto", -150.0d, new int[]{Color.parseColor("#16a085"), Color.parseColor("#f4d03f")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable partyBliss() {
        return INSTANCE.a("Party Bliss", -90.0d, new int[]{Color.parseColor("#4481eb"), Color.parseColor("#04befe")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable passionateBed() {
        return INSTANCE.a("Passionate Bed", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#ff758c"), Color.parseColor("#ff7eb3")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable perfectBlue() {
        return INSTANCE.a("Perfect Blue", -315.0d, new int[]{Color.parseColor("#3D4E81"), Color.parseColor("#5753C9"), Color.parseColor("#6E7FF3")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable perfectWhite() {
        return INSTANCE.a("Perfect White", -315.0d, new int[]{Color.parseColor("#E3FDF5"), Color.parseColor("#FFE6FA")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable phoenixStart() {
        return INSTANCE.a("Phoenix Start", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#f83600"), Color.parseColor("#f9d423")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable plumBath() {
        return INSTANCE.a("Plum Bath", -90.0d, new int[]{Color.parseColor("#cc208e"), Color.parseColor("#6713d2")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable plumPlate() {
        return INSTANCE.a("Plum Plate", 45.0d, new int[]{Color.parseColor("#667eea"), Color.parseColor("#764ba2")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable politeRumors() {
        return INSTANCE.a("Polite Rumors", -90.0d, new int[]{Color.parseColor("#a7a6cb"), Color.parseColor("#8989ba"), Color.parseColor("#8989ba")}, new float[]{0.0f, 0.52f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable premiumDark() {
        return INSTANCE.a("Premium Dark", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#434343"), Color.parseColor("black")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable premiumWhite() {
        return INSTANCE.a("Premium White", -90.0d, new int[]{Color.parseColor("#d5d4d0"), Color.parseColor("#d5d4d0"), Color.parseColor("#eeeeec"), Color.parseColor("#efeeec"), Color.parseColor("#e9e9e7")}, new float[]{0.0f, 0.01f, 0.31f, 0.75f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable purpleDivision() {
        return INSTANCE.a("Purple Division", -90.0d, new int[]{Color.parseColor("#7028e4"), Color.parseColor("#e5b2ca")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable rainyAshville() {
        return INSTANCE.a("Rainy Ashville", -90.0d, new int[]{Color.parseColor("#fbc2eb"), Color.parseColor("#a6c1ee")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable rareWind() {
        return INSTANCE.a("Rare Wind", -90.0d, new int[]{Color.parseColor("#a8edea"), Color.parseColor("#fed6e3")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable redSalvation() {
        return INSTANCE.a("Red Salvation", -90.0d, new int[]{Color.parseColor("#f43b47"), Color.parseColor("#453a94")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable richMetal() {
        return INSTANCE.a("Rich Metal", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#d7d2cc"), Color.parseColor("#304352")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable ripeMalinka() {
        return INSTANCE.a("Ripe Malinka", 30.0d, new int[]{Color.parseColor("#f093fb"), Color.parseColor("#f5576c")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable riskyConcrete() {
        return INSTANCE.a("Risky Concrete", -90.0d, new int[]{Color.parseColor("#c4c5c7"), Color.parseColor("#dcdddf"), Color.parseColor("#ebebeb")}, new float[]{0.0f, 0.52f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable riverCity() {
        return INSTANCE.a("River City", -90.0d, new int[]{Color.parseColor("#4481eb"), Color.parseColor("#04befe")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable royalGarden() {
        return INSTANCE.a("Royal Garden", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#ed6ea0"), Color.parseColor("#ec8c69")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable saintPetersburg() {
        return INSTANCE.a("Saint Petersburg", 45.0d, new int[]{Color.parseColor("#f5f7fa"), Color.parseColor("#c3cfe2")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable saltMountain() {
        return INSTANCE.a("Salt Mountain", -315.0d, new int[]{Color.parseColor("#FFFEFF"), Color.parseColor("#D7FFFE")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sandStrike() {
        return INSTANCE.a("Sand Strike", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#c1c161"), Color.parseColor("#c1c161"), Color.parseColor("#d4d4b1")}, new float[]{0.0f, 0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable seaLord() {
        return INSTANCE.a("Sea Lord", -315.0d, new int[]{Color.parseColor("#2CD8D5"), Color.parseColor("#C5C1FF"), Color.parseColor("#FFBAC3")}, new float[]{0.0f, 0.56f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable seaStrike() {
        return INSTANCE.a("Sea Strike", -315.0d, new int[]{Color.parseColor("#77FFD2"), Color.parseColor("#6297DB"), Color.parseColor("#1EECFF")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable seashore() {
        return INSTANCE.a("Seashore", -90.0d, new int[]{Color.parseColor("#209cff"), Color.parseColor("#68e0cf")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable settingsButton() {
        Gradients gradients = INSTANCE;
        MacroDroidApplication macroDroidApplication = f16111a;
        return gradients.a("Settings Button", -90.0d, new int[]{ContextCompat.getColor(macroDroidApplication, R.color.home_settings_gradient_1), ContextCompat.getColor(macroDroidApplication, R.color.home_settings_gradient_2)}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable shadyWater() {
        return INSTANCE.a("Shady Water", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#74ebd5"), Color.parseColor("#9face6")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sharpBlues() {
        return INSTANCE.a("Sharp Blues", -90.0d, new int[]{Color.parseColor("#00c6fb"), Color.parseColor("#005bea")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sharpeyeEagle() {
        return INSTANCE.a("Sharpeye Eagle", -90.0d, new int[]{Color.parseColor("#9890e3"), Color.parseColor("#b1f4cf")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable shyRainbow() {
        return INSTANCE.a("Shy Rainbow", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#eea2a2"), Color.parseColor("#bbc1bf"), Color.parseColor("#57c6e1"), Color.parseColor("#b49fda"), Color.parseColor("#7ac5d8")}, new float[]{0.0f, 0.19f, 0.42f, 0.79f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable skyGlider() {
        return INSTANCE.a("Sky Glider", -90.0d, new int[]{Color.parseColor("#88d3ce"), Color.parseColor("#6e45e2")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sleeplessNight() {
        return INSTANCE.a("Sleepless Night", -315.0d, new int[]{Color.parseColor("#5271C4"), Color.parseColor("#B19FFF"), Color.parseColor("#ECA1FE")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable smartIndigo() {
        return INSTANCE.a("Smart Indigo", -90.0d, new int[]{Color.parseColor("#b224ef"), Color.parseColor("#7579ff")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable smilingRain() {
        return INSTANCE.a("Smiling Rain", -110.0d, new int[]{Color.parseColor("#dcb0ed"), Color.parseColor("#99c99c")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable snowAgain() {
        return INSTANCE.a("Snow Again", -90.0d, new int[]{Color.parseColor("#e6e9f0"), Color.parseColor("#eef1f5")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable softCherish() {
        return INSTANCE.a("Soft Cherish", -90.0d, new int[]{Color.parseColor("#dbdcd7"), Color.parseColor("#dddcd7"), Color.parseColor("#e2c9cc"), Color.parseColor("#e7627d"), Color.parseColor("#b8235a"), Color.parseColor("#801357"), Color.parseColor("#3d1635"), Color.parseColor("#1c1a27")}, new float[]{0.0f, 0.24f, 0.3f, 0.46f, 0.59f, 0.71f, 0.84f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable softGrass() {
        return INSTANCE.a("Soft Grass", -90.0d, new int[]{Color.parseColor("#c1dfc4"), Color.parseColor("#deecdd")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable softLipstick() {
        return INSTANCE.a("Soft Lipstick", -315.0d, new int[]{Color.parseColor("#B6CEE8"), Color.parseColor("#F578DC")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable solidStone() {
        return INSTANCE.a("Solid Stone", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#243949"), Color.parseColor("#517fa4")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable spaceShift() {
        return INSTANCE.a("Space Shift", -30.0d, new int[]{Color.parseColor("#3d3393"), Color.parseColor("#2b76b9"), Color.parseColor("#2cacd1"), Color.parseColor("#35eb93")}, new float[]{0.0f, 0.37f, 0.65f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable spikyNaga() {
        return INSTANCE.a("Spiky Naga", -90.0d, new int[]{Color.parseColor("#505285"), Color.parseColor("#585e92"), Color.parseColor("#65689f"), Color.parseColor("#7474b0"), Color.parseColor("#7e7ebb"), Color.parseColor("#8389c7"), Color.parseColor("#9795d4"), Color.parseColor("#a2a1dc"), Color.parseColor("#b5aee4")}, new float[]{0.0f, 0.12f, 0.25f, 0.37f, 0.5f, 0.62f, 0.75f, 0.87f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable springWarmth() {
        return INSTANCE.a("Spring Warmth", -90.0d, new int[]{Color.parseColor("#fad0c4"), Color.parseColor("#fad0c4"), Color.parseColor("#ffd1ff")}, new float[]{0.0f, 0.01f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable starWine() {
        return INSTANCE.a("Star Wine", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#b8cbb8"), Color.parseColor("#b8cbb8"), Color.parseColor("#b465da"), Color.parseColor("#cf6cc9"), Color.parseColor("#ee609c"), Color.parseColor("#ee609c")}, new float[]{0.0f, 0.0f, 0.0f, 0.33f, 0.66f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable strictNovember() {
        return INSTANCE.a("Strict November", -315.0d, new int[]{Color.parseColor("#CBBACC"), Color.parseColor("#2580B3")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable strongBliss() {
        return INSTANCE.a("Strong Bliss", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#f78ca0"), Color.parseColor("#f9748f"), Color.parseColor("#fd868c"), Color.parseColor("#fe9a8b")}, new float[]{0.0f, 0.19f, 0.6f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable strongStick() {
        return INSTANCE.a("Strong Stick", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#a8caba"), Color.parseColor("#5d4157")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sugarLollipop() {
        return INSTANCE.a("Sugar Lollipop", -315.0d, new int[]{Color.parseColor("#A445B2"), Color.parseColor("#D41872"), Color.parseColor("#FF0066")}, new float[]{0.0f, 0.52f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable summerGames() {
        return INSTANCE.a("Summer Games", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#92fe9d"), Color.parseColor("#00c9ff")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sunVeggie() {
        return INSTANCE.a("Sun Veggie", -315.0d, new int[]{Color.parseColor("#20E2D7"), Color.parseColor("#F9FEA5")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sunnyMorning() {
        return INSTANCE.a("Sunny Morning", 30.0d, new int[]{Color.parseColor("#f6d365"), Color.parseColor("#fda085")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable supremeSky() {
        return INSTANCE.a("Supreme Sky", -315.0d, new int[]{Color.parseColor("#D4FFEC"), Color.parseColor("#57F2CC"), Color.parseColor("#4596FB")}, new float[]{0.0f, 0.48f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sweetDessert() {
        return INSTANCE.a("Sweet Dessert", -315.0d, new int[]{Color.parseColor("#7742B2"), Color.parseColor("#F180FF"), Color.parseColor("#FD8BD9")}, new float[]{0.0f, 0.52f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable sweetPeriod() {
        return INSTANCE.a("Sweet Period", -90.0d, new int[]{Color.parseColor("#3f51b1"), Color.parseColor("#5a55ae"), Color.parseColor("#7b5fac"), Color.parseColor("#8f6aae"), Color.parseColor("#a86aa4"), Color.parseColor("#cc6b8e"), Color.parseColor("#f18271"), Color.parseColor("#f3a469"), Color.parseColor("#f7c978")}, new float[]{0.0f, 0.13f, 0.25f, 0.38f, 0.5f, 0.62f, 0.75f, 0.87f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable teenNotebook() {
        return INSTANCE.a("Teen Notebook", -90.0d, new int[]{Color.parseColor("#9795f0"), Color.parseColor("#fbc8d4")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable teenParty() {
        return INSTANCE.a("Teen Party", -315.0d, new int[]{Color.parseColor("#FF057C"), Color.parseColor("#8D0B93"), Color.parseColor("#321575")}, new float[]{0.0f, 0.5f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable templateButton() {
        Gradients gradients = INSTANCE;
        MacroDroidApplication macroDroidApplication = f16111a;
        return gradients.a("Template Button", -90.0d, new int[]{ContextCompat.getColor(macroDroidApplication, R.color.home_template_gradient_1), ContextCompat.getColor(macroDroidApplication, R.color.home_template_gradient_2)}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable templateUser() {
        return INSTANCE.a("Template USER", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#6B6B6B"), Color.parseColor("#4E4E4E")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable temptingAzure() {
        return INSTANCE.a("Tempting Azure", 30.0d, new int[]{Color.parseColor("#84fab0"), Color.parseColor("#8fd3f4")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable trueSunset() {
        return INSTANCE.a("True Sunset", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#fa709a"), Color.parseColor("#fee140")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable viciousStance() {
        return INSTANCE.a("Vicious Stance", -30.0d, new int[]{Color.parseColor("#29323c"), Color.parseColor("#485563")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable warmFlame() {
        return INSTANCE.a("Warm Flame", -45.0d, new int[]{Color.parseColor("#ff9a9e"), Color.parseColor("#fad0c4"), Color.parseColor("#fad0c4")}, new float[]{0.0f, 0.99f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable wideMatrix() {
        return INSTANCE.a("Wide Matrix", -90.0d, new int[]{Color.parseColor("#fcc5e4"), Color.parseColor("#fda34b"), Color.parseColor("#ff7882"), Color.parseColor("#c8699e"), Color.parseColor("#7046aa"), Color.parseColor("#0c1db8"), Color.parseColor("#020f75")}, new float[]{0.0f, 0.15f, 0.35f, 0.52f, 0.71f, 0.87f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable wildApple() {
        return INSTANCE.a("Wild Apple", -90.0d, new int[]{Color.parseColor("#d299c2"), Color.parseColor("#fef9d7")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable winterNeva() {
        return INSTANCE.a("Winter Neva", 30.0d, new int[]{Color.parseColor("#a1c4fd"), Color.parseColor("#c2e9fb")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable witchDance() {
        return INSTANCE.a("Witch Dance", -315.0d, new int[]{Color.parseColor("#A8BFFF"), Color.parseColor("#884D80")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable youngGrass() {
        return INSTANCE.a("Young Grass", -90.0d, new int[]{Color.parseColor("#9be15d"), Color.parseColor("#00e3ae")}, new float[]{0.0f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable youngPassion() {
        return INSTANCE.a("Young Passion", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, new int[]{Color.parseColor("#ff8177"), Color.parseColor("#ff867a"), Color.parseColor("#ff8c7f"), Color.parseColor("#f99185"), Color.parseColor("#cf556c"), Color.parseColor("#b12a5b")}, new float[]{0.0f, 0.0f, 0.21f, 0.52f, 0.78f, 1.0f});
    }

    @JvmStatic
    @NotNull
    public static final WebGradientDrawable zeusMiracle() {
        return INSTANCE.a("Zeus Miracle", -90.0d, new int[]{Color.parseColor("#cd9cf2"), Color.parseColor("#f6f3ff")}, new float[]{0.0f, 1.0f});
    }

    @NotNull
    public final MacroDroidApplication getContext() {
        return f16111a;
    }
}
