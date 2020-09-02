package net.runelite.client.plugins.DeadZoneAPI;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

@SuppressWarnings("unused")
public enum DeadZonePrayerRestoreTypes
{
	SUPER_RESTOREPOT(3030, 23573, 3028, 23571, 3026, 23569, 3024, 23567),
	PRAYERPOT(143, 20396, 141, 20395, 139, 20394, 2434, 20393),
	SANFEWPOT(10931, 23565, 10929, 23563, 10927, 23561, 10925, 23559),
	BELIGHTED_SUPER_RESTORE(24605, 24603, 24601, 24598);

	public static final Map<Integer, DeadZonePrayerRestoreTypes> map;
	public final int[] items;

	DeadZonePrayerRestoreTypes(final int... items)
	{
		this.items = items;
	}

	public final int[] AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		return this.items;
	}

	public static DeadZonePrayerRestoreTypes AB1CaddDEdaHI12361JKLM8NO3ka5gw(final int itemId)
	{
		return map.get(itemId);
	}

	static
	{
		final Builder<Integer, DeadZonePrayerRestoreTypes> builder = new ImmutableMap.Builder<>();

		for (final DeadZonePrayerRestoreTypes prayerRestoreType : values())
		{
			for (final int itemId : prayerRestoreType.items)
			{
				builder.put(itemId, prayerRestoreType);
			}

		}

		map = builder.build();
	}
}
