package net.runelite.client.plugins.DeadZoneAutoEat;

import lombok.Getter;

@SuppressWarnings("unused")
public enum DZAutoEatPVP
{
	Brew(1, 6691, 6689, 6687, 6685, 23575, 23577, 23579, 23581),
	Manta(1, 391),
	Shark(1, 385, 20390),
	Anglerfish(1, 13441),
	Brew_Karambwan(2, 6691, 6689, 6687, 6685, 3144, 23575, 23577, 23579, 23581, 23533),
	Manta_Brew(2, 391, 6691, 6689, 6687, 6685, 6685, 23575, 23577, 23579, 23581),
	Shark_Brew(2, 385, 20390, 6691, 6689, 6687, 6685, 23575, 23577, 23579, 23581),
	Manta_Brew_Karambwan(3, 391, 6691, 6689, 6687, 6685, 23575, 23577, 23579, 23581, 3144, 23533),
	Shark_Brew_Karambwan(3, 385, 20390, 6691, 6689, 6687, 23575, 23577, 23579, 23581, 6685, 3144, 23533);

	@Getter
	private final int totalActions;

	@Getter
	private final int[] itemIds;

	DZAutoEatPVP(final int totalActions, final int... itemIDs)
	{
		this.totalActions = totalActions;
		this.itemIds = itemIDs;
	}
}
