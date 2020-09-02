package net.runelite.client.plugins.DeadZoneAgility;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public enum DZAgilityCourse
{
	GStronghold("GStronghold", 7, 0, 1000, false, 23145, 23134, 23559, 23557, 23560, 23135, 23139),
	Draynor_Village("Draynor Village", 7, 1000, 1000, false, 11404, 11405, 11406, 11430, 11630, 11631, 11632),
	Al_Kharid("Al Kharid", 8, 20, 1200, false, 11633, 14398, 14402, 14403, 14404, 11634, 14409, 14399),
	Varrock("Varrock", 9, 30, 1000, false, 14412, 14413, 14414, 14832, 14833, 14834, 14835, 14836, 14841),
	Canifis("Canifis", 8, 40, 1000, false, 14843, 14844, 14845, 14848, 14846, 14894, 14847, 14897),
	Falador("Falador", 13, 50, 1000, false, 14898, 14899, 14901, 14903, 14904, 14905, 14911, 14919, 14920, 14921, 14922, 14924, 14925),
	Seers("Seers", 6, 60, 1000, false, 14927, 14928, 14932, 14929, 14930, 14931),
	Pollnivneach("Pollnivneach", 9, 70, 1000, false, 14935, 14936, 14937, 14938, 14939, 14940, 14941, 14944, 14945),
	Rellekka("Relleka", 7, 80, 1000, false, 14946, 14947, 14987, 14990, 14991, 14992, 14994),
	Ardougne("Ardougne", 7, 90, 500, false, 15608, 15609, 26635, 15610, 15611, 28912, 15612);

	private final String name;
	private final int steps;
	private final int agilityLevel;
	private final int markPickupDistance;
	private final boolean markSightCheck;
	private final int[] objs;

	DZAgilityCourse(final String name, final int steps, final int agilityLevel, final int markPickupDistance, final boolean markSightCheck, final int... objs)
	{
		this.name = name;
		this.agilityLevel = agilityLevel;
		this.steps = steps;
		this.markPickupDistance = markPickupDistance;
		this.markSightCheck = markSightCheck;
		this.objs = objs;
	}
}
