package net.runelite.client.plugins.DeadZoneAPI;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Title;

@SuppressWarnings("unused")
@ConfigGroup("DeadZoneConfig")
public interface DeadZoneConfig extends Config
{
	// Title Section

	@ConfigTitleSection(
		keyName = "deadZoneTitle",
		name = "DeadZone Config",
		position = 0,
		description = ""
	)
	default Title deadZoneTitle()
	{
		return new Title();
	}

	@ConfigTitleSection(
		keyName = "delayConfig",
		name = "DeadZone Delay",
		position = 1,
		description = ""
	)
	default Title delayConfig()
	{
		return new Title();
	}

	@ConfigTitleSection(
		keyName = "testingTitle",
		name = "DeadZone Testing",
		position = 2,
		description = ""
	)
	default Title testingTitle()
	{
		return new Title();
	}

	// DeadZoneTitle Section

	@ConfigItem(
		keyName = "devTools",
		name = "Developer Tools",
		description = "Only enable if you know what you are doing or have been asked to",
		position = 2,
		titleSection = "deadZoneTitle"
	)
	default boolean devTools()
	{
		return false;
	}

	// Delay Config Section

	@ConfigItem(
		keyName = "minDelay",
		name = "Minimum Delay",
		description = "",
		position = 0,
		titleSection = "delayConfig"
	)
	@Range(
		min = 10,
		max = 120
	)
	default int minDelay()
	{
		return 60;
	}

	@ConfigItem(
		keyName = "maxDelay",
		name = "Maximum Delay",
		description = "",
		position = 1,
		titleSection = "delayConfig"
	)
	@Range(
		min = 25,
		max = 300
	)
	default int maxDelay()
	{
		return 160;
	}

	@ConfigItem(
		keyName = "target",
		name = "Delay Target",
		description = "",
		position = 2,
		titleSection = "delayConfig"
	)
	@Range(
		min = 15,
		max = 250
	)
	default int target()
	{
		return 100;
	}

	@ConfigItem(
		keyName = "deviation",
		name = "Delay Deviation",
		description = "",
		position = 3,
		titleSection = "delayConfig"
	)
	@Range(
		min = 5,
		max = 20
	)
	default int deviation()
	{
		return 10;
	}

	// Test Section

	@ConfigItem(
		keyName = "testItems",
		name = "Test Item IDs",
		description = "Enter the IDs of the items to test separated by a comma",
		position = 0,
		titleSection = "testingTitle"
	)
	default String testItems()
	{
		return "";
	}
}
