package net.runelite.client.plugins.DeadZoneHunter;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;

@SuppressWarnings("unused")
@ConfigGroup("DZHunterConfig")
public interface DZHunterConfig extends Config
{
	@ConfigTitleSection(
		keyName = "skillingTitle",
		name = "Hunter Skilling Config",
		position = 0,
		description = ""
	)
	default Title skillingTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "displayInfo",
		name = "Display Info Panel",
		position = 0,
		description = "Enable to display info regarding the Hunter Plugin",
		titleSection = "skillingTitle"
	)
	default boolean displayInfo()
	{
		return true;
	}

	@ConfigItem(
		keyName = "skillingMethod",
		name = "Method",
		position = 2,
		description = "Determine what method you will be using",
		titleSection = "skillingTitle"
	)
	default DZHunterMethods skillingMethod()
	{
		return DZHunterMethods.Red_Chins;
	}

	@ConfigItem(
		keyName = "toggleKey",
		name = "Toggle Key",
		description = "Toggles the Hunter Plugin on / off",
		position = 3,
		titleSection = "skillingTitle"
	)
	default Keybind toggleKey()
	{
		return new Keybind(97, 0);
	}

	@ConfigTitleSection(
		keyName = "additionalTitle",
		name = "Additional Config",
		position = 1,
		description = ""
	)
	default Title additionalTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "distanceCheck",
		name = "Distance Check",
		description = "How many tiles away from the player will it gather resources",
		position = 0,
		titleSection = "additionalTitle"
	)
	default int distanceCheck()
	{
		return 10;
	}

	@ConfigItem(
		keyName = "totalTraps",
		name = "Total Traps",
		description = "The total amount of hunter traps you want to use",
		position = 1,
		titleSection = "additionalTitle"
	)
	default int totalTraps()
	{
		return 4;
	}

	@ConfigItem(
		keyName = "timeout",
		name = "Skilling Timeout",
		description = "How long to run the Hunter Skilling Plugin before timing out automatically",
		position = 2,
		titleSection = "additionalTitle"
	)
	@Range(
		min = 5,
		max = 500
	)
	default int timeout()
	{
		return 10;
	}

	@ConfigItem(
		keyName = "dropItems",
		name = "Drop Items",
		description = "Determine if the helper should automatically drop items",
		position = 3,
		titleSection = "additionalTitle"
	)
	default boolean dropItems()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dropThreshold",
		name = "Drop Threshold",
		description = "When your inventory size reaches this value, it will attempt to drop provided items",
		position = 4,
		titleSection = "additionalTitle"
	)
	@Range(
		min = 10,
		max = 28
	)
	default int dropThreshold()
	{
		return 28;
	}

	@ConfigItem(
		keyName = "itemsToDrop",
		name = "Items to Drop",
		description = "Enter the ID of the items you wish to drop automatically",
		position = 5,
		titleSection = "additionalTitle"
	)
	default String itemsToDrop()
	{
		return "";
	}
}
