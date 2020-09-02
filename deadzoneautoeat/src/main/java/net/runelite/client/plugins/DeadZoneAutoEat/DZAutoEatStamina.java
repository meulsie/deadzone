package net.runelite.client.plugins.DeadZoneAutoEat;

import com.google.common.collect.ImmutableMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;

@SuppressWarnings("unused")
public enum DZAutoEatStamina
{
	STAMINA_POTION(12631, 12629, 12627, 12625),
	SUPER_ENERGY(3022, 3020, 3018, 3016);

	private static final Map<Integer, DZAutoEatStamina> map;
	private static final List<Integer> list;

	@Getter
	private final int[] items;

	DZAutoEatStamina(final int... items)
	{
		this.items = items;
	}

	public static Set<Integer> DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		return map.keySet();
	}

	private static DZAutoEatStamina fromItemId(final int itemId)
	{
		return map.get(itemId);
	}

	static
	{
		final ImmutableMap.Builder<Integer, DZAutoEatStamina> builder = new ImmutableMap.Builder<>();

		for (final DZAutoEatStamina staminaPot : DZAutoEatStamina.values())
		{
			for (final int itemId : DZAutoEatStamina.list)
			{
				builder.put(itemId, staminaPot);
			}
		}

		map = builder.build();

		list = new LinkedList<>();

		for (final DZAutoEatStamina staminaPot : DZAutoEatStamina.values())
		{
			for (final int itemID : staminaPot.items)
			{
				list.add(itemID);
			}
		}
	}
}
