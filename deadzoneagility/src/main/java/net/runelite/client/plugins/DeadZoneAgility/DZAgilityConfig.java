package net.runelite.client.plugins.DeadZoneAgility;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;
import net.runelite.client.config.Units;
import net.runelite.http.api.worlds.WorldRegion;

@SuppressWarnings("unused")
@ConfigGroup("DZAgilityConfig")
public interface DZAgilityConfig extends Config
{
	@ConfigTitleSection(
		keyName = "agilityTitle",
		name = "Agility Helper Config",
		position = 0,
		description = ""
	)
	default Title agilityTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "displayInfo",
		name = "Display Info Panel",
		position = 0,
		description = "Enable to display info regarding the Agility Helper",
		titleSection = "agilityTitle"
	)
	default boolean displayInfo()
	{
		return true;
	}

	@ConfigItem(
		keyName = "agilityMethod",
		name = "Course",
		position = 1,
		description = "Determine what course you will be using",
		titleSection = "agilityTitle"
	)
	default DZAgilityCourse agilityMethod()
	{
		return DZAgilityCourse.Varrock;
	}

	@ConfigItem(
		keyName = "toggleKey",
		name = "Toggle Key",
		description = "Toggles the Agility Helper on / off",
		position = 2,
		titleSection = "agilityTitle"
	)
	default Keybind toggleKey()
	{
		return new Keybind(97, 0);
	}

	@ConfigItem(
		keyName = "timeout",
		name = "Agility Timeout",
		description = "How long to run the agility helper before timing out automatically",
		position = 3,
		titleSection = "agilityTitle"
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
		keyName = "pickupMarks",
		name = "Pickup Marks",
		description = "Determine if the helper should automatically pickup marks",
		position = 4,
		titleSection = "agilityTitle"
	)
	default boolean pickupMarks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "delayedPickup",
		name = "Delay Pickup Marks",
		description = "Determine if the helper should wait until the last five minutes before picking up marks",
		position = 5,
		titleSection = "agilityTitle"
	)
	default boolean delayedPickup()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "worldHopTitle",
		name = "World Hop Config",
		position = 1,
		description = ""
	)
	default Title worldHopTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "hopWorlds",
		name = "Auto World Hop",
		description = "Determine if the helper should automatically hop worlds",
		position = 0,
		titleSection = "worldHopTitle"
	)
	default boolean hopWorlds()
	{
		return false;
	}

	@ConfigItem(
		keyName = "worldRegion",
		name = "World Region",
		description = "Determine what region to hop to",
		position = 1,
		titleSection = "worldHopTitle"
	)
	default WorldRegion worldRegion()
	{
		return WorldRegion.UNITED_KINGDOM;
	}

	@ConfigItem(
		keyName = "hopMinDelay",
		name = "Hop Min Delay",
		description = "The minimum hop frequency delay represented in minutes",
		position = 2,
		titleSection = "worldHopTitle"
	)
	@Units(" mins")
	@Range(
		min = 10,
		max = 60
	)
	default int hopMinDelay()
	{
		return 15;
	}

	@ConfigItem(
		keyName = "hopMaxDelay",
		name = "Hop Max Delay",
		description = "The maximum hop frequency delay represented in minutes",
		position = 3,
		titleSection = "worldHopTitle"
	)
	@Units(" mins")
	@Range(
		min = 15,
		max = 75
	)
	default int hopMaxDelay()
	{
		return 25;
	}

	@ConfigTitleSection(
		keyName = "agilMoreTitle",
		name = "Additional Config",
		position = 2,
		description = ""
	)
	default Title agilMoreTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "skillBreaks",
		name = "Skilling Breaks",
		description = "Stops the bot from running randomly for a period of time before resuming again",
		position = 0,
		titleSection = "agilMoreTitle"
	)
	default boolean skillBreaks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "restoreStamina",
		name = "Restore Stamina",
		description = "Determine if the helper should automatically restore stamina",
		position = 1,
		titleSection = "agilMoreTitle"
	)
	default boolean restoreStamina()
	{
		return false;
	}

	@ConfigItem(
		keyName = "restoreStaminaThreshold",
		name = "Stamina Threshold",
		description = "When the Stamina threshold is reached, it will restore stamina.",
		position = 2,
		titleSection = "agilMoreTitle"
	)
	@Range(
		min = 40,
		max = 75
	)
	default int restoreStaminaThreshold()
	{
		return 60;
	}

	@ConfigItem(
		keyName = "autoHeal",
		name = "Auto Eat",
		description = "Determine if the helper should automatically heal the player",
		position = 3,
		titleSection = "agilMoreTitle"
	)
	default boolean autoHeal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "foodID",
		name = "Food ID",
		description = "Enter the ID of the food to heal with",
		position = 4,
		titleSection = "agilMoreTitle"
	)
	default String foodID()
	{
		return "";
	}

	@ConfigItem(
		keyName = "hpTheshold",
		name = "HP Threshold",
		description = "When the HP threshold is reached, it will eat food.",
		position = 5,
		titleSection = "agilMoreTitle"
	)
	@Range(
		min = 5,
		max = 80
	)
	default int hpTheshold()
	{
		return 20;
	}

	@ConfigItem(
		keyName = "seersTP",
		name = "Enable Seers TP",
		description = "Will automatically use the seers teleport at the end of the course",
		position = 6,
		titleSection = "agilMoreTitle"
	)
	default boolean seersTP()
	{
		return false;
	}

	@ConfigItem(
		keyName = "magicImbue",
		name = "Cast Magic Imbue",
		description = "Will automatically cast magic imbue during the agility course",
		position = 7,
		titleSection = "agilMoreTitle"
	)
	default boolean magicImbue()
	{
		return false;
	}

	@ConfigItem(
		keyName = "summerPie",
		name = "Auto Summer Pie",
		description = "Will automatically use summer pies within your inventory",
		position = 8,
		titleSection = "agilMoreTitle"
	)
	default boolean summerPie()
	{
		return false;
	}
}
