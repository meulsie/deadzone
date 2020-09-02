package net.runelite.client.plugins.DeadZoneConstruction;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Keybind;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;

@ConfigGroup("DZConstructionConfig")
public interface DZConConfig extends Config
{
	@ConfigTitleSection(
		keyName = "skillingTitle",
		name = "Construction Helper Config",
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
		description = "Enable to display info regarding the Construction Helper Plugin",
		titleSection = "skillingTitle"
	)
	default boolean displayInfo()
	{
		return true;
	}

	@ConfigItem(
		keyName = "skillingMethod",
		name = "Skilling Method",
		position = 2,
		description = "Determine what method you will be using",
		titleSection = "skillingTitle"
	)
	default DZConMethods skillingMethod()
	{
		return DZConMethods.Mahogany_Tables;
	}

	@ConfigItem(
		keyName = "toggleKey",
		name = "Toggle Key",
		description = "Toggles the Construction Helper Plugin on / off",
		position = 3,
		titleSection = "skillingTitle"
	)
	default Keybind toggleKey()
	{
		return new Keybind(97, 0);
	}

	@ConfigItem(
		keyName = "timeout",
		name = "Skilling Timeout",
		description = "How long to run the Construction Helper Plugin before timing out automatically",
		position = 4,
		titleSection = "skillingTitle"
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
		keyName = "txt",
		name = "<html><center>---= Recommended Plank Presets =---<br> Oak Larders - 16<br>Oak Dungeon Doors - 20 <br> Mahogany Tables - 12 <br> Teak Benches - 12 <br> Mythical Cape Racks - 6</center></html>",
		description = "",
		position = 1
	)
	default Title txt()
	{
		return new Title();
	}
}
