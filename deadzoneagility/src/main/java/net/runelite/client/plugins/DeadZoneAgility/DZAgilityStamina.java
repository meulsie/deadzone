package net.runelite.client.plugins.DeadZoneAgility;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import java.util.Set;

public enum DZAgilityStamina
{
	STAMINA_POTION(12631, 12629, 12627, 12625),
	SUPER_ENERGY(3022, 3020, 3018, 3016);

	private static final Map<Integer, DZAgilityStamina> MAP;
	private final int[] itemIDs;

	DZAgilityStamina(final int... itemIDs)
	{
		this.itemIDs = itemIDs;
	}

	public final int[] AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		return this.itemIDs;
	}

	public static Set<Integer> DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		return MAP.keySet();
	}

	static
	{
		final Builder<Integer, DZAgilityStamina> builder = new ImmutableMap.Builder<>();

		for (final DZAgilityStamina dzAgilityStamina : values())
		{
			for (final int itemID : dzAgilityStamina.itemIDs)
			{
				builder.put(itemID, dzAgilityStamina);
			}
		}

		MAP = builder.build();
	}
}
