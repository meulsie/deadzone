package net.runelite.client.plugins.DeadZoneAPI;

import net.runelite.api.MenuEntry;

@SuppressWarnings("unused")
public enum BankInteractionTypes
{
	WITHDRAW_ONE(new MenuEntry("Withdraw-1", "", 1, 57, -1, 786444, true)),
	WITHDRAW_FIVE(new MenuEntry("Withdraw-5", "", 3, 57, -1, 786444, true)),
	WITHDRAW_TEN(new MenuEntry("Withdraw-10", "", 4, 57, -1, 786444, true)),
	WITHDRAW_X_PRESET(new MenuEntry("Withdraw-X", "", 5, 57, -1, 786444, true)),
	WITHDRAW_X_CUSTOM(new MenuEntry("Withdraw-X", "", 6, 1007, -1, 786444, true)),
	WITHDRAW_ALL(new MenuEntry("Withdraw-All", "", 7, 1007, -1, 786444, true)),
	DEPOSIT_ONE(new MenuEntry("Deposit-1", "", 2, 57, -1, 983043, true)),
	DEPOSIT_FIVE(new MenuEntry("Deposit-5", "", 4, 57, -1, 983043, true)),
	DEPOSIT_TEN(new MenuEntry("Deposit-10", "", 5, 57, -1, 983043, true)),
	DEPOSIT_X_PRESET(new MenuEntry("Deposit-X", "", 6, 57, -1, 983043, true)),
	DEPOSIT_X_CUSTOM(new MenuEntry("Deposit-X", "", 7, 1007, -1, 983043, true)),
	DEPOSIT_ALL(new MenuEntry("Deposit-All", "", 8, 1007, -1, 983043, true));

	public final MenuEntry menuEntry;

	BankInteractionTypes(final MenuEntry menuEntry)
	{
		this.menuEntry = menuEntry;
	}

	public final MenuEntry AB1CaddDEdaHI12361JKLM8NO3ka5gw()
	{
		return this.menuEntry;
	}
}
