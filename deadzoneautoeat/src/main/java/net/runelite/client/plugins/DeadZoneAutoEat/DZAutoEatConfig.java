package net.runelite.client.plugins.DeadZoneAutoEat;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;

@SuppressWarnings("unused")
@ConfigGroup("DZAutoEatConfig")
public interface DZAutoEatConfig extends Config
{
	@ConfigTitleSection(
		keyName = "skillingTitle",
		name = "Auto Eat Config",
		position = 0,
		description = ""
	)
	default Title skillingTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "clearChat",
		name = "Clear Chat Key",
		description = "Automatically removes typed key from chat when the hotkey is pressed",
		position = 0,
		titleSection = "skillingTitle"
	)
	default boolean clearChat()
	{
		return true;
	}

	@ConfigItem(
		keyName = "skillingMethod",
		name = "Eat Amount",
		position = 1,
		description = "Determine how much food to eat within a single tick",
		titleSection = "skillingTitle"
	)
	default SkillingMethod skillingMethod()
	{
		return SkillingMethod.Single;
	}

	@ConfigItem(
		keyName = "toggleKey",
		name = "Manual Key",
		description = "Press to manually eat using the selected eat amount",
		position = 2,
		titleSection = "skillingTitle"
	)
	default Keybind toggleKey()
	{
		return new Keybind(97, 0);
	}

	@ConfigItem(
		keyName = "autoEat",
		name = "Auto Eat",
		position = 3,
		description = "Enable to automatically eat food if available",
		titleSection = "skillingTitle"
	)
	default boolean autoEat()
	{
		return true;
	}

	@ConfigItem(
		keyName = "eatInOrder",
		name = "Eat in Order (Premium)",
		position = 4,
		description = "Enable to eat the food in the provided order if available",
		titleSection = "skillingTitle"
	)
	default boolean eatInOrder()
	{
		return true;
	}

	@ConfigItem(
		keyName = "hpTheshold",
		name = "HP Threshold",
		description = "When the HP threshold is reached, it will eat food.",
		position = 5,
		titleSection = "skillingTitle"
	)
	@Range(
		min = 1,
		max = 98
	)
	default int hpThreshold()
	{
		return 20;
	}

	@ConfigItem(
		keyName = "foodID",
		name = "Food IDs",
		description = "Enter the IDs of the food to Auto Eat",
		position = 6,
		titleSection = "skillingTitle"
	)
	default String foodID()
	{
		return "";
	}

	@ConfigTitleSection(
		keyName = "addSkillingTitle",
		name = "Additional Auto Config",
		position = 1,
		description = ""
	)
	default Title addSkillingTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "autoPrayerPot",
		name = "Auto Prayer Pot (Premium)",
		position = 0,
		description = "Enable to auto restore prayer using prayer pots if available",
		titleSection = "addSkillingTitle"
	)
	default boolean autoPrayerPot()
	{
		return false;
	}

	@ConfigItem(
		keyName = "prayerThreshold",
		name = "Prayer Threshold",
		description = "When Prayer threshold is reached, it will restore prayer",
		position = 1,
		titleSection = "addSkillingTitle"
	)
	@Range(
		min = 1,
		max = 98
	)
	default int prayerThreshold()
	{
		return 20;
	}

	@ConfigItem(
		keyName = "autoStaminaPot",
		name = "Auto Stamina Pot (Premium)",
		position = 2,
		description = "Enable to auto restore restore using stamina pots if available",
		titleSection = "addSkillingTitle"
	)
	default boolean autoStaminaPot()
	{
		return false;
	}

	@ConfigItem(
		keyName = "staminaThreshold",
		name = "Stamina Threshold",
		description = "When Stamina threshold is reached, it will restore stamina",
		position = 3,
		titleSection = "addSkillingTitle"
	)
	@Range(
		min = 1,
		max = 98
	)
	default int staminaThreshold()
	{
		return 20;
	}

	@ConfigTitleSection(
		keyName = "pvpTitle",
		name = "Player vs Player (Premium)",
		position = 2,
		description = ""
	)
	default Title pvpTitle()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "PVPT1Activate",
		name = "PVP T1 Activate",
		position = 0,
		description = "Determines if this threshold is active",
		titleSection = "pvpTitle"
	)
	default boolean PVPT1Activate()
	{
		return false;
	}

	@ConfigItem(
		keyName = "PVPT1Type",
		name = "T1",
		position = 1,
		description = "Determine what food to eat when HP reaches below threshold",
		titleSection = "pvpTitle"
	)
	default DZAutoEatPVP PVPT1Type()
	{
		return DZAutoEatPVP.Manta_Brew_Karambwan;
	}

	@ConfigItem(
		keyName = "PVPT1HPTheshold",
		name = "HP T1 Threshold",
		description = "When the HP threshold is exceeded, it will execute the provided action",
		position = 2,
		titleSection = "pvpTitle"
	)
	@Range(
		min = 1,
		max = 98
	)
	default int PVPT1HPTheshold()
	{
		return 20;
	}

	@ConfigItem(
		keyName = "PVPT2Activate",
		name = "PVP T2 Activate",
		position = 3,
		description = "Determines if this threshold is active",
		titleSection = "pvpTitle"
	)
	default boolean PVPT2Activate()
	{
		return false;
	}

	@ConfigItem(
		keyName = "PVPT2Type",
		name = "T2",
		position = 4,
		description = "Determine what food to eat when HP reaches below threshold",
		titleSection = "pvpTitle"
	)
	default DZAutoEatPVP PVPT2Type()
	{
		return DZAutoEatPVP.Manta_Brew;
	}

	@ConfigItem(
		keyName = "PVPT2HPTheshold",
		name = "HP T2 Threshold",
		description = "When the HP threshold is exceeded, it will execute the provided action",
		position = 5,
		titleSection = "pvpTitle"
	)
	@Range(
		min = 1,
		max = 98
	)
	default int PVPT2HPTheshold()
	{
		return 40;
	}

	@ConfigItem(
		keyName = "PVPT3Activate",
		name = "PVP T3 Activate",
		position = 6,
		description = "Determines if this threshold is active",
		titleSection = "pvpTitle"
	)
	default boolean PVPT3Activate()
	{
		return false;
	}

	@ConfigItem(
		keyName = "PVPT3Type",
		name = "T3",
		position = 7,
		description = "Determine what food to eat when HP reaches below threshold",
		titleSection = "pvpTitle"
	)
	default DZAutoEatPVP PVPT3Type()
	{
		return DZAutoEatPVP.Manta;
	}

	@ConfigItem(
		keyName = "PVPT3HPTheshold",
		name = "HP T3 Threshold",
		description = "When the HP threshold is exceeded, it will execute the provided action",
		position = 8,
		titleSection = "pvpTitle"
	)
	@Range(
		min = 1,
		max = 98
	)
	default int PVPT3HPTheshold()
	{
		return 60;
	}

	enum SkillingMethod
	{
		Single,
		Double,
		Triple
	}
}
