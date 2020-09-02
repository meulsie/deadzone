package net.runelite.client.plugins.DeadZoneHunter;

import lombok.AccessLevel;
import lombok.Getter;

public enum DZHunterMethods
{
	Salamanders("Salamanders"),
	Red_Chins("Red Chins"),
	Black_Chins("Black Chins");

	@Getter(AccessLevel.PACKAGE)
	private final String name;

	DZHunterMethods(final String name)
	{
		this.name = name;
	}
}
