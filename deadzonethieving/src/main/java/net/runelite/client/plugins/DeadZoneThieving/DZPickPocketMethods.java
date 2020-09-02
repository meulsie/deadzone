package net.runelite.client.plugins.DeadZoneThieving;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public enum DZPickPocketMethods
{
	Stalls("Stalls", 11734, 11733, 11732, 11731, 11730, 11729, 28823, 6945, 635),
	Farmers("Farmers", 3114, 3243, 3244, 3245, 3250, 3251),
	Ardy_Knights("Knights", 3297),
	Master_Farmers("Master Farmers", 5730, 5731),
	Blackjacking("Blackjacking", 737, 735, 3550),
	Tzhaar("Tzhaar-Hur", 2163, 2164, 7684, 7682, 7683, 7685, 7686, 7687),
	Vyrewatch("Vyrewatch", 9703, 9686, 9712, 9693, 9707, 9696, 9711, 9698, 9695, 9708, 9697, 9713, 9692, 9710, 9691, 9694, 9709, 9785, 9689, 9714, 9701, 9788, 9700, 9690, 9706, 9687, 9702, 9704, 9699, 9705),
	Elves("Elves", 9072, 9070, 9068, 9066, 9067, 9061, 9062, 9088, 9065, 9064, 9164, 9063, 9137, 9069, 9074, 9073, 9075, 9089, 9077, 9090, 9078, 9079, 90982, 9081, 9080, 9083, 9163, 9154, 9055, 9054, 9056, 9087, 9057, 9058);

	private final String name;
	private final int[] npcIDs;

	DZPickPocketMethods(final String name, final int... npcIDs)
	{
		this.name = name;
		this.npcIDs = npcIDs;
	}
}
