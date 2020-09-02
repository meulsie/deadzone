package net.runelite.client.plugins.DeadZoneAPI;

import net.runelite.api.MenuEntry;

@SuppressWarnings("unused")
public enum PlayerTabTypes
{
	COMBAT_OPTIONS(new MenuEntry("Combat Options", "", 1, 57, -1, 10551349, false), new MenuEntry("Combat Options", "", 1, 57, -1, 10747956, false), new MenuEntry("", "", 1, 57, -1, 35913778, true)),
	INVENTORY(new MenuEntry("Inventory", "", 1, 57, -1, 10551352, false), new MenuEntry("Inventory", "", 1, 57, -1, 10747959, false), new MenuEntry("", "", 1, 57, -1, 35913781, true)),
	EQUIPMENT(new MenuEntry("Worn Equipment", "", 1, 57, -1, 10551353, false), new MenuEntry("Worn Equipment", "", 1, 57, -1, 10747960, false), new MenuEntry("", "", 1, 57, -1, 35913782, true)),
	PRAYER(new MenuEntry("Prayer", "", 1, 57, -1, 10551354, false), new MenuEntry("Prayer", "", 1, 57, -1, 10747961, false), new MenuEntry("", "", 1, 57, -1, 35913783, true)),
	MAGIC(new MenuEntry("Magic", "", 1, 57, -1, 10551355, false), new MenuEntry("Magic", "", 1, 57, -1, 10747962, false), new MenuEntry("", "", 1, 57, -1, 35913784, true)),
	LOGOUT(new MenuEntry("Logout", "", 1, 57, -1, 10551336, false), new MenuEntry("Logout", "", 1, 57, -1, 10747935, false), new MenuEntry("", "", 1, 57, -1, 35913764, true));

	private final MenuEntry noPanelEntry;
	private final MenuEntry panelEntry;
	private final MenuEntry fixedEntry;

	PlayerTabTypes(final MenuEntry noPanelEntry, final MenuEntry PanelEntry, final MenuEntry FixedEntry)
	{
		this.noPanelEntry = noPanelEntry;
		this.panelEntry = PanelEntry;
		this.fixedEntry = FixedEntry;
	}

	public final MenuEntry AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		return this.noPanelEntry;
	}

	public final MenuEntry DEFGvsdHI1sfggwPQRSTUdfVop2qrstuz178()
	{
		return this.panelEntry;
	}

	public final MenuEntry JKaFLM8NO3ka5g12M8NO3ka5gwPQRS2()
	{
		return this.fixedEntry;
	}
}
