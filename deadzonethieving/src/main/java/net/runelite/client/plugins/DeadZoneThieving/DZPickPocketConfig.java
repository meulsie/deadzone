package net.runelite.client.plugins.DeadZoneThieving;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;

@SuppressWarnings("unused")
@ConfigGroup("DZPickPocket")
public interface DZPickPocketConfig extends Config
{
	@ConfigTitleSection(
		keyName = "pickPocketTitle",
		name = "Pickpocket Config",
		position = 0,
		description = ""
	)
	default Title pickPocketTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "displayInfo",
		name = "Display Info Panel",
		position = 0,
		description = "Enable to display info regarding the Thieving Helper",
		titleSection = "pickPocketTitle"
	)
	default boolean displayInfo()
	{
		return true;
	}

	@ConfigItem(
		keyName = "thievingMethod",
		name = "Method",
		position = 1,
		description = "Determine what method you will be using",
		titleSection = "pickPocketTitle"
	)
	default DZPickPocketMethods thievingMethod()
	{
		return DZPickPocketMethods.Ardy_Knights;
	}

	@ConfigItem(
		keyName = "toggleKey",
		name = "Toggle Key",
		description = "Toggles the Thieving Helper on / off",
		position = 2,
		titleSection = "pickPocketTitle"
	)
	default Keybind toggleKey()
	{
		return new Keybind(97, 0);
	}

	@ConfigItem(
		keyName = "timeout",
		name = "Timeout",
		description = "How long to run the Thieving Helper before timing out automatically",
		position = 3,
		titleSection = "pickPocketTitle"
	)
	@Range(
		min = 5,
		max = 500
	)
	default int timeout()
	{
		return 10;
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
		keyName = "skillBreaks",
		name = "Skilling Breaks",
		description = "Stops the bot from running randomly for a period of time before resuming again",
		position = 0,
		titleSection = "additionalTitle"
	)
	default boolean skillBreaks()
	{
		return true;
	}

	@ConfigItem(
		keyName = "distanceCheck",
		name = "NPC Distance Check",
		description = "How many tiles away from the player will it attempt to find an NPC",
		position = 1,
		titleSection = "additionalTitle"
	)
	default int distanceCheck()
	{
		return 10;
	}

	@ConfigItem(
		keyName = "emptyCoinPouch",
		name = "Empty Coin Pouch",
		description = "Automatically empties coin pouches during thieving",
		position = 2,
		titleSection = "additionalTitle"
	)
	default boolean emptyCoinPouch()
	{
		return true;
	}

	@ConfigItem(
		keyName = "disableWhenFull",
		name = "Disable Full Inventory",
		description = "Automatically disables the plugin when no other conditions are meet and you have a full inventory",
		position = 3,
		titleSection = "additionalTitle"
	)
	default boolean disableWhenFull()
	{
		return false;
	}

	@ConfigItem(
		keyName = "gemBag",
		name = "Fill Gem Bag",
		description = "Automatically fills your Gem Bag when using the Tzhaar Pickpocketing Method",
		position = 4,
		titleSection = "additionalTitle"
	)
	default boolean gemBag()
	{
		return false;
	}

	@ConfigItem(
		keyName = "dodgyNecklace",
		name = "Equip Dodgy Necklace",
		description = "Auto equips dodgy necklaces if they are available in your inventory",
		position = 5,
		titleSection = "additionalTitle"
	)
	default boolean dodgyNecklace()
	{
		return false;
	}

	@ConfigItem(
		keyName = "autoHeal",
		name = "Auto Heal",
		description = "Determine if the helper should automatically heal the player",
		position = 6,
		titleSection = "additionalTitle"
	)
	default boolean autoHeal()
	{
		return false;
	}

	@ConfigItem(
		keyName = "autoWithdraw",
		name = "Auto Withdraw",
		description = "Determine if the helper should automatically withdraw food from the bank if available",
		position = 7,
		titleSection = "additionalTitle"
	)
	default boolean autoWithdraw()
	{
		return false;
	}

	@ConfigItem(
		keyName = "hpTheshold",
		name = "HP Threshold",
		description = "When the HP threshold is reached, it will eat food.",
		position = 8,
		titleSection = "additionalTitle"
	)
	@Range(
		min = 2,
		max = 80
	)
	default int hpTheshold()
	{
		return 20;
	}

	@ConfigItem(
		keyName = "foodID",
		name = "Food ID",
		description = "Enter the ID of the food to heal with",
		position = 9,
		titleSection = "additionalTitle"
	)
	default String foodID()
	{
		return "";
	}

	@ConfigItem(
		keyName = "dropItems",
		name = "Drop Items",
		description = "Determine if the helper should automatically drop items",
		position = 10,
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
		position = 11,
		titleSection = "additionalTitle"
	)
	@Range(
		min = 8,
		max = 28
	)
	default int dropThreshold()
	{
		return 28;
	}

	@ConfigItem(
		keyName = "itemsToDrop",
		name = "Items to Drop",
		description = "Enter the IDs of the items you wish to drop automatically",
		position = 12,
		titleSection = "additionalTitle"
	)
	default String itemsToDrop()
	{
		return "";
	}
}
