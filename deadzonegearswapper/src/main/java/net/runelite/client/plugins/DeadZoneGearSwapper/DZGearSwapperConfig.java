package net.runelite.client.plugins.DeadZoneGearSwapper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Title;

@SuppressWarnings("unused")
@ConfigGroup("DZGearSwapperConfig")
public interface DZGearSwapperConfig extends Config
{
	@ConfigTitleSection(
		keyName = "skillingTitle",
		name = "Gear Swapping Config",
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
		keyName = "pvpSpec",
		name = "PvP Spec Support",
		description = "Enable to add support for gear swap special attack in PvP, otherwise disable it",
		position = 1,
		titleSection = "skillingTitle"
	)
	default boolean pvpSpec()
	{
		return true;
	}

	@ConfigTitleSection(
		keyName = "gearSwap1Title",
		name = "Gear Swap One",
		position = 1,
		description = ""
	)
	default Title gearSwap1Title()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "toggleKey1",
		name = "Toggle Key",
		description = "Executes Gear Swap for configuration one",
		position = 0,
		titleSection = "gearSwap1Title"
	)
	default Keybind toggleKey1()
	{
		return new Keybind(97, 0);
	}

	@ConfigItem(
		keyName = "gearSwap1",
		name = "Gear to Swap",
		description = "Enter the IDs of the gear you want to swap separated by a comma",
		position = 1,
		titleSection = "gearSwap1Title"
	)
	default String gearSwap1()
	{
		return "";
	}

	@ConfigItem(
		keyName = "autoSpec1",
		name = "Enable Spec (Premium)",
		description = "Automatically enabled special attack after swapping",
		position = 2,
		titleSection = "gearSwap1Title"
	)
	default boolean autoSpec1()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "gearSwap2Title",
		name = "Gear Swap Two",
		position = 2,
		description = ""
	)
	default Title gearSwap2Title()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "toggleKey2",
		name = "Toggle Key",
		description = "Executes Gear Swap for configuration two",
		position = 0,
		titleSection = "gearSwap2Title"
	)
	default Keybind toggleKey2()
	{
		return new Keybind(98, 0);
	}

	@ConfigItem(
		keyName = "gearSwap2",
		name = "Gear to Swap",
		description = "Enter the IDs of the gear you want to swap separated by a comma",
		position = 1,
		titleSection = "gearSwap2Title"
	)
	default String gearSwap2()
	{
		return "";
	}

	@ConfigItem(
		keyName = "autoSpec2",
		name = "Enable Spec (Premium)",
		description = "Automatically enabled special attack after swapping",
		position = 2,
		titleSection = "gearSwap2Title"
	)
	default boolean autoSpec2()
	{
		return false;
	}

	@ConfigTitleSection(
		keyName = "gearSwap3Title",
		name = "Gear Swap Three",
		position = 3,
		description = ""
	)
	default Title gearSwap3Title()
	{
		return new Title();
	}

	@ConfigItem(
		keyName = "toggleKey3",
		name = "Toggle Key",
		description = "Executes Gear Swap for configuration three",
		position = 0,
		titleSection = "gearSwap3Title"
	)
	default Keybind toggleKey3()
	{
		return new Keybind(99, 0);
	}

	@ConfigItem(
		keyName = "gearSwap3",
		name = "Gear to Swap",
		description = "Enter the IDs of the gear you want to swap separated by a comma",
		position = 1,
		titleSection = "gearSwap3Title"
	)
	default String gearSwap3()
	{
		return "";
	}

	@ConfigItem(
		keyName = "autoSpec3",
		name = "Enable Spec (Premium)",
		description = "Automatically enabled special attack after swapping",
		position = 2,
		titleSection = "gearSwap3Title"
	)
	default boolean autoSpec3()
	{
		return false;
	}
}
