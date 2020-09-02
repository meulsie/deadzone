package net.runelite.client.plugins.DeadZoneAPI;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.annotation.Nullable;
import net.runelite.api.widgets.WidgetInfo;

@SuppressWarnings("unused")
public enum DeadZonePrayerMap
{
	THICK_SKIN("Thick Skin", WidgetInfo.PRAYER_THICK_SKIN, 35454981),
	BURST_OF_STRENGTH("Burst of Strength", WidgetInfo.PRAYER_BURST_OF_STRENGTH, 35454982),
	CLARITY_OF_THOUGHT("Clarity of Thought", WidgetInfo.PRAYER_CLARITY_OF_THOUGHT, 35454983),
	SHARP_EYE("Sharp Eye", WidgetInfo.PRAYER_SHARP_EYE, 35454999),
	MYSTIC_WILL("Mystic Will", WidgetInfo.PRAYER_MYSTIC_WILL, 35455000),
	ROCK_SKIN("Rock Skin", WidgetInfo.PRAYER_ROCK_SKIN, 35454984),
	SUPERHUMAN_STRENGTH("Superhuman Strength", WidgetInfo.PRAYER_SUPERHUMAN_STRENGTH, 35454985),
	IMPROVED_REFLEXES("Improved Reflexes", WidgetInfo.PRAYER_IMPROVED_REFLEXES, 35454986),
	RAPID_RESTORE("Rapid Restore", WidgetInfo.PRAYER_RAPID_RESTORE, 35454987),
	RAPID_HEAL("Rapid Heal", WidgetInfo.PRAYER_RAPID_HEAL, 35454988),
	PROTECT_ITEM("Protect Item", WidgetInfo.PRAYER_PROTECT_ITEM, 35454989),
	HAWK_EYE("Hawk Eye", WidgetInfo.PRAYER_HAWK_EYE, 35455001),
	MYSTIC_LORE("Mystic Lore", WidgetInfo.PRAYER_MYSTIC_LORE, 35455002),
	STEEL_SKIN("Steel Skin", WidgetInfo.PRAYER_STEEL_SKIN, 35454990),
	ULTIMATE_STRENGTH("Ultimate Strength", WidgetInfo.PRAYER_ULTIMATE_STRENGTH, 35454991),
	INCREDIBLE_REFLEXES("Incredible Reflexes", WidgetInfo.PRAYER_INCREDIBLE_REFLEXES, 35454992),
	PROTECT_FROM_MAGIC("Protect from Magic", WidgetInfo.PRAYER_PROTECT_FROM_MAGIC, 35454993),
	PROTECT_FROM_MISSILES("Protect from Missiles", WidgetInfo.PRAYER_PROTECT_FROM_MISSILES, 35454994),
	PROTECT_FROM_MELEE("Protect from Melee", WidgetInfo.PRAYER_PROTECT_FROM_MELEE, 35454995),
	EAGLE_EYE("Eagle Eye", WidgetInfo.PRAYER_EAGLE_EYE, 35455003),
	MYSTIC_MIGHT("Mystic Might", WidgetInfo.PRAYER_MYSTIC_MIGHT, 35455004),
	RETRIBUTION("Retribution", WidgetInfo.PRAYER_RETRIBUTION, 35454996),
	REDEMPTION("Redemption", WidgetInfo.PRAYER_REDEMPTION, 35454997),
	SMITE("Smite", WidgetInfo.PRAYER_SMITE, 35454998),
	CHIVALRY("Chivalry", WidgetInfo.PRAYER_CHIVALRY, 35455005),
	PIETY("Piety", WidgetInfo.PRAYER_PIETY, 35455006),
	PRESERVE("Preserve", WidgetInfo.PRAYER_PRESERVE, 35455009),
	RIGOUR("Rigour", WidgetInfo.PRAYER_RIGOUR, 35455007),
	AUGURY("Augury", WidgetInfo.PRAYER_AUGURY, 35455008);

	public final String prayerName;
	public final WidgetInfo widgetInfo;
	public final int entry;
	public static final Map<String, WidgetInfo> map;

	@Nullable
	public static WidgetInfo getWidgetInfo(final String prayer)
	{
		return map.getOrDefault(prayer, null);
	}

	public final String getPrayerName()
	{
		return this.prayerName;
	}

	public final int getEntry()
	{
		return this.entry;
	}

	DeadZonePrayerMap(final String name, final WidgetInfo info, final int entryParam)
	{
		this.prayerName = name;
		this.widgetInfo = info;
		this.entry = entryParam;
	}

	static
	{
		final Builder<String, WidgetInfo> builder = ImmutableMap.builder();

		for (final DeadZonePrayerMap prayer : values())
		{
			builder.put(prayer.getPrayerName(), prayer.widgetInfo);
		}

		map = builder.build();
	}
}
